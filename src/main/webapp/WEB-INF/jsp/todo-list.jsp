<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

	<head>
		<title> Todos for ${name} </title>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css", rel="stylesheet" >
	</head>

	<body>

		<div class="container">
			<h1> The List is : </h1>
			<table class="table">
				<thead>
					<tr>
						<th>Todo</th>
						<th>Description</th>
						<th>Date</th>
						<th>Delete</th>
					</tr>
				</thead>
				<br/>
				<tbody>
					<c:forEach items="${todoList}" var="todo">
						<tr>
							<td>${todo.todo}</td>
							<td>${todo.desc}</td>
							<td>${todo.curr_date}</td>
							<td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">DELETE</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-todo"> Add Todo </a>
		</div>

	</body>

	<script scr="webjars/bootstrap/3.3.6/js/bootstrap.min.js"> </script>
	<script scr="webjars/jquery/1.9.1/js/jquery.min.js"> </script>

</html>