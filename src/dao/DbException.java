package dao;

public class DbException extends Exception {

	public DbException(){
		super();
		
	}
	
	public DbException(String message) {
		super(message);
	}
	
	public DbException(String mess, Throwable c){
		super(mess, c);
	}
}
