package houseware.learn.tunning.wildfly2;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StatefulSessionTestSampler extends AbstractJavaSamplerClient {

	public SampleResult runTest(JavaSamplerContext context) {
		SampleResult results = new SampleResult();

		StatefulSessionTestRemote bean = null;
		try {
			bean = lookupBean();
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}

		results.sampleStart();

		bean.test(0);
			
		results.setSuccessful(true);
		results.setResponseCodeOK();
		results.sampleEnd();

		return results;
	}

	@Override
	public Arguments getDefaultParameters() {
		return new Arguments();
	}

	private StatefulSessionTestRemote lookupBean() throws NamingException {
		Hashtable jndiProperties = new Hashtable();
        	jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        	Context context = new InitialContext(jndiProperties);

		String jndiName = "ejb:ear-2014.0-SNAPSHOT/ejb-2014.0-SNAPSHOT/StatefulSessionTestBean!wildfly.performance.tuning.ch05.StatefulSessionTestRemote?stateful";

		return (StatefulSessionTestRemote) context.lookup(jndiName);
	}

}
