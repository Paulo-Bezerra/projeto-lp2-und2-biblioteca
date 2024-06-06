package repositorio;

import modelo.Estudante;

import java.util.HashSet;

public class EstudanteRepositorio {
    private HashSet<Estudante> ER;

    public EstudanteRepositorio() {
        ER = new HashSet<>();
    }

    public boolean adicionarEstudante(Estudante estudante) {
        return ER.add(estudante);
    }

    public boolean removerEstudante(Estudante estudante) {
        return ER.remove(estudante);
    }

    public HashSet<Estudante> getEstudantes() {
        return new HashSet<Estudante>(ER);
    }
}
