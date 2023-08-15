package com.yflash.tech.SampleAPI.repository;

import com.yflash.tech.SampleAPI.entity.FileDataEntity;
import com.yflash.tech.SampleAPI.projections.FileNameAndTypeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileDataRepository extends JpaRepository<FileDataEntity, Long> {

    Optional<FileDataEntity> findByName(String filename);

    @Query(value = "SELECT f.id as id, f.name as name, f.type as type FROM FileData f",nativeQuery = true)
    List<FileNameAndTypeProjection> fetchFileNameAndType();
}
