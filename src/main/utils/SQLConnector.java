package main.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLConnector {
    private static Connection _con;
    public void connect(){
        try{
            try{
                Class.forName("com.mysql.jdbc.Driver");
            }catch (Exception ex){System.out.println("\"com.mysql.jdbc.Driver\" not found");};
            _con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/jptv22_shop","root","");
            System.out.println("Connected successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void execute(String sql){
        try {
            Statement stmt = _con.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<List<Object>> reqQuery(String sql){
        try {
            Statement stmt = _con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<List<Object>> objects = new ArrayList<>();
            while(rs.next()){
                List<Object> arrList = new ArrayList<>();

                boolean allowed = true;
                int i = 1;
                while(allowed){
                    try{

                        Object obj = rs.getObject(i);
                        arrList.add(obj);
                        i++;
                    }catch (Exception ex){
                        allowed = false;
                    }
                }
                objects.add(arrList);
            }
            return objects;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void close(){
        try {
            _con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
