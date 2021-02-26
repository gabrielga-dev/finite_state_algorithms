package testes;

import data_shape.Automato;
import data_shape.Estado;
import data_shape.Transicao;
import data_shape.enums.EnumOperador;

import java.util.Arrays;
import java.util.List;

public class MultiplicacaoDeAutomatosUniaoTESTE01 {
    public static void main(String[] args) {
        List<String> inputs = Arrays.asList("a", "b");

        Automato aut1 = new Automato();
        //adicionando 3 estados
        Estado estado1 = new Estado(1L,"1", Boolean.FALSE, Boolean.TRUE);
        Estado estado2 = new Estado(2L,"2", Boolean.TRUE, Boolean.FALSE);
        Estado estado3 = new Estado(3L,"3");
        //adicionando transicoes
        //1
        Transicao trans1 = new Transicao(estado1, estado3, "a");
        Transicao trans2 = new Transicao(estado1, estado2, "b");
        //2
        Transicao trans3 = new Transicao(estado2, estado1, "a");
        Transicao trans4 = new Transicao(estado2, estado2, "b");
        //3
        Transicao trans5 = new Transicao(estado3, estado3, "a");
        Transicao trans6 = new Transicao(estado3, estado2, "b");
        //montagem
        aut1.estados = Arrays.asList(estado1, estado2, estado3);
        aut1.inputs_possiveis = inputs;
        aut1.transicoes = Arrays.asList(trans1, trans2, trans3, trans4, trans5, trans6);
        aut1.estado_inicial = estado1;
        aut1.estados_de_aceitacao = Arrays.asList(estado2);

        Automato aut2 = new Automato();
        //adicionando 3 estados
        Estado estado4 = new Estado(4L,"4", Boolean.FALSE, Boolean.TRUE);
        Estado estado5 = new Estado(5L,"5", Boolean.TRUE, Boolean.FALSE);
        //adicionando transicoes
        //4
        Transicao trans7 = new Transicao(estado4, estado5, "a");
        Transicao trans8 = new Transicao(estado4, estado4, "b");
        //5
        Transicao trans9 = new Transicao(estado5, estado4, "a");
        Transicao trans10 = new Transicao(estado5, estado5, "b");
        //montagem
        aut2.estados = Arrays.asList(estado4, estado5);
        aut2.inputs_possiveis = inputs;
        aut2.transicoes = Arrays.asList(trans7, trans8, trans9, trans10);
        aut2.estado_inicial = estado4;
        aut2.estados_de_aceitacao = Arrays.asList(estado5);


        aut1.show();
        aut2.show();

        System.out.println("União de aut1 e aut2:");
        EnumOperador.UNIAO.executaOperacao(aut1, aut2).show();
    }
}
