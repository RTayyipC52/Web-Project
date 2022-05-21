package web.project.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginReturnDto {
	private int userId;
    private String name;
    private String email;
    private int userType;
}
