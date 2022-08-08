package persistence.repository.impl;

import persistence.entity.UserEntity;
import persistence.mock.UserMock;
import persistence.repository.UserRepository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public List<UserEntity> getAll() {
        return (ArrayList<UserEntity>) UserMock.getAllUsers().values();
    }

    @Override
    public Optional<UserEntity> findOne(BigInteger id) {
        return Optional.ofNullable(UserMock.getAllUsers().get(id));
    }

    @Override
    public UserEntity save(UserEntity entity) {
        final Map<BigInteger, UserEntity> allUsers = UserMock.getAllUsers();
        BigInteger nextVal = BigInteger.valueOf(allUsers.size() + 1);
        allUsers.put(nextVal, entity);
        entity.setId(nextVal);
        return entity;
    }

    @Override
    public UserEntity update(UserEntity entityToUpdate) {
        UserEntity updatedUser = updateUser.apply(entityToUpdate);
        UserMock.getAllUsers().put(updatedUser.getId(), updatedUser);
        return updatedUser;
    }

    private static final Function<UserEntity, UserEntity> updateUser =
            (u) -> UserEntity.builder()
                    .name(u.getName())
                    .surname(u.getSurname())
                    .age(u.getAge())
                    .build();
}
