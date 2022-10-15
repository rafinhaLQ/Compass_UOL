
/* Escreva um programa Java que tem como objetivo ser um quiz de
perguntas e respostas. Na tela, você perguntará ao usuário e ele
responderá. Se o usuário acertar ou errar, você precisa informar se ele
acertou ou errou e passar para próxima pergunta (enquanto houver
próxima). Utilizem array para guardar as perguntas e respostas. Na tela
perguntará ao usuário o nome, e por vez assim as perguntas, caso o
usuário acerte ele demonstre os erros e acertos (como no exemplo abaixo): */

import java.util.Scanner;

public class Quiz {

    // Declaração do Scanner global.
    static Scanner scan = new Scanner(System.in);

    // função que verifica se a resposta dada pelo usuário é válida.
    public static String verificaVerdadeiroFalso(String resposta) {

        // Deixa resposta em letra maiúscula.
        resposta = resposta.toUpperCase();

        if (resposta.equals("VERDADEIRO")) {
            return resposta;
        } else if (resposta.equals("FALSO")) {
            return resposta;
        } else {
            System.out.printf("\nOpcao invalida!\n\nPor favor responda com \"VERDADEIRO\" ou \"FALSO\": ");
            resposta = scan.nextLine();
            // Cria o loop até receber uma resposta válida.
            return verificaVerdadeiroFalso(resposta);
        }

    }

    public static void main(String[] args) {

        // Array contendo as perguntas do quiz.
        String[] perguntas = {
                "A Bahia nao eh o estado que mais faz divisa com outros estados",
                "Na Bahia, ha um clube que foi o primeiro campeao brasileiro da historia",
                "Salvador foi a primeira capital do Brasil",
                "A Bahia eh o estado que tem o maior litoral",
                "A Bahia faz divisa com o Rio de Janeiro"
        };

        // Array contendo o gabarito do quiz.
        String[] gabarito = {
                "FALSO",
                "VERDADEIRO",
                "VERDADEIRO",
                "VERDADEIRO",
                "FALSO"
        };

        // Array que armazena respotas do quiz
        String[] respostas = new String[5];

        // Introdução do quiz
        System.out.printf("\n\tQuiz da Bahia!\n\n\n");

        System.out.printf("Este quiz ira apresentar afirmacoes que voce dira se eh \"VERDADEIRO\" ou \"FALSO\"\n\n");

        // Loop para imprimir perguntas e receber respostas.
        for (int cont = 1; cont <= 5; cont++) {

            String resposta;

            System.out.printf("Questao %d\n\n", cont);
            System.out.println(perguntas[cont - 1]);
            System.out.println("VERDADEIRO ou FALSO: ");

            resposta = scan.nextLine();
            resposta = verificaVerdadeiroFalso(resposta);

            if (resposta.equals(gabarito[cont - 1])) {
                System.out.println("ACERTOU!");
                respostas[cont - 1] = "ACERTOU";
            } else {
                System.out.println("ERROU!");
                respostas[cont - 1] = "ERROU";
            }
            System.out.printf("\n\n\n");
        }

        // Resultado do quiz.
        int acertos = 0, erros = 0;

        System.out.println("Resultado:");
        for (int cont = 0; cont < 5; cont++) {
            System.out.printf("Questao %d: %s\n", cont, respostas[cont]);
            if (respostas[cont].equals("ACERTOU"))
                acertos++;
            else
                erros++;
        }

        System.out.printf("\n\nAcertos: %d\nErros: %d", acertos, erros);

    }

}