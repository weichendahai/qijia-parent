<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=UpmsRolePermission.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form action="${ctx}/pages/UpmsRolePermission/list.do" method="post">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/UpmsRolePermission/list.do'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="id" name="id" value="${upmsRolePermission.id}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=UpmsRolePermission.ALIAS_ROLE_ID%></td>	
				<td><c:out value='${upmsRolePermission.roleId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsRolePermission.ALIAS_PERMISSION_ID%></td>	
				<td><c:out value='${upmsRolePermission.permissionId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsRolePermission.ALIAS_CREATE_TIME%></td>	
				<td><c:out value='${upmsRolePermission.createTime}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsRolePermission.ALIAS_UPDATE_TIME%></td>	
				<td><c:out value='${upmsRolePermission.updateTime}'/></td>
			</tr>
		</table>
	</form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>