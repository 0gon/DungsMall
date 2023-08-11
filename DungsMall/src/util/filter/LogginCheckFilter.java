package util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogginCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("로그인 세션 필터 지나침!");
		HttpServletRequest request = (HttpServletRequest) req;

		String excludedPath = "/DungsMall/main";
		if (!request.getRequestURI().startsWith(excludedPath)) {

			HttpSession session = request.getSession();
			String sessionId = session.getId();

			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("logging")) {
						if (cookie.getValue().equals(sessionId)) {
							System.out.println("로그인쿠키있음!");
							chain.doFilter(req, resp);
						}
					}
				}
			}
			System.out.println("로그인쿠키없음!");
			HttpServletResponse response = (HttpServletResponse) resp;
			response.sendRedirect(request.getContextPath() + "/login.do");
		}
		chain.doFilter(req, resp);
	}
}
