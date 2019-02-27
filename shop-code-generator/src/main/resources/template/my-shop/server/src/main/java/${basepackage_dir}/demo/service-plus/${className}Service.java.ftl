<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#--项目自定义参数-->
<#assign appModelPackangeName = basepackage + '.model'>
<#assign appDaoPackangeName = basepackage + '.dao'>
<#assign appConfigPackangeName = basepackage + '.config'>
<#assign appServicePackangeName = basepackage + '.rpc.api'>
<#assign appControllerPackangeName = basepackage + '.controller'>

package ${appServicePackangeName};

import com.qijia.framework.service.IBaseService;
import ${appModelPackangeName}.${className};

<#include "/java_copyright.include">

public interface ${className}Service extends IBaseService<${className}> {
}