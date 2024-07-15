package org.example.classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LocalProxyTest {

    @BeforeEach
    void setUp() {
        ForecastApi.addLocal(new Local("123,456", "Praça Central", "Juiz de Fora", 25.0f, 60.0f));
        ForecastApi.addLocal(new Local("789,101", "Praia de Copacabana", "Rio de Janeiro", 30.0f, 70.0f));
    }

    @Test
    void deveRetornarDadosPessoaisLocal() {
        LocalProxy local = new LocalProxy("123,456");

        assertEquals(Arrays.asList("Praça Central", "Juiz de Fora"), local.obterDadosPessoais());
    }

    @Test
    void deveRetonarDadosClimaticosLocal() {
        Usuario usuario = new Usuario("Ana", true);
        LocalProxy local = new LocalProxy("789,101");

        assertEquals(Arrays.asList(30.0f, 70.0f), local.obterDadosClimaticos(usuario));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarDadosClimaticosLocal() {
        try {
            Usuario usuario = new Usuario("Joana", false);
            LocalProxy local = new LocalProxy("789,101");

            local.obterDadosClimaticos(usuario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Usuário não autorizado", e.getMessage());
        }
    }
}