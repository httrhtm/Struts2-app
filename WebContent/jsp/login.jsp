<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Struts2のタグライブラリを使用可能にする -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div style="color:red">
        <s:property value="errorMessage"/>
    </div>

	<s:form action="login" method="POST" name="form" theme="simple" autocomplete="off">
		<table>
			<tr>
				<th><s:text name="ID" /></th>
				<td><s:textfield name="id" /></td>
			</tr>

			<tr>
				<th><s:text name="PW" /></th>
				<td><s:password name="password" /></td>
			</tr>
		</table>
		<s:submit value="ログイン"></s:submit>
	</s:form>

</body>
</html>