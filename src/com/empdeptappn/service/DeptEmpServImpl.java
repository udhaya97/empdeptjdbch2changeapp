package com.empdeptappn.service;

import java.util.List;

import com.empdeptappn.dao.DeptEmpDao;
import com.empdeptappn.dao.DeptEmpDaoImpl;
import com.empdeptappn.model.Department;
import com.empdeptappn.model.Employee;



public class DeptEmpServImpl implements DeptEmpService {

	DeptEmpDao dempServ = new DeptEmpDaoImpl();
	@Override
	public boolean createDeptServ(Department dept) {
		
		dempServ.createDept(dept);
		return false;
	}

	@Override
	public boolean updateDeptServ(Department dept) {

          dempServ.updateDept(dept);
		return false;
	}

	@Override
	public List<Department> readAllDeptServ() {
		List<Department> lisDept = dempServ.readAllDept();
		return lisDept;
	}

	@Override
	public boolean delteDeptServ(int deptId) {
	dempServ.delteDept(deptId);
		return false;
	}

	@Override
	public boolean createEmpServ(Employee employee) {
		dempServ.createEmp(employee);
		return false;
	}

	@Override
	public boolean updateEmpServ(Employee employee) {
		dempServ.updateEmp(employee);
		return false;
	}

	@Override
	public List<Employee> readEmpFromDeptServ(int empId) {
		List<Employee> lisEmp = dempServ.readEmpFromDept(empId);
		return lisEmp;
	}

	@Override
	public boolean deleteEmpFromDeptServ(int deptId, int empId) {
		dempServ.deleteEmpFromDept(deptId, empId);
		return false;
	}

	@Override
	public Employee readEmployeeServ(int empId) {
		Employee emp = dempServ.readEmployee(empId);
		return emp;
	}

	@Override
	public Department showDeptServ(int id) {
		Department demp = dempServ.showDept(id);
		return demp;
	}

}
