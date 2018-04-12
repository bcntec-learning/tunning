package houseware.learn.tunning.wildfly2;

import javax.ejb.Lock;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import static javax.ejb.LockType.READ;

@Singleton
@Remote(SingletonSessionTestRemote.class)
@Lock(READ)
public class SingletonSessionReadLockTestBean extends StatelessSessionTestBean {

    @Lock(READ)
    public void test(long beanSleep) {
        super.test(beanSleep);
    }

}
