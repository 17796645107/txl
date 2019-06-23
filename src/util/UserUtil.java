package util;

import entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 邓宁
 * @Date: Created in 10:59 2019/6/6
 */

public class UserUtil {
    public static User getUser(HttpServletRequest request){
        FileUpLoadUtil file = FileUpLoadUtil.upload(request);
        Integer id = null;
        if (file.getParameter("id") != null && file.getParameter("id").trim().length() != 0){
            id = Integer.valueOf(file.getParameter("id"));
        }
        String username = file.getParameter("username");
        String password = file.getParameter("password");
        String name = file.getParameter("name");
        Double salary = null;
        if (file.getParameter("salary") != null && file.getParameter("salary").trim().length() != 0){
            salary = Double.valueOf(file.getParameter("salary"));
        }
        String telephone = file.getParameter("telephone");
        String icon = file.getParameter("icon");
        Integer permission = null;
        if (file.getParameter("permission") != null && file.getParameter("permission").trim().length() != 0){
            permission = Integer.valueOf(file.getParameter("permission"));
        }
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setSalary(salary);
        user.setTelephone(telephone);
        user.setIcon(icon);
        user.setPermission(permission);
        return user;
    }

}
