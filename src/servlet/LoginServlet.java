package servlet;

import dao.UserDao;
import entity.User;
import util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: 邓宁
 * @Date: Created in 22:22 2019/6/5
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        User user = userDao.login(username,password);
        if (user.getId() != null){
            HttpSession session = request.getSession();
            session.setAttribute("USER",user);
            response.sendRedirect("main.jsp");
        }
        else{
            request.setAttribute("error","账号或密码不正确");
            request.getRequestDispatcher("login.jsp");
        }
    }
}
