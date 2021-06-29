package com.project.springbootproject.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;


@Service
@NoArgsConstructor
public class S3Service {

    //fileService.java에서 사용될 상수임. s3Client.getUrl()에서 불러오는 것이아니라
    //cdn 된 캐시로 접근하여 (cloudfront를 통해) 파일을 불러올것이기때문이다.
    public static final String CLOUD_FRONT_DOMAIN_NAME = "d2zec66nj5q5ud.cloudfront.net";

    //build.gradle => compile에 content가 포함되어야한다.
    private AmazonS3 s3Client;

    @Value("${cloud.aws.credentials.accessKey}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secretKey}")
    private String secretKey;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.region.static}")
    private String region;

    @PostConstruct
    public void setS3Client () {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);

        s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(this.region)
                .build();
    }

    public String upload(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();

        s3Client.putObject(new PutObjectRequest(bucket, fileName, file.getInputStream(), null)
            .withCannedAcl(CannedAccessControlList.PublicRead));

        return s3Client.getUrl(bucket, fileName).toString();
    }
}
