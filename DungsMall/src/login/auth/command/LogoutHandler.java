package login.auth.command;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.member.service.LogoutFailException;
import mvc.command.CommandHandler;

public class LogoutHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("로그아웃핸들러 두겟 지나침!");
			return processForm(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		deleteCookie(res);
		try {
			res.sendRedirect(req.getContextPath() + "/main.do");
		} catch (IOException e) {
			e.printStackTrace();
			throw new LogoutFailException();
		}
		return null;
	}

	public void deleteCookie(HttpServletResponse res) {
		Cookie cookie = new Cookie("logging", null); // 삭제할 쿠키에 대한 값을 null로 지정
		cookie.setPath("/"); // 모든 경로에서 접근 가능하도록 설정
		cookie.setMaxAge(0); // 유효시간을 0으로 설정해서 바로 만료시킨다.
		res.addCookie(cookie); // 응답에 추가해서 없어지도록 함
	}
}
