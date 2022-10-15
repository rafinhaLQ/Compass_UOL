public class Funcionario {
    String nome;
    double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Este método recebe a porcentagem como argumento para acrescentar ao salário.
    public double acrescentaEmPorcentagem(double porcentagem) {
        double salarioAntigo = this.salario;
        double bonus;
        porcentagem = 1 + porcentagem / 100;
        this.salario *= porcentagem;
        bonus = this.salario - salarioAntigo;
        return bonus;
    }

    // Este método recebe a porcentagem como argumento para descontar do salário.
    public double descontaEmPorcentagem(double porcentagem) {
        double salarioAntigo = this.salario;
        double desconto;
        porcentagem = 1 - porcentagem / 100;
        this.salario *= porcentagem;
        desconto = salarioAntigo - this.salario;
        return desconto;
    }

}
