package houseware.learn.tunning.wildfly2;

public interface StatelessSessionTestLocal {

	public void test(long beanSleep);
	public void callTestBean(long iterations, long beanSleep);

}
