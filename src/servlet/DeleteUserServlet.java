package servlet;

import dao.UserDao;
import util.JsonUtil;
import util.ResultUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: 邓宁
 * @Date: Created in 19:54 2019/6/6
 */
@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        UserDao userDao = new UserDao();
        boolean result = userDao.deleteUser(id);
        if (result){
            req.getRequestDispatcher("/findUser").forward(req,resp);
        }else {
            req.setAttribute("error","删除同学失败");
            req.getRequestDispatcher("show.jsp").forward(req,resp);
        }
    }
}
