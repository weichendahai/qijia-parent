<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="id" name="id" value="${upmsPermission.id}"/>

	<tr>	
		<td class="tdLabel">
			<span class="required">*</span><%=UpmsPermission.ALIAS_SYSTEM_ID%>:
		</td>		
		<td>
		<form:input path="systemId" id="systemId" cssClass="required validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="systemId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsPermission.ALIAS_PID%>:
		</td>		
		<td>
		<form:input path="pid" id="pid" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="pid"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsPermission.ALIAS_NAME%>:
		</td>		
		<td>
		<form:input path="name" id="name" cssClass="" maxlength="20" />
		<font color='red'><form:errors path="name"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsPermission.ALIAS_TYPE%>:
		</td>		
		<td>
		<form:input path="type" id="type" cssClass="validate-integer max-value-2147483647" maxlength="3" />
		<font color='red'><form:errors path="type"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsPermission.ALIAS_PERMISSION_VALUE%>:
		</td>		
		<td>
		<form:input path="permissionValue" id="permissionValue" cssClass="" maxlength="50" />
		<font color='red'><form:errors path="permissionValue"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsPermission.ALIAS_URI%>:
		</td>		
		<td>
		<form:input path="uri" id="uri" cssClass="" maxlength="100" />
		<font color='red'><form:errors path="uri"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsPermission.ALIAS_ICON%>:
		</td>		
		<td>
		<form:input path="icon" id="icon" cssClass="" maxlength="50" />
		<font color='red'><form:errors path="icon"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsPermission.ALIAS_STATUS%>:
		</td>		
		<td>
		<form:input path="status" id="status" cssClass="validate-integer max-value-2147483647" maxlength="3" />
		<font color='red'><form:errors path="status"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsPermission.ALIAS_ORDERS%>:
		</td>		
		<td>
		<form:input path="orders" id="orders" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="orders"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsPermission.ALIAS_CREATE_TIME%>:
		</td>		
		<td>
		<form:input path="createTime" id="createTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="createTime"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsPermission.ALIAS_UPDATE_TIME%>:
		</td>		
		<td>
		<form:input path="updateTime" id="updateTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="updateTime"/></font>
		</td>
	</tr>	
	
		