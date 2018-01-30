<html>
<head>
<title>
Fruit Picker
</title>
</head>
<body>
<h1> Select the fav fruit ? </h1>
<form action="/fav_fruit" method="POST">
<#list fruits as fruit>
<p>
	<input type="radio" name="fruit" value="${fruit}">${fruit}</input>
</p>
</#list>

<input type="submit" value="Submit"/>
</form>
</body>
</html>