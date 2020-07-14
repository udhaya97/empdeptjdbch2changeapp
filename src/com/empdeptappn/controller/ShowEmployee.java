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
import com.empdeptappn.model.Employee;
import com.empdeptappn.service.DeptEmpServImpl;
import com.empdeptappn.service.DeptEmpService;

/**
 * Servlet implementation class ShowEmployee
 */
@WebServlet("/showemployee")
public class ShowEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("employee id for showing is :"+ request.getParameter("empId"));
		System.out.println("dept id for showing is :"+ request.getParameter("deptId"));
		
		int empId =Integer.parseInt(request.getParameter("empId"));
		
		DeptEmpService ded = new DeptEmpServImpl();
		Employee emp = (Employee) ded.readEmployeeServ(empId);
		System.out.println("Employee based on id"+emp.getEmpId()+" "+emp.getEmpName());
		HttpSession ses = request.getSession();
		ses.setAttribute("empl", emp);
		request.setAttribute("mainemp", "checktable");
		request.setAttribute("emp", emp);
		request.setAttribute("addlin", "anemp");
		
		request.setAttribute("lis", ses.getAttribute("lisvaldept"));
		request.setAttribute("val", ses.getAttribute("emplvaldept"));
		
			RequestDispatcher rd = request.getRequestDispatcher("home3.jsp");
			rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
