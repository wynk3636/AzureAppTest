<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="docoTsubu.*,java.util.List" %>
 
 <%
 //セッションスコープに保存されたユーザ情報を取得
 User loginUser = (User) session.getAttribute("loginUser");
 //アプリケーションスコープに保存された情報を取得
 List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
 //エラーメッセージを取得
 String errorMSG = (String) request.getAttribute("errorMSG");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<p>
<%=loginUser.getName() %>さんログイン中
<br>
<a href="Logout">ログアウト</a>
</p>
<p>
<a href="Main">更新</a>
</p>
<form action="Main" method="post">
	<input type ="text" name="text">
	<input type ="submit" value="呟く">
</form>
<%
if(errorMSG!=null){
%>
<p><%=errorMSG %></p>
<%} %>
<%
for(Mutter mutter:mutterList){
%>
	<p><%=mutter.getUserName() %>：<%=mutter.getText() %></p>
<%
}
%>
</body>
</html>