package example.springboot.aws.s3.service;

import example.springboot.aws.s3.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.Assert.*;

/**
 * Created by abhilekhsingh041992 on 12/18/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AmazonS3ServiceTest {

    @Autowired
    AmazonS3Service amazonS3Service;

    @Test
    public void getImage() throws Exception {
        amazonS3Service.getImage("user-profiles", "1.jpg");
    }

}