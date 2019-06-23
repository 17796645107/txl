package servlet;

import dao.UserDao;
import entity.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 邓宁
 * @Date: Created in 10:55 2019/6/6
 */
@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        Double salary = null;
        if (request.getParameter("salary") != null && request.getParameter("salary").trim().length() != 0){
            salary = Double.valueOf(request.getParameter("salary"));
        }
        String telephone = request.getParameter("telephone");
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setName(name);
        user.setSalary(salary);
        user.setTelephone(telephone);
        UserDao userDao = new UserDao();
        boolean result = userDao.updateUser(user);
        if (result){
            request.getRequestDispatcher("/findUser").forward(request,response);
        }else {
            request.setAttribute("error","更新同学失败");
            request.getRequestDispatcher("show.jsp").forward(request,response);
        }

    }
}
