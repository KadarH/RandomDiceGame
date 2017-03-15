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
import dao.DbException;
import dao.PlayerDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		
		Message mess = (Message)session.getAttribute("msg");
		if (mess == null) {
			mess = new Message();
			session.setAttribute("mess", mess);
		}
		
			Player p = new Player(nom, prenom, username, password, 0);
			PlayerDao playerDao = new PlayerDao();
			String error = "/error.jsp";
			String url = getServletContext().getContextPath()+"/Login.jsp";
			
			try {
				playerDao.save(p);
				mess.addMessage("Succés For Inscription");
				response.sendRedirect(url);
				
			} catch (DbException e) {
				mess.addMessage("Inscription failed");
				request.getServletContext().getRequestDispatcher(error).forward(request, response);
				e.printStackTrace();
				return;
			}
		
		
		
		
	}

	
}
