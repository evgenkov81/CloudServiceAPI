package ru.evgenkov.cloudserviceapi.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.evgenkov.cloudserviceapi.entity.File;
import ru.evgenkov.cloudserviceapi.entity.User;
import ru.evgenkov.cloudserviceapi.exeptions.InputDataException;
import ru.evgenkov.cloudserviceapi.exeptions.UnauthorizedException;
import ru.evgenkov.cloudserviceapi.model.FileNameRequest;
import ru.evgenkov.cloudserviceapi.model.FileNameResponse;
import ru.evgenkov.cloudserviceapi.repository.AuthorizationRepository;
import ru.evgenkov.cloudserviceapi.repository.FileRepository;
import ru.evgenkov.cloudserviceapi.repository.UserRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class FileService {
    FileRepository fileRepository;
    AuthorizationRepository authorizationRepository;
    UserRepository userRepository;


    public void uploadFile(String authToken, String fileName, MultipartFile file) throws IOException {
        final User user =getUser(authToken);
        if (user == null) {
            throw new UnauthorizedException("Unauthorized error");
        }
        fileRepository.save(new File(fileName, LocalDateTime.now(), file.getSize(), file.getContentType(), file.getBytes(), user));
    }
    public void deleteFile(String authToken, String fileName) {
        final User user = getUser(authToken);
        if (user == null) {
            throw new UnauthorizedException("Unauthorized error");
        }
        fileRepository.deleteByUserAndFileName(user, fileName);
    }
    public void editFileName(String authToken, String filename, FileNameRequest fileNameRequest) {
        final User user = getUser(authToken);
        if (user == null) {
            throw new UnauthorizedException("Unauthorized error");
        }
        if (fileNameRequest.getFileName() != null) {
            File editFile = fileRepository.findByUserAndFileName(user, filename);
            editFile.setFileName(fileNameRequest.getFileName());
            fileRepository.save(fileRepository.findByUserAndFileName(user, editFile.getFileName()));
        } else {
            throw new InputDataException("Error input data");
        }
    }

    public List<FileNameResponse> getAllFiles(String authToken, Integer limit) {
        final User user = getUser(authToken);
        if (user == null) {
            throw new UnauthorizedException("Unauthorized error");
        }
        return fileRepository.findAllByUser(user, Sort.by("fileName")).stream()
                .map(f -> new FileNameResponse(f.getFileName(), f.getSize()))
                .collect(Collectors.toList());
    }

    private User getUser(String authToken) {
        final String username = authorizationRepository.getUserNameByToken(authToken);
        return userRepository.findByLogin(username)
                .orElseThrow(() -> new UnauthorizedException("Unauthorized error"));
    }


}
