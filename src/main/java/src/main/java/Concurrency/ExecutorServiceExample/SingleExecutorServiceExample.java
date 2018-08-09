package src.main.java.Concurrency.ExecutorServiceExample;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleExecutorServiceExample {

    public static void main(String[] args) {
        ExecutorService service = null;
        try{

            //order is guaranteed
            System.out.println("begin");
            service = Executors.newSingleThreadExecutor();
            service.execute(()-> System.out.println("printing inventory"));
            service.execute(()->{
                for(int i=0; i< 10; i++){
                    System.out.println("i value: " + i);
                }
            });
            service.execute(()-> System.out.println("printing inventory end"));
            System.out.println("end");
        } finally {
            if(service != null)
                service.shutdown();
        }
    }
}
