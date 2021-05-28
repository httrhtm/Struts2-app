<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>

	<h1>問題一覧</h1>

	<div class="header-nav">
		<s:a action="logout">Logout</s:a>
		<s:a action="top">Top</s:a>
	</div>

	<div class="register-btn">
		<s:a href="register">新規登録</s:a>
	</div>

	<div class="main">
		<table class="table">

			<!-- Question ループ処理 -->
			<s:iterator value="qlist" end="qlist.size()" status="qst">
			<s:set value="id" var="id"/>

				<tr class="question">

					<th>問題:</th>
					<td><s:property value="id"/></td>
					<td><s:property value="question" /></td>
					<td>
						<!-- Edit -->
						<s:form action="" method="POST" name="form">
							<s:submit value="編集"></s:submit>
						</s:form>
					</td>
					<td>
						<!-- Delete -->
						<s:form action="delete_confirm.action" method="POST" name="form" >
							<s:hidden name="id" value="%{#id}"></s:hidden>
							<s:submit value="削除"></s:submit>
						</s:form>
					</td>
				</tr>

				<!-- Answer ループ処理 -->
				<s:iterator value="calist" end="calist.size()" status="cast">
				<s:set value="questions_id" var="questions_id"/>

				<s:if test="%{#id == #questions_id}">

					<tr class="answer">
						<th>答え:</th>
						<td><s:property value="id"/></td>
						<td><s:property value="answer" /></td>
					</tr>

				</s:if>

				</s:iterator>
			</s:iterator>

		</table>
	</div>

</body>
</html>