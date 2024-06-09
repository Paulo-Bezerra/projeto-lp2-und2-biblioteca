package servico;

import dto.EstudanteDTO;

import java.util.List;

public interface IOperacoesEstudante {
    boolean adicionarEstudante(EstudanteDTO estudanteDTO);
    List<EstudanteDTO> listarEstudantes();
}
