package web.project.core.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import web.project.core.results.DataResult;

public interface CloudinaryService {
	DataResult<?> upload(MultipartFile multipartFile);
	DataResult<?> delete(String publicIdOfCert);
}
