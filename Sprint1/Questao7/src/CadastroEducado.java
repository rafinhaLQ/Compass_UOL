
/* Escreva um programa em Java que tem como objetivo validar se um
usuário e senha existem no sistema. Se o usuário e senha tiver corretos, o
usuário deverá receber uma mensagem de acordo com o horário. (Utilizem
arrays para armazenar os dados)
• Se for das 6h às 11h59 da manhã, receberá “Bom dia, você se
logou ao nosso sistema.”
• Se for das 12 às 17h59 da tarde, receberá “Boa tarde, você se
logou ao nosso sistema.”
• Se for das 18h às 23h59 da noite, receberá “Boa noite, você se
logou ao nosso sistema.”
• Se for das 0h às 05h59 da madrugada, receberá “Boa madrugada,
você se logou ao nosso sistema.”
• Se o usuário ou senha for inválidos, deverá exibir a mensagem:
“Usuário e/ou senha incorretos.” */

//Classe para leitura de dados fornecidos pelo usuário.
import java.util.Scanner;
//Classe para leitura de hora do computador.
import java.time.LocalTime;

public class CadastroEducado {

    // boolean para indicar se tem algum usuário registrado no sistema.
    static boolean verifica = false;
    // Declaração do Scanner global.
    static Scanner scan = new Scanner(System.in);

    // Método para imprimir menu do sistema.
    static int imprimeMenu() {

        int opcaoMenu;
        System.out.printf("\n\n\tMENU\n\n");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Logar");
        System.out.println("3 - Sair");
        opcaoMenu = scan.nextInt();
        return opcaoMenu;

    }

    // Método para cadastro do usuário.
    static Usuario cadastraUsuario() {

        Usuario usuarioCriado = new Usuario();
        String usuarioCadastrando, senhaCadastrando;
        System.out.print("Informe o nome de usuario que voce deseja usar: ");
        // Essa chamada do scan é para limpar o buffer do teclado.
        scan.nextLine();
        usuarioCadastrando = scan.nextLine();
        System.out.print("Informe a senha que voce deseja usar: ");
        senhaCadastrando = scan.nextLine();
        usuarioCriado.cadastra(usuarioCadastrando, senhaCadastrando);
        // Indica que já tem ao menos um usuário no sistema.
        verifica = true;
        return usuarioCriado;

    }

    // Método para tentativa de logar usuário
    static void logaUsuario(Usuario usuario) {

        String usuarioLogando, senhaLogando;
        System.out.print("Usuario: ");
        // Essa chamada do scan é para limpar o buffer do teclado.
        scan.nextLine();
        usuarioLogando = scan.nextLine();
        System.out.print("Senha: ");
        senhaLogando = scan.nextLine();
        if (usuario.getUsuario().equals(usuarioLogando) && usuario.getSenha().equals(senhaLogando)) {
            exibeMensagemEducada();
        } else {
            System.out.printf("\n\nUsuario e/ou senha incorretos.\n");
        }

    }

    // Método que exibe a mensagem ao usuário.
    static void exibeMensagemEducada() {

        LocalTime agora = LocalTime.now();
        System.out.printf("\n\n\nBem Vindo ao Sistema Educado!\n\n");

        if (agora.getHour() >= 6 && agora.getHour() < 12)
            System.out.println("Bom dia, voce se logou ao nosso sistema.");
        else if (agora.getHour() >= 12 && agora.getHour() < 18)
            System.out.println("Boa tarde, voce se logou ao nosso sistema.");
        else if (agora.getHour() >= 18 && agora.getHour() < 24)
            System.out.println("Boa noite, voce se logou ao nosso sistema.");
        else
            System.out.println("Boa madrugada, voce se logou ao nosso sistema.");

        System.out.printf("\n\nAperte enter para deslogar!");
        // Scan para simular uma pausa.
        String pausa = scan.nextLine();

    }

    public static void main(String[] args) {

        Usuario usuario = new Usuario();

        while (true) {

            switch (imprimeMenu()) {

                case 1:
                    usuario = cadastraUsuario();
                    break;

                case 2:
                    if (verifica)
                        logaUsuario(usuario);
                    else
                        System.out.println("Nenhum usuário registrado no sistema! Se cadastre!");
                    break;

                case 3:
                    System.exit(0);
            }
        }
    }
}