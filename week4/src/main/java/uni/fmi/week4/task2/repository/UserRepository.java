package uni.fmi.week4.task2.repository;

import uni.fmi.week4.task2.model.User;

public interface UserRepository {
    /**
     * Create new user
     */
    void addUser(User u);

    /**
     * Delete user
     */
    void deleteUser(Long id);

    /**
     * Find user by id
     */
    User findById(Long id);

    /**
     * Update user information
     */
    void updateUser(User user);

}
