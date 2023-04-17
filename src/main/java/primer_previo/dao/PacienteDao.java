package primer_previo.dao;

import primer_previo.entities.Paciente;
import primer_previo.utils.Conexion;
import primer_previo.utils.GenericDao;

public class PacienteDao extends Conexion<Paciente> implements GenericDao<Paciente>{
	public PacienteDao() {
		super(Paciente.class);
	}
}
