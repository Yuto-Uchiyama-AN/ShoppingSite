<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>ログイン</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../css/style.css">
<script src="js/openclose.js"></script>
<script src="js/fixmenu_pagetop.js"></script>
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>

<div id="container">

<header>
<h1 id="logo"><a href="index.html"><img src="../images/SWEETS.jpg" alt="SWEET SHOP"></a></h1>
<h2>LOGIN<span>ログイン</span></h2>
<!--PC用（901px以上端末）メニュー-->
<nav id="menubar">
<ul>
<li><a href="../index.html"><span>Home</span><span>ホーム</span></a></li>
<li><a href="/ShoppingSite/views/login2.jsp"><span>Login</span><span>ログイン</span></a></li>
<li><a href="../menu.html"><span>Menu</span><span>おすすめメニュー</span></a></li>
<li><a href="../access.html"><span>Access</span><span>アクセス</span></a></li>
<li><a href="../recruit.html"><span>News</span><span>お知らせ</span></a></li>
</ul>
</nav>
</header>
</div>


<%
String id = (String)session.getAttribute("isFail");
if(id == null){
	id = "";
}
String message = (String) session.getAttribute("message");
if(message == null){
	message = "";
}
try {
	if(!(boolean)session.getAttribute("isLogin")) { %>
	<h3 style="color: red;text-align:center"><%=message %></h3>
<%}
} catch(NullPointerException e) {}
%>
<hr>

<form action="../loginServlet" method="post">

	<h2 style="text-align:center">ログイン画面</h2>
	<p style="text-align:center">ログインIDとパスワードを入力してください。</p>
	<p style="text-align:center">ログインID:<input type="text" name="id" value="<%=id%>">
	<p style="text-align:center">パスワード:<input type="password" name="password">
	<p style="text-align:center"><input type="submit" value="login">

</form>

<p style="text-align:center"><a href="newlogin.jsp">新規登録はこちら！</a></p>

<%
session.removeAttribute("isLogin");
session.removeAttribute("isFail");
session.removeAttribute("message");
%>

<% session.invalidate(); %>

<%@include file="../views/footer.html" %>