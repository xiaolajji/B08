package cdu.come.dao;

import cdu.come.jdbc.BaseDao;

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
}
