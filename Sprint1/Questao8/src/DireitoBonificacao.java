
    /* Escreva um programa Java que tem como objetivo validar se um
    determinado funcionário tem direito a bonificação. O programa precisa
    receber a quantidade de funcionários que serão cadastrados e após isso, o
    programa deve armazenar o nome e o salário de cada funcionário. Se o
    usuário receber até R$ 1000,00 reais, receberá 20% de bonificação. Se
    receber acima de 1000 e menos que 2000, recebe 10%. Se for acima de
    2000, em vez de bonificação, o funcionário terá um desconto de 10%. No
    fim do programa, deverá ter uma saída com os nomes dos funcionários,
    salário, bônus ou desconto e salário líquido. (Utilizem arrays para
    armazenar os dados). */
    
import java.util.Scanner;
    
public class DireitoBonificacao {
    
    static Scanner scan = new Scanner(System.in);

    static Funcionario cadastraFuncionarios() {

        scan.nextLine();
        System.out.printf("\n\nInforme o nome do funcionário: ");
        String nome = scan.nextLine();
        
        System.out.print("Informe o salário do funcionário: ");
        double salario = scan.nextDouble();

        Funcionario cadastra = new Funcionario(nome, salario);
        return cadastra;
        
    }
    
    public static void main(String[] args) {
        
        int quantiaFuncionarios;

        System.out.print("Informe a quantia de funcionarios que serao cadastrados: ");
        quantiaFuncionarios = scan.nextInt();

        Funcionario[] listaFuncionarios = new Funcionario[quantiaFuncionarios];

        for(int cont = 0; cont < quantiaFuncionarios; cont++)
            listaFuncionarios[cont] = cadastraFuncionarios();

        System.out.printf("\n\nInformacoes dos funcionarios:\n");
        for(int cont = 0; cont < quantiaFuncionarios; cont++) {
            System.out.println("Funcionario " + listaFuncionarios[cont].getNome());
            System.out.printf("\tSalario: %.2f\n", listaFuncionarios[cont].getSalario());
            if(listaFuncionarios[cont].getSalario() <= 1000) {

                System.out.printf("\tBonus: %.2f\n\tSalario Liquido: %.2f\n\n",
                listaFuncionarios[cont].acrescentaEmPorcentagem(20), listaFuncionarios[cont].getSalario());

            } else if(listaFuncionarios[cont].getSalario() < 2000) {
                
                System.out.printf("\tBonus: %.2f\n\tSalario Liquido: %.2f\n\n",
                listaFuncionarios[cont].acrescentaEmPorcentagem(10), listaFuncionarios[cont].getSalario());
                
            } else {
                
                System.out.printf("\tDesconto: %.2f\n\tSalario Liquido: %.2f\n\n",
                listaFuncionarios[cont].descontaEmPorcentagem(10), listaFuncionarios[cont].getSalario());

            }

        }
    }
}
