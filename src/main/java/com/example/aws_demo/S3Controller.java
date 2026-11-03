package com.example.aws_demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class S3Controller {
    private final S3FileService s3FileService;

    public S3Controller(S3FileService s3FileService){
        this.s3FileService = s3FileService;
    }

    @GetMapping(value = "s3/file",
        produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String getFile(){
        return s3FileService.readWelocomeFile();
    }
}
