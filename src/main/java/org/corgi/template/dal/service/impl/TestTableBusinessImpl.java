package org.corgi.template.dal.service.impl;

import org.corgi.template.dal.entity.TestTableDO;
import org.corgi.template.dal.mapper.TestTableDOMapper;
import org.corgi.template.dal.service.TestTableBusiness;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.corgi.template.exception.NotFoundException;

/**
 * <p>
 * test_table 服务实现类
 * </p>
 *
 * @author 
 * @since 2022-01-16
 */
@Service
public class TestTableBusinessImpl extends ServiceImpl<TestTableDOMapper, TestTableDO> implements TestTableBusiness {
    @Override
    public TestTableDO getAndCheckById(Long id) {
        TestTableDO entity = getById(id);
        if (entity == null){
            throw new NotFoundException(String.format("对应 ID: %d 的 TestTable 不存在", id));
        }
        return entity;
    }
}
