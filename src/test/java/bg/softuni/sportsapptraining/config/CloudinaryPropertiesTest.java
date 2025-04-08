package bg.softuni.sportsapptraining.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CloudinaryPropertiesTest {

    @Autowired
    private CloudinaryProperties properties;

    @Test
    void cloudinaryPropertiesAreLoaded() {
        assertThat(properties).isNotNull();
        assertThat(properties.getCloudName()).isNotBlank();
        assertThat(properties.getApiKey()).isNotBlank();
        assertThat(properties.getApiSecret()).isNotBlank();
    }


}
