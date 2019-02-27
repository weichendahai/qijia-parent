<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=UpmsUserRole.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form action="${ctx}/pages/UpmsUserRole/list.do" method="post">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/UpmsUserRole/list.do'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="id" name="id" value="${upmsUserRole.id}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=UpmsUserRole.ALIAS_USER_ID%></td>	
				<td><c:out value='${upmsUserRole.userId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUserRole.ALIAS_ROLE_ID%></td>	
				<td><c:out value='${upmsUserRole.roleId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUserRole.ALIAS_CREATE_TIME%></td>	
				<td><c:out value='${upmsUserRole.createTime}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUserRole.ALIAS_UPDATE_TIME%></td>	
				<td><c:out value='${upmsUserRole.updateTime}'/></td>
			</tr>
		</table>
	</form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>