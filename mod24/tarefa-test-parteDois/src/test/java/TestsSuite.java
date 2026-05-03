import com.fabioperettig.testProject.TestDAOClient;
import com.fabioperettig.testProject.TestDAOContrato;
import com.fabioperettig.testProject.TestServiceClient;
import com.fabioperettig.testProject.TestServiceContrato;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Test Suite")
@SelectClasses({
        TestDAOClient.class,
        TestDAOContrato.class,
        TestServiceClient.class,
        TestServiceContrato.class
})

public class TestsSuite {

}
