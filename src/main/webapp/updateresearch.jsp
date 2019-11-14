<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ResearchDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Research</title>
</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/user/getall">Users</a>
  <a href="/research/getall">Researches</a>
  <a href="/topic/getall">Topics</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<% ResearchDTO r = (ResearchDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/research/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="topic">Topic</label>
    </div>
    <div class="col-75">
      <input type="text" id="topic" name="topicname" value=<%=r.getTopic().getKeywords()%>>
    </div>
    	<input type="hidden" name="id" value =<%=r.getId() %>>
    	<input type="hidden" name="topicid" value =<%=r.getTopic().getId() %>>
    	
  </div>
      <button type="submit" >Edit</button>
</form>

</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>