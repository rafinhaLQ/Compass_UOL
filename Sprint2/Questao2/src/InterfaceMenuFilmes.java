import java.util.List;

public class InterfaceMenuFilmes {
    public static void exibeMenuFiltrar() {
        FilmeController filmeController = new FilmeController();

        System.out.printf("\n\tFILMES DE QUALIDADE\n");
        List<Filme> filmes = filmeController.listarComFiltro(1, 10);

        for (Filme filmeProvisorioParaImprimir : filmes) {
            System.out.println(filmeProvisorioParaImprimir);
        }
        System.out.println("Página 1 de 2");

        filmes = filmeController.listarComFiltro(11, 20);

        for (Filme filmeProvisorioParaImprimir : filmes) {
            System.out.println(filmeProvisorioParaImprimir);
        }
        System.out.println("Página 2 de 2");

        
    }
}
