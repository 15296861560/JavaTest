package Competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList a=new ArrayList();
        ArrayList b=new ArrayList();
        Random random=new Random();
        while(a.size()<200){
            int x=random.nextInt(101);
            if (!a.contains(x)){
                a.add(x);
            }else {
                if (!b.contains(x)) {
                    b.add(x);
                    a.add(x);
                }
            }
        }
        System.out.println();

    }
}
