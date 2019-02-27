<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameFirstLower = table.classNameFirstLower>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<#macro mapperEl value>${r"#{"}${value}}</#macro>
<mapper namespace="${basepackage}.dao.${className}Dao">

	<!--基础返回结果-->
	<resultMap id="BaseResultMap" type="${basepackage}.model.${className}">
        <#list table.columns as column>
		<#if column.pk>
		<id property="${column.columnNameLower}" column="${column.sqlName}" jdbcType="${column.jdbcSqlTypeName}"/>
		</#if>
		<#if !column.pk>
		<result property="${column.columnNameLower}" column="${column.sqlName}" jdbcType="${column.jdbcSqlTypeName}"/>
		</#if>
		</#list>
	</resultMap>

	<!-- 查询条件 -->
    <sql id="Base_Where_Clause">
    	where 1=1
    	<trim  suffixOverrides="," >
		<#list table.columns as column>
			<if test="${column.columnNameFirstLower} != null and ${column.columnNameFirstLower} != ''">
				and ${column.sqlName} = ${r'#{'}${column.columnNameFirstLower}, jdbcType=${column.jdbcSqlTypeName} ${r'}'}
			</if>
		</#list>
		</trim>
    </sql>

	<!--添加-->
	<insert id="insert" useGeneratedKeys="true" keyProperty="id"
		parameterType="${basepackage}.model.${className}">
		insert into ${table.sqlName}
		<trim prefix="(" suffix=")" suffixOverrides=",">
		<#list table.columns as column>
			<if test="${column.columnNameFirstLower} != null">
				${column.sqlName},
			</if>
        </#list>
		</trim>
		<trim prefix="values (" suffix=")" suffixOverrides=",">
	    <#list table.columns as column>
			<if test="${column.columnNameFirstLower} != null">
				${r'#{'}${column.columnNameFirstLower}, jdbcType=${column.jdbcSqlTypeName}${r'},'}
			</if>
        </#list>
		</trim>
	</insert>

	<!--删除-->
	<delete id="delete" parameterType="Object">
		delete from ${table.sqlName}
		where
		id = <@mapperEl "id"/>
	</delete>

	<!--修改-->
	<update id="update" parameterType="${basepackage}.model.${className}">
		update ${table.sqlName}
		<set>
			<#list table.notPkColumns as column>
			<if test="${column.columnNameFirstLower} != null">
				${column.sqlName} = ${r'#{'}${column.columnNameFirstLower}, jdbcType=${column.jdbcSqlTypeName} ${r'}'},
			</if>
	        </#list>
		</set>
		where
		id = <@mapperEl "id"/>
	</update>

	<!-- 用于select查询公用抽取的列 -->
	<sql id="Base_Column_List">
		<#list table.columns as column>${column.sqlName}<#if column_has_next>,</#if></#list>
	</sql>

	<!--根据Id查询-->
	<select id="queryById" parameterType="int" resultMap="BaseResultMap">
		select
		<include refid="Base_Column_List" />
		from ${table.sqlName}
		where
		id = <@mapperEl "id"/>
	</select>

	<!--根据model 查询-->
    <select id="queryOne" resultMap="BaseResultMap"  parameterType="Object">
        select <include refid="Base_Column_List"/>
        from ${table.sqlName}
        <include refid="Base_Where_Clause"/>
        limit 1
    </select>

	<!--根据model 查询; 返回list 结果-->
    <select id="queryByObject" resultMap="BaseResultMap"  parameterType="Object">
        select <include refid="Base_Column_List"/>
        from ${table.sqlName}
        <include refid="Base_Where_Clause"/>
    </select>

	<!--查询全部-->
	<select id="queryAll" resultMap="BaseResultMap">
		select
		<include refid="Base_Column_List" />
		from ${table.sqlName}
	</select>

	<!--
    查询条件;根据具体业务逻辑实现查询；默认查询条件与字段名字相同；保存至map
    例如
        Map<String, Object> filter = new HashMap<String, Object>();
        filter.put("id", localeRequest.getId());
        filter.put("name", localeRequest.getName());
     -->
	<sql id="Filter_Where_Clause">
		where 1=1
		<trim  suffixOverrides="," >
			<#list table.columns as column>
			<if test="${column.sqlName} != null and ${column.sqlName} != ''">
				and ${column.sqlName} = ${r'#{'}${column.sqlName}, jdbcType=${column.jdbcSqlTypeName} ${r'}'}
			</if>
		</#list>
		</trim>
	</sql>

	<!--根据map 查询条件查询-->
	<select id="queryByList" resultMap="BaseResultMap"  parameterType="java.util.Map">
		select <include refid="Base_Column_List"/>
		from ${table.sqlName}
		<include refid="Filter_Where_Clause"/>
	</select>
</mapper>