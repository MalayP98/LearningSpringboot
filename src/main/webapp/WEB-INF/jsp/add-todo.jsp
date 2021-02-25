<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<head>
	<title> Add Todo </title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css", rel="stylesheet" >
</head>

<body>
	<div class="container">
		<form:form method="post" modelAttribute="bean">
			<fieldset class="form-group">
				<form:label path="todo">Todo</form:label>
				<form:input path="todo" type="text" required="required" class="form-control" />
				<form:errors path="todo"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label>
				<form:input type="text" path="desc" required="required" class="form-control" />
				<form:errors path="desc"/>
			</fieldset>
			<button type="submit", class="btn btn-success">ADD</button>
		</form:form>
	</div>
	
</body>

	<script scr="webjars/bootstrap/3.3.6/js/bootstrap.min.js"> </script>
	<script scr="webjars/jquery/1.9.1/js/jquery.min.js"> </script>

</html>