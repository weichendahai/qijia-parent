<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=UpmsSystem.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="upmssystem"  >
		<input type="button" value="返回列表" onclick="window.location='${ctx}/upmssystem'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="id" name="id" value="${upmsSystem.id}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=UpmsSystem.ALIAS_ICON%></td>	
				<td><c:out value='${upmsSystem.icon}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsSystem.ALIAS_BANNER%></td>	
				<td><c:out value='${upmsSystem.banner}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsSystem.ALIAS_THEME%></td>	
				<td><c:out value='${upmsSystem.theme}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsSystem.ALIAS_BASEPATH%></td>	
				<td><c:out value='${upmsSystem.basepath}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsSystem.ALIAS_STATUS%></td>	
				<td><c:out value='${upmsSystem.status}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsSystem.ALIAS_NAME%></td>	
				<td><c:out value='${upmsSystem.name}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsSystem.ALIAS_TITLE%></td>	
				<td><c:out value='${upmsSystem.title}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsSystem.ALIAS_DESCRIPTION%></td>	
				<td><c:out value='${upmsSystem.description}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsSystem.ALIAS_ORDERS%></td>	
				<td><c:out value='${upmsSystem.orders}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsSystem.ALIAS_CREATE_TIME%></td>	
				<td><c:out value='${upmsSystem.createTime}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsSystem.ALIAS_UPDATE_TIME%></td>	
				<td><c:out value='${upmsSystem.updateTime}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>