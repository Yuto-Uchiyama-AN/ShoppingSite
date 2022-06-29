<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>会員情報削除</title>
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
<h2>DELETE<span>会員削除</span></h2>
<!--PC用（901px以上端末）メニュー-->
<nav id="menubar">
<ul>
<li><a href="../views/product.jsp"><span>PRODUCT</span><span>商品</span></a></li>
<li><a href="../views/update.jsp"><span>UPDATE</span><span>会員更新</span></a></li>
<li><a href="../views/cart.jsp"><span>CART</span><span>カート</span></a></li>
<li><a href="../views/logout.jsp"><span>LOGOUT</span><span>ログアウト</span></a></li>
</ul>
</nav>
</header>
</div>
</head>
<body>

<%try{ %>
	<% if(session.getAttribute("deleteMessage").toString() != "") { %>
	<p><h3 style="color: red;text-align:center"><%=session.getAttribute("deleteMessage") %></h3>
	<%}
	session.removeAttribute("deleteMessage");%>

<%} catch (Exception e) {} %>
<hr>
<h2 style="text-align:center">会員情報削除</h2>

<form action="./../MemberSearch" method="post" name="search">

<p style="text-align:center">ID<br>
	<input type="text" name="id" id="id" oninput="updateValue();" value="${sessionScope.deleteid }">
	<button type="submit">検索</button></p>
</form>

<form action="../DleteMember" method="post">

	<input type="hidden" name="id" id="idHidden" value="${sessionScope.deleteid }">


	<p style="text-align:center"><a href="product.jsp">
    	<button type="button">戻る</button>
	</a>
	<button type="button" onclick="formReset()">リセット</button>
	<button type="submit">削除</button></p>

</form>
<script type="text/javascript" src="../js/scriptvar3.js"></script>
<%@include file="footer.html" %>
