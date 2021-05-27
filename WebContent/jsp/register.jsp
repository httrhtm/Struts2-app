<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<div style="color:red">
        <s:property value="errorMessage"/>
    </div>

    <div class="title">
        <h1>新規登録</h1>
    </div>

	<s:form action="confirm" method="POST" name="form" theme="simple" autocomplete="off">
		<table>
			<tr>
				<th><s:text name="問題" /></th>
				<td><s:textfield name="question" /></td>
			</tr>

			<tr>
				<th><s:text name="答え" /></th>
				<td>
					<s:textfield name="answer" value="" />
				</td>
			</tr>

			<tr>
				<th><s:text name="答え" /></th>
				<td><s:textfield name="answer" value="" /></td>
			</tr>
		</table>

		<div class="back-btn">
			<s:a action="list.action">戻る</s:a>
		</div>

		<s:submit value="確認"></s:submit>
	</s:form>



</body>
</html>