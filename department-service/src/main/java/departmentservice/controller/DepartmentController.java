package departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import departmentservice.entity.Department;
import departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/departments")


public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable("id") Long departmentId){
		 Department department = departmentService.getDepartment(departmentId);
	     return ResponseEntity.ok(department);
	}
	
	@PostMapping
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
		
		Department savedDepartment = departmentService.saveDepartment(department);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
		
		
	}
}