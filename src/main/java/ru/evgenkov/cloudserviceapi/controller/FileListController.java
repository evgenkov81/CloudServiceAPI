package ru.evgenkov.cloudserviceapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.evgenkov.cloudserviceapi.model.FileNameResponse;
import ru.evgenkov.cloudserviceapi.service.FileService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/list")
public class FileListController {

    private final FileService fileService;

    @GetMapping
    List<FileNameResponse> getAllFiles(@RequestHeader("auth-token")
                                       String authToken, @RequestParam("limit") Integer limit) {
        return fileService.getAllFiles(authToken, limit);
    }
}