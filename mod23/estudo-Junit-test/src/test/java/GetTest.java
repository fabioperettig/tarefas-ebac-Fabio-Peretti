import com.fabioperettig.jtest.Instance;
import com.fabioperettig.jtest.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GetTest {

    User user1 = new User();
    Instance i = new Instance();


    @Test
    public void testSet(){
        user1.setName("Ada");

        Assertions.assertEquals("Ada", user1.getName());
    }

    @Test
    public void testGetInstance(){
        Assertions.assertEquals("Leon",i.getUserB().getName());
    }

    @Test
    public void testAvgLevel(){
        int lvlA = i.getUserA().getLevel();
        int lvlB = i.getUserB().getLevel();
        int lvlC = i.getUserC().getLevel();
        int lvlD = i.getUserD().getLevel();

        double SOMA =  lvlA + lvlB + lvlC + lvlD;

        Assertions.assertEquals(14.5,SOMA/4);
    }


    @Test
    public void testAVGdois(){
        Assertions.assertEquals(14.5, i.averagelvl());
    }

}
