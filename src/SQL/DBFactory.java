package SQL;

import java.sql.*;

public class DBFactory {

    private static final String URI = "jdbc:mysql://127.0.0.1:3306/testbase?&useSSL=false";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    public static Connection getCon(){
        Connection conn=null;
        try{
            //1、加载数据库驱动
            Class.forName(DRIVER);
            //2、获取数据库连接
            conn = DriverManager.getConnection(URI,"lgy","123456");
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }


}
