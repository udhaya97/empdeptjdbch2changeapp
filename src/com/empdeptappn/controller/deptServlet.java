package com.empdeptappn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empdeptappn.dao.DeptEmpDao;
import com.empdeptappn.dao.DeptEmpDaoImpl;
import com.empdeptappn.model.Department;
import com.empdeptappn.model.Employee;
import com.empdeptappn.service.DeptEmpServImpl;
import com.empdeptappn.service.DeptEmpService;

@WebServlet("/home")
public class deptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public deptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptEmpService ded = new DeptEmpServImpl();
		List<Department> ldept = ded.readAllDeptServ();
		int deptId =ldept.get(0).getDeptId();
		List<Employee> empl = ded.readEmpFromDeptServ(deptId);
		Department dep = ded.showDeptServ(deptId);
		int i=0;
		response.sendRedirect("listEmp?deptId="+deptId);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
