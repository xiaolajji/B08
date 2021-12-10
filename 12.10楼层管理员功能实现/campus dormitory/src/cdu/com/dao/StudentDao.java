package cdu.com.dao;

import cdu.com.bean.StudentBean;
import cdu.com.jdbc.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
    public String CheckLogin(String username, String password) {
        String id = null;
        String sql="select * from Student where Student_Username='"+username+"' and Student_Password='"+password+"' and Student_State='入住'";
        Statement stat = null;
        ResultSet rs = null;
        Connection conn = new BaseDao().getConn();
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                id = rs.getString("Student_ID");
            }
        }
        catch(SQLException ex){}
        return id;

    }

    //删除
    public void Delete(String strwhere){
        String sql="delete Student where ";
        sql+=strwhere;
        Statement stat = null;
        ResultSet rs = null;
        Connection conn = new BaseDao().getConn();
        try{
            stat = conn.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (stat != null)
                    stat.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    //判断是否空值
    private boolean isInvalid(String value) {
        return (value == null || value.length() == 0);
    }

    //测试
    public static void main(String[] args) {
        System.out.println("");
    }

    //获取指定ID的实体Bean
    public StudentBean GetAllBean(int id){
        String sql="select * from Student where Student_ID="+id;
        Statement stat = null;
        ResultSet rs = null;
        Connection conn = new BaseDao().getConn();
        StudentBean cnbean=new StudentBean();
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()){
                cnbean.setStudent_ID(rs.getInt("Student_ID"));
                cnbean.setStudent_DomitoryID(rs.getInt("Student_DomitoryID"));
                cnbean.setStudent_Username(rs.getString("Student_Username"));
                cnbean.setStudent_Password(rs.getString("Student_Password"));
                cnbean.setStudent_Name(rs.getString("Student_Name"));
                cnbean.setStudent_Sex(rs.getString("Student_Sex"));
                cnbean.setStudent_Class(rs.getString("Student_Class"));
                cnbean.setStudent_State(rs.getString("Student_State"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (stat != null)
                    stat.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cnbean;
    }
}

