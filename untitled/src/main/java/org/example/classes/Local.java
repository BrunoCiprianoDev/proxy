package org.example.classes;

import java.util.Arrays;
import java.util.List;

public class Local implements ILocal {

    private String coordenadas;
    private String nome;
    private String cidade;
    private Float temperatura;
    private Float umidade;

    public Local(String coordenadas) {
        this.coordenadas = coordenadas;
        Local objeto = ForecastApi.getLocal(coordenadas);
        this.nome = objeto.nome;
        this.cidade = objeto.cidade;
        this.temperatura = objeto.temperatura;
        this.umidade = objeto.umidade;
    }

    public Local(String coordenadas, String nome, String cidade, Float temperatura, Float umidade) {
        this.coordenadas = coordenadas;
        this.nome = nome;
        this.cidade = cidade;
        this.temperatura = temperatura;
        this.umidade = umidade;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.cidade);
    }

    @Override
    public List<Float> obterDadosClimaticos(Usuario usuario) {
        return Arrays.asList(this.temperatura, this.umidade);
    }
}