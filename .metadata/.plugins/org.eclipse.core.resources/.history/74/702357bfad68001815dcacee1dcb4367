package demo.app;

import org.hibernate.Session;

public class Sample {

	public static void main(String[] args)
	{
		Session ss=HibernateUtilities.getSessionFactory().openSession();
		ss.beginTransaction();
		
		Employee e1=new Employee();
		e1.setId(1001);
		e1.setName("nagendra");
		e1.setDesignation("software Engineer");
		ss.save(e1);
		ss.getTransaction().commit();
		ss.close();
		HibernateUtilities.getSessionFactory().close();
		
	}

}
