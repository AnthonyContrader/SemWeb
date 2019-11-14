<%@ page import="it.contrader.dto.ResearchDTO" import="java.util.*" import="it.contrader.dto.TopicDTO"
import="java.sql.Date"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Research Management">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Research Manager</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a> 
		<a class="active" href="/research/getall">Researches</a>
		<a href="/topic/getall">Topics</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<ResearchDTO> list = (List<ResearchDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>ResearchID</th>
				<th>Topic</th>
				<th>Date</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (ResearchDTO r : list) {
			%>
			<tr>
				<td><a href="/research/read?id=<%=r.getId()%>"> <%=r.getId()%> </a></td>
				<td><%=r.getTopic().getKeywords()%></td>
				<td><%=r.getDate()%></td>
				<td><a href="/research/preupdate?id=<%=r.getId()%>">Edit</a></td>
				<td><a href="/research/delete?id=<%=r.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>


		<form id="floatright" action="/research/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="topic">Topic</label>
				</div>
				<div class="col-75">
					<input type="text" id="topic" name="topicname"
						placeholder="inserisci topic">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>