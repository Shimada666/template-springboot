package org.corgi.template.service;

import org.corgi.template.dal.entity.{{ name }}DO;
import org.corgi.template.dal.service.{{ name }}Business;
import org.corgi.template.dto.{{ name }}DTO;
import org.corgi.template.util.transformer.{{ name }}Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class {{ name }}Service {
    @Autowired
    private {{ name }}Business {{ name | lower_first }}Business;

    public List<{{ name }}DTO> list{{ name }}() {
        List<{{ name }}DO> list = {{ name | lower_first }}Business.list();
        return {{ name }}Transformer.INSTANCE.dosToDtos(list);
    }

    public {{ name }}DTO get{{ name }}(Long id) {
        {{ name }}DO rule = {{ name | lower_first }}Business.getById(id);
        return {{ name }}Transformer.INSTANCE.doToDto(rule);
    }

    public boolean create{{ name }}({{ name }}DTO request) {
        // validate

        // do
        {{ name }}DO rule = {{ name }}Transformer.INSTANCE.dtoToDo(request);
        return {{ name | lower_first }}Business.save(rule);
    }

    public boolean update{{ name }}(Long id, {{ name }}DTO request) {
        // validate

        // do
        {{ name }}DO rule = {{ name }}Transformer.INSTANCE.dtoToDo(request);
        return {{ name | lower_first }}Business.updateById(rule);
    }

    public boolean delete{{ name }}(Long id) {
        // validate

        // do
        return {{ name | lower_first }}Business.removeById(id);
    }
}
