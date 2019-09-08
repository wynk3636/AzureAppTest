<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>StartPage</title>
	<meta name="viewport" content ="width=device-width">
	<link rel="stylesheet" href=css/style.css>
</head>
<body>
	<div class="container">
		<header>
			<h1>ようこそ!</h1>
		</header>
		<div class ="content">
			<a href="HealthCheck">健康診断</a><br>
			<a href="RegisterUser">ユーザ登録</a>
			<form action="Login" method="post">
				ユーザー名：<input type ="text" name="name"><br>
				パスワード：<input type ="password" name="pass"><br>
				<input type="submit" value="ログイン">
			</form>
		</div>
	</div>
</body>
</html>