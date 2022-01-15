package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import org.corgi.template.exception.NotFoundException;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {
    @Override
    public ${entity} getAndCheckById(Long id) {
        ${entity} entity = getById(id);
        if (entity == null){
            throw new NotFoundException(String.format("对应 ID: %d 的 ${entity?replace('DO','')} 不存在", id));
        }
        return entity;
    }
}
</#if>
