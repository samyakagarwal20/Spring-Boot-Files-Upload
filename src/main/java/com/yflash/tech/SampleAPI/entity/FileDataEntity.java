package com.yflash.tech.SampleAPI.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "FileData")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    // to store the binary data into the DB, we use @Lob annotation
    @Lob
    @Column(length = 5 * 1024 * 1024)       // setting the length of column to store data up to 5MB
    private byte[] data;

}
