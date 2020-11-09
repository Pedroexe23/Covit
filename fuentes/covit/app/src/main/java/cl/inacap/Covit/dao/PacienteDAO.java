package cl.inacap.Covit.dao;

import java.util.List;

import cl.inacap.Covit.dto.Paciente;

public interface PacienteDAO {
    List<Paciente> getAll();
    Paciente Save(Paciente p);
}
