package houseware.learn.tunning.onerror;

import java.util.HashMap;
import java.util.Map;

public class GCEval {

    public static void main(String[] args) throws InterruptedException {
        Map<Long, byte[]> map = new HashMap<>();
        long start = System.currentTimeMillis();

        while (true) {
            GCElem e = new GCElem(System.currentTimeMillis(), new byte[1024]);
            map.put(e.id, e.data);
            if ((map.size() % 1000) == 0) {

                long t = System.currentTimeMillis()-start;
                System.out.println(map.size() + "->" +t+ "ms->" + Runtime.getRuntime().freeMemory()/1024+"m/"+Runtime.getRuntime().maxMemory()/1024+"m");
                Thread.sleep(1);
                start=System.currentTimeMillis();
            }
        }
    }


}
