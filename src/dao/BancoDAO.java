package dao;

import repositorio.EmprestimoRepositorio;
import repositorio.LivroRepositorio;
import repositorio.UsuarioRepositorio;

import java.io.*;
import java.nio.file.Paths;


public class BancoDAO {
  private LivroRepositorio LR;
  private UsuarioRepositorio UR;
  private EmprestimoRepositorio ER;
  private final String arquivoURPath = "arquivo_ur.bin";
  private final String arquivoLRPath = "arquivo_lr.bin";
  private final String arquivoERPath = "arquivo_er.bin";

  private static BancoDAO instance;

  private BancoDAO() {
    LR = new LivroRepositorio();
    UR = new UsuarioRepositorio();
    ER = new EmprestimoRepositorio();
  }

  public static BancoDAO getInstance() {
    if (instance == null) {
      instance = new BancoDAO();
    }
    return instance;
  }

  public LivroRepositorio getLR() {
    return LR;
  }

  public UsuarioRepositorio getUR() {
    return UR;
  }

  public EmprestimoRepositorio getER() {
    return ER;
  }

  public boolean salvarDados() {
    try {
      FileOutputStream arquivo = new FileOutputStream(arquivoURPath);
      ObjectOutputStream saida = new ObjectOutputStream(arquivo);
      saida.writeObject(UR);
      saida.close();

      arquivo = new FileOutputStream(arquivoLRPath);
      saida = new ObjectOutputStream(arquivo);
      saida.writeObject(LR);
      saida.close();

      arquivo = new FileOutputStream(arquivoERPath);
      saida = new ObjectOutputStream(arquivo);
      saida.writeObject(ER);
      saida.close();
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  public boolean carregarDados() {
    try {
      FileInputStream arquivo = new FileInputStream(arquivoURPath);
      ObjectInputStream entrada = new ObjectInputStream(arquivo);
      this.UR = new UsuarioRepositorio((UsuarioRepositorio) entrada.readObject());
      entrada.close();

      arquivo = new FileInputStream(arquivoLRPath);
      entrada = new ObjectInputStream(arquivo);
      this.LR = new LivroRepositorio((LivroRepositorio) entrada.readObject());
      entrada.close();

      arquivo = new FileInputStream(arquivoERPath);
      entrada = new ObjectInputStream(arquivo);
      this.ER = new EmprestimoRepositorio((EmprestimoRepositorio) entrada.readObject());
      entrada.close();

      return true;
    } catch (FileNotFoundException e) {
      System.out.println("Erro ao carregar um dos arquivos de dados.\n" +
          "(Ignore caso for o primeiro uso).");
      return false;
    } catch (ClassNotFoundException e) {
      System.out.println("Houve um erro ao copiar os dados dos arquivos para as classes.");
      return false;
    } catch (IOException e) {
      System.out.println("Houve um erro carregar os arquivos de dados.");
      return false;
    }
  }
}
