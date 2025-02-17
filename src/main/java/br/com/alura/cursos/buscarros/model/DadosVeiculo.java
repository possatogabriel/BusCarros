package br.com.alura.cursos.buscarros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo(@JsonAlias("TipoVeiculo") Integer tipoDoVeiculo,
                           @JsonAlias("Valor") String valor,
                           @JsonAlias("Marca") String marca,
                           @JsonAlias("Modelo") String modelo,
                           @JsonAlias("AnoModelo") Integer anoDoModelo,
                           @JsonAlias("Combustivel") String tipoDeCombustivel,
                           @JsonAlias("CodigoFipe") String codigoFipe,
                           @JsonAlias("MesReferencia") String mesReferencia) {
}
