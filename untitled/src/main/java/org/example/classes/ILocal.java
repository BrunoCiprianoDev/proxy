package org.example.classes;

import java.util.List;

public interface ILocal {
    List<String> obterDadosPessoais();
    List<Float> obterDadosClimaticos(Usuario usuario);
}
