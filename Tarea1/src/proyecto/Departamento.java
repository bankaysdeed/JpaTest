package proyecto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento {

	@Id
	@GeneratedValue
	private Long id;

	private String nombre;
	
	@OneToMany(mappedBy="departamento",cascade=CascadeType.PERSIST)
	private List<Empleado> empleados = new ArrayList<Empleado>();
}
