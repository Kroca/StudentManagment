package studentManagment.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(urlPatterns = "/home")
public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userRole = (String) ((HttpServletRequest) servletRequest)
                .getSession().getAttribute("role");
        if (userRole!=null && (userRole.equals("user")||userRole.equals("admin"))) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            ((HttpServletResponse)servletResponse).sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
