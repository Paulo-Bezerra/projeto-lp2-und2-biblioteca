package servico;

import dto.EstudanteDTO;

import java.util.List;

public interface IOperacoesEstudante {
    boolean adicionarEstudante(String matricula);

    boolean removerEstudante(String matricula);

    List<EstudanteDTO> listarEstudantes();
}
