<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Confirm</title>
</head>
<body>
	<div class="title">
        <h1>削除確認</h1>
    </div>

    <div class="header-nav">
		<s:a action="logout">Logout</s:a>
		<s:a action="top">Top</s:a>
	</div>

	<s:form action="delete" method="POST" name="form">
		<table>
			<s:set value="id" var="id"/>

			<tr>
				<th>問題:</th>
				<td><s:property value="id"/></td>
				<td><s:textfield name="question" readonly="true" value="%{q.question}" /></td>
				<s:hidden name="id" value="%{#id}"></s:hidden>
			</tr>


					<tr>
					<s:iterator value='calist'>
						<th>答え:</th>
						<td><s:property value="id"/></td>
						<td><s:textfield name="answer" readonly="true" value="%{answer}"/></td>
					</s:iterator>
					</tr>


		</table>

		<div class="back-btn">
			<s:a action="list.action">戻る</s:a>
		</div>
		<s:submit value="削除"></s:submit>
	</s:form>

</body>
</html>