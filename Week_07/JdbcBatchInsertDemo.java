package com.jerry.learn.week7;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liang on 2020/12/2.
 */
public class JdbcBatchInsertDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        List<UserOrder> list = new ArrayList<>();
        for(int i=1; i<=1000000; i++) {
            UserOrder userOrder = new UserOrder();
            userOrder.setUsername("小明"+i);
            userOrder.setGoodname("苹果"+1);
            userOrder.setPrice(new BigDecimal("10"));
            userOrder.setCount(5);
            userOrder.setCellphone("12345678901");
            userOrder.setAddress("上海市浦东新区当前时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            list.add(userOrder);
        }
        System.out.println("list size: "+list.size());
        System.out.println("first list: "+list.get(0));


        // 用PreparedStatement批量插入100万条数据，耗时：秒
        insertByPreparedStatement(list);




    }

    public static void insertByPreparedStatement(List<UserOrder> list) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_order?useSSL=false&serverTimezone=UTC", "root", "root123");
        connection.setAutoCommit(false);
        long start = System.currentTimeMillis();
        String sql = "insert into orders(username, goodname, price, count, cellphone, address) values(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        for(UserOrder order : list) {
            ps.setObject(1, order.getUsername());
            ps.setObject(2, order.getGoodname());
            ps.setObject(3, order.getPrice());
            ps.setObject(4, order.getCount());
            ps.setObject(5, order.getCellphone());
            ps.setObject(6, order.getAddress());
            ps.addBatch();

        }
        ps.executeBatch();
        connection.commit();
        long end = System.currentTimeMillis();
        System.out.println("花费的时间: "+ (end-start)/1000+"秒");

        connection.close();

    }
}
