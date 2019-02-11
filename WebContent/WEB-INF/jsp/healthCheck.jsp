<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="doHealthCheck.Health" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>健康診断</title>
	<meta name="viewport" content ="width=device-width">
	<link rel="stylesheet" href=css/style.css>
</head>
<body>
	<script type="text/javascript" src="js/CheckData.js"></script>
	<div class="container">
		<header>
			<h1>健康診断</h1>
		</header>
		<div class ="content">
			<%-- ※JSPファイルの場合：/アプリケーション名/WebContentからのパス --%>
			<%-- ※サーブレットクラスの場合：/アプリケーション名/URLパターン --%>
			<form name="postData" action="HealthCheck" method="post" onSubmit="return CheckData()">
				身長：<input type="text" name="height">(cm)<br>
				体重：<input type="text" name="weight">(kg)<br><br>
					 <input type="submit" value="診断">
			</form>
			<br><br><hr>
			<a href="./">戻る</a>
		</div>
	</div>
</body>
</html>