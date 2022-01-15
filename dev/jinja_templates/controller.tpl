package org.corgi.template.controller;

import org.corgi.template.util.response.WebResponse;
import org.corgi.template.dto.{{ name }}DTO;
import org.corgi.template.service.{{ name }}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Transactional
@Validated
public class {{ name }}Controller {

    @Autowired
    private {{ name }}Service {{ name | lower_first }}Service;

    @GetMapping("/api/v1/{{ name | snake_case }}")
    public WebResponse<List<{{ name }}DTO>> list{{ name }}() {
        return WebResponse.buildData({{ name | lower_first }}Service.list{{ name }}());
    }

    @GetMapping("/api/v1/{{ name | snake_case }}/{id}")
    public WebResponse<{{ name }}DTO> get{{ name }}(@PathVariable Long id) {
        return WebResponse.buildData({{ name | lower_first }}Service.get{{ name }}(id));
    }

    @PostMapping("/api/v1/{{ name | snake_case }}")
    public WebResponse<Boolean> create{{ name }}(@RequestBody @Valid {{ name }}DTO request) {
        {{ name | lower_first }}Service.create{{ name }}(request);
        return WebResponse.buildData(true);
    }


    @PutMapping("/api/v1/{{ name | snake_case }}/{id}")
    public WebResponse<Boolean> update{{ name }}(@PathVariable Long id,
                                                 @RequestBody @Valid {{ name }}DTO request) {
        {{ name | lower_first }}Service.update{{ name }}(id, request);
        return WebResponse.buildData(true);
    }

    @DeleteMapping("/api/v1/{{ name | snake_case }}/{id}")
    public WebResponse<Boolean> delete{{ name }}(@PathVariable Long id) {
        return WebResponse.buildData({{ name | lower_first }}Service.delete{{ name }}(id));
    }
}
