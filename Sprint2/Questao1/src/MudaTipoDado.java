//Classe para mudar tipos de dados.
public class MudaTipoDado {

    public static int mudaParaInt(String string) {
        int inteiro;

        try{
            inteiro = Integer.parseInt(string);
        } catch(NumberFormatException e){
            System.out.println("Esse valor nao eh valido!");
            //Loop ate receber valor valido.
            inteiro = 4;
        }
        return inteiro;
    }

}
