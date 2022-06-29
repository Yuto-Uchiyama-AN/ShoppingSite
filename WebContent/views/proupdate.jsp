<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報更新</title>
</head>
<body>
<script type="text/javascript" src="../js/script.js"></script>
<%try{ %>
	<% if(session.getAttribute("updateMessage").toString() != "") { %>
	<p><h3 style="color: red"><%=session.getAttribute("updateMessage") %></h3>
	<%}
	session.removeAttribute("updateMessage");%>

<%} catch (Exception e) {} %>

<h2>商品情報更新</h2>

<form action="./../ProductUpdateSearch" method="post" name="search">
	商品番号<br>
	<input type="text" name="id" id="id" oninput="updateValue();" value="${sessionScope.updateBean.id }">
	<button type="submit">検索</button>
</form>

<form action="../ProductUpdateServlet" method="post">

	<input type="hidden" name="id" id="idHidden" value="${sessionScope.proupdateBean.id }">

	<p>名前<br>
	<input type="text" id="name" name="name" value="${sessionScope.proupdateBean.name }"></p>

	<p>値段<br>
	<input type="text" id="price" name="price" value="${sessionScope.proupdateBean.price }"></p>

	<p>説明<br>
	<input type="text" id="info" name="info" value="${sessionScope.proupdateBean.info }"></p>

	<p>商品画像<br>
	<input type="file"id="imgname" name="imgname" value="${sessionScope.proupdateBean.price }"></p>

	<a href="insert.jsp">
    	<button type="button">戻る</button>
	</a>

	<button type="button" onclick="formReset()">リセット</button>
	<button type="submit">更新</button>

</form>
<script type="text/javascript" src="../js/scriptvar2.js"></script>
<%@include file="footer.html" %>