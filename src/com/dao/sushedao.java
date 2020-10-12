package com.dao;

import com.entity.susheduixiang;

import java.sql.*;

public class sushedao {
    public susheduixiang sushebianhao(Integer susheid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        susheduixiang duixiang=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sushe?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "333");
            sql = "select id,chengyuan,chengyuan1,chengyuan2,chengyuan3,chengyuan4,shezhang from sushe where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,susheid);
            rs = ps.executeQuery();
            if (rs.next()) {
                duixiang = new susheduixiang();
                duixiang.setId(rs.getInt("id"));
                duixiang.setChengyuan(rs.getString("chengyuan"));
                duixiang.setChengyuan1(rs.getString("chengyuan1"));
                duixiang.setChengyuan2(rs.getString("chengyuan2"));
                duixiang.setChengyuan3(rs.getString("chengyuan3"));
                duixiang.setChengyuan4(rs.getString("chengyuan4"));
                duixiang.setShezhang(rs.getString("shezhang"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
        return duixiang;
    }
}
