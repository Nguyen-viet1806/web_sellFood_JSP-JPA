package vietnqv.utils;

import javax.servlet.http.Cookie;

public class Cookies_Utils {
	public static void add(String name, String value, int hours) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(hours * 60 * 60);
		cookie.setPath("/");
		RRShare_Utils.response().addCookie(cookie);
	}
	
	public static String getCookie(String name,String defval) {
		Cookie[] cookies = RRShare_Utils.request().getCookies();
		if(cookies!=null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equalsIgnoreCase(name)) {
					return cookie.getValue();
				}
			}
		}
		return defval;
		
	}

}
