package converter;

import dto.User;
import persistence.entity.UserEntity;
import response.UserResponse;

import java.util.function.Function;

public class EntityModelUserConverter {

    public static final Function<UserEntity, User> updateModel =
            (entity) -> User.builder()
                    .name(entity.getName())
                    .surname(entity.getSurname())
                    .age(entity.getAge())
                    .build();

    public static final Function<User, UserEntity> updateEntity =
            (model) -> UserEntity.builder()
                    .name(model.getName())
                    .surname(model.getSurname())
                    .age(model.getAge())
                    .build();

    public static final Function<User, User> updateUserModel =
            (model) -> User.builder()
                    .name(model.getName())
                    .surname(model.getSurname())
                    .age(model.getAge())
                    .build();

    public static final Function<User, UserResponse> toUserResponse =
            (model) -> UserResponse.builder()
                    .name(model.getName())
                    .surname(model.getSurname())
                    .age(model.getAge())
                    .build();

    public static final Function<UserEntity, UserResponse> updateEntityToUserResponse =
            (entity) -> UserResponse.builder()
                    .name(entity.getName())
                    .surname(entity.getSurname())
                    .age(entity.getAge())
                    .build();
}
