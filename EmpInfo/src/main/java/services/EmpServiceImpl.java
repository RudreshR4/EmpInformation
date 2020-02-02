package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.EmpBn;
import dao.EmpDaoImpl;
import entities.EmpEn;
@Service
public class EmpServiceImpl implements EmpService{
static {
	System.out.println("EmpServiceImpl is loaded!!");
}
@Autowired(required = true)
EmpDaoImpl daoimpl;

	@Override
	public String addEmp(EmpBn bean) {
		EmpEn entity = beanToEntity(bean);
		return daoimpl.insertEmp(entity);
	}

	private EmpEn beanToEntity(EmpBn bean) {
		return new EmpEn(bean.getEmpId(), bean.getEmpName(), bean.getEmpSalary(), bean.getEmpAge(), bean.getEmpCity());
	}

	@Override
	public List<EmpBn> getEmps() {
		return entitesToBean(daoimpl.fetchEmps());
	}

	private List<EmpBn> entitesToBean(List<EmpEn> fetchEmps) {
		List<EmpBn> beans = new ArrayList<EmpBn>();
		for(EmpEn empEn : fetchEmps) {
			beans.add(entityToBean(empEn));
		}
		return beans;
	}

	private EmpBn entityToBean(EmpEn empEn) {
		return new EmpBn(empEn.getEmpId(),empEn.getEmpName(),empEn.getEmpSalary(),empEn.getEmpAge(),empEn.getEmpCity(),"");
	}

	@Override
	public EmpBn getEmp(int empId) {
		return entityToBean(daoimpl.fetchEmp(empId));
	}

	@Override
	public EmpBn updateEmp(EmpBn bean) {
		return entityToBean(daoimpl.modifyEmp(beanToEntity(bean)));
	}

	@Override
	public String deleteEmp(int empId) {
	    return daoimpl.deleteEmp(empId);
	}

	public EmpDaoImpl getDaoimpl() {
		return daoimpl;
	}

	public void setDaoimpl(EmpDaoImpl daoimpl) {
		this.daoimpl = daoimpl;
	}

	public EmpServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


}
