/*
    Crie uma entidade produto, com os seguintes atributos:
    • id
    • nome
    • descrição
    • quantidade
    • preço
    Sua aplicação deve oferecer no método main 3 opções no console usando a classe
    Scanner:
    A primeira opção deve cadastrar produtos e ao selecionar ela deve cadastrar
    automaticamente 3 produtos na base.
    A segunda opção deve atualizar o primeiro produto cadastrado na opção 1.
    A terceira opção deve excluir o segundo produto cadastrado.
    Obs.: Tudo deve ser feito de forma automática apenas selecionando as opções ao
    selecionar uma ação, deve ser mantida as opções apenas sinalizando no console que
    ação foi realizada. Para finalizar a aplicação deve ser selecionado a opção 0.
    */

import java.util.Scanner;

public class Principal {
    
    //Metodo que imprime o menu do sistema.
    public static void exibeMenu() {
        System.out.printf("\n\tMenu da Aplicacao\n\n");
        System.out.println("1 - Cadastrar Produtos");
        System.out.println("2 - Atualizar Produto");
        System.out.println("3 - Excluir Produto");
        System.out.println("0 - Sair");
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        //Variavel de escolha entre as opcoes do menu.
        int menu = 1;
        while (menu != 0) {
            String menuString;
            exibeMenu();
            menuString = scan.nextLine();
            menu = MudaTipoDado.mudaParaInt(menuString);
            switch(menu){
                case 1: 
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Até mais!");
            }
        }
        scan.close();
    }

}
