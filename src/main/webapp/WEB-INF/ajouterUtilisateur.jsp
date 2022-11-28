<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
	
	<h1 id="titre-principal">Ajout d'un utilisateur</h1>
	<p class="messageBox ${ status ? 'succes' : 'erreur' }">${ statusMessage }</p>
	
	<form method="post">
		<fieldset>
			<legend>Ajout d'un utilisateur</legend>
			<label for="nom">Nom</label><br>
			<input type="text" name="nom" id="nom" value="${ utilisateur.nom }"><br>
			<span class="erreur">${ erreurs.nom }</span>
			
			<label for="prenom">Prénom</label><br>
			<input type="text" name="prenom" id="prenom" value="${ utilisateur.prenom }"><br>
			<span class="erreur">${ erreurs.prenom }</span>
			
			<label for="login">Login</label><br>
			<input type="text" name="login" id="login" value="${ utilisateur.login }"><br>
			<span class="erreur">${ erreurs.login }</span>
			
			<label for="password">Password</label><br>
			<input type="password" name="password" id="password"><br>
			<span class="erreur">${ erreurs.password }</span>
			
			<label for="password">Password (confirmation)</label><br>
			<input type="password" name="passwordBis" id="passwordBis"><br>
			<span class="erreur">${ erreurs.passwordBis }</span><br>
			
			<input type="submit" value="Ajouter">
		</fieldset>
	</form>
	<%@include file="inc/footer.jsp" %>
