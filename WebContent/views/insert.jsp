<%@page import="java.util.List"%>
<%@page import="jp.co.aforce.bean.SweetBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@include file="../views/header.html" %>
<p><a href = "../views/logout.jsp">ログアウト</a></p>
<p>追加する商品を入力してください。</p>
<form action = "../jp.co.aforce.servlet/insert" method="post" enctype="multipart/form-data">
商品名<input type = "text" name = "name" required="required"><br>
価格<input type = "text" name = "price"><br>
商品説明:<input type ="text" name="info" required><br>
商品画像:<input type="file" name="imgname"><br>
<button type="submit">登録</button>
<a href="delete.jsp">削除する場合はこちら！</a>
<a href = "proupdate.jsp">更新する場合はこちら！</a>
</form>
<%List<SweetBean> list =(List<SweetBean>) session.getAttribute("list"); %>
<%for(SweetBean p : list) {%>
	<%=p.getId() %>
	<%=p.getName() %>
	<%=p.getPrice() %>
	<%=p.getInfo() %>

<img src="../img/<%=p.getImgname() %>" width="250px" height="250px"></img><br>

<%} %>

<%@include file="../views/footer.html" %>
