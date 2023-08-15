package com.yflash.tech.SampleAPI.service;

import com.yflash.tech.SampleAPI.model.FileData;
import com.yflash.tech.SampleAPI.model.FileDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    String uploadFile(MultipartFile file) throws Exception;
    FileData downloadFile(String fileName) throws Exception;
    List<FileDetails> listFiles();
}
