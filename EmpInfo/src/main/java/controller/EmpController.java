package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bean.EmpBn;
import services.EmpServiceImpl;

@Controller("econtroller")
@RequestMapping("/emp")
public class EmpController {
	static {
		System.out.println("Emp-Controller loaded");
	}

	@Autowired
	EmpServiceImpl serviceImpl;
	
	public EmpController() {
		super();
	}

	@RequestMapping(value = "/login")
	public ModelAndView showWelcomePage() {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("empbean", new EmpBn());
		List<EmpBn> listOfEmps = serviceImpl.getEmps();
		model.put("emplist", listOfEmps);
		return new ModelAndView("empInfo", model);
	}

	private static String UPLOAD_LOCATION = "D:\\mytemp\\";

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveWelcomePage(@ModelAttribute("empbean") EmpBn bean) {
		System.out.println("Save method called" + bean);
		String msg = "";
		try {
			FileCopyUtils.copy(bean.getFile().getBytes(), new File(UPLOAD_LOCATION + bean.getFile().getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (bean.getEmpId() == 0) {
			msg = serviceImpl.addEmp(bean);
		} else {
			EmpBn beans = serviceImpl.updateEmp(bean);
			if (beans == null) {
				msg = "Problem in update";
			} else {
				msg = "Employee added sucessfully!!!";
			}
		}

		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("empbean", new EmpBn());
		model.put("msg", msg);
		List<EmpBn> listOfEmps = serviceImpl.getEmps();
		model.put("emplist", listOfEmps);
		System.out.println("Inside Controller & Model of save: " + model);
		return new ModelAndView("empInfo", model);
	}

	@RequestMapping(value = "/save/edit/{eid}", method = RequestMethod.GET)
	public ModelAndView getDataFromEdit(@PathVariable("eid") int empId) {
		System.out.println("Inside Edit operation:" + empId);
		HashMap<String, Object> model = new HashMap<String, Object>();
		List<EmpBn> listOfEmps = serviceImpl.getEmps();
		model.put("empbean", serviceImpl.getEmp(empId));
		model.put("emplist", listOfEmps);
		System.out.println("Inside Controller & Model of Edit: " + model);
		return new ModelAndView("empInfo", model);
	}

	@RequestMapping(value = "/save/delete/{eid}", method = RequestMethod.GET)
	public ModelAndView deleteData(@PathVariable("eid") int empId) {
		System.out.println("Inside Delete operation");
		List<EmpBn> listOfEmps = serviceImpl.getEmps();
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("msg", serviceImpl.deleteEmp(empId));
		model.put("emplist", listOfEmps);
		return new ModelAndView("empInfo", model);
	}

	public EmpServiceImpl getServiceImpl() {
		return serviceImpl;
	}

	public void setServiceImpl(EmpServiceImpl serviceImpl) {
		this.serviceImpl = serviceImpl;
	}

}