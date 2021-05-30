package org.corgi.template.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.corgi.template.dal.entity.TestTableDO;
import org.corgi.template.dal.service.TestTableBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 不用接口，实际业务开发中多个service继承接口的情况非常少
 */
@Service
public class TestService {
    @Autowired
    private TestTableBusiness testTableBusiness;

    public List<TestTableDO> listTest() {
        return testTableBusiness.list();
    }

    public Page<TestTableDO> queryTest(int current, int size) {
        Page<TestTableDO> page = new Page<>(current, size);
        return testTableBusiness.lambdaQuery().
                eq(TestTableDO::getNumber, 2)
                .page(page);
    }
}
