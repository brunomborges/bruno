/**
 * Created by bborges on 9/26/14.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(
        features = { "classpath:features" },
        glue = { "flipKart.steps" },
        format = { "html:target/cucumber/java" },
        strict = true)

public class javaFeatureTest {

}
