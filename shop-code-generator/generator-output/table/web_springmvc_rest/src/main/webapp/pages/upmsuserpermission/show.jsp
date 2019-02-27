<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=UpmsUserPermission.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="upmsuserpermission"  >
		<input type="button" value="返回列表" onclick="window.location='${ctx}/upmsuserpermission'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="id" name="id" value="${upmsUserPermission.id}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=UpmsUserPermission.ALIAS_USER_ID%></td>	
				<td><c:out value='${upmsUserPermission.userId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUserPermission.ALIAS_PERMISSION_ID%></td>	
				<td><c:out value='${upmsUserPermission.permissionId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUserPermission.ALIAS_TYPE%></td>	
				<td><c:out value='${upmsUserPermission.type}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUserPermission.ALIAS_CREATE_TIME%></td>	
				<td><c:out value='${upmsUserPermission.createTime}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUserPermission.ALIAS_UPDATE_TIME%></td>	
				<td><c:out value='${upmsUserPermission.updateTime}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>