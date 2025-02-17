package br.com.alura.cursos.buscarros.model;

public class Veiculo {
    private Integer tipoDoVeiculo;
    private String valor;
    String marca;
    String modelo;
    Integer anoDoModelo;
    String tipoDeCombustivel;
    String codigoFipe;
    String mesReferencia;

    public Veiculo(DadosVeiculo rVeiculo) {
        this.modelo = rVeiculo.modelo();
        this.tipoDoVeiculo = rVeiculo.tipoDoVeiculo();
        this.marca = rVeiculo.marca();
        this.valor = rVeiculo.valor();
        this.anoDoModelo = rVeiculo.anoDoModelo();
        this.mesReferencia = rVeiculo.mesReferencia();
        this.tipoDeCombustivel = rVeiculo.tipoDeCombustivel();
        this.codigoFipe = rVeiculo.codigoFipe();
    }

    public Veiculo() {
    }

    public String getValor() {
        return valor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAnoDoModelo() {
        return anoDoModelo;
    }

    public String getTipoDeCombustivel() {
        return tipoDeCombustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    @Override
    public String toString() {
        return """
                
                MODELO: %s - %s
                > MARCA: %s
                > VALOR: %s
                > ANO DO MODELO: %d
                > MÊS DE REFERÊNCIA: %s
                > TIPO DE COMBUSTÍVEL: %s
                
                > CÓDIGO FIPE: %s""".formatted(getModelo(), exibeTipoVeiculo(), getMarca(), getValor(), getAnoDoModelo(), getMesReferencia(), getTipoDeCombustivel(), getCodigoFipe());
    }

    public String exibeTipoVeiculo() {
        if (this.tipoDoVeiculo == 1) {
            return "CARRO";
        } else if (this.tipoDoVeiculo == 2) {
            return "MOTO";
        } else {
            return "CAMINHÃO";
        }
    }
}
