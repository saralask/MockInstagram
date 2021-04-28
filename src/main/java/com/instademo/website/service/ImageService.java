package com.instademo.website.service;

import com.instademo.website.Repo.ImageModelRepository;
import com.instademo.website.domain.ImageModel;
import com.instademo.website.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    ImageModelRepository imageModelRepository;

    public ImageModel getImage(long id) {
        final Optional<ImageModel> retrievedImage = imageModelRepository.findById(id);
        return new ImageModel(retrievedImage.get().getName(),
                retrievedImage.get().getType(),
                Utils.decompressBytes(retrievedImage.get().getPicByte()));
    }

    public void uploadImage(MultipartFile file) throws IOException {
        ImageModel imageModel = new ImageModel(file.getOriginalFilename(),
                file.getContentType(),
                Utils.compressBytes(file.getBytes()));
        imageModelRepository.save(imageModel);
    }

}
