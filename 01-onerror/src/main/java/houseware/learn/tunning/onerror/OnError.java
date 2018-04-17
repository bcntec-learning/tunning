package houseware.learn.tunning.onerror;

import java.util.ArrayList;
import java.util.List;

public class OnError {
    public static void main(String[] args) {
        List<byte[]> bytes = new ArrayList<>();
        while (true) {
            try {
                bytes.add(new byte[64 * 1024 * 1024]);
            } catch (OutOfMemoryError e){
                bytes.clear();
                System.out.println("cleared");
            }
        }
    }

}
