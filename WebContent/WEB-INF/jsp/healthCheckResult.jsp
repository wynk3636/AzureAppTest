<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="doHealthCheck.Health" %>
<%
    //リクエストスコープに保存されたHealthを取得
    Health health = (Health) request.getAttribute("health");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>健康診断</title>
	<meta name="viewport" content ="width=device-width">
	<link rel="stylesheet" href=css/style.css>
</head>
<body>
	<div class="container">
		<header>
			<h1>健康診断の結果</h1>
		</header>
		<div class ="content">
			<p>
			    身長：<%= health.getHeight() %><br>
			    体重：<%= health.getWeight() %><br>
			    BMI：<%= health.getBmi() %><br>
			    体格：<%= health.getBodyType() %>
			</p>
			<br><hr>
			<a href="HealthCheck">戻る</a>
		</div>
	</div>
</body>
</html>