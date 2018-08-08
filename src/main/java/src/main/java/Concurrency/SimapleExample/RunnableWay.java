package src.main.java.Concurrency.SimapleExample;

public class RunnableWay implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i<=3; i++){
            System.out.println("printing i: " + i);
        }
    }

    public static void main(String[] args) {
        new Thread(new RunnableWay()).start();
        new Thread(new RunnableWay()).start();
    }
}
