package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.Message;
import bo.Player;
import dao.PlayerDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request,response);
	}
	private void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String login ="/Login.jsp";
	     String home  ="/zone"+"/Game.jsp";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("authenticated") !=null && session.getAttribute("authenticated").equals(true))
		{
			
			response.sendRedirect(request.getServletContext().getContextPath()+home);
			return;
		}
		
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		PlayerDao playerDao = new PlayerDao();
		
		Message mess =(Message)session.getAttribute("mess");
		
		if(mess != null){
		
			mess=new Message();
			session.setAttribute("mess", mess);
		
		}
		Player p ;
		
		try {
		
			p=(Player)playerDao.getPlayerByLogin(username);
			
			if(p!=null && p.getPassword().equals(password) && !password.equals("")){
			
				p.setPassword(null);
				
				session.setAttribute("player", p);
				session.setAttribute("authenticated", true); 
				session.setAttribute("resultat", ""); 
				
				getServletContext().getRequestDispatcher(home).forward(request, response);
				
				return;
		
			}
			
			else{
			
				mess.addMessage("Login Failed !");
				
				getServletContext().getRequestDispatcher(login).forward(request, response);
				
			}
		
		} catch (Exception e){
			
			e.printStackTrace();
			getServletContext().getRequestDispatcher(login).forward(request, response);
			
		}
		
		}
		
	
	
	

}
