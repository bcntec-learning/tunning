package houseware.learn.tunning.onerror;

import java.util.Objects;

public class GCElem {
    Long id;
    String data;

    public GCElem(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GCElem gcElem = (GCElem) o;
        return Objects.equals(id, gcElem.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
