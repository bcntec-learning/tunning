package houseware.learn.tunning.wildfly2;

import javax.ejb.Stateful;
import javax.ejb.Remote;
import javax.ejb.StatefulTimeout;


@Stateful
@StatefulTimeout(value=1)
@Remote(StatefulSessionTestRemote.class)
public class StatefulSessionTestBean extends StatelessSessionTestBean implements StatefulSessionTestRemote {

	private byte someData[] = new byte[1000*1024];

}
