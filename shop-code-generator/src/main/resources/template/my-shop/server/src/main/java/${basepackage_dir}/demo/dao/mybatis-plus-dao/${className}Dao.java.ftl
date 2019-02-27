<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#--项目自定义参数-->
<#assign appModelPackangeName = basepackage + '.model'>
<#assign appDaoPackangeName = basepackage + '.dao'>
<#assign appConfigPackangeName = basepackage + '.config'>
<#assign appServicePackangeName = basepackage + '.service'>

package ${basepackage}.dao;

import org.springframework.stereotype.Repository;
import com.qijia.framework.dao.IBaseDao;
import ${appModelPackangeName}.${className};

<#include "/java_copyright.include">

@Repository(value = "${classNameLower}")
public interface ${className}Dao extends IBaseDao<${className}> {
}