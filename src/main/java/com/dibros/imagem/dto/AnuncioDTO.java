package com.dibros.imagem.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnuncioDTO {

    private Long id;
    private Long idUsuario;
    private String imagemPath;
    private Long idLoja;
    private String legenda;
    private Integer indexImagem;

}


