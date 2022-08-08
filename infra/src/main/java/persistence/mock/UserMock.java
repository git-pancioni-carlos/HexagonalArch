package persistence.mock;

import org.springframework.context.annotation.Configuration;
import persistence.entity.UserEntity;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class UserMock {

    private static Map<BigInteger, UserEntity> allUsers;
    static {
        allUsers = new HashMap<>();

        allUsers.put(BigInteger.ONE,UserEntity.builder()
                        .id(BigInteger.ONE)
                        .name("Aroldo")
                        .surname("Silva")
                        .age(49)
                .build());

        allUsers.put(BigInteger.valueOf(2), UserEntity.builder()
                .id(BigInteger.valueOf(2))
                .name("Beatriz")
                .surname("Cardoso")
                .age(22)
                .build());

        allUsers.put(BigInteger.valueOf(3), UserEntity.builder()
                .id(BigInteger.valueOf(3))
                .name("Cinthia")
                .surname("Vidal")
                .age(34)
                .build());

        allUsers.put(BigInteger.valueOf(4), UserEntity.builder()
                .id(BigInteger.valueOf(4))
                .name("Daniel")
                .surname("Alvez")
                .age(34)
                .build());

        allUsers.put(BigInteger.valueOf(5), UserEntity.builder()
                .id(BigInteger.valueOf(5))
                .name("Eduarda")
                .surname("Souza")
                .age(15)
                .build());
    }

    public static Map<BigInteger, UserEntity> getAllUsers() {
        return allUsers;
    }
}
