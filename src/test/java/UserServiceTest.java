import org.junit.Before;
import org.junit.Test;
import ru.innopolis.stc9.dao.pojo.User;
import ru.innopolis.stc9.service.UserService;

import java.sql.SQLException;

import static junit.framework.TestCase.assertTrue;

public class UserServiceTest {
    private UserService userService;

    @Before
    public void before(){
        userService = new UserService();
    }

    @Test(expected = NullPointerException.class)
    public void testCheckAuthWithExeption() throws SQLException {
        userService.checkAuth(null,null,null);
    }

    @Test
    public void testCheckAuth() throws SQLException {
        User user = userService.checkAuth("555","555","");
        assertTrue("Find not existed user",user == null);
        user = userService.checkAuth("qwerty","555","");
        assertTrue("Find user with incorrect type",user == null);
        user = userService.checkAuth("1","1","1");
        assertTrue("User <1> not found in DB",user != null);
    }
}
