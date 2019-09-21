package SQL;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlCon {
    public static  Object getObject(String className,int Id){
        //得到表名
        String tableName=className.substring(className.lastIndexOf(".")+1,className.length());
        //根据类名来创建Class对象
        Class c=null;
        try {
            c=Class.forName(className);
        }catch (ClassNotFoundException e1){
            e1.printStackTrace();
        }
        String sql="select * from "+tableName+" where Id="+Id;//sql语句
        System.out.println("查找sql语句："+sql);
        Connection con=DBFactory.getCon();//获取数据库链接
        Object obj=null;//创建类的实例
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);//得到结果集
            Method[] methods=c.getMethods();//得到对象的方法数组
            while (rs.next()){//遍历结果集
                obj=c.newInstance();
                //遍历对象的方法
                for (Method method:methods) {
                    String methodName=method.getName();
                    if (methodName.startsWith("set")){//如果对象的方法以set开头
                        //根据方法名字得到数据表格中字段的名字
                        String columeName=methodName.substring(3,methodName.length());
                        //得到方法的参数类型
                        Class[] parmts=method.getParameterTypes();
                        if (parmts[0]==String.class){//如果参数为String类型
                            //从结果集中按照列名取得对应的值，并且执行该set方法
                            method.invoke(obj,rs.getString(columeName));
                        }
                        if (parmts[0]==int.class){//如果参数为int类型
                            //从结果集中按照列名取得对应的值，并且执行该set方法
                            method.invoke(obj,rs.getInt(columeName));
                        }

                    }

                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args) {
        UserInfo userInfo=(UserInfo)getObject("SQL.UserInfo",3);
        System.out.println("获取到的信息:"+userInfo);
    }
}
