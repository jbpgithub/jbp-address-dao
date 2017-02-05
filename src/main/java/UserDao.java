import java.util.List;

/**
 * Created by Silver on 3.2.2017..
 */
public interface UserDao {
    public User fetchUser(String id);

    public List findUsers();

    public boolean authenticateUser(String username, String password);
}
