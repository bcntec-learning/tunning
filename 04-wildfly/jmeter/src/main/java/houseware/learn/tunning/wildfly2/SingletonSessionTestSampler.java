package houseware.learn.tunning.wildfly2;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SingletonSessionTestSampler extends AbstractJavaSamplerClient {

	public SampleResult runTest(JavaSamplerContext context) {
		SampleResult results = new SampleResult();

		SingletonSessionTestRemote bean = null;
		String beanName = context.getParameter("BEAN_NAME");
		try {
			bean = lookupBean(beanName);
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}

		results.sampleStart();
		Long param1 = context.getLongParameter("BEAN_SLEEP_TIME");

		bean.test(param1);
			
		results.setSuccessful(true);
		results.setResponseCodeOK();
		results.sampleEnd();

		return results;
	}

	@Override
	public Arguments getDefaultParameters() {
		Arguments args = new Arguments();
		args.addArgument("BEAN_SLEEP_TIME", "1000");
		args.addArgument("BEAN_NAME", "SingletonSessionLockTestBean!wildfly.performance.tuning.ch05.SingletonSessionLockTestRemote");
		return args;
	}

	private SingletonSessionTestRemote lookupBean(String beanName) throws NamingException {
		Hashtable jndiProperties = new Hashtable();
        	jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        	Context context = new InitialContext(jndiProperties);

		String jndiName = "ejb:ear-2014.0-SNAPSHOT/ejb-2014.0-SNAPSHOT/" + beanName;

		return (SingletonSessionTestRemote) context.lookup(jndiName);
	}

}
