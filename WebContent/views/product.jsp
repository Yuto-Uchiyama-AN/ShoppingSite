<%@page import="jp.co.aforce.bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file ="../views/header.html" %>
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
<h2>PRODUCT<span>商品</span></h2>
<!--PC用（901px以上端末）メニュー-->
<nav id="menubar">
<ul>

<li><a href="/ShoppingSite/views/memdelete.jsp"><span>DELETE</span><span>会員削除</span></a></li>
<li><a href="../views/update.jsp"><span>UPDATE</span><span>会員更新</span></a></li>
<li><a href="../views/cart.jsp"><span>CART</span><span>カート</span></a></li>
<li><a href="../views/logout.jsp"><span>LOGOUT</span><span>ログアウト</span></a></li>
</ul>
</nav>
</header>
</div>
</head>
<body>

<p style="text-align:center">検索キーワードを入力してください。</p>

<form action = "../ProductSearch" method="post">

<p style="text-align:center"><input type = "text" name = "keyword">
<input type = "submit" value="検索"></p>
</form>
<hr>


<table style="boder-collapse:separate;boder-spacing:10px; margin:0 auto;">


<c:forEach var = "memberbean" items="${list}" >



	<tr>
	<td><img src="../img/${memberbean.imgname }" width="150px" height="150px" ></img><br>
	<td>${memberbean.name}</td>
	<td>${memberbean.price}円</td>
	<td>${memberbean.info}</td>
	<td><form action = "../jp.co.aforce.servlet/cart-plus" method="post"><button name = "itemId" value = "${memberbean.id}">カートに追加</button></form></td>
	</tr>
</c:forEach>

</table>




<%@include file="../views/footer.html" %>