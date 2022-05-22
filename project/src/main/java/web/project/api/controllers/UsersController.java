package web.project.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import web.project.business.abstracts.UserService;
import web.project.core.entities.User;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.entities.dtos.UserLoginDto;
import web.project.entities.dtos.UserLoginReturnDto;

//import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping(value="/api/users")

public class UsersController {

    private UserService userService;
    @Autowired
    public UsersController(UserService  userService) {
        super();
        this.userService = userService;
    }
    
    @GetMapping("/getAll")
    public DataResult<List<User>> getAll() {
        return this.userService.getAll();
    }
    
   /* @PostMapping(value="/add")
   public ResponseEntity<?> add(@Valid @RequestBody User user){
        return ResponseEntity.ok(this.userService.add(user));
   }*/
    
    @GetMapping("/getById")
    public DataResult<User> getById(@RequestParam int userId) {
        return this.userService.getById(userId);
    }
    
    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto){
        DataResult<UserLoginReturnDto> result = this.userService.login(userLoginDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.badRequest().body(result);
        }
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Dogrulama Hataları");
        return errors;
    }

}
