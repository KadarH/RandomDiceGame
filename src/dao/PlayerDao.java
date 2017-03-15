package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bo.Player;

public class PlayerDao {
		
	private DbConnect dbConnect;
	
	public PlayerDao(){
		
		dbConnect= new DbConnect();
		
	}
	
	public void save(Player player) throws DbException{
		System.out.println(player);

		
		try {
			String query = "INSERT INTO player(nom,prenom,username,password,bestScore) VALUES(?,?,?,?,?)";
			
			PreparedStatement prep = dbConnect.getConnection().prepareStatement(query);
			prep.setString(1, player.getNom());
			prep.setString(2, player.getPrenom());
			prep.setString(3, player.getUsername());
			prep.setString(4, player.getPassword());
			prep.setInt(5, player.getBestScore());
			prep.executeUpdate();
			
		}catch (SQLException e) {
			throw new DbException("Sorry ! Problem in adding player",e);
		}
	}
	public void updateScore(Player player)throws DbException{
		try{
			String query = "UPDATE player SET bestScore=? where username=? ";
			PreparedStatement prep = dbConnect.getConnection().prepareStatement(query);
			prep.setInt(1, player.getBestScore());
			prep.setString(2, player.getUsername());
			prep.executeUpdate();
		}catch(SQLException e ){
			throw new DbException("problem in updating score",e);
		}
		
	}
	public Player getPlayerByLogin(String username)throws DbException,PlayerNotFoundException{
		Player p = new Player() ; 
		
		try {
			String query = "SELECT * From player where username =?";
			PreparedStatement prep = dbConnect.getConnection().prepareStatement(query);
			prep.setString(1, username);
			ResultSet res = prep.executeQuery();
			if(res.next()){
				p.setNom(res.getString("nom"));
				p.setPrenom(res.getString("prenom"));
				p.setUsername(res.getString("username"));
				p.setPassword(res.getString("password"));
				p.setBestScore(res.getInt("bestScore"));
				return p;
			}
			else{
				throw new PlayerNotFoundException();
			}
		}catch(SQLException s ){
			throw new DbException("player don't exist in database",s);
		}
		
	}
}
