package userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import userservice.dto.DepartmentDto;
import userservice.dto.ResponseDto;
import userservice.dto.UserDto;
import userservice.entity.User;
import userservice.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user); 
    }
    
    public ResponseDto getUser(Long userId) {
        System.out.println("Fetching user for ID: " + userId);

        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            System.out.println("User not found!");
            return null; // Return null if user does not exist
        }

        // 🔥 Ensure departmentId is NEVER NULL: Assign employeeId if null
        if (user.getDepartmentId() == null) {
            System.out.println("Department ID is null, setting departmentId = employeeId");
            user.setDepartmentId(user.getEmployeeId());
            userRepository.save(user); // Save the updated departmentId to database
        }

        UserDto userDto = mapToUser(user);
        
        // ✅ Fetch department details ONLY if departmentId is present
        ResponseEntity<DepartmentDto> responseEntity = restTemplate
                .getForEntity("http://localhost:8082/departments/" + user.getDepartmentId(),
                        DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();
        System.out.println("Department ID: " + user.getDepartmentId());
        System.out.println(responseEntity.getStatusCode());

        responseDto.setUser(userDto);
        responseDto.setDepartmentId(departmentDto);
        
        return responseDto;
    }

 

    private UserDto mapToUser(User user){
        UserDto userDto = new UserDto();
        userDto.setEmployeeId(user.getEmployeeId());
        userDto.setEmployeeFirstName(user.getEmployeeFirstName());
        userDto.setEmployeeLastName(user.getEmployeeLastName());
        userDto.setEmail(user.getEmail());
        userDto.setDepartmentId(user.getDepartmentId());

        return userDto;
    }
}
 