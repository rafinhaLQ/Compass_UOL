
/*
(OBI-2020) Emoticons são símbolos usados para expressar o sentimento de quem
escreve uma mensagem. Scott Fahlman, um professor de uma universidade
americana, foi o primeiro a propor o uso das sequências de caracteres :-) e :-(, que
2 viraram respectivamente símbolos para “divertido” e “chateado”. Vamos definir o
sentimento expresso em uma mensagem como sendo:
a) neutro: se o número de símbolos “divertido” é igual ao número de símbolos
“chateado”
b) divertido: se o número de símbolos “divertido” é maior do que número de
símbolos “chateado”
c) chateado: se o número de símbolos “chateado” é maior do que número de
símbolos “divertido”.
Dada uma mensagem composta por uma cadeia de caracteres, escreva um programa
para determinar o sentimento expresso na mensagem. O seu programa deve usar a
classe Scanner para ler uma linha de entrada e a partir dessa linha devolver o
sentimento expresso. (Atenção: Validações de entrada é um ponto para prestar
bastante atenção).
Exemplo:
Entrada: Espero que esteja tudo bem:-)
Saída: divertido
Entrada: Achei o filme muito divertido.
Saída: neutro
Entrada: :-):-(:-(:-)
Saída: neutro
Entrada: Sonhei com a prova :-( (vou estudar).
Saída: chateado
*/

import java.util.Scanner;

public class Emoticon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String mensagem = "";
        int divertido, chateado;

        while (true) {
            divertido = 0;
            chateado = 0;
            mensagem = scan.nextLine();

            //O programa se encerra quando recebe uma entrada vazia.
            if (mensagem.equals("")) {
                scan.close();
                break;
            }

            for (int i = 0; i < mensagem.length(); i++) {
                if ((mensagem.charAt(i) == ':') && (mensagem.charAt(i + 1) == '-')) {
                    if (mensagem.charAt(i + 2) == ')')
                        divertido++;
                    else if (mensagem.charAt(i + 2) == '(')
                        chateado++;
                }
            }

            if (divertido > chateado)
                System.out.println("divertido");
            else if (chateado > divertido)
                System.out.println("chateado");
            else
                System.out.println("neutro");

        }
    }
}
