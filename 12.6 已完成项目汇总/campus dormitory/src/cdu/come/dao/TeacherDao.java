package cdu.come.dao;

import cdu.come.jdbc.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherDao {
    public String CheckLogin(String username, String password) {
        String id = null;
        String sql="select * from Teacher where Teacher_Username='"+username+"' and Teacher_Password='"+password+"'";
        Statement stat = null;
        ResultSet rs = null;
        Connection conn = new BaseDao().getConn();
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                id = rs.getString("Teacher_ID");
            }
        }
        catch(SQLException ex){}
        return id;

    }
}
