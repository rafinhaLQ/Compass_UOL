import java.util.List;
import java.util.Scanner;

public class InterfaceMenuFilmes {
    public static void exibeMenuFiltrar() {

        Scanner scan = new Scanner(System.in);
        FilmeController filmeController = new FilmeController();
        int pagina=0, quantidadeFilmes;

        do {
            String paginaEmString, quantidadeFilmesEmString;

            System.out.printf("\n\tFILMES DE QUALIDADE\n");
            exibePaginas(filmeController, 1, 10);
            System.out.printf("Pagina 1 de 2\n\n\n");

            exibePaginas(filmeController, 2, 10);
            System.out.printf("Pagina 2 de 2\n\n\n");

            System.out.println("Informe a pagina que voce quer filtrar (Informe 0(zero) para sair): ");
            paginaEmString = scan.nextLine();
            pagina = MudaTipoDado.mudaParaInt(paginaEmString);
            if (pagina == 0)
                break;
            System.out.println("Informe a quantidade de filmes que voce quer dessa pagina: ");
            quantidadeFilmesEmString = scan.nextLine();
            quantidadeFilmes = MudaTipoDado.mudaParaInt(quantidadeFilmesEmString);
            System.out.printf("\nFilmes filtrados:\n");
            exibePaginas(filmeController, pagina, quantidadeFilmes);
            System.out.println("Aperte enter para continuar!");
            scan.nextLine(); //Simula pausa
        } while (pagina != 0);
        System.out.println("Saindo...");
    }

    public static void exibePaginas(FilmeController filmeController, int pagina, int quantidadeFilmes) {
        List<Filme> filmes;

        filmes = filmeController.listarComFiltro(pagina, quantidadeFilmes);
        for (Filme filmeProvisorioParaImprimir : filmes) {
            System.out.printf("%s\n\n", filmeProvisorioParaImprimir);
        }
    }
}
