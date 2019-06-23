package servlet;

import dao.UserDao;
import entity.User;
import util.JsonUtil;
import util.ResultUtil;
import util.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: 邓宁
 * @Date: Created in 22:54 2019/6/5
 */
@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User user = UserUtil.getUser(request);
        UserDao userDao = new UserDao();
        PrintWriter out = response.getWriter();
        boolean result = userDao.saveUser(user);
        if (result){
            out.print(JsonUtil.objectToJson(ResultUtil.success()));
        }else {
            out.print(JsonUtil.objectToJson(ResultUtil.error(1001,"添加用户失败")));
        }

    }
}
