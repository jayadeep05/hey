package userservice.service;

import org.springframework.stereotype.Service;
import userservice.dto.ResponseDto;
import userservice.entity.User;


@Service
public interface UserService {
	
	
	User saveUser(User user);
	
	ResponseDto getUser(Long employeeId);

}
