package departmentservice.service;

import org.springframework.stereotype.Service;
import departmentservice.entity.Department;

@Service
public interface DepartmentService {
	
	Department saveDepartment(Department department);
	Department getDepartment(Long departmentId);
//	Department getDepartment(Department departmentId);
	

} 