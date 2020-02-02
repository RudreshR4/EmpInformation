package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entities.EmpEn;

@Repository
public class EmpDaoImpl implements EmpDao{
	static {
		System.out.println("EmpDaoImpl loaded");
	}
@Autowired	
SessionFactory sfactory;
public SessionFactory getSfactory() {
	return sfactory;
}

public void setSfactory(SessionFactory sfactory) {
	this.sfactory = sfactory;
}

public EmpDaoImpl() {
super();
}

	@Override
	public String insertEmp(EmpEn entity) {
		System.out.println("Inside InsertEmp");
		Session session =null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			session.save(entity);
			return "Emp saved successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Problem in save Emp";
		}finally {
			closeResources(session,tr);
		}
		//return null;
	}

	private void closeResources(Session session, Transaction tr) {
		if(session!=null) {
			if(tr!=null){
				session.flush();
				tr.commit();
			}
			session.close();
		}	
	}

	@Override
	public List<EmpEn> fetchEmps() {
	return sfactory.openSession().createCriteria(EmpEn.class).list();
	}

	@Override
	public EmpEn fetchEmp(int empId) {
		return sfactory.openSession().get(EmpEn.class,empId);
	}

	@Override
	public EmpEn modifyEmp(EmpEn empen) {
	Session	session =null;
	Transaction tr = null;
	try {
		System.out.println("Inside modify Emp");
		session=sfactory.openSession();
		tr=session.beginTransaction();
		return (EmpEn)session.merge(empen);
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}finally {
		closeResources(session, tr);
	}		
}

	@Override
	public String deleteEmp(int empId) {
		Session	session =null;
		Transaction tr = null;
		try {
			System.out.println("Inside Delete Emp");
			session = sfactory.openSession();
			tr = session.beginTransaction();
			session.delete(fetchEmp(empId));
		 return "Emp Deleted successfully";  
		} catch (Exception e) {
			return"Problem in Delete";
		}finally {
			closeResources(session, tr);
		}
		//return null;
	}

}
