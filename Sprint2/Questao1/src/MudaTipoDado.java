import java.util.Scanner;

//Classe para mudar tipos de dados.
public class MudaTipoDado {

    public static int mudaParaInt(String string) {
        Scanner scan = new Scanner(System.in);
        int inteiro;
        //Try Catch para caso o tipo de dado nao seja valido.
        try{
            inteiro = Integer.parseInt(string);
        } catch(NumberFormatException e){
            System.out.println("Esse valor nao eh valido!");
            System.out.println("Entre com um valor valido (inteiro): ");
            string = scan.nextLine();
            //Loop ate receber valor valido.
            inteiro = mudaParaInt(string);
        }
        scan.close();
        return inteiro;
    }

}
