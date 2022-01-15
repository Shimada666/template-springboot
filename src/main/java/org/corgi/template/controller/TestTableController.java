package org.corgi.template.controller;

import org.corgi.template.util.response.WebResponse;
import org.corgi.template.dto.TestTableDTO;
import org.corgi.template.service.TestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Transactional
@Validated
public class TestTableController {

    @Autowired
    private TestTableService testTableService;

    @GetMapping("/api/v1/test_table")
    public WebResponse<List<TestTableDTO>> listTestTable() {
        return WebResponse.buildData(testTableService.listTestTable());
    }

    @GetMapping("/api/v1/test_table/{id}")
    public WebResponse<TestTableDTO> getTestTable(@PathVariable Long id) {
        return WebResponse.buildData(testTableService.getTestTable(id));
    }

    @PostMapping("/api/v1/test_table")
    public WebResponse<Boolean> createTestTable(@RequestBody @Valid TestTableDTO request) {
        testTableService.createTestTable(request);
        return WebResponse.buildData(true);
    }


    @PutMapping("/api/v1/test_table/{id}")
    public WebResponse<Boolean> updateTestTable(@PathVariable Long id,
                                                 @RequestBody @Valid TestTableDTO request) {
        testTableService.updateTestTable(id, request);
        return WebResponse.buildData(true);
    }

    @DeleteMapping("/api/v1/test_table/{id}")
    public WebResponse<Boolean> deleteTestTable(@PathVariable Long id) {
        return WebResponse.buildData(testTableService.deleteTestTable(id));
    }
}