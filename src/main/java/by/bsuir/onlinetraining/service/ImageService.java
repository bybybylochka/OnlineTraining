package by.bsuir.onlinetraining.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String uploadFile(MultipartFile file);
    byte[] downloadFile(String pathToFile);
}
