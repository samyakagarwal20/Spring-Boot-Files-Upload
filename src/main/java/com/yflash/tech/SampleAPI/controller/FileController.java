package com.yflash.tech.SampleAPI.controller;

import com.yflash.tech.SampleAPI.service.FileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

}
