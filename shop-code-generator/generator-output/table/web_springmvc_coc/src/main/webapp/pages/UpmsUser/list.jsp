<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=UpmsUser.TABLE_ALIAS%> 维护</title>
	
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
	<form id="queryForm" name="queryForm" action="<c:url value="/pages/UpmsUser/list.do"/>" method="get" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend>搜索</legend>
			<table>
				<tr>	
					<td class="tdLabel"><%=UpmsUser.ALIAS_USERNAME%></td>		
					<td>
						<input value="${query.username}" id="username" name="username" maxlength="20"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsUser.ALIAS_PASSWORD%></td>		
					<td>
						<input value="${query.password}" id="password" name="password" maxlength="32"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsUser.ALIAS_SALT%></td>		
					<td>
						<input value="${query.salt}" id="salt" name="salt" maxlength="32"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsUser.ALIAS_REALNAME%></td>		
					<td>
						<input value="${query.realname}" id="realname" name="realname" maxlength="20"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=UpmsUser.ALIAS_AVATAR%></td>		
					<td>
						<input value="${query.avatar}" id="avatar" name="avatar" maxlength="150"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsUser.ALIAS_PHONE%></td>		
					<td>
						<input value="${query.phone}" id="phone" name="phone" maxlength="20"  class=""/>
					</td>
					<td class="tdLabel"><%=UpmsUser.ALIAS_EMAIL%></td>		
					<td>
						<input value="${query.email}" id="email" name="email" maxlength="50"  class="validate-email "/>
					</td>
					<td class="tdLabel"><%=UpmsUser.ALIAS_SEX%></td>		
					<td>
						<input value="${query.sex}" id="sex" name="sex" maxlength="3"  class="validate-integer max-value-2147483647"/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=UpmsUser.ALIAS_LOCKED%></td>		
					<td>
						<input value="${query.locked}" id="locked" name="locked" maxlength="3"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=UpmsUser.ALIAS_CREATE_TIME%></td>		
					<td>
						<input value="${query.createTime}" id="createTime" name="createTime" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=UpmsUser.ALIAS_UPDATE_TIME%></td>		
					<td>
						<input value="${query.updateTime}" id="updateTime" name="updateTime" maxlength="19"  class="validate-integer "/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/UpmsUser/list.do'"/>
			<input type="submit" class="stdButton" style="width:80px" value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/UpmsUser/create.do'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="batchDelete('${ctx}/pages/UpmsUser/delete.do','items',document.forms.queryForm)"/>
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
				<th sortColumn="username" ><%=UpmsUser.ALIAS_USERNAME%></th>
				<th sortColumn="password" ><%=UpmsUser.ALIAS_PASSWORD%></th>
				<th sortColumn="salt" ><%=UpmsUser.ALIAS_SALT%></th>
				<th sortColumn="realname" ><%=UpmsUser.ALIAS_REALNAME%></th>
				<th sortColumn="avatar" ><%=UpmsUser.ALIAS_AVATAR%></th>
				<th sortColumn="phone" ><%=UpmsUser.ALIAS_PHONE%></th>
				<th sortColumn="email" ><%=UpmsUser.ALIAS_EMAIL%></th>
				<th sortColumn="sex" ><%=UpmsUser.ALIAS_SEX%></th>
				<th sortColumn="locked" ><%=UpmsUser.ALIAS_LOCKED%></th>
				<th sortColumn="create_time" ><%=UpmsUser.ALIAS_CREATE_TIME%></th>
				<th sortColumn="update_time" ><%=UpmsUser.ALIAS_UPDATE_TIME%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="id=${item.id}&"></td>
				
				<td><c:out value='${item.username}'/>&nbsp;</td>
				<td><c:out value='${item.password}'/>&nbsp;</td>
				<td><c:out value='${item.salt}'/>&nbsp;</td>
				<td><c:out value='${item.realname}'/>&nbsp;</td>
				<td><c:out value='${item.avatar}'/>&nbsp;</td>
				<td><c:out value='${item.phone}'/>&nbsp;</td>
				<td><c:out value='${item.email}'/>&nbsp;</td>
				<td><c:out value='${item.sex}'/>&nbsp;</td>
				<td><c:out value='${item.locked}'/>&nbsp;</td>
				<td><c:out value='${item.createTime}'/>&nbsp;</td>
				<td><c:out value='${item.updateTime}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/pages/UpmsUser/show.do?id=${item.id}&">查看</a>&nbsp;&nbsp;&nbsp;
					<a href="${ctx}/pages/UpmsUser/edit.do?id=${item.id}&">修改</a>
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

