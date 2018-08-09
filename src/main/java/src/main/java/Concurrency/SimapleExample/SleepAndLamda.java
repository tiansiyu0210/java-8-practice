package src.main.java.Concurrency.SimapleExample;

public class SleepAndLamda {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            for(int i = 0; i<=500; i++){
                SleepAndLamda.counter++;
            }
        }).start();

        while(counter < 100){
            System.out.println("not reach 100");
            Thread.sleep(1000);//1 second
        }

        System.out.println("reached 100");
    }
}
