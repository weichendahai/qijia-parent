<%@page import="com.qijia.upms.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=UpmsSystem.TABLE_ALIAS%> 维护</title>
	
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
					<td class="tdLabel"><%=UpmsSystem.ALIAS_ICON%></td>		
					<td>
						<input value="${query.icon}" id="icon" name="icon" maxlength="50"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsSystem.ALIAS_BANNER%></td>		
					<td>
						<input value="${query.banner}" id="banner" name="banner" maxlength="150"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsSystem.ALIAS_THEME%></td>		
					<td>
						<input value="${query.theme}" id="theme" name="theme" maxlength="50"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsSystem.ALIAS_BASEPATH%></td>		
					<td>
						<input value="${query.basepath}" id="basepath" name="basepath" maxlength="100"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=UpmsSystem.ALIAS_STATUS%></td>		
					<td>
						<input value="${query.status}" id="status" name="status" maxlength="3"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=UpmsSystem.ALIAS_NAME%></td>		
					<td>
						<input value="${query.name}" id="name" name="name" maxlength="20"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsSystem.ALIAS_TITLE%></td>		
					<td>
						<input value="${query.title}" id="title" name="title" maxlength="20"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsSystem.ALIAS_DESCRIPTION%></td>		
					<td>
						<input value="${query.description}" id="description" name="description" maxlength="300"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=UpmsSystem.ALIAS_ORDERS%></td>		
					<td>
						<input value="${query.orders}" id="orders" name="orders" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=UpmsSystem.ALIAS_CREATE_TIME%></td>		
					<td>
						<input value="${query.createTime}" id="createTime" name="createTime" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=UpmsSystem.ALIAS_UPDATE_TIME%></td>		
					<td>
						<input value="${query.updateTime}" id="updateTime" name="updateTime" maxlength="19"  class="validate-integer "/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/upmssystem'"/>
			<input type="button" class="stdButton" style="width:80px" value="新增" onclick="window.location = '${ctx}/upmssystem/new'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="doRestBatchDelete('${ctx}/upmssystem','items',document.forms.queryForm)"/>
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
				<th sortColumn="icon" ><%=UpmsSystem.ALIAS_ICON%></th>
				<th sortColumn="banner" ><%=UpmsSystem.ALIAS_BANNER%></th>
				<th sortColumn="theme" ><%=UpmsSystem.ALIAS_THEME%></th>
				<th sortColumn="basepath" ><%=UpmsSystem.ALIAS_BASEPATH%></th>
				<th sortColumn="status" ><%=UpmsSystem.ALIAS_STATUS%></th>
				<th sortColumn="name" ><%=UpmsSystem.ALIAS_NAME%></th>
				<th sortColumn="title" ><%=UpmsSystem.ALIAS_TITLE%></th>
				<th sortColumn="description" ><%=UpmsSystem.ALIAS_DESCRIPTION%></th>
				<th sortColumn="orders" ><%=UpmsSystem.ALIAS_ORDERS%></th>
				<th sortColumn="create_time" ><%=UpmsSystem.ALIAS_CREATE_TIME%></th>
				<th sortColumn="update_time" ><%=UpmsSystem.ALIAS_UPDATE_TIME%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.id}"></td>
				
				<td><c:out value='${item.icon}'/>&nbsp;</td>
				<td><c:out value='${item.banner}'/>&nbsp;</td>
				<td><c:out value='${item.theme}'/>&nbsp;</td>
				<td><c:out value='${item.basepath}'/>&nbsp;</td>
				<td><c:out value='${item.status}'/>&nbsp;</td>
				<td><c:out value='${item.name}'/>&nbsp;</td>
				<td><c:out value='${item.title}'/>&nbsp;</td>
				<td><c:out value='${item.description}'/>&nbsp;</td>
				<td><c:out value='${item.orders}'/>&nbsp;</td>
				<td><c:out value='${item.createTime}'/>&nbsp;</td>
				<td><c:out value='${item.updateTime}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/upmssystem/${item.id}">查看</a>&nbsp;&nbsp;
					<a href="${ctx}/upmssystem/${item.id}/edit">修改</a>&nbsp;&nbsp;
					<a href="${ctx}/upmssystem/${item.id}" onclick="doRestDelete(this,'你确认删除?');return false;">删除</a>
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
