package request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@ToString
@AllArgsConstructor
@Builder
public class UpdateUserRequest {

    private BigInteger id;
    private String name;
    private String surname;
    private int age;
}
