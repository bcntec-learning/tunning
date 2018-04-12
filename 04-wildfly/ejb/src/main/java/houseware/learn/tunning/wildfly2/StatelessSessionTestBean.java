package houseware.learn.tunning.wildfly2;

import javax.ejb.Stateless;
import javax.ejb.Remote;
import javax.ejb.Local;

@Stateless
@Remote(StatelessSessionTestRemote.class)
@Local(StatelessSessionTestLocal.class)
public class StatelessSessionTestBean implements StatelessSessionTestLocal, StatelessSessionTestRemote {

	public void test(long beanSleep) {
		try {
			Thread.sleep(beanSleep);
		} catch (InterruptedException e) {
			// Ignore
		}
	}

	public void callTestBean(long iterations, long beanSleep) {
		for (int i=0; i<iterations; i++) {
			test(beanSleep);
		}
	}

}
