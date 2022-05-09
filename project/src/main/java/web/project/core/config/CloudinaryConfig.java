package web.project.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import web.project.core.cloudinary.CloudinaryManager;
import web.project.core.cloudinary.CloudinaryService;

@Configuration
public class CloudinaryConfig {
	@Bean
	public Cloudinary cloudinaryAccount() { //Cloudinary hesap bilgileri
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "",
                "api_key", "",
                "api_secret", ""
        ));
    }

    @Bean
    public CloudinaryService cloudinaryService() {
        return new CloudinaryManager(cloudinaryAccount());
    }
}
