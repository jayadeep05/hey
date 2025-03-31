package userservice.dto;

public class ResponseDto {
	
	private DepartmentDto departmentId;
	private UserDto user;
	
	
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	
	
	public DepartmentDto getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(DepartmentDto departmentId) {
		this.departmentId = departmentId;
	}


}
