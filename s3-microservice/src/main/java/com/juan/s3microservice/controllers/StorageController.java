package com.juan.s3microservice.controllers;

import com.juan.s3microservice.exception.BusinessException;
import com.juan.s3microservice.service.StorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class StorageController {

    private StorageService storageService;

    public StorageController(StorageService storageService){
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> UploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestHeader("Username") String username,
                                             @RequestHeader("Role") String role){
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Por favor, selecciona un archivo.");
        }

        try {
            storageService.upload(file, username, role);
        }catch (BusinessException e){
            return ResponseEntity.accepted().body(e.getMessage());
        }


        return ResponseEntity.ok("Archivo subido con éxito para el usuario: " + username);
    }

}
