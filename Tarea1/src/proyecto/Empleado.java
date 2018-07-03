package proyecto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Empleado {
	@Id
	@GeneratedValue
	private Long id;

	private String nombre;
	
	@ManyToOne
	private Departamento departamento;
}

