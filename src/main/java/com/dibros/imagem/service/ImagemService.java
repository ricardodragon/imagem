package com.dibros.imagem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImagemService {

    public Mono<String> testeImagem(FilePart file) {
        if(Objects.isNull(file)) return Mono.empty();
        File f = new File("C:/Users/ricar/Desktop/projects/SERVIDOR - PROD -/imagens/" + file.filename());
        for (int i = 0; i < 100; i++) {
            try {
                if (!f.createNewFile())
                    f = new File("C:/Users/ricar/Desktop/projects/SERVIDOR - PROD -/imagens/" + file.filename().split("\\.")[0] + i + "." + file.filename().split("\\.")[1]);
                else break;
            } catch (IOException e) {
                log.info(e.getMessage());
            }
        }
        return file.transferTo(f).then(Mono.just("/imagem/public/imagens/" + f.getName()));
    }
}
