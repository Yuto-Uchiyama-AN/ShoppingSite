<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../views/header.html" %>

<p>検索キーワードを入力してください。</p>
<form action = "../jp.co.aforce.servlet/search" method="post">
<input type = "text" name = "keyword">
<input type = "submit" value = "検索">
</form>


<%@include file="../views/footer.html" %>