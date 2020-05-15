package dgroomes;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Custom JMeter sample class to test the {@link Echo} class.
 * <p>
 * For a reference example of a custom JMeter sample implementation, see https://github.com/apache/jmeter/blob/8fd448fe366b4e193c1e9a2d24eb974225135eec/src/protocol/java/src/main/java/org/apache/jmeter/protocol/java/test/SleepTest.java#L50
 */
public class EchoSampler extends AbstractJavaSamplerClient {

    private static final Logger log = LoggerFactory.getLogger(EchoSampler.class);

    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        log.info("Running the EchoSampler test!");
        var echo = new Echo();
        var sampleResult = new SampleResult();
        sampleResult.sampleStart();
        try {
            echo.slowEcho("hello from the EchoSampler JMeter test!");
            sampleResult.setSuccessful(true);
        } catch (InterruptedException e) {
            log.error("Error running EchoSample JMeter test", e);
            sampleResult.setSuccessful(false);
        } finally {
            sampleResult.sampleEnd();
        }
        return sampleResult;
    }
}
