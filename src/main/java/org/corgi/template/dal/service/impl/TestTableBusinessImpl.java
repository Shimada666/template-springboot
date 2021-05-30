package org.corgi.template.dal.service.impl;

import org.corgi.template.dal.entity.TestTableDO;
import org.corgi.template.dal.mapper.TestTableDOMapper;
import org.corgi.template.dal.service.TestTableBusiness;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2021-05-30
 */
@Service
public class TestTableBusinessImpl extends ServiceImpl<TestTableDOMapper, TestTableDO> implements TestTableBusiness {

}
