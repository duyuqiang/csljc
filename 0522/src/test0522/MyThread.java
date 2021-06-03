package test0522;

class MyThread extends Thread {

    private int i = 0;

    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static int f(String cardID){
//        0-无效卡片,1-美国运通卡,2-探索卡,3-万事达卡,4-Visa卡
        int cardflag=0;

//        0-偶数，1-奇数
        int j = 1;

//        偶数位和
        int sum0 = 0;
//        奇数位和
        int sum1 = 0;

        for (int i=1;i<=cardID.length();i++){
            int a = 0;
//            奇数位
            if (j == 1){
                j = 0;
                a = Integer.valueOf(cardID)%power(i)/power(i-1);
                sum1 += a;
            }
//            偶数位
            else if(j == 0){
                j = 1;
                a = Integer.valueOf(cardID)%power(i)/power(i-1)*2;
                if (a>9){
                    a = a%10+a/10;
                }
                sum0 += a;
            }
        }

        if ((sum0+sum1)%10==0){
            if (cardID.length()==15){
                return 1;
            }else if(cardID.length()==16){
                return 3;
            }else if ((sum0+sum1)/10==6){
                return 2;
            }else if ((sum0+sum1)/10 == 4){
                return 4;
            }
            else{
                return 0;
            }
        }
        else {
            return 0;
        }
    }

    public static int power(int n){
        int m = 1;
        for (int i=1;i<=n;i++){
            m *= 10;
        }
        return m;
    }
}
