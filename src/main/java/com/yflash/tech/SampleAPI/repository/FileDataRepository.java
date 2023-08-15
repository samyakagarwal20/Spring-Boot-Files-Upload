package com.yflash.tech.SampleAPI.repository;

import com.yflash.tech.SampleAPI.entity.FileDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDataRepository extends JpaRepository<FileDataEntity, Long> {

}
