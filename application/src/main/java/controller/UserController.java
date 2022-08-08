package controller;

import org.springframework.web.bind.annotation.*;
import request.AddUserRequest;
import request.UpdateUserRequest;
import response.common.Response;
import response.presentation.GetAllUsersResponse;

import java.math.BigInteger;

public interface UserController {

    String REST_SECTION = "/public/user/";

    @GetMapping(value = REST_SECTION + "findAll", produces = "application/json")
    Response<GetAllUsersResponse> getUsers();

    @GetMapping(value = REST_SECTION + "findById", produces = "application/json")
    Response<GetAllUsersResponse> getUser(@RequestParam(value = "id", required = true) final BigInteger id);

    @PostMapping(value = REST_SECTION + "add", produces = "application/json")
    Response addUser(@RequestBody AddUserRequest request);

    @PutMapping(value = REST_SECTION + "modify", produces = "application/json")
    Response updateUser(@RequestBody UpdateUserRequest request);

}
