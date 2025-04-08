package bg.softuni.sportsapptraining.config;

import com.cloudinary.Cloudinary;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CloudinaryConfigTest {

    @Test
    void testCloudinaryBeanIsCreatedSuccessfully() {
        CloudinaryProperties testProps = new CloudinaryProperties();
        testProps.setCloudName("test-cloud");
        testProps.setApiKey("test-key");
        testProps.setApiSecret("test-secret");


        CloudinaryConfig config = new CloudinaryConfig(testProps);


        Cloudinary cloudinary = config.cloudinary();


        assertThat(cloudinary).isNotNull();
    }
}
