import com.ylg.dao.UserMapper;
import com.ylg.pojo.User;
import com.ylg.service.Impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;
public class UserMapperTest {

    @Test
    public void getAllUserTest() throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userServiceImpl = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
        List<User> users = userServiceImpl.getAllUser();

        for (User i : users) {
            System.out.println(i);
        }
    }
}
