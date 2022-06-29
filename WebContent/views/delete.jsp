<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報削除</title>
</head>
<body>

<%try{ %>
	<% if(session.getAttribute("deleteMessage").toString() != "") { %>
	<p><h3 style="color: red"><%=session.getAttribute("deleteMessage") %></h3>
	<%}
	session.removeAttribute("deleteMessage");%>

<%} catch (Exception e) {} %>

<strong>商品情報削除</strong>

<form action="./../DeleteSearchServletver2" method="post" name="search">

商品番号<br>
	<input type="text" name="id" id="id" oninput="updateValue();" value="${sessionScope.deleteBean.id }">
	<button type="submit">検索</button>
</form>

<form action="../DeleteServlet" method="post">

	<input type="hidden" name="id" id="idHidden" value="${sessionScope.deleteBean.id }">

	<p>名前<br>
	<input type="text" id="name" name="name" value="${sessionScope.deleteBean.name }"></p>

	<p>値段<br>
	<input type="text" id="price" name="price" value="${sessionScope.deleteBean.price }"></p>

	<p>説明<br>
	<input type="text" id="info" name="info" value="${sessionScope.deleteBean.info }"></p>

	<p>商品画像<br>
	<input type="file"id="imgname" name="imgname" value="${sessionScope.deleteBean.price }"></p>


	<a href="insert.jsp">
    	<button type="button">戻る</button>
	</a>
	<button type="button" onclick="formReset()">リセット</button>
	<button type="submit">削除</button>

</form>
<script type="text/javascript" src="../js/scriptvar2.js"></script>
<%@include file="footer.html" %>