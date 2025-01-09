package com.dibros.imagem.controller;

import com.dibros.imagem.service.ImagemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/imagem")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class ImagemController {

    private final ImagemService imagemService;

    @PostMapping
    public ResponseEntity<Object> postProdutos(@RequestPart(value="files", required = false) MultipartFile[] files){
        try {
            return new ResponseEntity<>(this.imagemService.testeImagem(files), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
