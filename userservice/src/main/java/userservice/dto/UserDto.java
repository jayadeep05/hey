package userservice.dto;

public class UserDto {
	
	private Long employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	private String email;
	private Long departmentId;
	
	
	public Long getEmployeeId() {
		// TODO Auto-generated method stub
		return employeeId;
	}
	
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
		
	}
	public String getEmployeeFirstName() {
		// TODO Auto-generated method stub
		return employeeFirstName;
		
	}
	public String getEmployeeLastName() {
		// TODO Auto-generated method stub
		return employeeLastName;
		
	}
	
	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	
	public void setEmployeeId(Long employeeId) {
		// TODO Auto-generated method stub
		this.employeeId = employeeId;
		
		
	}
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;

		
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		// TODO Auto-generated method stub
		this.employeeFirstName = employeeFirstName;

		
	}
	public void setEmployeeLastName(String employeeLastName) {
		// TODO Auto-generated method stub
		this.employeeLastName = employeeLastName;
		
	}

	

	
}
