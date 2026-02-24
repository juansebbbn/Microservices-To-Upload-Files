package com.juan.s3microservice.service;

import com.juan.s3microservice.exception.BusinessException;
import com.juan.s3microservice.repo.S3Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

    private S3Repository s3rep;

    public StorageService(S3Repository s3rep){
        this.s3rep = s3rep;
    }


    public void upload(MultipartFile file, String username, String role) throws BusinessException {
        long sizeInMb = file.getSize() / (1024 * 1024);

        if ("TIER1".equals(role) && sizeInMb > 0.001) {
            throw new BusinessException("Usuarios TIER1 tienen un límite de 2MB por archivo.");
        }

        if ("TIER2".equals(role) && sizeInMb > 0.4) {
            throw new BusinessException("Usuarios TIER2 tienen un límite de 10MB por archivo.");
        }

        String fileName = username + "_" + System.currentTimeMillis() + "_" + file.getOriginalFilename();

        s3rep.uploadFile(fileName, file);
    }
}
