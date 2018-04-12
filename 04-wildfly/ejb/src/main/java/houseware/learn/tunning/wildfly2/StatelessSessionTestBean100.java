package houseware.learn.tunning.wildfly2;

import javax.ejb.Stateless;
import javax.ejb.Remote;
import javax.ejb.Local;

//import org.jboss.ejb3.annotation.Pool;

@Stateless
@Remote(StatelessSessionTestRemote.class)
@Local(StatelessSessionTestLocal.class)
//@Pool(value="slsb-strict-max-pool-100")
public class StatelessSessionTestBean100 extends StatelessSessionTestBean {
}
