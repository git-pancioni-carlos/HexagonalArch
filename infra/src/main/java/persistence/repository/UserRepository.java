package persistence.repository;

import org.springframework.stereotype.Component;
import persistence.entity.UserEntity;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Component
public interface UserRepository {

    List<UserEntity> getAll();
    Optional<UserEntity> findOne(BigInteger id);
    UserEntity save(UserEntity entity);
    UserEntity update(UserEntity entity);
}
