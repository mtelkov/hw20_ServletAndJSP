package ru.innopolis.stc9.controller.filter;

import ru.innopolis.stc9.pojo.UserTypes;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class StudentFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession httpSession = ((HttpServletRequest) request).getSession();
        String userType;
        String redirectLoacation = null;
        if (httpSession.getAttribute("user") != null && (userType=(String)httpSession.getAttribute("usertype"))!=null){
            if (Integer.valueOf(userType) == UserTypes.USER_STUDENT) {
                chain.doFilter(request, response);
                return;
            }else{
                request.getRequestDispatcher("/not_allow.jsp").forward(request, response);
            }
        } else {
            redirectLoacation = "/login?errorMsg=noAuth";
        }
        HttpServletResponse httpServletRespoonse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        httpServletRespoonse.sendRedirect(httpServletRequest.getContextPath() + redirectLoacation);
    }

    @Override
    public void destroy() {

    }
}
