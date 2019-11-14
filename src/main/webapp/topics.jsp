<%@ page import="it.contrader.dto.TopicDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Topic Management">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Topic Manager</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a> 
		<a href="/research/getall">Researches</a>
		<a class="active" href="/topic/getall">Topics</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<TopicDTO> list = (List<TopicDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>TopicID</th>
				<th>Keywords</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (TopicDTO t : list) {
			%>
			<tr>
			
				<td><%=t.getId()%></td>
				<td><a href="/topic/read?id=<%=t.getId()%>"> <%=t.getKeywords()%> </a></td>
				<td><a href="/topic/preupdate?id=<%=t.getId()%>">Edit</a></td>
				<td><a href="/topic/delete?id=<%=t.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>


		<form id="floatright" action="/topic/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="topic">Keywords</label>
				</div>
				<div class="col-75">
					<input type="text" id="topic" name="keywords"
						placeholder="inserisci keywords">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>

</body>
</html>