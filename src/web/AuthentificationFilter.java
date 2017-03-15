package web;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import bo.Player;

public class AuthentificationFilter implements Filter {

	private FilterConfig filterConfig;

	public AuthentificationFilter() {
	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//pour debug
		System.out.println("Security filter executed");

		String loginPage = "/Login";

		ServletContext cntx = filterConfig.getServletContext();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		Player joueur = (Player) session.getAttribute("player");

		if (joueur != null) {

			chain.doFilter(request, response);
		}
		else {
			
			httpResponse.sendRedirect(httpRequest.getServletContext().getContextPath()+loginPage);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		filterConfig = fConfig;
	}

}
