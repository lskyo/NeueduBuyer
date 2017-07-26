package com.neuedu.model;
/**
 * @author 刘志杰
 *
 */

public class Employee {
	
	private String employeeId;		//员工编号	
	private String employeeAccount; //员工账号
	private String password;		//密码
	private String employeeName;	//员工姓名
	private String employeeMobile;	//员工手机号
	private int departmentId;		//员工部门编号

	
	public Employee() {
		super();
	}
	
	public Employee(String employeeId, String employeeAccount, String password, String employeeName,
			String employeeMobile, int departmentId) {
		super();
		this.employeeId = employeeId;
		this.employeeAccount = employeeAccount;
		this.password = password;
		this.employeeName = employeeName;
		this.employeeMobile = employeeMobile;
		this.departmentId = departmentId;
	}



	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeAccount=" + employeeAccount + ", password=" + password
				+ ", employeeName=" + employeeName + ", employeeMobile=" + employeeMobile + ", departmentId="
				+ departmentId + "]";
	}

	public String getEmployeeId() {
		return employeeId;
	}
	
	
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeAccount() {
		return employeeAccount;
	}
	public void setEmployeeAccount(String employeeAccount) {
		this.employeeAccount = employeeAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeMobile() {
		return employeeMobile;
	}
	public void setEmployeeMobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

}
