<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
<div id="corps">
	<h1 id="titre-principal">Authentification d'un utilisateur</h1>
	<p class="messageBox ${ status ? 'succes' : 'erreur' }">${ messageRecu }</p>
	<form method="post">
		<fieldset>
			<legend>Connexion</legend>
			
			<label for="login">Login</label><br>
			<input type="text" name="login" id="login" value="${ login }"><br>
			
			<label for="password">Password</label><br>
			<input type="password" name="password" id="password"><br><br>
			
			<input type="submit" value="Se connecter">
		</fieldset>
	</form>
	<%@include file="inc/footer.jsp" %>
</div>