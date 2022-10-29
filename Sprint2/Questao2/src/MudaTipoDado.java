public class MudaTipoDado {

    public static int mudaParaInt(String string) {
        int inteiro;

        try{
            inteiro = Integer.parseInt(string);
        } catch(NumberFormatException e){
            System.out.println("Esse valor nao eh valido!");
            inteiro = 3;
        }
        return inteiro;
    }

}