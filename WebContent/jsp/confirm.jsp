<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Comfirm</title>
</head>
<body>
	<div class="title">
        <h1>新規登録確認</h1>
    </div>

	<s:form action="insert" method="POST" name="form" theme="simple" autocomplete="off">
		<table>
			<tr>
				<th><s:text name="問題" /></th>
				<td><s:textfield name="question" readonly="true" value="%{question}" /></td>
			</tr>

			<s:iterator value='ansAry' end="ansAry.length" status="i">
				<tr>
					<th><s:text name="答え" /></th>
					<td><s:textfield name="answer" readonly="true" value="%{ansAry[#i.index].trim()}"/></td>
				</tr>
			</s:iterator>
		</table>

		<div class="back-btn">
			<s:a href="/Struts2App/jsp/register.jsp">戻る</s:a>
		</div>
		<s:submit value="登録"></s:submit>
	</s:form>

</body>
</html>