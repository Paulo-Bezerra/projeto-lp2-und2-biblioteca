package visao;

import dto.BibliotecarioDTO;
import dto.EstudanteDTO;
import dto.ProfessorDTO;
import util.Leitura;

public class FormUI {
  public static EstudanteDTO formCadastrarEstudante() {
    String nome, cpf, matricula, dataNascimento, curso;
    System.out.println("Informe os dados do estudante.");
    nome = Leitura.leStr("Informe o nome: ");
    cpf = Leitura.leStr("Informe a CPF: ");
    matricula = Leitura.leStr("Informe a matrícula: ");
    dataNascimento = Leitura.leStr("Informe a data de nascimento (dd/MM/aaaa): ");
    curso = Leitura.leStr("Informe o curso: ");
    return new EstudanteDTO(nome, cpf, matricula, dataNascimento, curso);
  }

  public static ProfessorDTO formCadastrarProfessor() {
    String nome, cpf, matricula, dataNascimento, departamento;
    System.out.println("Informe os dados do professor.");
    nome = Leitura.leStr("Informe o nome: ");
    cpf = Leitura.leStr("Informe a CPF: ");
    matricula = Leitura.leStr("Informe a matrícula: ");
    dataNascimento = Leitura.leStr("Informe a data de nascimento (dd/MM/aaaa): ");
    departamento = Leitura.leStr("Informe o departamento: ");
    return new ProfessorDTO(nome, cpf, matricula, dataNascimento, departamento);
  }

  public static BibliotecarioDTO formCadastrarBibliotecario() {
    String nome, cpf, matricula, dataNascimento, login, senha;
    System.out.println("Informe os dados do bibliotecário.");
    nome = Leitura.leStr("Informe o nome: ");
    cpf = Leitura.leStr("Informe a CPF: ");
    matricula = Leitura.leStr("Informe a matrícula: ");
    dataNascimento = Leitura.leStr("Informe a data de nascimento (dd/MM/aaaa): ");
    login = Leitura.leStr("Informe o login: ");
    senha = Leitura.leStr("Informe a senha: ");
    return new BibliotecarioDTO(nome, cpf, matricula, dataNascimento, login, senha);
  }
}
