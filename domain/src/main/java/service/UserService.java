package service;

import dto.User;
import exception.BusinessPortalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.repository.UserRepository;
import request.AddUserRequest;
import request.BaseUser;
import request.UpdateUserRequest;
import response.ResponseError;
import response.UserResponse;
import response.presentation.GetAllUsersResponse;

import java.math.BigInteger;
import java.util.Objects;
import java.util.stream.Collectors;

import static converter.EntityModelUserConverter.*;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public GetAllUsersResponse getAll() {
        return GetAllUsersResponse.builder()
                .userList(
                        repository.getAll()
                                .stream()
                                .map(entity -> updateEntityToUserResponse.apply(entity))
                                .collect(Collectors.toList())
                ).build();
    }

    public UserResponse getUserResponseById(BigInteger id) {
        User savedUser = updateModel.apply(
                repository.findOne(id)
                        .orElseThrow(() -> new BusinessPortalException(ResponseError.NOT_FOUND))
        );

        return toUserResponse.apply(savedUser);
    }

    public void save(AddUserRequest request) {
        saveOrUpdate(buildUserFromRequest(request));
    }

    public User update(UpdateUserRequest request) {
        return updateModel.apply(
                    repository.update(
                            updateEntity.apply(
                                    updateUserModel.apply(
                                            getById(buildUserFromRequest(request).getId())
                                    )
                            )
                    )
            );
    }

    private void saveOrUpdate(User user) {
        if (Objects.nonNull(user.getId())) {
            UpdateUserRequest updateUserRequest =
                    new UpdateUserRequest(user.getId(), user.getName(), user.getSurname(), user.getAge());
            update(updateUserRequest);
            return;
        }
        repository.save(updateEntity.apply(user));
    }

    private User buildUserFromRequest(final BaseUser baseUser){
        User user = User.builder()
                .name(baseUser.getName())
                .surname(baseUser.getSurname())
                .age(baseUser.getAge())
                .build();

        if(baseUser instanceof UpdateUserRequest){
            user.setId(((UpdateUserRequest) baseUser).getId());
        }
        return user;
    }

    private User getById(BigInteger id) {
        return updateModel.apply(
                repository.findOne(id)
                        .orElseThrow(() -> new BusinessPortalException(ResponseError.NOT_FOUND))
        );
    }
}
