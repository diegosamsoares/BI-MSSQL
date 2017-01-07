package filtros;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(servletNames = { "Faces Servlet" })
public class FiltroAutorizacao implements Filter {

	boolean loggedIn = false;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		HttpSession session = req.getSession();

		if ((session.getAttribute("usuarioLogado") != null) || uri.endsWith("css")
				|| (req.getRequestURI().endsWith("login.xhtml")) || (req.getRequestURI().endsWith("login2.xhtml"))
				|| (req.getRequestURI().contains("javax.faces.resource/"))) {

			chain.doFilter(request, response);
		}

		else {
			redireciona("login.xhtml", response);
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	private void redireciona(String url, ServletResponse response) throws IOException {
		HttpServletResponse res = (HttpServletResponse) response;
		res.sendRedirect(url);
	}
}