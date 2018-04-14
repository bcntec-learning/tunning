package houseware.learn.tunning.wildfly;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StatelessEJB {

    private byte someData[] = new byte[1000*1024*20];

    List<String> list = new ArrayList<>();

    public String sayHello(String name) {
        list.add(name);
        return "Hello " + name;
    }
}
