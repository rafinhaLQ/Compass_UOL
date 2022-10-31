public class MudaTipoDado {

    public static int mudaParaInt(String string) {
        int inteiro;

        try {
            inteiro = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            inteiro = 11;
        }
        return inteiro;
    }

}