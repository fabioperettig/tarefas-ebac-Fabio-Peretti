import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        MarcaDaoTest.class,
        CarroDaoTest.class,
        AcessorioDaoTest.class,
})
public class SuiteTest {
}
