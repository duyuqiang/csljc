package test0522;

import java.util.Random;

public class test1 extends Thread{

    private String cardID;

    public test1(String cardID)
    {
        this.cardID = cardID;
    }
    public void run()
    {
        int i1 = f(cardID);

        if (i1 == 0){
            System.out.println(cardID+" is invalid");
        }else if(i1 == 1){
            System.out.println(cardID+" is American Express cards");
        }else if(i1 == 2){
            System.out.println(cardID+" is Discover cards");
        }else if(i1 == 3){
            System.out.println(cardID+" is Master cards");
        }else if(i1 == 4){
            System.out.println(cardID+" is Visa cards");
        }
    }

    public static void main(String[] args){
        Random r = new Random();
//        r.longs(9999999999999999999l);
        Thread thread1 = new test1("6064388576010702000");
        Thread thread2 = new test1("438857601841070700");
        Thread thread3 = new test1("43885760184");
        Thread thread4 = new test1("4388576018402626");
        thread1.start();
        thread2.start();
        thread3.start();
//        thread4.start();
//        System.out.println(f("4388576018410707"));
//
//        System.out.println(Long.valueOf("4388576018410707")%power(11)/power(10));
//        System.out.println(Long.valueOf("4388576018410707"));
//        System.out.println(Long.valueOf("4388576018410707")%power(11));
    }

    public static int f(String cid){
//        0-无效卡片,1-美国运通卡,2-探索卡,3-万事达卡,4-Visa卡
        int cardflag=0;

//        0-偶数，1-奇数
        int j = 1;

//        偶数位和
        int sum0 = 0;
//        奇数位和
        int sum1 = 0;

        if (cid.length()<13 || cid.length()>19){
            return 0;
        }

        for (int i=1;i<=cid.length();i++){
            Long a = 0l;
//            奇数位
            if (j == 1){
                j = 0;
//                a = Integer.valueOf(cid)%power(i)/power(i-1);
                a = Long.valueOf(cid)%power(i)/power(i-1);
                sum1 += a;
            }
//            偶数位
            else if(j == 0){
                j = 1;
                a = Long.valueOf(cid)%power(i)/power(i-1)*2;
                if (a>9){
                    a = a%10+a/10;
                }
                sum0 += a;
            }
        }

        if ((sum0+sum1)%10==0){
            if (cid.length()==15){
                return 1;
            }else if(cid.length()==16){
                return 3;
            }else if ((sum0+sum1)/10==6){
                return 2;
            }else if ((sum0+sum1)/10 == 4){
                return 4;
            }
            else{
                System.out.println(cid+","+sum0+sum1);
                return 0;
            }
        }
        else {
            System.out.println(cid+","+sum0+sum1);
            return 0;
        }
    }

    public static long power(int n){
        long m = 1;
        for (int i=1;i<=n;i++){
            m *= 10;
        }
        return m;
    }
}
