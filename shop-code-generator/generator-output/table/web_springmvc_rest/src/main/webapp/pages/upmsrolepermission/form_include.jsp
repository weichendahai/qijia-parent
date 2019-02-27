<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="id" name="id" value="${upmsRolePermission.id}"/>

	<tr>	
		<td class="tdLabel">
			<span class="required">*</span><%=UpmsRolePermission.ALIAS_ROLE_ID%>:
		</td>		
		<td>
		<form:input path="roleId" id="roleId" cssClass="required validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="roleId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<span class="required">*</span><%=UpmsRolePermission.ALIAS_PERMISSION_ID%>:
		</td>		
		<td>
		<form:input path="permissionId" id="permissionId" cssClass="required validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="permissionId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsRolePermission.ALIAS_CREATE_TIME%>:
		</td>		
		<td>
		<form:input path="createTime" id="createTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="createTime"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsRolePermission.ALIAS_UPDATE_TIME%>:
		</td>		
		<td>
		<form:input path="updateTime" id="updateTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="updateTime"/></font>
		</td>
	</tr>	
	
		