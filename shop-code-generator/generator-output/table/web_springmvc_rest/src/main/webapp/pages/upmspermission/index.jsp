<%@page import="com.qijia.upms.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=UpmsPermission.TABLE_ALIAS%> 维护</title>
	
	<script src="${ctx}/scripts/rest.js" ></script>
	<link href="<c:url value="/widgets/simpletable/simpletable.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
	
	<script type="text/javascript" >
		$(document).ready(function() {
			// 分页需要依赖的初始化动作
			window.simpleTable = new SimpleTable('queryForm',${page.thisPageNumber},${page.pageSize},'${pageRequest.sortColumns}');
		});
	</script>
</rapid:override>

<rapid:override name="content">
	<form id="queryForm" name="queryForm" method="get" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend>搜索</legend>
			<table>
				<tr>	
					<td class="tdLabel"><%=UpmsPermission.ALIAS_SYSTEM_ID%></td>		
					<td>
						<input value="${query.systemId}" id="systemId" name="systemId" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=UpmsPermission.ALIAS_PID%></td>		
					<td>
						<input value="${query.pid}" id="pid" name="pid" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=UpmsPermission.ALIAS_NAME%></td>		
					<td>
						<input value="${query.name}" id="name" name="name" maxlength="20"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsPermission.ALIAS_TYPE%></td>		
					<td>
						<input value="${query.type}" id="type" name="type" maxlength="3"  class="validate-integer max-value-2147483647"/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=UpmsPermission.ALIAS_PERMISSION_VALUE%></td>		
					<td>
						<input value="${query.permissionValue}" id="permissionValue" name="permissionValue" maxlength="50"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsPermission.ALIAS_URI%></td>		
					<td>
						<input value="${query.uri}" id="uri" name="uri" maxlength="100"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsPermission.ALIAS_ICON%></td>		
					<td>
						<input value="${query.icon}" id="icon" name="icon" maxlength="50"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsPermission.ALIAS_STATUS%></td>		
					<td>
						<input value="${query.status}" id="status" name="status" maxlength="3"  class="validate-integer max-value-2147483647"/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=UpmsPermission.ALIAS_ORDERS%></td>		
					<td>
						<input value="${query.orders}" id="orders" name="orders" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=UpmsPermission.ALIAS_CREATE_TIME%></td>		
					<td>
						<input value="${query.createTime}" id="createTime" name="createTime" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=UpmsPermission.ALIAS_UPDATE_TIME%></td>		
					<td>
						<input value="${query.updateTime}" id="updateTime" name="updateTime" maxlength="19"  class="validate-integer "/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/upmspermission'"/>
			<input type="button" class="stdButton" style="width:80px" value="新增" onclick="window.location = '${ctx}/upmspermission/new'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="doRestBatchDelete('${ctx}/upmspermission','items',document.forms.queryForm)"/>
		<div>
	
	</div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
		显示在这里是为了提示你如何自定义表头,可修改模板删除此行
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="gridBody">
		  <thead>
			  
			  <tr>
				<th style="width:1px;"> </th>
				<th style="width:1px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="system_id" ><%=UpmsPermission.ALIAS_SYSTEM_ID%></th>
				<th sortColumn="pid" ><%=UpmsPermission.ALIAS_PID%></th>
				<th sortColumn="name" ><%=UpmsPermission.ALIAS_NAME%></th>
				<th sortColumn="type" ><%=UpmsPermission.ALIAS_TYPE%></th>
				<th sortColumn="permission_value" ><%=UpmsPermission.ALIAS_PERMISSION_VALUE%></th>
				<th sortColumn="uri" ><%=UpmsPermission.ALIAS_URI%></th>
				<th sortColumn="icon" ><%=UpmsPermission.ALIAS_ICON%></th>
				<th sortColumn="status" ><%=UpmsPermission.ALIAS_STATUS%></th>
				<th sortColumn="orders" ><%=UpmsPermission.ALIAS_ORDERS%></th>
				<th sortColumn="create_time" ><%=UpmsPermission.ALIAS_CREATE_TIME%></th>
				<th sortColumn="update_time" ><%=UpmsPermission.ALIAS_UPDATE_TIME%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.id}"></td>
				
				<td><c:out value='${item.systemId}'/>&nbsp;</td>
				<td><c:out value='${item.pid}'/>&nbsp;</td>
				<td><c:out value='${item.name}'/>&nbsp;</td>
				<td><c:out value='${item.type}'/>&nbsp;</td>
				<td><c:out value='${item.permissionValue}'/>&nbsp;</td>
				<td><c:out value='${item.uri}'/>&nbsp;</td>
				<td><c:out value='${item.icon}'/>&nbsp;</td>
				<td><c:out value='${item.status}'/>&nbsp;</td>
				<td><c:out value='${item.orders}'/>&nbsp;</td>
				<td><c:out value='${item.createTime}'/>&nbsp;</td>
				<td><c:out value='${item.updateTime}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/upmspermission/${item.id}">查看</a>&nbsp;&nbsp;
					<a href="${ctx}/upmspermission/${item.id}/edit">修改</a>&nbsp;&nbsp;
					<a href="${ctx}/upmspermission/${item.id}" onclick="doRestDelete(this,'你确认删除?');return false;">删除</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
		显示在这里是为了提示你如何自定义表头,可修改模板删除此行
		</simpletable:pageToolbar>
		
	</div>
	</form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>
