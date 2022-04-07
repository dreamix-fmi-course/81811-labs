package uni.fmi.week6.ticket.repository;

import uni.fmi.week6.ticket.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private Map<Long, User> userDb = new ConcurrentHashMap<>();

    @Override
    public void addUser(User u) {
        if (u == null) {
            throw new IllegalArgumentException("user cannot be null");
        }

        /*if (userDb.containsKey(u.getId())) {
            throw new UserAlreadyExistsException("This user is already in the DB");
        }*/

        if (!userDb.containsKey(u.getId())) {
            userDb.put(u.getId(), u);
        }
    }

    @Override
    public void deleteUser(Long id) {
        User user = findById(id);
        if (user != null) {
            userDb.remove(id ,user);
        }
    }

    @Override
    public User findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }

        return userDb.get(id);
    }

    @Override
    public void updateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }

        Long id = user.getId();
        User userById = findById(id);
        if (userById != null) {
            userDb.put(id, new User(id, user.getUserName(), user.getEmail()));
        }
    }
}
