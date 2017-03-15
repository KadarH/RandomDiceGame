package bo;



public class Player {
	private String nom;
	private String prenom;
	private String username ;
	private String password;
	private int bestScore;
	public int currentScore;
	public Player() {

	}

	public Player(String nom, String prenom, String username, String password, int bestScore) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.bestScore = 0;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getBestScore() {
		return bestScore;
	}
	
	public void setBestScore(int bestScore) {
		this.bestScore = bestScore;
	}

	public String toString() {
		return "Player [nom=" + nom + ", prenom=" + prenom + ", username=" + username + ", password=" + password
				+ ", bestScore=" + bestScore + "]";
	}
	
	public int getCurrentScore() {
		return currentScore;
	}
	
	public void setCurrentScore(int bestScore) {
		this.currentScore = bestScore;
	}
	
	
	
}
