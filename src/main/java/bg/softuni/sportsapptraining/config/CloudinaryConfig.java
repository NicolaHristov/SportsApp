package bg.softuni.sportsapptraining.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public static Cloudinary getInstance() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dccqkyfpt",
                "api_key", "995832413948972",
                "api_secret", "dnp3ZgWG92KfRF2IJv3rF-dUCuA"
        ));
    }
}
