package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.service.ImageService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;

@Component
public class ImageServiceImpl implements ImageService {
    private static final String FOLDER_PATH = "D:/dev/online-training/src/assets/users-photo/";

    @Override
    @SneakyThrows
    public String uploadFile(MultipartFile file) {
        String filePath = FOLDER_PATH + file.getOriginalFilename();
        file.transferTo(new File(filePath));

        return filePath;
    }

    @Override
    @SneakyThrows
    public byte[] downloadFile(String pathToFile) {
        if (pathToFile==null) return null;
        return Files.readAllBytes(new File(pathToFile).toPath());
    }
}
