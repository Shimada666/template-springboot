package org.corgi.template.util.transformer;


import org.corgi.template.dal.entity.TestTableDO;
import org.corgi.template.dto.TestTableDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        unmappedSourcePolicy = ReportingPolicy.WARN
)
public interface TestTableTransformer {
    TestTableTransformer INSTANCE = Mappers.getMapper(TestTableTransformer.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleteTime", ignore = true)
    TestTableDO dtoToDo(TestTableDTO dto);

    TestTableDTO doToDto(TestTableDO TestTableDO);

    @IterableMapping(qualifiedByName = "doToDto")
    List<TestTableDTO> dosToDtos(List<TestTableDO> dos);

    default LocalDateTime stringToLocalDateTime(String dateStr) throws ParseException {
        if (dateStr == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.systemDefault());
        return LocalDateTime.parse(dateStr, formatter);
    }

    default String localDateTimeToString(LocalDateTime dateTime) throws ParseException {
        if (dateTime == null) {
            return null;
        }
        return dateTime.atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ISO_INSTANT);
    }
}