<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>会員情報更新</title>
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
<h2>UPDATE<span>会員更新</span></h2>
<!--PC用（901px以上端末）メニュー-->
<nav id="menubar">
<ul>
<li><a href="../views/product.jsp"><span>PRODUCT</span><span>商品</span></a></li>
<li><a href="/ShoppingSite/views/memdelete.jsp"><span>DELETE</span><span>会員削除</span></a></li>
<li><a href="../views/cart.jsp"><span>CART</span><span>カート</span></a></li>
<li><a href="../views/logout.jsp"><span>LOGOUT</span><span>ログアウト</span></a></li>
</ul>
</nav>
</header>
</div>
</head>
<body>
<script type="text/javascript" src="../js/script.js"></script>
<%try{ %>
	<% if(session.getAttribute("updateMessage").toString() != "") { %>
	<p><h3 style="color: red;text-align:center"><%=session.getAttribute("updateMessage") %></h3>
	<%}
	session.removeAttribute("updateMessage");%>

<%} catch (Exception e) {} %>
<hr>
<h2 style="text-align:center">会員情報更新</h2>

<form action="./../UpdateSearch" method="post" name="search">
	<p style="text-align:center">会員番号<br>
	<input type="text" name="id" id="id" oninput="updateValue();" value="${sessionScope.updateBean.id }">
	<button type="submit">検索</button></p>
</form>

<form action="../UpdateServlet" method="post">

	<input type="hidden" name="id" id="idHidden" value="${sessionScope.updateBean.id }">

	<p style="text-align:center">名前<br>
	<input type="text" id="name" name="name" value="${sessionScope.updateBean.name }"></p>

	<p style="text-align:center">パスワード<br>
	<input type="password"id="password" name="password" value="${sessionScope.updateBean.password }"></p>

	<p style="text-align:center"><a href="product.jsp">
    	<button type="button">戻る</button>
	</a>

	<button type="button" onclick="formReset()">リセット</button>
	<button type="submit">更新</button></p>

</form>
<script type="text/javascript" src="../js/scriptvar3.js"></script>
<%@include file="footer.html" %>