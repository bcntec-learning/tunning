package houseware.learn.tunning.onerror;

import java.util.HashMap;
import java.util.Map;

public class GCEval {

    public static void main(String[] args) throws InterruptedException {
        Map<Long, String> map = new HashMap<>();
        long start = System.currentTimeMillis();

        while (true) {
            GCElem e = new GCElem(System.currentTimeMillis(), Long.toString(System.currentTimeMillis()));
            map.put(e.id, e.data);
            if ((map.size() % 10000) == 0) {
                long t = System.currentTimeMillis()-start;
                System.out.println(map.size() + "->" +t+ "ms->" + Runtime.getRuntime().freeMemory()+"b/"+Runtime.getRuntime().maxMemory()+"b");
                Thread.sleep(1);
            }
        }
    }
}
