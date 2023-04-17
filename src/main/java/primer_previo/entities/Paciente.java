package primer_previo.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@NamedQuery(name = "Paciente.findAll" , query = "SELECT p FROM Paciente p")
public class Paciente {
	
	@Id
	@SequenceGenerator(name="paciente_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="paciente_id_seq")
	private int id;
	
	private String documento;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private String genero;
	
	private LocalDate fechanacimiento;
	
	private String telefono;
	
	private String direccion;
	
	private float peso;
	
	private float estatura;
	
	@Transient
	private String imc;

	public Paciente(String documento, String nombre, String apellido, String email, String genero,
			LocalDate fechanacimiento, String telefono, String direccion, float peso, float estatura) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.genero = genero;
		this.fechanacimiento = fechanacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.peso = peso;
		this.estatura = estatura;
	}
	
	
}
