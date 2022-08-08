package request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AddUserRequest extends BaseUser{

    public AddUserRequest(String name, String surname, int age) {
        super(name, surname, age);
    }
}
