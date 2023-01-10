package ru.evgenkov.cloudserviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.evgenkov.cloudserviceapi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByLogin(String login);
}
