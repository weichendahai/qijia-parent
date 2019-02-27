<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=UpmsUser.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form action="${ctx}/pages/UpmsUser/list.do" method="post">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/UpmsUser/list.do'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="id" name="id" value="${upmsUser.id}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=UpmsUser.ALIAS_USERNAME%></td>	
				<td><c:out value='${upmsUser.username}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUser.ALIAS_PASSWORD%></td>	
				<td><c:out value='${upmsUser.password}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUser.ALIAS_SALT%></td>	
				<td><c:out value='${upmsUser.salt}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUser.ALIAS_REALNAME%></td>	
				<td><c:out value='${upmsUser.realname}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUser.ALIAS_AVATAR%></td>	
				<td><c:out value='${upmsUser.avatar}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUser.ALIAS_PHONE%></td>	
				<td><c:out value='${upmsUser.phone}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUser.ALIAS_EMAIL%></td>	
				<td><c:out value='${upmsUser.email}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUser.ALIAS_SEX%></td>	
				<td><c:out value='${upmsUser.sex}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUser.ALIAS_LOCKED%></td>	
				<td><c:out value='${upmsUser.locked}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUser.ALIAS_CREATE_TIME%></td>	
				<td><c:out value='${upmsUser.createTime}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UpmsUser.ALIAS_UPDATE_TIME%></td>	
				<td><c:out value='${upmsUser.updateTime}'/></td>
			</tr>
		</table>
	</form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>