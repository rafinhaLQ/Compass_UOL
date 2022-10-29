import java.util.List;

public class InterfaceMenuFilmes {
    public static void exibeMenuFiltrar() {
        int pagina=0, quantidadeFilmes;
        do {
            FilmeController filmeController = new FilmeController();

            System.out.printf("\n\tFILMES DE QUALIDADE\n");
            List<Filme> filmes = filmeController.listarComFiltro(1, 10);

            for (Filme filmeProvisorioParaImprimir : filmes) {
                System.out.printf("%s\n\n", filmeProvisorioParaImprimir);
            }
            System.out.printf("Página 1 de 2\n\n\n");

            filmes = filmeController.listarComFiltro(11, 20);

            for (Filme filmeProvisorioParaImprimir : filmes) {
                System.out.printf("%s\n\n", filmeProvisorioParaImprimir);
            }
            System.out.printf("Página 2 de 2\n\n\n");

            
        } while (pagina != 0);

    }
}
