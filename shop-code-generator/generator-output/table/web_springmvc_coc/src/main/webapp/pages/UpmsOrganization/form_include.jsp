<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="id" name="id" value="${upmsOrganization.id}"/>

	<tr>	
		<td class="tdLabel">
			<%=UpmsOrganization.ALIAS_PID%>:
		</td>		
		<td>
		<form:input path="upmsOrganization.pid" id="pid" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="pid"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsOrganization.ALIAS_NAME%>:
		</td>		
		<td>
		<form:input path="upmsOrganization.name" id="name" cssClass="" maxlength="20" />
		<font color='red'><form:errors path="name"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsOrganization.ALIAS_DESCRIPTION%>:
		</td>		
		<td>
		<form:input path="upmsOrganization.description" id="description" cssClass="" maxlength="1000" />
		<font color='red'><form:errors path="description"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsOrganization.ALIAS_CREATE_TIME%>:
		</td>		
		<td>
		<form:input path="upmsOrganization.createTime" id="createTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="createTime"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsOrganization.ALIAS_UPDATE_TIME%>:
		</td>		
		<td>
		<form:input path="upmsOrganization.updateTime" id="updateTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="updateTime"/></font>
		</td>
	</tr>	
	


