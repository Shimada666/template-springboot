package org.corgi.template.util.transformer;

import org.corgi.template.dal.entity.TestTableDO;
import org.corgi.template.dto.TestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        unmappedSourcePolicy = ReportingPolicy.WARN
)
public interface TestTransformer {
    TestTransformer INSTANCE = Mappers.getMapper(TestTransformer.class);

    TestDTO doToDTO(TestTableDO testDO);

    TestTableDO dtoToDO(TestDTO testDTO);
}
