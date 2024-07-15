package org.example.classes;

import java.util.List;

public class LocalProxy implements ILocal {

    private Local local;

    private String coordenadas;

    public LocalProxy(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public List<String> obterDadosPessoais() {
        if (this.local == null) {
            this.local = new Local(this.coordenadas);
        }
        return this.local.obterDadosPessoais();
    }

    @Override
    public List<Float> obterDadosClimaticos(Usuario usuario) {
        if (!usuario.isAdministrador()) {
            throw new IllegalArgumentException("Usuário não autorizado");
        }
        if (this.local == null) {
            this.local = new Local(this.coordenadas);
        }
        return this.local.obterDadosClimaticos(usuario);
    }
}