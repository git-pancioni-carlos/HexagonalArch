package controller.impl;

import controller.UserController;
import org.springframework.web.bind.annotation.RestController;
import request.AddUserRequest;
import request.UpdateUserRequest;
import response.common.Response;
import response.presentation.GetAllUsersResponse;

import java.math.BigInteger;

@RestController
public class UserControllerImpl implements UserController {

    @Override
    public Response<GetAllUsersResponse> getUsers() {
        return null;
    }

    @Override
    public Response<GetAllUsersResponse> getUser(BigInteger id) {
        return null;
    }

    @Override
    public Response addUser(AddUserRequest request) {
        return null;
    }

    @Override
    public Response updateUser(UpdateUserRequest request) {
        return null;
    }
}
