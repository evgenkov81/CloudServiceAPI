package ru.evgenkov.cloudserviceapi.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.evgenkov.cloudserviceapi.entity.File;
import ru.evgenkov.cloudserviceapi.entity.User;

import java.util.List;

public interface FileRepository extends JpaRepository<File,String> {
    File findByUserAndFileName (User user, String fileName);
    void deleteByUserAndFileName(User user, String fileName);
    List<File> findAllByUser(User user, Sort sort);
}
