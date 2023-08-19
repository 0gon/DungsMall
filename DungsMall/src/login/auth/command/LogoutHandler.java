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
		deleteCookie(req, res);
		try {
			res.sendRedirect(req.getContextPath() + "/main.do");
		} catch (IOException e) {
			e.printStackTrace();
			throw new LogoutFailException();
		}
		return null;
	}

	private void deleteCookie(HttpServletRequest request, HttpServletResponse response) {
		// 쿠키 이름으로 삭제할 쿠키를 찾습니다.
		String cookieName = "logging"; // 여기에 삭제할 쿠키의 이름을 넣어주세요.
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName)) {
					cookie.setMaxAge(0); // 쿠키의 만료 시간을 0으로 설정하여 삭제합니다.
					response.addCookie(cookie);
					System.out.println("쿠키" + cookie.getName());
					break;
				}
			}
		}
	}
}
