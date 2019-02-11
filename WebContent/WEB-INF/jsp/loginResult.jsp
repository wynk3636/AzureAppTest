<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="docoTsubu.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶログイン</title>
</head>
<body>
<%
if(loginUser !=null){
%>
	<P>ログイン成功</P>
	<p>ようこそ<%= loginUser.getName() %>さん<p/>
	<a href ="Main">呟き一覧へ</a>
<%
}
else{
%>
	<p>ログインに失敗しました</p>
	<a href="./">TOP</a>
<%} %>
</body>
</html>