package vietnqv.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import vietnqv.utils.Cookies_Utils;


@WebFilter({"/Login"})
public class LoginFilter implements Filter {


    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
	String  email=	Cookies_Utils.getCookie("email", "kh�ng");
	 if(!email.equals("kh�ng")) {
		 request.getRequestDispatcher("/Profile1User").forward(request, response);
	 }else {
		 request.getRequestDispatcher("/Login").forward(request, response);
	 }
	
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
