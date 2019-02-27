<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=UpmsRole.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="upmsrole"  >
		<input type="button" value="返回列表" onclick="window.location='${ctx}/upmsrole'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="id" name="id" value="${upmsRole.id}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=UpmsRole.ALIAS_NAME%></td>	
				<td><c:out value='${upmsRole.name}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsRole.ALIAS_TITLE%></td>	
				<td><c:out value='${upmsRole.title}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsRole.ALIAS_DESCRIPTION%></td>	
				<td><c:out value='${upmsRole.description}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsRole.ALIAS_ORDERS%></td>	
				<td><c:out value='${upmsRole.orders}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsRole.ALIAS_CREATE_TIME%></td>	
				<td><c:out value='${upmsRole.createTime}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsRole.ALIAS_UPDATE_TIME%></td>	
				<td><c:out value='${upmsRole.updateTime}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>