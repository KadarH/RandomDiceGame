package web;

import java.io.IOException;
import java.util.Random;
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
 * Servlet implementation class PlayServlet
 */
@WebServlet("/zone/play")
public class PlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession sess = request.getSession();
		if(sess.getAttribute("authenticated") !=null && sess.getAttribute("authenticated").equals(false))
		{
			
			response.sendRedirect(request.getServletContext().getContextPath()+"/Login.jsp");
			return ;
		}
		Message mess = (Message) sess.getAttribute("mess");
		if(mess != null){
			mess.clear();
		}
		
		
		String resultat ;
		String action = request.getParameter("action");
		if( action.equals("Click")){
			String clickReplay="Click";
			resultat = "";
			Player player = (Player) sess.getAttribute("player");
			int nbrLancee = 0;
			if(sess.getAttribute("nbrLancee") != null){
				nbrLancee = ((Integer)sess.getAttribute("nbrLancee")).intValue();
			}
			if(nbrLancee < 20){
				clickReplay = "Click";
				sess.setAttribute("nbrLancee", (nbrLancee+1));
				
				Random rand = new Random();
				
				int res = 1 + rand.nextInt(6);
				
				Integer oldRes = (Integer) sess.getAttribute("res");
				sess.setAttribute("res", Integer.valueOf(res));
				if(oldRes != null){
					if(oldRes.intValue() == res){
						player.setCurrentScore(player.getCurrentScore()+20);
					}
				}
		}
		else {
			clickReplay = "Replay";
			resultat = "GAME OVER";
			if(player.getBestScore() < player.getCurrentScore()){
			
				try{
					PlayerDao playerDao = new PlayerDao();
					player.setBestScore(player.getCurrentScore());
					playerDao.updateScore(player);

				}catch(DbException e){
					mess.addMessage("Error ! ");
					String errorPage = "/erreur.jsp";
					getServletContext().getRequestDispatcher(errorPage).forward(request, response);
					e.printStackTrace();
					return;
				}
			}
			}
			sess.setAttribute("clickReplay", clickReplay);
			sess.setAttribute("resultat", resultat);
			String path = "/zone/Game.jsp";
			getServletContext().getRequestDispatcher(path).forward(request, response);	
	}
	else if(action.equals("Replay")){
		String path = "/replay";
		String clickReplay="Click";
		resultat = "";
		
		sess.setAttribute("clickReplay", clickReplay);
		sess.setAttribute("resultat", resultat);
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
		
	}
	else if(action.equals("Reset")){
		//hedraaa wehdaaaaakhraaaaaa
	}
		
	}
	
}
