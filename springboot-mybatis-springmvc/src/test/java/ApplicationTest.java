import com.vzard.Application;
import com.vzard.domain.User;
import com.vzard.domain.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class ApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void testUserMapper() throws Exception{

        userMapper.insert("vzard",20);
        User u = userMapper.findByName("vzard");
        Assert.assertEquals(20,u.getAge().intValue());

    }



}
