package example.springboot.aws.s3.config;

import lombok.Data;

/**
 * Created by asingh on 11/1/16.
 */
@Data
public class AWSCredentials {

    private String accessKey;

    private String secretKey;
}
