package example.springboot.aws.s3.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;


/**
 * Created by asingh on 11/1/16.
 */
@ConfigurationProperties(prefix = "cloud.aws")
@Data
public class AWSProperties {

    @NestedConfigurationProperty
    private AWSCredentials credentials;

    private String region;
}
