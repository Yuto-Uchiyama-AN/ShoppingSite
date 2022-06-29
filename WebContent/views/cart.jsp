<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../views/header.html" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>カート</title>
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
<h2>CART<span>カート</span></h2>
<!--PC用（901px以上端末）メニュー-->
<nav id="menubar">
<ul>
<li><a href="../views/product.jsp"><span>PRODUCT</span><span>商品</span></a></li>
<li><a href="/ShoppingSite/views/memdelete.jsp"><span>DELETE</span><span>会員削除</span></a></li>
<li><a href="../views/update.jsp"><span>UPDATE</span><span>会員更新</span></a></li>
<li><a href="../views/logout.jsp"><span>LOGOUT</span><span>ログアウト</span></a></li>
</ul>
</nav>
</header>
</div>
</head>
<body>
<form action = "../jp.co.aforce.servlet/cart-info" method="post"></form>

<%try{ %>
	<% if(session.getAttribute("message").toString() != "") { %>
	<p><h3 style="color: red;text-align:center"><%=session.getAttribute("message") %></h3>
	<%}
	session.removeAttribute("message");
	%>

<%} catch (Exception e) {} %>

<p style="text-align:center">ショッピングカート</p>
<table style="boder-collapse:separate;boder-spacing:10px;" align="center">
<c:set var = "priceTotal" value ="${0}" />
<c:forEach var = "memberbean" items="${cart}" varStatus = "status">
<c:set var = "priceTotal" value ="${priceTotal + memberbean.price}" />
	<tr>
	<td><img src="../img/${memberbean.imgname }" width="250px" height="250px"></img><br>
	<td>${memberbean.name}</td>
	<td>${memberbean.price}円</td>
	<td>${memberbean.info}</td>
	<td><form action = "../jp.co.aforce.servlet/cart-delete" method="post"><button name = "itemId" value = "${status.index}">削除</button></form></td>
	</tr>
</c:forEach>


</table>
<p style="text-align:center">小計:<c:out value="${priceTotal}"/>円</p>




<%@include file="../views/footer.html" %>