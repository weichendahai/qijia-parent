<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="id" name="id" value="${upmsRole.id}"/>

	<tr>	
		<td class="tdLabel">
			<%=UpmsRole.ALIAS_NAME%>:
		</td>		
		<td>
		<form:input path="upmsRole.name" id="name" cssClass="" maxlength="20" />
		<font color='red'><form:errors path="name"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsRole.ALIAS_TITLE%>:
		</td>		
		<td>
		<form:input path="upmsRole.title" id="title" cssClass="" maxlength="20" />
		<font color='red'><form:errors path="title"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsRole.ALIAS_DESCRIPTION%>:
		</td>		
		<td>
		<form:input path="upmsRole.description" id="description" cssClass="" maxlength="1000" />
		<font color='red'><form:errors path="description"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<span class="required">*</span><%=UpmsRole.ALIAS_ORDERS%>:
		</td>		
		<td>
		<form:input path="upmsRole.orders" id="orders" cssClass="required validate-integer " maxlength="19" />
		<font color='red'><form:errors path="orders"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsRole.ALIAS_CREATE_TIME%>:
		</td>		
		<td>
		<form:input path="upmsRole.createTime" id="createTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="createTime"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsRole.ALIAS_UPDATE_TIME%>:
		</td>		
		<td>
		<form:input path="upmsRole.updateTime" id="updateTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="updateTime"/></font>
		</td>
	</tr>	
	


