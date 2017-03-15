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
/**
 * Servlet implementation class PlayServlet
 */
@WebServlet("/replay")
public class ReplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path = "/zone"+"/Game.jsp";
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session = request.getSession();
		Message mess = (Message)session.getAttribute("mess");
		if(mess != null){
			mess.clear();
		}
		
		Player player = (Player)session.getAttribute("player");
		if(player != null){
			player.setCurrentScore(0);
		}
		session.setAttribute("nbrLancee", 0);
		session.setAttribute("res", 0);
		
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
		
	}
	
}
