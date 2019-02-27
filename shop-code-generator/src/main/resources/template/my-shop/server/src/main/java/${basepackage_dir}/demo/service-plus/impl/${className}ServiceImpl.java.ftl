<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#--项目自定义参数-->
<#assign appModelPackangeName = basepackage + '.model'>
<#assign appDaoPackangeName = basepackage + '.dao'>
<#assign appConfigPackangeName = basepackage + '.config'>
<#assign appServicePackangeName = basepackage + '.rpc.api'>
<#assign appControllerPackangeName = basepackage + '.controller'>

package ${appServicePackangeName}.impl;

import org.springframework.stereotype.Service;

import com.qijia.framework.service.impl.BaseServiceImpl;
import ${appModelPackangeName}.${className};
import ${appDaoPackangeName}.${className}Dao;
import ${appServicePackangeName}.${className}Service;


<#include "/java_copyright.include">

@Service
public class ${className}ServiceImpl extends BaseServiceImpl<${className}Dao,${className}> implements ${className}Service {
}
