package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurDao {

	private static ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	private static Connection Connexion() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gesusers","admin","passer");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	static {
		
		try {
			
			Connection connection = Connexion();
			String req = "SELECT * FROM user";
			Statement state = connection.createStatement();
			ResultSet result= state.executeQuery(req);
			if(result.next()) {
				Utilisateur user = new Utilisateur(result.getString("nom"), result.getString("prenom"), result.getString("login"), result.getString("password"));
				utilisateurs.add(user);
			}
			else {
			}
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	public static boolean ajouter(Utilisateur utilisateur) {
		
		try {
			
			Connection connection = Connexion();
			String req = "INSERT INTO utilisateursSaved (nom, prenom, login, password) values (?,?,?,?)";
			PreparedStatement state = connection.prepareStatement(req);
			state.setString(1, utilisateur.getNom());
			state.setString(2, utilisateur.getPrenom());
			state.setString(3, utilisateur.getLogin());
			state.setString(4, utilisateur.getPassword());
			state.executeUpdate();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
		return true;

	}
	
	public static ArrayList<Utilisateur> lister(){
		
		ArrayList <Utilisateur> user = new ArrayList<>();
		
		try {
			Connection connection= Connexion(); 
			String req = "SELECT * FROM utilisateursSaved";
			Statement state = connection.createStatement();
			ResultSet result= state.executeQuery(req);
			while(result.next()) {
				user.add(new Utilisateur(result.getInt(1), result.getString("nom"), result.getString("prenom"), result.getString("login"), result.getString("password")));
			}
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
		return user;
	}
	
	public static boolean supprimer(int id) {
		
		try {
			
			Connection connection = Connexion();
			String req = "delete from utilisateursSaved where id='"+id+"'";
			Statement state = connection.createStatement();
			int result= state.executeUpdate(req);
			if(result!=0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public static boolean modifier(Utilisateur utilisateur) {
		
		for(Utilisateur user: utilisateurs) {
			
			if (utilisateur.getId() == user.getId()){
				
				user.setNom(utilisateur.getNom());
				user.setPrenom(utilisateur.getPrenom());
				user.setLogin(utilisateur.getLogin());
				user.setPassword(utilisateur.getPassword());
				
				try{

					Connection connection = Connexion();
					String req = "update utilisateursSaved set nom=?, prenom=?, login=?, password=? where id = ?";
					PreparedStatement state = connection.prepareStatement(req);
					state.setString(1, utilisateur.getNom());
					state.setString(2, utilisateur.getPrenom());
					state.setString(3, utilisateur.getLogin());
					state.setString(4, utilisateur.getPassword());
					if(state.executeUpdate()!=0) {
						return true;
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}

	
	public static Utilisateur get(int id) {
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.getId() == id) {
				return utilisateur;
			}
		}
		return null;
	}
	
	public static boolean connexion(String username, String password) {
			if(username.equals("admin") && password.equals("passer")) {
				return true;
			}
		
		return false;
	}
	
	public static Utilisateur getByUsername(String login) {
		for(Utilisateur user : utilisateurs) {
			if(login.equals(user.getLogin())) {
				return user;
			}
		}
		return null;
	}
	
}
