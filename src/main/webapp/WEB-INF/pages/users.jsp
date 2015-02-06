<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
	<h1>User controller - User List</h1>
	<table>
		<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Surname</th>
		</tr> 
		<c:forEach var="o" items="${list}">
		<tr>
		<td>
		<c:out value="${o.getUserId()}"/>
		</td>
		<td>
		<c:out value="${o.getUserName()}"/>
		</td>
		<td>
		<c:out value="${o.getUserSurname()}"/>
		</td>
		</tr>
		</c:forEach>
	</table>
	<form method="post" action="/user-repo-0.1/user">
		Id:<input name="id" type="text" /> Name:<input name="name" type="text" />
		Surname:<input name="surname" type="text" /> <input type="submit"
			value="send" />
	</form>
</body>
</html>