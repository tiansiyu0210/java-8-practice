package src.main.java.DynamicProxy.Proxy;

public class RealObject implements Interface{
    @Override
    public void getMyName() {
        System.out.println("my name is siyu tian");
    }

    @Override
    public String getNameById(String id) {
        System.out.println("id is:" + id);
        return "siyu tian";
    }
}
