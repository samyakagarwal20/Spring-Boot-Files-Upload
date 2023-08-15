package com.yflash.tech.SampleAPI.service.impl;

import com.yflash.tech.SampleAPI.entity.FileDataEntity;
import com.yflash.tech.SampleAPI.repository.FileDataRepository;
import com.yflash.tech.SampleAPI.service.FileService;
import com.yflash.tech.SampleAPI.utils.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger LOGGER = LogManager.getLogger(FileServiceImpl.class);

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    FileUtils fileUtils;

    @Autowired
    FileDataRepository fileDataRepository;

    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        LOGGER.info("Uploading the file...");
        LOGGER.info("Compressing file content...");
        FileDataEntity fileDetails = fileDataRepository.save(FileDataEntity.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .data(FileUtils.compressFile(file.getBytes()))
                .build());
        if(fileDetails == null) {
            LOGGER.error("Error uploading file !");
            throw new Exception("Error uploading file !");
        }
        LOGGER.info("File {} of type {} uploaded successfully !", file.getOriginalFilename(), file.getContentType());
        return "File details saved successfully !";
    }
}
