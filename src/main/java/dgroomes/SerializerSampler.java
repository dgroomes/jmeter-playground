package dgroomes;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Custom JMeter sample class to test the {@link Serializer} class.
 * <p>
 * For a reference example of a custom JMeter sample implementation, see https://github.com/apache/jmeter/blob/8fd448fe366b4e193c1e9a2d24eb974225135eec/src/protocol/java/src/main/java/org/apache/jmeter/protocol/java/test/SleepTest.java#L50
 */
public class SerializerSampler extends AbstractJavaSamplerClient {

    private static final Logger log = LoggerFactory.getLogger(SerializerSampler.class);

    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        log.info("Running the SerializerSampler test!");
        var serializer = new Serializer();
        var sampleResult = new SampleResult();
        sampleResult.sampleStart();

        serializer.serialize(List.of(Serializer.Fruit.APPLE, Serializer.Fruit.BANANA, Serializer.Fruit.ORANGE));

        sampleResult.setSuccessful(true);
        sampleResult.sampleEnd();
        return sampleResult;
    }
}
