package com.example.aws_demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

@Service
public class S3FileService {

    private final S3Client s3Client;
    private final String bucketName;

    public S3FileService(S3Client s3Client, @Value("${aws.s3.bucket}") String bucketName) {
        this.s3Client = s3Client;
        this.bucketName = bucketName;
    }

    public String readWelocomeFile() {
        GetObjectRequest request = GetObjectRequest.builder()
                .bucket(bucketName)
                .key("welcome.txt")
                .build();

        ResponseBytes<GetObjectResponse> response = s3Client.getObjectAsBytes(request);

        return response.asUtf8String();
    }
}
