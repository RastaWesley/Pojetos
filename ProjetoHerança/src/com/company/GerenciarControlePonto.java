package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GerenciarControlePonto {
    public static void main(String[] args) {
        Gerente gerente = new Gerente(01, "Wesley", "Wesley@teste.com",
                "01020304", "Gerente01", "12345678");
        Secretaria secretaria = new Secretaria(02, "Celia", "celia@teste.com",
                "13245768", "19-70707070", "01");
        Operador operador = new Operador(03, "Marcos", "Marcos@teste.com", "98765432", 6.89);


        LocalDate dataRegistro = LocalDate.now();
        LocalDateTime horarioEntrada = LocalDateTime.now();
        try {
            Thread.sleep(1550);
        }catch(Exception erro) {}
        LocalDateTime horarioSaida = LocalDateTime.now();

        RegistroPonto rpFunc1 = new RegistroPonto(01, gerente,  dataRegistro,
                horarioEntrada, horarioSaida);

        RegistroPonto rpFunc2 = new RegistroPonto(02, secretaria,  dataRegistro,
                horarioEntrada, horarioSaida);

        RegistroPonto rpFunc3 = new RegistroPonto(03, operador,  dataRegistro,
                horarioEntrada, horarioSaida);

        rpFunc1.apresentarRegistroPonto();
        rpFunc2.apresentarRegistroPonto();
        rpFunc3.apresentarRegistroPonto();

    }
}
