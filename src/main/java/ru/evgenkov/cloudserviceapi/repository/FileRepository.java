package ru.evgenkov.cloudserviceapi.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.evgenkov.cloudserviceapi.entity.File;
import ru.evgenkov.cloudserviceapi.entity.User;

import java.util.List;

@Repository
public interface FileRepository  extends JpaRepository<File, String> {

    File findByUserAndFileName(User user, String filename);
    void deleteByUserAndFileName(User user, String filename);
    List<File> findAllByUser(User user, Sort sort);

}