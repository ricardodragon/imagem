package com.dibros.imagem.controller;

import com.dibros.imagem.dto.AnuncioDTO;
import com.dibros.imagem.service.ImagemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/imagem")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Api(value = "Endpoints to manage usuarios")
@Slf4j
public class ImagemController {

    private final ImagemService imagemService;

    @PostMapping
    @ApiOperation(value = "List all available produtos", response = AnuncioDTO.class)
    public ResponseEntity<List<String>> postProdutos(@RequestPart(value="files", required = false) MultipartFile[] files){
        try {
            return new ResponseEntity<List<String>>(this.imagemService.testeImagem(files), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
