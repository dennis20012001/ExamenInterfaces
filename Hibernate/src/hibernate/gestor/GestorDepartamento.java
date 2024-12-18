package hibernate.gestor;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernate.util.HibernateUtil;
import primero.Departamentos;


public class GestorDepartamento {
	
	public List<Departamentos> getDepartContabilidadOrInvestigacion() {
	    List<Departamentos> ret = null;
	    String hql2 = "from Empleados as e where e.oficio=:oficio and e.departamentos.deptNo = :depNO )";
	    Session session = null;
	    Query q = session.createQuery(hql2);
	    Transaction transaction = null;
	    q.setParameter("oficio", (String) "DIRECTOR");
	    q.setParameter("depNO", (byte) 10);

	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        transaction = session.beginTransaction();

	        Query query = session.createQuery(hql2);
	        ret = query.list();  

	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        System.out.println("Error: " + e.getMessage());
	    } finally {
	        if (session != null) {
	            session.close();  
	        }
	    }

	    return ret;
	}
}
