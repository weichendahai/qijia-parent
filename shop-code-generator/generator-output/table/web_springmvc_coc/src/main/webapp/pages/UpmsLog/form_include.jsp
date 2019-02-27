<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="id" name="id" value="${upmsLog.id}"/>

	<tr>	
		<td class="tdLabel">
			<%=UpmsLog.ALIAS_DESCRIPTION%>:
		</td>		
		<td>
		<form:input path="upmsLog.description" id="description" cssClass="" maxlength="100" />
		<font color='red'><form:errors path="description"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsLog.ALIAS_USERNAME%>:
		</td>		
		<td>
		<form:input path="upmsLog.username" id="username" cssClass="" maxlength="20" />
		<font color='red'><form:errors path="username"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsLog.ALIAS_START_TIME%>:
		</td>		
		<td>
		<form:input path="upmsLog.startTime" id="startTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="startTime"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsLog.ALIAS_SPEND_TIME%>:
		</td>		
		<td>
		<form:input path="upmsLog.spendTime" id="spendTime" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="spendTime"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsLog.ALIAS_BASE_PATH%>:
		</td>		
		<td>
		<form:input path="upmsLog.basePath" id="basePath" cssClass="" maxlength="500" />
		<font color='red'><form:errors path="basePath"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsLog.ALIAS_URI%>:
		</td>		
		<td>
		<form:input path="upmsLog.uri" id="uri" cssClass="" maxlength="500" />
		<font color='red'><form:errors path="uri"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsLog.ALIAS_URL%>:
		</td>		
		<td>
		<form:input path="upmsLog.url" id="url" cssClass="" maxlength="500" />
		<font color='red'><form:errors path="url"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsLog.ALIAS_METHOD%>:
		</td>		
		<td>
		<form:input path="upmsLog.method" id="method" cssClass="" maxlength="10" />
		<font color='red'><form:errors path="method"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsLog.ALIAS_PARAMETER%>:
		</td>		
		<td>
		<form:input path="upmsLog.parameter" id="parameter" cssClass="" maxlength="16777215" />
		<font color='red'><form:errors path="parameter"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsLog.ALIAS_USER_AGENT%>:
		</td>		
		<td>
		<form:input path="upmsLog.userAgent" id="userAgent" cssClass="" maxlength="500" />
		<font color='red'><form:errors path="userAgent"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsLog.ALIAS_IP%>:
		</td>		
		<td>
		<form:input path="upmsLog.ip" id="ip" cssClass="" maxlength="30" />
		<font color='red'><form:errors path="ip"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsLog.ALIAS_RESULT%>:
		</td>		
		<td>
		<form:input path="upmsLog.result" id="result" cssClass="" maxlength="16777215" />
		<font color='red'><form:errors path="result"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsLog.ALIAS_PERMISSIONS%>:
		</td>		
		<td>
		<form:input path="upmsLog.permissions" id="permissions" cssClass="" maxlength="100" />
		<font color='red'><form:errors path="permissions"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsLog.ALIAS_CREATE_TIME%>:
		</td>		
		<td>
		<form:input path="upmsLog.createTime" id="createTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="createTime"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsLog.ALIAS_UPDATE_TIME%>:
		</td>		
		<td>
		<form:input path="upmsLog.updateTime" id="updateTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="updateTime"/></font>
		</td>
	</tr>	
	


