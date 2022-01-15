package org.corgi.template.util.transformer;


import org.corgi.template.dal.entity.{{ name }}DO;
import org.corgi.template.dto.{{ name }}DTO;
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
public interface {{ name }}Transformer {
    {{ name }}Transformer INSTANCE = Mappers.getMapper({{ name }}Transformer.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleteTime", ignore = true)
    {{ name }}DO dtoToDo({{ name }}DTO dto);

    {{ name }}DTO doToDto({{ name }}DO {{ name }}DO);

    @IterableMapping(qualifiedByName = "doToDto")
    List<{{ name }}DTO> dosToDtos(List<{{ name }}DO> dos);

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