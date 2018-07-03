package ejecutador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import proyecto.Departamento;
import proyecto.Empleado;

public class JpaTest {
	
	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.crearEmpleados();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listarEmpleados();

		System.out.println(".. done");
	}

	private void crearEmpleados() {
		int nroDeEmpleados = manager.createQuery("Select a From Empleado a", Empleado.class).getResultList().size();
		if (nroDeEmpleados == 0) {
			Departamento departamento = new Departamento();
			manager.persist(departamento);
			manager.persist(new Empleado());
		}
	}

	private void listarEmpleados() {
		List<Empleado> resultList = manager.createQuery("Select a From Empleado a", Empleado.class).getResultList();
		System.out.println("nro de empleados:" + resultList.size());
		for (Empleado next : resultList) {
			System.out.println("siguiente empleado: " + next);
		}
	}
}

