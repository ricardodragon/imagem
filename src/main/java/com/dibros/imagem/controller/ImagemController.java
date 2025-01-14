package com.dibros.imagem.controller;

import com.dibros.imagem.service.ImagemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/imagem")
@RequiredArgsConstructor
@Slf4j
public class ImagemController {

    private final ImagemService imagemService;

    @PostMapping
    public Flux<String> postProdutos(@RequestPart("files") Flux<FilePart> files) throws Exception {
        return this.imagemService.testeImagem(files);
    }
}
