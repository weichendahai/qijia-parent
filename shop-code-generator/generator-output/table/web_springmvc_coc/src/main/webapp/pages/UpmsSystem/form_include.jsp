<%@page import="com.qijia.upms.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="id" name="id" value="${upmsSystem.id}"/>

	<tr>	
		<td class="tdLabel">
			<%=UpmsSystem.ALIAS_ICON%>:
		</td>		
		<td>
		<form:input path="upmsSystem.icon" id="icon" cssClass="" maxlength="50" />
		<font color='red'><form:errors path="icon"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsSystem.ALIAS_BANNER%>:
		</td>		
		<td>
		<form:input path="upmsSystem.banner" id="banner" cssClass="" maxlength="150" />
		<font color='red'><form:errors path="banner"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsSystem.ALIAS_THEME%>:
		</td>		
		<td>
		<form:input path="upmsSystem.theme" id="theme" cssClass="" maxlength="50" />
		<font color='red'><form:errors path="theme"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsSystem.ALIAS_BASEPATH%>:
		</td>		
		<td>
		<form:input path="upmsSystem.basepath" id="basepath" cssClass="" maxlength="100" />
		<font color='red'><form:errors path="basepath"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsSystem.ALIAS_STATUS%>:
		</td>		
		<td>
		<form:input path="upmsSystem.status" id="status" cssClass="validate-integer max-value-2147483647" maxlength="3" />
		<font color='red'><form:errors path="status"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsSystem.ALIAS_NAME%>:
		</td>		
		<td>
		<form:input path="upmsSystem.name" id="name" cssClass="" maxlength="20" />
		<font color='red'><form:errors path="name"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsSystem.ALIAS_TITLE%>:
		</td>		
		<td>
		<form:input path="upmsSystem.title" id="title" cssClass="" maxlength="20" />
		<font color='red'><form:errors path="title"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsSystem.ALIAS_DESCRIPTION%>:
		</td>		
		<td>
		<form:input path="upmsSystem.description" id="description" cssClass="" maxlength="300" />
		<font color='red'><form:errors path="description"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsSystem.ALIAS_ORDERS%>:
		</td>		
		<td>
		<form:input path="upmsSystem.orders" id="orders" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="orders"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsSystem.ALIAS_CREATE_TIME%>:
		</td>		
		<td>
		<form:input path="upmsSystem.createTime" id="createTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="createTime"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=UpmsSystem.ALIAS_UPDATE_TIME%>:
		</td>		
		<td>
		<form:input path="upmsSystem.updateTime" id="updateTime" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="updateTime"/></font>
		</td>
	</tr>	
	

