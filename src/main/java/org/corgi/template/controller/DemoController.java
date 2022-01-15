package org.corgi.template.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.corgi.template.dal.entity.TestTableDO;
import org.corgi.template.dal.service.TestTableBusiness;
import org.corgi.template.service.TestService;
import org.corgi.template.util.response.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {
    @Autowired
    private TestService testService;

    @Autowired
    private TestTableBusiness testTableBusiness;

    @GetMapping("/")
    public Page<TestTableDO> demo() {
        Page<TestTableDO> page = testTableBusiness.page(new Page<>(1, 10));
        return page;
    }

    @GetMapping("/api/v1/test/list")
    public WebResponse<List<TestTableDO>> listTest() {
        return WebResponse.buildData(testService.listTest());
    }

    @GetMapping("/api/v1/test/query")
    public WebResponse<Page<TestTableDO>> queryTest(@RequestParam(required = false, defaultValue = "1") Integer page,
                                                    @RequestParam(required = false, defaultValue = "10") Integer size) {
        return WebResponse.buildData(testService.queryTest(page, size));
    }
}
