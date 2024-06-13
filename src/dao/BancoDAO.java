package dao;

import repositorio.EmprestimoRepositorio;
import repositorio.LivroRepositorio;
import repositorio.UsuarioRepositorio;

import java.io.*;


public class BancoDAO {
  private LivroRepositorio LR;
  private UsuarioRepositorio UR;
  private EmprestimoRepositorio ER;
  private final String caminhoArquivoUR = "arquivo_ur.bin";
  private final String caminhoArquivoLR = "arquivo_lr.bin";
  private final String caminhaArquivoER = "arquivo_er.bin";

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
    try (FileOutputStream arquivoUR = new FileOutputStream("arquivo_ur.bin");
         ObjectOutputStream saidaUR = new ObjectOutputStream(arquivoUR);
         FileOutputStream arquivoLR = new FileOutputStream("arquivo_lr.bin");
         ObjectOutputStream saidaLR = new ObjectOutputStream(arquivoLR);
         FileOutputStream arquivoER = new FileOutputStream("arquivo_er.bin");
         ObjectOutputStream saidaER = new ObjectOutputStream(arquivoER)
    ) {
      saidaUR.writeObject(UR);
      saidaUR.close();

      saidaLR.writeObject(LR);
      saidaLR.close();

      saidaER.writeObject(ER);
      saidaER.close();
      return true;
    } catch (Exception e) {
      System.out.println("Houve um erro salvar os dados.");
      System.out.println(e.getMessage());
      return false;
    }
  }

  public boolean carregarDados() {
    try (FileInputStream arquivoUR = new FileInputStream("arquivo_ur.bin");
         ObjectInputStream entradaUR = new ObjectInputStream(arquivoUR);
         FileInputStream arquivoLR = new FileInputStream("arquivo_lr.bin");
         ObjectInputStream entradaLR = new ObjectInputStream(arquivoLR);
         FileInputStream arquivoER = new FileInputStream("arquivo_er.bin");
         ObjectInputStream entradaER = new ObjectInputStream(arquivoER)
    ) {
      this.UR = new UsuarioRepositorio((UsuarioRepositorio) entradaUR.readObject());
      entradaUR.close();

      this.LR = new LivroRepositorio((LivroRepositorio) entradaLR.readObject());
      entradaLR.close();

      this.ER = new EmprestimoRepositorio((EmprestimoRepositorio) entradaER.readObject());
      entradaER.close();

      return true;
    } catch (FileNotFoundException e) {
      System.out.println("Erro ao carregar um dos arquivos de dados.\n" +
          "(Ignore caso for o primeiro uso).");
      return false;
    } catch (ClassNotFoundException e) {
      System.out.println("Houve um erro ao copiar os dados dos arquivos para as classes.");
      System.out.println(e.getMessage());
      return false;
    } catch (IOException e) {
      System.out.println("Houve um erro carregar os arquivos de dados.");
      System.out.println(e.getMessage());
      return false;
    }
  }
}
