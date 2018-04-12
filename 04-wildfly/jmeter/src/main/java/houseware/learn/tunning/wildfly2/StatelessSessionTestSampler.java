package houseware.learn.tunning.wildfly2;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StatelessSessionTestSampler extends AbstractJavaSamplerClient {

	public SampleResult runTest(JavaSamplerContext context) {
		SampleResult results = new SampleResult();

		StatelessSessionTestRemote bean = null;
		String pool = context.getParameter("POOL");
		try {
			bean = lookupBean(pool);
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
		args.addArgument("POOL", "default");
		return args;
	}

	private StatelessSessionTestRemote lookupBean(String pool) throws NamingException {
		Hashtable jndiProperties = new Hashtable();
        	jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        	Context context = new InitialContext(jndiProperties);

		String jndiName = null;
		if (pool.equals("default")) {
			jndiName = "ejb:ear-2014.0-SNAPSHOT/ejb-2014.0-SNAPSHOT/StatelessSessionTestBean!wildfly.performance.tuning.ch05.StatelessSessionTestRemote";
		} 
		if (pool.equals("10")) {
                        jndiName = "ejb:ear-2014.0-SNAPSHOT/ejb-2014.0-SNAPSHOT/StatelessSessionTestBean10!wildfly.performance.tuning.ch05.StatelessSessionTestRemote";
                }

		if (pool.equals("100")) {
			jndiName = "ejb:ear-2014.0-SNAPSHOT/ejb-2014.0-SNAPSHOT/StatelessSessionTestBean100!wildfly.performance.tuning.ch05.StatelessSessionTestRemote";
		}

		return (StatelessSessionTestRemote) context.lookup(jndiName);
	}

}
