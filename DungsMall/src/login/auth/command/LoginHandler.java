package login.auth.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.auth.model.User;
import login.auth.service.LoginService;
import login.member.service.LoginFailException;
import mvc.command.CommandHandler;

public class LoginHandler implements CommandHandler {
	private static final String FORM_VIEW = "/view/member/login/login.jsp";
	private LoginService loginService = new LoginService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("로그인핸들러 두겟 지나침!");
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("로그인핸들러 두포스트 지나침!");
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String id = trim(req.getParameter("id"));
		String password = trim(req.getParameter("password"));

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		System.out.println(password);
		
		if (id == null || id.isEmpty())
			errors.put("id", Boolean.TRUE);
		if (password == null || password.isEmpty())
			errors.put("password", Boolean.TRUE);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		try {
			User user = loginService.login(id, password);
			setCookie(req, res);
			System.out.println("로그인 성공함!");
			res.sendRedirect(req.getContextPath() + "/index.jsp");
			return null;
		} catch (LoginFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

	private String trim(String str) {
		return str == null ? null : str.trim();
	}

	private void setCookie(HttpServletRequest req, HttpServletResponse res) {
		String sessionId = req.getRequestedSessionId();
		Cookie cookie = new Cookie("logging", sessionId); // 쿠키 이름 지정하여 생성( key, value 개념)
		// cookie.setSecure(true); // https 연결에서면 쿠키 전송
		cookie.setHttpOnly(true); // js접근 불가 설정
		cookie.setMaxAge(60 * 60); // 쿠키 유효 기간 1시간
		cookie.setPath("/"); // 모든 경로에서 접근 가능하도록 설정
		res.addCookie(cookie); // response에 Cookie 추가
	}
}
