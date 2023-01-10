package ru.evgenkov.cloudserviceapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.evgenkov.cloudserviceapi.model.FileNameRequest;
import ru.evgenkov.cloudserviceapi.service.FileService;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/file")
public class FileController {
    private FileService fileService;
    @PostMapping
    public ResponseEntity<?> uploadFile(@RequestHeader("auth-token") String authToken,
                                        @RequestParam("filename") String fileName, MultipartFile file) throws IOException {
        fileService.uploadFile(authToken, fileName, file);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteFile(@RequestHeader("authToken") String authToken,
                                        @RequestParam("filename") String fileName) {
        fileService.deleteFile(authToken, fileName);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<?> downloadFile(@RequestHeader("auth-token") String authToken,
                                          @RequestParam("filename") String fileName) {
        fileService.deleteFile(authToken, fileName);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> editFileName(@RequestHeader("auth-token") String authToken,
                                          @RequestParam("fileName") String fileName,
                                          @RequestBody FileNameRequest fileNameRequest) {
        fileService.editFileName(authToken, fileName, fileNameRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
