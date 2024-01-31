package com.dibros.imagem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class ImagemService {

    public List<String> testeImagem(MultipartFile[] files) throws Exception{
        if(files==null) return null;
        List<String> imagens = new ArrayList<String>();
        for(MultipartFile file : files) {
            File f = new File("C:/Users/ricar/Desktop/Projects/SERVIDOR - PROD -/imagens/" + file.getOriginalFilename());
            int i = 0;
            while (!f.createNewFile() && i < 100)
                f = new File("C:/Users/ricar/Desktop/Projects/SERVIDOR - PROD -/imagens/" + file.getOriginalFilename().split("\\.")[0] + (++i) + "." + file.getOriginalFilename().split("\\.")[1]);
            try (OutputStream os = Files.newOutputStream(f.toPath())) {
                os.write(file.getBytes());
                os.flush();
                imagens.add("/imagem/public/imagens/" + f.getName());
            } catch (Exception e) {
                throw new FileSystemLoopException("Erro ao salvar arquivo");
            }
        }
        return imagens;
    }
}
