package userservice.entity;


import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "users")
@Setter
@Getter

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	 
	
	private String employeeFirstName;
	private String employeeLastName;
	private String email;
	private Long departmentId; 
	 
	public User() {}

	
	public User(String employeeFirstName, String employeeLastName,String email) {
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.email = email;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	} 
	
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	} 
	
	 public String getEmail() { 
		 return email; 
	 }
	    
	 public void setEmail(String email) { 
		 this.email = email; 
		  
	 }
	 
	 public Long getDepartmentId() {
		 return departmentId;
	 }
	 
	 public void setDepartmentId(Long departmentId) {
		 this.departmentId = departmentId;
	}

}
