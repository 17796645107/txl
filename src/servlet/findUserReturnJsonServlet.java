package servlet;

import dao.UserDao;
import entity.User;
import util.JsonUtil;
import util.ResultUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author: 邓宁
 * @Date: Created in 11:28 2019/6/7
 */
@WebServlet("/findAll")
public class findUserReturnJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao  = new UserDao();
        List<User> userList = userDao.findUser();
        PrintWriter out = resp.getWriter();
        out.print(JsonUtil.objectToJson(ResultUtil.success(userList)));
    }
}
