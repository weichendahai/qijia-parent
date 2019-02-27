<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=UpmsOrganization.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="upmsorganization"  >
		<input type="button" value="返回列表" onclick="window.location='${ctx}/upmsorganization'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="id" name="id" value="${upmsOrganization.id}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=UpmsOrganization.ALIAS_PID%></td>	
				<td><c:out value='${upmsOrganization.pid}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsOrganization.ALIAS_NAME%></td>	
				<td><c:out value='${upmsOrganization.name}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsOrganization.ALIAS_DESCRIPTION%></td>	
				<td><c:out value='${upmsOrganization.description}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsOrganization.ALIAS_CREATE_TIME%></td>	
				<td><c:out value='${upmsOrganization.createTime}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsOrganization.ALIAS_UPDATE_TIME%></td>	
				<td><c:out value='${upmsOrganization.updateTime}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>