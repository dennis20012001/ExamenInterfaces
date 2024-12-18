package hibernate.gestor;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.util.HibernateUtil;
import primero.Empleados;

public class GestorEmpleados {
	public List<Empleados> getAll() {
	    List<Empleados> ret = null;
	    String hql = "FROM Empleados where dept_no = '10' ";
	    Session session = null;
	    Transaction transaction = null;

	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        
	        transaction = session.beginTransaction();

	        Query query = session.createQuery(hql);
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
	    public List<Empleados> getEmpleadoWithMaxSalary() {
		    List<Empleados> ret = null;
		    String hql = "from Empleados e where e.salario = (select max(emp.salario) from Empleados emp)"
		    		;
		    Session session = null;
		    Transaction transaction = null;

		    try {
		        session = HibernateUtil.getSessionFactory().openSession();
		        
		        transaction = session.beginTransaction();

		        Query query = session.createQuery(hql);
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
