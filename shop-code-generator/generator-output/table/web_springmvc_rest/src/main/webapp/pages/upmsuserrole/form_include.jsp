<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="id" name="id" value="${upmsUserRole.id}"/>

	<tr>	
		<td class="tdLabel">
			<span class="required">*</span><%=UpmsUserRole.ALIAS_USER_ID%>:
		</td>		
		<td>
		<form:input path="userId" id="userId" cssClass="required validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="userId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsUserRole.ALIAS_ROLE_ID%>:
		</td>		
		<td>
		<form:input path="roleId" id="roleId" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="roleId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsUserRole.ALIAS_CREATE_TIME%>:
		</td>		
		<td>
		<form:input path="createTime" id="createTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="createTime"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsUserRole.ALIAS_UPDATE_TIME%>:
		</td>		
		<td>
		<form:input path="updateTime" id="updateTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="updateTime"/></font>
		</td>
	</tr>	
	
		