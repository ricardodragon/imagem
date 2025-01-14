package com.dibros.imagem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImagemService {

    public Flux<String> testeImagem(Flux<FilePart> files) {
        return files.map(file ->{
            File f = new File("C:/Users/ricar/OneDrive/Área de Trabalho/Projects/SERVIDOR - PROD -/imagens/" + file.filename());
            for(int i=0; i < 100; i++) {
                try {
                    if(!f.createNewFile())
                        f = new File("C:/Users/ricar/OneDrive/Área de Trabalho/Projects/SERVIDOR - PROD -/imagens/" + file.filename().split("\\.")[0] + i + "." + file.filename().split("\\.")[1]);
                    else break;
                } catch (IOException e) {
                    log.info(e.getMessage());
                }
            }
            file.transferTo(f);
            return "/imagem/public/imagens/" + f.getName();
        });
    }
}
