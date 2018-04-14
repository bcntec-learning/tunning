package houseware.learn.tunning.wildfly;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;


@Stateful
public class StatefulEJB {

    List<String> list = new ArrayList<>();

    public String sayHello(String name) {
        list.add(name);
        return "Hello " + name;
    }
}
