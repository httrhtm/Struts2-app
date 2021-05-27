<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Struts2のタグライブラリを使用可能にする -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top</title>
</head>
<body>
	<h1>Top</h1>
	<div class="header-nav">
		<s:a action="logout">logout</s:a>
	</div>
	<div class="main-nav">
		<div class="button">
			<s:a action="list.action">問題と答えを確認・登録する　＞</s:a>
		</div>
		<div class="button">
			<s:a action="">テストをする　＞</s:a>
		</div>
		<div class="button">
			<s:a action="">過去の採点結果をみる　＞</s:a>
		</div>
	</div>
</body>
</html>