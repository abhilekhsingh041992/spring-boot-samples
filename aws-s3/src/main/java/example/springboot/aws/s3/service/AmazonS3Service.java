package example.springboot.aws.s3.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * Created by abhilekhsingh041992 on 12/18/16.
 */
@Service
public class AmazonS3Service {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Autowired
    public AmazonS3Service(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    public String getImage(String folderName, String fileName) throws IOException {
        final S3Object object = amazonS3Client.getObject(new GetObjectRequest(bucket + "/" + folderName, fileName));
        final BufferedInputStream i = new BufferedInputStream(object.getObjectContent());
        InputStream objectData = object.getObjectContent();
        Files.copy(objectData, new File(fileName).toPath());
        objectData.close();
        return objectData.toString();
    }

}
