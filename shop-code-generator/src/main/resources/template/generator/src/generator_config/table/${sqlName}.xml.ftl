<?xml version="1.0" encoding="UTF-8"?>
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<!--******************************
本文件用于table变量的属性自定义
 强烈提醒: 
 1.如果你不想自定义配置,可以删除整个文件或是其中几列, 有定义的列才读自定义配置,没有定义的读数据库.不用一一对应
 2.你可以自由添加要自定义的属性，只要Table.java有set方法，并不限下面属性
 ***********************************-->
 
<!-- 
<table sqlName="数据库表名" className="类名称" tableAlias="表的别名">
	<column sqlName="数据库列名" columnAlias="列的别名" javaType="自定义javaType"
	unique="是否唯一性约束" nullable="是否可以为空" pk="是否主键,在表没有主键的情况下,可以指定一个代理主键" 
	updatable="是否可以更新" insertable="是否插入"	
	enumString="枚举值,以分号分隔,示例值:M(1,男);F(0,女) 或者是:M(男);F(女)" 
	enumClassName="如果枚举有值,生成的类名称将是这个,没有枚举值，该配置无用.示例值:Sex"
	hibernateValidatorExprssion="HibernateValidator表达式: @NotNull @Min(10) @Pattern(regex=, flag=)"
	/>
</table>
 -->
<table sqlName="${table.sqlName}" className="${className}" tableAlias="${table.tableAlias}" >
<#list table.columns as c>

	<column sqlName="${c.sqlName}" columnAlias="${c.columnAlias}" javaType="${c.javaType}" 
		unique="${c.unique?string}" nullable="${c.nullable?string}" pk="${c.pk?string}"
		updatable="${c.updatable?string}" insertable="${c.insertable?string}"
		enumString="${c.enumString}" enumClassName="${c.enumClassName}"
		hibernateValidatorExprssion="${c.hibernateValidatorExprssion}"
		hasOne="${c.hasOne!?string}" hasMany="${c.hasMany!?string}"
	/>
</#list>

</table>
