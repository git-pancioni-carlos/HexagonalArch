package request;

import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@ToString
public class UpdateUserRequest extends BaseUser{

    private BigInteger id;

    public UpdateUserRequest(BigInteger id, String name, String surname, int age) {
        super(name, surname, age);
        this.id = id;
    }
    public UpdateUserRequest(String name, String surname, int age) {
        super(name, surname, age);
    }

}
