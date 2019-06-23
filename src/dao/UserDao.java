package dao;

import entity.User;
import util.DataBaseUtil;
import util.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 邓宁
 * @Date: Created in 11:55 2019/6/5
 */

public class UserDao {
    private static Connection conn=null;
    private static PreparedStatement prestat=null;
    private static ResultSet resultSet=null;

    public List<User> findUser() {
        List<User> userList = new ArrayList<>();
        String sql = "select * from user";
        conn = DataBaseUtil.getConn();
        try {
            prestat = conn.prepareStatement(sql);
            resultSet = prestat.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setSalary(resultSet.getDouble("salary"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setIcon(resultSet.getString("icon"));
                user.setPermission(resultSet.getInt("permission"));
                user.setCreated_time(resultSet.getString("created_time"));
                user.setState(resultSet.getInt("state"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeAll(resultSet,prestat, conn);
        }
        return userList;
    }

    public User login(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        conn = DataBaseUtil.getConn();
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1,username);
            prestat.setString(2,password);
            resultSet = prestat.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultSet == null){
            return null;
        }
        User user = new User();
        try {
            if(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setSalary(resultSet.getDouble("salary"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setIcon(resultSet.getString("icon"));
                user.setPermission(resultSet.getInt("permission"));
                user.setIcon(resultSet.getString("icon"));
                user.setCreated_time(resultSet.getString("created_time"));
                user.setState(resultSet.getInt("state"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeAll(resultSet,prestat, conn);
        }
        return user;
    }

    public boolean saveUser(User user) {
        String sql = "insert into user(username,password,name,salary,telephone,icon,permission,created_time,state)" +
                "values(?,?,?,?,?,?,?,?,?)";
        conn = DataBaseUtil.getConn();
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1,user.getUsername());
            prestat.setString(2,user.getPassword());
            prestat.setString(3,user.getName());
            prestat.setDouble(4,user.getSalary());
            prestat.setString(5,user.getTelephone());
            prestat.setString(6,user.getIcon());
            prestat.setInt(7,user.getPermission());
            prestat.setString(8, DateUtil.getDate());
            prestat.setInt(9,1);
            if (prestat.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(User user) {
        StringBuilder stringBuilder = new StringBuilder();
        int f = 1;
        stringBuilder.append("update user set ");
        if (user.getUsername() != null){
            stringBuilder.append("username = ?");
            f++;
        }
        if (user.getPassword() != null){
            if (f != 1){
                stringBuilder.append(",");
            }
            stringBuilder.append("password = ?");
            f++;
        }
        if (user.getName() != null){
            if (f != 1){
                stringBuilder.append(",");
            }
            stringBuilder.append("name = ?");
            f++;
        }
        if (user.getSalary() != null){
            if (f != 1){
                stringBuilder.append(",");
            }
            stringBuilder.append("salary = ?");
            f++;
        }
        if (user.getTelephone() != null){
            if (f != 1){
                stringBuilder.append(",");
            }
            stringBuilder.append("telephone = ?");
            f++;
        }
        if (user.getIcon() != null){
            if (f != 1){
                stringBuilder.append(",");
            }
            stringBuilder.append("icon = ?");
            f++;
        }
        stringBuilder.append(" where id = ?");
        System.out.println(stringBuilder.toString());
        conn = DataBaseUtil.getConn();
        int flag = 1;
        try {
            prestat = conn.prepareStatement(stringBuilder.toString());
            if (user.getUsername() != null){
                prestat.setString(flag,user.getUsername());
                flag++;
            }
            if (user.getPassword() != null){
                prestat.setString(flag,user.getPassword());
                flag++;
            }
            if (user.getName() != null){
                prestat.setString(flag,user.getName());
                flag++;
            }
            if (user.getSalary() != null){
                prestat.setDouble(flag,user.getSalary());
                flag++;
            }
            if (user.getTelephone() != null){
                prestat.setString(flag,user.getTelephone());
                flag++;
            }
            if (user.getIcon() != null){
                prestat.setString(flag,user.getIcon());
                flag++;
            }
            prestat.setInt(flag,user.getId());
            if(prestat.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeAll(resultSet,prestat,conn);
        }
        return false;
    }

    public boolean deleteUser(Integer id) {
        String sql = "delete from user where id = ?";
        conn = DataBaseUtil.getConn();
        int result = 0;
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setInt(1,id);
            result = prestat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0 ? true:false;
    }
}
