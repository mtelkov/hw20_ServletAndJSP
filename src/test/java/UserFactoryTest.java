import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.innopolis.stc9.dao.factory.UserFactory;
import ru.innopolis.stc9.dao.pojo.Admin;
import ru.innopolis.stc9.dao.pojo.User;
import ru.innopolis.stc9.dao.pojo.UserTypes;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class UserFactoryTest {
    private UserFactory userFactory;

    @Before
    public void before(){
        userFactory = new UserFactory();
    }

    @Test
    public void testFactory() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        Mockito.when(resultSet.getInt("adm_id")).thenReturn(1);
        Mockito.when(resultSet.getString("fio")).thenReturn("1");
        Mockito.when(resultSet.getString("login")).thenReturn("1");
        Mockito.when(resultSet.getString("passw")).thenReturn("1");
        User user = userFactory.createUser(UserTypes.USER_ADMIN, resultSet);
        assertTrue("Wrong state of object",user.getId() == 1);
        assertTrue("Wrong type object",user instanceof Admin);
    }

    @Test
    public void testFactoryNull() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        Mockito.when(resultSet.getInt("adm_id")).thenReturn(1);
        Mockito.when(resultSet.getString("fio")).thenReturn("1");
        Mockito.when(resultSet.getString("login")).thenReturn("1");
        Mockito.when(resultSet.getString("passw")).thenReturn("1");
        User user = userFactory.createUser(22, resultSet);
        assertTrue("Wrong type user",user == null);
    }

}
