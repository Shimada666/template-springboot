package org.corgi.template.dal.service;

import org.corgi.template.dal.entity.TestTableDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * test_table 服务类
 * </p>
 *
 * @author 
 * @since 2022-01-16
 */
public interface TestTableBusiness extends IService<TestTableDO> {
    TestTableDO getAndCheckById(Long id);
}
