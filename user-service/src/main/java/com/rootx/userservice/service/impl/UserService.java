package com.rootx.userservice.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.rootx.userservice.dto.DepartmentDTO;
import com.rootx.userservice.entity.User;
import com.rootx.userservice.repository.IUserRepository;
import com.rootx.userservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService {

    private final IUserRepository iUserRepository;

    private final RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public JsonArray getUsers() {

        JsonArray jsonElements = new JsonArray();

        List<User> users = iUserRepository.findAll();
        ResponseEntity<DepartmentDTO[]> departmentDTOS = restTemplate.getForEntity("http://DEPARTMENT-SERVICE/api/departments/", DepartmentDTO[].class);
        List<DepartmentDTO> responsList = Arrays.asList(Objects.requireNonNull(departmentDTOS.getBody()));
//        log.info(departmentDTOS);
        users.forEach(user -> {
            JsonObject userObj = new JsonObject();
            userObj.addProperty("userId", user.getUserId());
            userObj.addProperty("firstName", user.getFirstName());
            userObj.addProperty("lastName", user.getLastName());
            userObj.addProperty("email", user.getEmail());
//            assert departmentDTOS.getBody() != null;
            responsList.forEach(departmentDTO -> {
                if(Objects.equals(departmentDTO.getDepartmentId(), user.getDepartmentId())) {
                    JsonObject departmentObj = new JsonObject();
                    departmentObj.addProperty("departmentId", departmentDTO.getDepartmentId());
                    departmentObj.addProperty("departmentName", departmentDTO.getDepartmentName());
                    departmentObj.addProperty("departmentAddress", departmentDTO.getDepartmentAddress());
                    departmentObj.addProperty("departmentCode", departmentDTO.getDepartmentCode());
                    userObj.add("department", departmentObj);
                }
            });
            jsonElements.add(userObj);
        });

        return jsonElements;
    }
}
