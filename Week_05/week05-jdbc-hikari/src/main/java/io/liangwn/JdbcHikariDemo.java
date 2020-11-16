package io.liangwn;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by liang on 2020/11/17.
 */
public class JdbcHikariDemo {

    public static void main(String[] args) {
        String configFile = JdbcHikariDemo.class.getClassLoader().getResource("application.properties").getPath();
        HikariDataSource ds = new HikariDataSource(new HikariConfig(configFile));

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = ds.getConnection();
            pst = con.prepareStatement("SELECT * FROM user");
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.format("%d %s %n", rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
                ds.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
