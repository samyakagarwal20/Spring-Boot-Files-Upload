package com.yflash.tech.SampleAPI.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String uploadFile(MultipartFile file) throws Exception;
}
