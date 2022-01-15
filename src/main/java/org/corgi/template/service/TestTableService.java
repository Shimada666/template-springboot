package org.corgi.template.service;

import org.corgi.template.dal.entity.TestTableDO;
import org.corgi.template.dal.service.TestTableBusiness;
import org.corgi.template.dto.TestTableDTO;
import org.corgi.template.util.transformer.TestTableTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestTableService {
    @Autowired
    private TestTableBusiness testTableService;

    public List<TestTableDTO> listTestTable() {
        List<TestTableDO> list = testTableService.list();
        return TestTableTransformer.INSTANCE.dosToDtos(list);
    }

    public TestTableDTO getTestTable(Long id) {
        TestTableDO rule = testTableService.getById(id);
        return TestTableTransformer.INSTANCE.doToDto(rule);
    }

    public boolean createTestTable(TestTableDTO request) {
        // validate

        // do
        TestTableDO rule = TestTableTransformer.INSTANCE.dtoToDo(request);
        return testTableService.save(rule);
    }

    public boolean updateTestTable(Long id, TestTableDTO request) {
        // validate

        // do
        TestTableDO rule = TestTableTransformer.INSTANCE.dtoToDo(request);
        return testTableService.updateById(rule);
    }

    public boolean deleteTestTable(Long id) {
        // validate

        // do
        return testTableService.removeById(id);
    }
}