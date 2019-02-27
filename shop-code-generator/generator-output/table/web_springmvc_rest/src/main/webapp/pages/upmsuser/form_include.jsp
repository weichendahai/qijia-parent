<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="id" name="id" value="${upmsUser.id}"/>

	<tr>	
		<td class="tdLabel">
			<span class="required">*</span><%=UpmsUser.ALIAS_USERNAME%>:
		</td>		
		<td>
		<form:input path="username" id="username" cssClass="required " maxlength="20" />
		<font color='red'><form:errors path="username"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<span class="required">*</span><%=UpmsUser.ALIAS_PASSWORD%>:
		</td>		
		<td>
		<form:input path="password" id="password" cssClass="required " maxlength="32" />
		<font color='red'><form:errors path="password"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsUser.ALIAS_SALT%>:
		</td>		
		<td>
		<form:input path="salt" id="salt" cssClass="" maxlength="32" />
		<font color='red'><form:errors path="salt"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsUser.ALIAS_REALNAME%>:
		</td>		
		<td>
		<form:input path="realname" id="realname" cssClass="" maxlength="20" />
		<font color='red'><form:errors path="realname"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsUser.ALIAS_AVATAR%>:
		</td>		
		<td>
		<form:input path="avatar" id="avatar" cssClass="" maxlength="150" />
		<font color='red'><form:errors path="avatar"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsUser.ALIAS_PHONE%>:
		</td>		
		<td>
		<form:input path="phone" id="phone" cssClass="" maxlength="20" />
		<font color='red'><form:errors path="phone"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsUser.ALIAS_EMAIL%>:
		</td>		
		<td>
		<form:input path="email" id="email" cssClass="validate-email " maxlength="50" />
		<font color='red'><form:errors path="email"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsUser.ALIAS_SEX%>:
		</td>		
		<td>
		<form:input path="sex" id="sex" cssClass="validate-integer max-value-2147483647" maxlength="3" />
		<font color='red'><form:errors path="sex"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsUser.ALIAS_LOCKED%>:
		</td>		
		<td>
		<form:input path="locked" id="locked" cssClass="validate-integer max-value-2147483647" maxlength="3" />
		<font color='red'><form:errors path="locked"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsUser.ALIAS_CREATE_TIME%>:
		</td>		
		<td>
		<form:input path="createTime" id="createTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="createTime"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsUser.ALIAS_UPDATE_TIME%>:
		</td>		
		<td>
		<form:input path="updateTime" id="updateTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="updateTime"/></font>
		</td>
	</tr>	
	
		