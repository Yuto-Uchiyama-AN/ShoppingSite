<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="header.html"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>会員登録</title>
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
<h2>NEWLOGIN<span>会員登録</span></h2>
<!--PC用（901px以上端末）メニュー-->
<nav id="menubar">
<ul>
<li><a href="/ShoppingSite/views/login2.jsp"><span>Login</span><span>ログイン</span></a></li>
</ul>
</nav>
</header>
</div>
 <%try{ %>
	<% if(request.getAttribute("message").toString() != "") { %>
	<p><h3 style="color: red;text-align:center"><%=request.getAttribute("message").toString() %></h3>
	<%} %>
<%} catch (Exception e) {} %>

<hr>

<p style="text-align:center">会員登録</p>

<form action="../jp.co.aforce.servlet/Servret" method="post">
	<p style="text-align:center">ID:<input type="text" name="id" required="required">
	<p style="text-align:center">名前:<input type="text" name="name" required="required">
	<p style="text-align:center">パスワード:<input type = "password" name= "password" required="required">
	<p style="text-align:center">権限:<input type = "checkbox" name="A" value="admin">管理者
	<input type = "checkbox" name="A" value="general">一般
	<p style="text-align:center"><input type="submit" value="登録">
	<p style="text-align:center"><a href="/ShoppingSite/views/login2.jsp">戻る</a></p>
</form>


<%@include file="../views/footer.html" %>