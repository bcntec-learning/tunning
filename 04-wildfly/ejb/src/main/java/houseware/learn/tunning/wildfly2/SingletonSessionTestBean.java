package houseware.learn.tunning.wildfly2;

import javax.ejb.Singleton;
import javax.ejb.Remote;
import javax.ejb.Local;

@Singleton
@Remote(SingletonSessionTestRemote.class)
public class SingletonSessionTestBean extends StatelessSessionTestBean {
}
