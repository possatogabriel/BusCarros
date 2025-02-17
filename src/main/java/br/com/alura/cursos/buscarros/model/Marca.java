package br.com.alura.cursos.buscarros.model;

import br.com.alura.cursos.buscarros.service.API;
import br.com.alura.cursos.buscarros.service.Conversao;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Marca {
    private String endereco;
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    private Scanner input = new Scanner(System.in);
    private API api = new API();
    private Conversao conversor = new Conversao();

    public void exibeMarcas() {
        System.out.println("""
                - CARROS -
                - MOTOS -
                - CAMINHÕES -
                """);

        System.out.print("Qual dos itens acima você deseja visualizar? ");
        var busca = input.nextLine().toLowerCase();
        System.out.println();

        if (busca.contains("car")) {
            System.out.println("- VEÍCULO SELECIONADO: CARRO -\n");
            endereco = URL_BASE + "carros/marcas";
        } else if (busca.contains("mo")) {
            System.out.println("- VEÍCULO SELECIONADO: MOTO -\n");
            endereco = URL_BASE + "motos/marcas";
        } else {
            System.out.println("- VEÍCULO SELECIONADO: CAMINHÃO -\n");
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = api.buscaDados(endereco);
        var listaDeMarcas = conversor.obtemLista(json, Dados.class);

        listaDeMarcas.stream()
                .sorted(Comparator.comparing(Dados::nome))
                .forEach(d -> System.out.println("CÓDIGO: " + d.codigo() + " - MARCA: " + d.nome()));

        exibeModelos(endereco, listaDeMarcas);
    }

    public void exibeModelos(String endereco, List<Dados> listaDeMarcas) {
        System.out.println();
        System.out.print("Digite o código da marca que você quer visualizar: ");
        var codigo = input.nextLine();

        listaDeMarcas.stream()
                .filter(i -> i.codigo().equals(codigo))
                .forEach(i -> System.out.println("\n- MARCA SELECIONADA: " + i.nome() + " - \n"));

        endereco = endereco + "/" + codigo + "/modelos";

        var json = api.buscaDados(endereco);
        var listaDeModelos = conversor.converteDados(json, Modelos.class);

        listaDeModelos.modelos().stream()
                .sorted(Comparator.comparing(Dados::nome))
                .forEach(d -> System.out.println("CÓDIGO: " + d.codigo() + " - MODELO: " + d.nome()));

        exibeAnos(endereco, listaDeModelos);
    }

    public void exibeAnos(String endereco, Modelos listaDeModelos) {
        System.out.print("\nInsira o código do modelo que você quer visualizar: ");
        var codigo = input.nextLine();

        listaDeModelos.modelos().stream()
                .filter(i -> i.codigo().equals(codigo))
                .forEach(i -> System.out.println("\n- MODELO SELECIONADO: " + i.nome() + " - \n"));

        endereco = endereco + "/" + codigo + "/anos";

        var json = api.buscaDados(endereco);
        var listaDeAnos = conversor.obtemLista(json, Dados.class);

        listaDeAnos.stream()
                .forEach(i -> System.out.println("CÓDIGO: " + i.codigo() + " - TIPO: " + i.nome()));

        exibeCarro(endereco);
    }

    public void exibeCarro(String endereco) {
        System.out.print("\nEscreva o código do tipo que você quer visualizar: ");
        var codigo = input.nextLine();

        endereco = endereco + "/" + codigo;

        var json = api.buscaDados(endereco);
        var informacoes = conversor.converteDados(json, DadosVeiculo.class);

        var veiculo = new Veiculo(informacoes);
        System.out.println(veiculo);
    }
}
