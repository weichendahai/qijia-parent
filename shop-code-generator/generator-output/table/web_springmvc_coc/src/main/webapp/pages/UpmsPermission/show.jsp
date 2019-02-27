<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=UpmsPermission.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form action="${ctx}/pages/UpmsPermission/list.do" method="post">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/UpmsPermission/list.do'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="id" name="id" value="${upmsPermission.id}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=UpmsPermission.ALIAS_SYSTEM_ID%></td>	
				<td><c:out value='${upmsPermission.systemId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsPermission.ALIAS_PID%></td>	
				<td><c:out value='${upmsPermission.pid}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsPermission.ALIAS_NAME%></td>	
				<td><c:out value='${upmsPermission.name}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsPermission.ALIAS_TYPE%></td>	
				<td><c:out value='${upmsPermission.type}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsPermission.ALIAS_PERMISSION_VALUE%></td>	
				<td><c:out value='${upmsPermission.permissionValue}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsPermission.ALIAS_URI%></td>	
				<td><c:out value='${upmsPermission.uri}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsPermission.ALIAS_ICON%></td>	
				<td><c:out value='${upmsPermission.icon}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsPermission.ALIAS_STATUS%></td>	
				<td><c:out value='${upmsPermission.status}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsPermission.ALIAS_ORDERS%></td>	
				<td><c:out value='${upmsPermission.orders}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsPermission.ALIAS_CREATE_TIME%></td>	
				<td><c:out value='${upmsPermission.createTime}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsPermission.ALIAS_UPDATE_TIME%></td>	
				<td><c:out value='${upmsPermission.updateTime}'/></td>
			</tr>
		</table>
	</form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>