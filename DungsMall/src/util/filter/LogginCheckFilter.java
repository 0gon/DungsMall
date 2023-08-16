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
		System.out.println("--------");
		System.out.println("로그인 세션 필터 지나침!");
		HttpServletRequest request = (HttpServletRequest) req;
		System.out.println(req.getParameter("id"));

		String excludedPath = "/DungsMall/main.do";
		String excludedPath2 = "/DungsMall/login.do";
		System.out.println(request.getRequestURI());
		if (!request.getRequestURI().startsWith(excludedPath)) {
			if (!request.getRequestURI().startsWith(excludedPath2)) {

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
				String loginForm = "/DungsMall/view/member/login/login.jsp";
				request.getRequestDispatcher(loginForm).forward(req, resp);
				return;
			}
		}
		System.out.println("쿠키체크 안함!");
		chain.doFilter(req, resp);
	}
}
