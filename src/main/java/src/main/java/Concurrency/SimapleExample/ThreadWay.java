package src.main.java.Concurrency.SimapleExample;

public class ThreadWay extends Thread{
    public void run() {
        for(int i = 0; i<=100; i++){
            System.out.println("printing i: " + i);
        }
    }

    public static void main(String[] args) {
        (new ThreadWay()).start();
        (new ThreadWay()).start();
        (new ThreadWay()).start();
        (new ThreadWay()).start();
        (new ThreadWay()).start();
        (new ThreadWay()).start();
        (new ThreadWay()).start();
        (new ThreadWay()).start();
        (new ThreadWay()).start();
    }
}
