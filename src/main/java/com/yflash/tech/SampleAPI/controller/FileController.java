package com.yflash.tech.SampleAPI.controller;

import com.yflash.tech.SampleAPI.model.FileData;
import com.yflash.tech.SampleAPI.model.FileDetails;
import com.yflash.tech.SampleAPI.service.FileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/files")
public class FileController {

    @Autowired
    FileService fileService;

    private static final Logger LOGGER = LogManager.getLogger(FileController.class);

    @PostMapping(value = "/upload-file")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        String msg = fileService.uploadFile(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(msg);
    }

    @GetMapping(value = "/download-file/{filename}")
    public ResponseEntity<?> downloadFile(@PathVariable String filename) throws Exception {
        FileData fileData = fileService.downloadFile(filename);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(fileData.getType()))
                        .body(fileData.getData());
    }

    @GetMapping(value = "/list-files")
    public ResponseEntity<List<FileDetails>> filesList() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(fileService.listFiles());
    }

}
