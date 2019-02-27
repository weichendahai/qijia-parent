<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=UpmsLog.TABLE_ALIAS%> 维护</title>
	
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
	<form id="queryForm" name="queryForm" action="<c:url value="/pages/UpmsLog/list.do"/>" method="get" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend>搜索</legend>
			<table>
				<tr>	
					<td class="tdLabel"><%=UpmsLog.ALIAS_DESCRIPTION%></td>		
					<td>
						<input value="${query.description}" id="description" name="description" maxlength="100"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsLog.ALIAS_USERNAME%></td>		
					<td>
						<input value="${query.username}" id="username" name="username" maxlength="20"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsLog.ALIAS_START_TIME%></td>		
					<td>
						<input value="${query.startTime}" id="startTime" name="startTime" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=UpmsLog.ALIAS_SPEND_TIME%></td>		
					<td>
						<input value="${query.spendTime}" id="spendTime" name="spendTime" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=UpmsLog.ALIAS_BASE_PATH%></td>		
					<td>
						<input value="${query.basePath}" id="basePath" name="basePath" maxlength="500"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsLog.ALIAS_URI%></td>		
					<td>
						<input value="${query.uri}" id="uri" name="uri" maxlength="500"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsLog.ALIAS_URL%></td>		
					<td>
						<input value="${query.url}" id="url" name="url" maxlength="500"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsLog.ALIAS_METHOD%></td>		
					<td>
						<input value="${query.method}" id="method" name="method" maxlength="10"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=UpmsLog.ALIAS_PARAMETER%></td>		
					<td>
						<input value="${query.parameter}" id="parameter" name="parameter" maxlength="16777215"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsLog.ALIAS_USER_AGENT%></td>		
					<td>
						<input value="${query.userAgent}" id="userAgent" name="userAgent" maxlength="500"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsLog.ALIAS_IP%></td>		
					<td>
						<input value="${query.ip}" id="ip" name="ip" maxlength="30"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsLog.ALIAS_RESULT%></td>		
					<td>
						<input value="${query.result}" id="result" name="result" maxlength="16777215"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=UpmsLog.ALIAS_PERMISSIONS%></td>		
					<td>
						<input value="${query.permissions}" id="permissions" name="permissions" maxlength="100"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsLog.ALIAS_CREATE_TIME%></td>		
					<td>
						<input value="${query.createTime}" id="createTime" name="createTime" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=UpmsLog.ALIAS_UPDATE_TIME%></td>		
					<td>
						<input value="${query.updateTime}" id="updateTime" name="updateTime" maxlength="19"  class="validate-integer "/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/UpmsLog/list.do'"/>
			<input type="submit" class="stdButton" style="width:80px" value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/UpmsLog/create.do'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="batchDelete('${ctx}/pages/UpmsLog/delete.do','items',document.forms.queryForm)"/>
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
				<th sortColumn="description" ><%=UpmsLog.ALIAS_DESCRIPTION%></th>
				<th sortColumn="username" ><%=UpmsLog.ALIAS_USERNAME%></th>
				<th sortColumn="start_time" ><%=UpmsLog.ALIAS_START_TIME%></th>
				<th sortColumn="spend_time" ><%=UpmsLog.ALIAS_SPEND_TIME%></th>
				<th sortColumn="base_path" ><%=UpmsLog.ALIAS_BASE_PATH%></th>
				<th sortColumn="uri" ><%=UpmsLog.ALIAS_URI%></th>
				<th sortColumn="url" ><%=UpmsLog.ALIAS_URL%></th>
				<th sortColumn="method" ><%=UpmsLog.ALIAS_METHOD%></th>
				<th sortColumn="parameter" ><%=UpmsLog.ALIAS_PARAMETER%></th>
				<th sortColumn="user_agent" ><%=UpmsLog.ALIAS_USER_AGENT%></th>
				<th sortColumn="ip" ><%=UpmsLog.ALIAS_IP%></th>
				<th sortColumn="result" ><%=UpmsLog.ALIAS_RESULT%></th>
				<th sortColumn="permissions" ><%=UpmsLog.ALIAS_PERMISSIONS%></th>
				<th sortColumn="create_time" ><%=UpmsLog.ALIAS_CREATE_TIME%></th>
				<th sortColumn="update_time" ><%=UpmsLog.ALIAS_UPDATE_TIME%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="id=${item.id}&"></td>
				
				<td><c:out value='${item.description}'/>&nbsp;</td>
				<td><c:out value='${item.username}'/>&nbsp;</td>
				<td><c:out value='${item.startTime}'/>&nbsp;</td>
				<td><c:out value='${item.spendTime}'/>&nbsp;</td>
				<td><c:out value='${item.basePath}'/>&nbsp;</td>
				<td><c:out value='${item.uri}'/>&nbsp;</td>
				<td><c:out value='${item.url}'/>&nbsp;</td>
				<td><c:out value='${item.method}'/>&nbsp;</td>
				<td><c:out value='${item.parameter}'/>&nbsp;</td>
				<td><c:out value='${item.userAgent}'/>&nbsp;</td>
				<td><c:out value='${item.ip}'/>&nbsp;</td>
				<td><c:out value='${item.result}'/>&nbsp;</td>
				<td><c:out value='${item.permissions}'/>&nbsp;</td>
				<td><c:out value='${item.createTime}'/>&nbsp;</td>
				<td><c:out value='${item.updateTime}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/pages/UpmsLog/show.do?id=${item.id}&">查看</a>&nbsp;&nbsp;&nbsp;
					<a href="${ctx}/pages/UpmsLog/edit.do?id=${item.id}&">修改</a>
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

