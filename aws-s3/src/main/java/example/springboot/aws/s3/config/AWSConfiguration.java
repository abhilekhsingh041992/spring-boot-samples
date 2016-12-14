package example.springboot.aws.s3.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by asingh on 11/1/16.
 */
@Configuration
@ConditionalOnClass({AWSProperties.class, AmazonS3Client.class})
@EnableConfigurationProperties(AWSProperties.class)
public class AWSConfiguration {

    @Autowired
    private AWSProperties properties;

    @Bean
    public BasicAWSCredentials basicAWSCredentials() {
        return new BasicAWSCredentials(properties.getCredentials().getAccessKey(), properties.getCredentials().getSecretKey());
    }

    @Bean
    public AmazonS3Client amazonS3Client(AWSCredentials awsCredentials) {
        AmazonS3Client amazonS3Client = new AmazonS3Client(awsCredentials);
        amazonS3Client.setRegion(Region.getRegion(Regions.fromName(properties.getRegion())));
        return amazonS3Client;
    }
}