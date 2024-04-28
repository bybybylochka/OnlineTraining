package by.bsuir.onlinetraining.mapper.qualifier;

import by.bsuir.onlinetraining.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ImageServiceQualifier {
    private final ImageService imageService;

    @Named("downloadImage")
    public byte[] downloadImage(String pathToFile) {
        return imageService.downloadFile(pathToFile);
    }
}
