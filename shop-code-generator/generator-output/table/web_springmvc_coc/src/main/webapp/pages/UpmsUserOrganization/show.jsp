<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=UpmsUserOrganization.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form action="${ctx}/pages/UpmsUserOrganization/list.do" method="post">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/UpmsUserOrganization/list.do'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="id" name="id" value="${upmsUserOrganization.id}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=UpmsUserOrganization.ALIAS_USER_ID%></td>	
				<td><c:out value='${upmsUserOrganization.userId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUserOrganization.ALIAS_ORGANIZATION_ID%></td>	
				<td><c:out value='${upmsUserOrganization.organizationId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUserOrganization.ALIAS_CREATE_TIME%></td>	
				<td><c:out value='${upmsUserOrganization.createTime}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUserOrganization.ALIAS_UPDATE_TIME%></td>	
				<td><c:out value='${upmsUserOrganization.updateTime}'/></td>
			</tr>
		</table>
	</form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>