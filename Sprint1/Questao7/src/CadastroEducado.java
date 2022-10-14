
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
    

import java.util.Scanner;
import java.time.LocalTime;

public class CadastroEducado {
    
    static Scanner scan = new Scanner(System.in); 

    static int imprimeMenu() {
        
        int opcaoMenu;

        System.out.printf("\n\n\tMENU\n\n");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Logar");
        System.out.println("3 - Sair");
        opcaoMenu = scan.nextInt();
        return opcaoMenu;

    }

    static Usuario cadastraUsuario() {

        Usuario usuarioCriado = new Usuario();
        String usuarioCadastrando, senhaCadastrando;
        System.out.print("Informe o nome de usuario que voce deseja usar: ");
        scan.nextLine();
        usuarioCadastrando = scan.nextLine();
        System.out.print("Informe a senha que voce deseja usar: ");
        senhaCadastrando = scan.nextLine();
        usuarioCriado.cadastra(usuarioCadastrando, senhaCadastrando);
        return usuarioCriado;

    }

    static void logaUsuario(Usuario usuario) {
        String usuarioLogando, senhaLogando;
        System.out.print("Usuário: ");
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

    static void exibeMensagemEducada() {

        LocalTime agora = LocalTime.now();
        System.out.printf("\n\n\nBem Vindo ao Sistema Educado!\n\n");

        if (agora.getHour() >=6 && agora.getHour() < 12)
            System.out.println("Bom dia, voce se logou ao nosso sistema.");
        else if (agora.getHour() >=12 && agora.getHour() < 18)
            System.out.println("Boa tarde, voce se logou ao nosso sistema.");
        else if (agora.getHour() >=18 && agora.getHour() < 24)
            System.out.println("Boa noite, voce se logou ao nosso sistema.");
        else
            System.out.println("Boa madrugada, voce se logou ao nosso sistema.");

        System.out.printf("\n\nAperte enter para deslogar!");
        String pausa = scan.nextLine();

    }

    public static void main(String[] args) {
        
        Usuario usuario = new Usuario();

        while(true) {

            switch(imprimeMenu()) {
                
                case 1: usuario = cadastraUsuario();
                break;

                case 2: logaUsuario(usuario);
                break;

                case 3: System.exit(0);
            }
        }
    }
}
