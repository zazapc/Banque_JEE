<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<div id="formBanque">
<form action="Controller.php" method="post">
<table>
<tr>
<td>code1 :</td><td><input type="text" name="code1"/></td>
</tr>
<tr>
<td>code2 :</td><td><input type="text" name="code2"/></td>
</tr>
<tr>
<td>Montant :</td><td><input type="text" name="montant"/></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" name="action" value="verser"/>
<input type="submit" name="action" value="retirer"/>
<input type="submit" name="action" value="virement"/>
<input type="submit" name="action" value="ajouter"/>
</td>
</tr>
</table>
</form>
</div>
<div>
<table class="table1">
<tr>
<th>code</th><th>Solde</th><th>Date de Creation</th><th>Active</th>
</tr>
<c:forEach items="${comptes}" var="cp">
<tr>
<td>${cp.code}</td><td>${cp.solde}</td><td>${cp.dateCreation}</td><td>${cp.active}</td>
<td><a href="Controller.php?action=delete&code=${cp.code}">Supprimer</a></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>