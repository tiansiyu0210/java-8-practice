package Generic.Bounds;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by siyu on 5/9/2017.
 */
public class boundsApp {

    public static void main(String args[]){
        List<SuperA> superAList = new ArrayList<>();
        superAList.add(new SuperA());
        List<A> aList = new ArrayList<>();
        aList.add(new A());
        List<SubA> subAList = new ArrayList<>();
        subAList.add(new SubA());
        System.out.println("=====================upper bounded=====================");
        //upper-bpunds, class extends A and A itself can be added
        System.out.println(upperBounds(aList));
        System.out.println(upperBounds(subAList));
        //System.out.println(upperBounds(superAList)); wrong
        System.out.println("=====================lower bounded=====================");
        //lower-bounded
        System.out.println(lowerBounds(aList));
        System.out.println(lowerBounds(superAList));
        //System.out.println(lowerBounds(subAList)); wrong
    }

    private static int upperBounds(List<? extends A> list){
        //list.add(xxx) wrong, cause upper-bounded generics are immutable
        return list.size();
    }

    private static int lowerBounds(List<? super A> list) {
        list.add(new A());
        return list.size();
    }
}
