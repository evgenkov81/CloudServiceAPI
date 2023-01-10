package ru.evgenkov.cloudserviceapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileNameResponse {
    private String fileName;
    private Long size;
}
