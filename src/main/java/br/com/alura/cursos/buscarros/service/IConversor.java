package br.com.alura.cursos.buscarros.service;

import java.util.List;

public interface IConversor {
    <T> T converteDados(String json, Class<T> classe);
    <T> List<T> obtemLista(String json, Class<T> classe);
}
