package Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetTimeTest {
    public static void main(String[] args) {
        //1.通过Util包中的Date获取
        Date date = new Date();
        SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        System.out.println(dateFormat1.format(date));
        //2.通过Util包的Calendar 获取
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat2= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        System.out.println(dateFormat2.format(calendar.getTime()));
        //3.通过Util包的Calendar 获取时间，分别获取年月日时分秒
        Calendar cal=Calendar.getInstance();
        int y=cal.get(Calendar.YEAR);
        int m=cal.get(Calendar.MONTH);
        int d=cal.get(Calendar.DATE);
        int h=cal.get(Calendar.HOUR_OF_DAY);
        int mi=cal.get(Calendar.MINUTE);
        int s=cal.get(Calendar.SECOND);
        System.out.println("现在时刻是"+y+"年"+m+"月"+d+"日"+h+"时"+mi+"分"+s+"秒");
        // 4.通过System类中的currentTimeMillis方法来获取当前时间
        System.out.println(dateFormat2.format(System.currentTimeMillis()));

    }

}
