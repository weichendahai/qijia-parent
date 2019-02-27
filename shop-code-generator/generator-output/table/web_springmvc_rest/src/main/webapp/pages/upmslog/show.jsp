<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=UpmsLog.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="upmslog"  >
		<input type="button" value="返回列表" onclick="window.location='${ctx}/upmslog'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="id" name="id" value="${upmsLog.id}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=UpmsLog.ALIAS_DESCRIPTION%></td>	
				<td><c:out value='${upmsLog.description}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsLog.ALIAS_USERNAME%></td>	
				<td><c:out value='${upmsLog.username}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsLog.ALIAS_START_TIME%></td>	
				<td><c:out value='${upmsLog.startTime}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsLog.ALIAS_SPEND_TIME%></td>	
				<td><c:out value='${upmsLog.spendTime}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsLog.ALIAS_BASE_PATH%></td>	
				<td><c:out value='${upmsLog.basePath}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsLog.ALIAS_URI%></td>	
				<td><c:out value='${upmsLog.uri}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsLog.ALIAS_URL%></td>	
				<td><c:out value='${upmsLog.url}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsLog.ALIAS_METHOD%></td>	
				<td><c:out value='${upmsLog.method}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsLog.ALIAS_PARAMETER%></td>	
				<td><c:out value='${upmsLog.parameter}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsLog.ALIAS_USER_AGENT%></td>	
				<td><c:out value='${upmsLog.userAgent}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsLog.ALIAS_IP%></td>	
				<td><c:out value='${upmsLog.ip}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsLog.ALIAS_RESULT%></td>	
				<td><c:out value='${upmsLog.result}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsLog.ALIAS_PERMISSIONS%></td>	
				<td><c:out value='${upmsLog.permissions}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsLog.ALIAS_CREATE_TIME%></td>	
				<td><c:out value='${upmsLog.createTime}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsLog.ALIAS_UPDATE_TIME%></td>	
				<td><c:out value='${upmsLog.updateTime}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>