import com.fabioperettig.DAO.DaoJPATest;
import com.fabioperettig.DAO.DaoMongoTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        DaoJPATest.class,
        DaoMongoTest.class
})
public class SuiteTest {
}
