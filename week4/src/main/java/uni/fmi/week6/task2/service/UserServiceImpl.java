package uni.fmi.week6.task2.service;

import uni.fmi.week6.task2.model.Event;
import uni.fmi.week6.task2.model.User;
import uni.fmi.week6.task2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User u) {
        userRepository.addUser(u);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUserInformation(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public List<Event> getAllVisitedEvent() {
        return null;
    }

    @Override
    public List<Event> getAllVisitedEventsInPastMonth() {
        return null;
    }
}
