package Generic.Gereric_Interface;

/**
 * Created by siyu on 5/9/2017.
 */
public class ShippableImpl implements Shippable<Phone>{

    @Override
    public void ship(Phone phone) {
        System.out.println("here");
    }
}
