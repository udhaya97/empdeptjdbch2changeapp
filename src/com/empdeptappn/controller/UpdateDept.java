package com.empdeptappn.controller;

import java.io.IOException;

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
import com.empdeptappn.service.DeptEmpServImpl;
import com.empdeptappn.service.DeptEmpService;

/**
 * Servlet implementation class UpdateDept
 */
@WebServlet("/updatedept")
public class UpdateDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("deptName");
		String loc = request.getParameter("deptLoc");
		//int dId=Integer.parseInt(request.getParameter("deptId"));
		HttpSession ses = request.getSession();
		int deptId =(int) ses.getAttribute("sdt");
		System.out.println("updating values "+ "id "+deptId+"name"+name+"loc"+loc);
		
		Department dpt = new Department(deptId,name,loc);
		
		
		DeptEmpService edf = new DeptEmpServImpl();
		
		edf.updateDeptServ(dpt);
		HttpSession sel = request.getSession();
		sel.setAttribute("EditDept","done");
		
		response.sendRedirect("homeserv");
		
	}

}
