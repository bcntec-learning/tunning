package houseware.learn.tunning.memleaks;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class MemBean implements Serializable {

    private RequestType requestType = RequestType.TYPE_ONE;

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

}
