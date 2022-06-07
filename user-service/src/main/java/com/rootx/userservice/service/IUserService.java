package com.rootx.userservice.service;

import com.google.gson.JsonArray;
import com.rootx.userservice.entity.User;

import java.util.List;

public interface IUserService {

    User saveUser(User user);

    JsonArray getUsers();
}
