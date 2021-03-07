<html>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<head>
	<title> JSP Page </title>
</head>

<body>

	<nav role="navigation" class="navbar navbar-default">
		<div class="">
			<a class="navbar-brand">TODO Application</a>
		</div>
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>
				<li><a href="/todo-list">Todos</a></li>
			</ul>
		</div>
	</nav>
	
	<font color="red"> ${errorMessage} </font>
	
	<form method="post">
		Name : <input type="text" name="name" />
		Password : <input type="password" name="password" />
		<input type="submit" />
	</form>
</body>

	<script scr="webjars/bootstrap/3.3.6/js/bootstrap.min.js"> </script>
	<script scr="webjars/jquery/1.9.1/js/jquery.min.js"> </script>

</html>