<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
	<h3 style="color: red;"><%=message %></h3>
<%}
} catch(NullPointerException e) {}
%>
<a href = "./../index.html">トップページ</a>
<a href="login.jsp"><span>ログイン</span></a>
<a href="./../menu.html"><span>本日のおすすめ</span></a>
<a href="./../access.html"><span>アクセス</span></a>
<a href="./../recruit.html"><span>ニュース</span></a>
<hr>
<title>ログイン</title>

<form action="../loginServlet" method="post">

	<h2>ログイン画面</h2>
	<p>ログインIDとパスワードを入力してください。</p>
	<p>ログインID:<input type="text" name="id" value="<%=id%>">
	<p>パスワード:<input type="password" name="password">
	<p><input type="submit" value="login">

</form>

<a href="newlogin.jsp">新規登録はこちら！</a>

<%
session.removeAttribute("isLogin");
session.removeAttribute("isFail");
session.removeAttribute("message");
%>

<% session.invalidate(); %>

<%@include file="../views/footer.html" %>
