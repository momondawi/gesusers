<%@page import="beans.Utilisateur" %>
<%@include file="inc/header.jsp" %>

	<h1 id="titre-principal">Modification d'un utilisateur</h1>
	<p class="messageBox ${ status ? 'succes' : 'erreur' }">${ statusMessage }</p>
	
	<form method="post">
		<fieldset>
			<legend>modification d'un utilisateur</legend>
			<label for="nom">Nom</label><br>
			<input type="text" name="nom" value=${ utilisateur.nom }><br>
			<span class="erreur">${ erreurs.nom }</span>
			
			<label for="prenom">Prenom</label><br>
			<input type="text" name="prenom" value=${ utilisateur.prenom }><br>
			<span class="erreur">${ erreurs.prenom }</span>
			
			<label for="login">Login</label><br>
			<input type="text" name="login" value=${ utilisateur.login }><br>
			<span class="erreur">${ erreurs.login }</span>
			
			<label for="password">Password</label><br>
			<input type="password" name="password" value=${ utilisateur.password }><br>
			<span class="erreur">${ erreurs.password }</span><br>
			
			<input type="submit" value="Modifier">
		</fieldset>
	</form>
	<%@include file="inc/footer.jsp" %>
