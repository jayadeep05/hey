//package userservice.controller;

package userservice.controller;

import lombok.AllArgsConstructor;
import userservice.dto.ResponseDto;
import userservice.entity.User;
import userservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
	
	@Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    
    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable("id") Long userId) {
        System.out.println("Fetching user for ID: " + userId);

        ResponseDto responseDto = userService.getUser(userId);

        
        //responseDto is not null at this point.
        if (responseDto == null) {
            System.out.println("ResponseDto is null for user ID: " + userId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        System.out.println("User found: " + responseDto.getUser());
        
        if (responseDto.getUser() == null) {
            System.out.println("User object is null");
        } else {
            System.out.println("Department ID: " + responseDto.getUser().getDepartmentId());
        }

        return ResponseEntity.ok(responseDto);
    }

}