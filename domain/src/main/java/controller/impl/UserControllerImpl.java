package controller.impl;

import controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import request.AddUserRequest;
import request.UpdateUserRequest;
import response.Response;
import response.UserResponse;
import response.presentation.GetAllUsersResponse;
import service.UserService;

import java.math.BigInteger;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService service;

    @Override
    public Response<GetAllUsersResponse> getUsers() {
        return Response.successfulResponse(service.getAll());
    }

    @Override
    public Response<UserResponse> getUser(BigInteger id) {
        return Response.successfulResponse(service.getUserResponseById(id));
    }

    @Override
    public Response addUser(AddUserRequest request) {
        service.save(request);

        return Response.SUCCESS;
    }

    @Override
    public Response updateUser(UpdateUserRequest request) {
        service.update(request);

        return Response.SUCCESS;
    }
}
