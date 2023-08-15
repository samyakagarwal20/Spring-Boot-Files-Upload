package com.yflash.tech.SampleAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileData extends FileDetails{

    private byte[] data;

}
