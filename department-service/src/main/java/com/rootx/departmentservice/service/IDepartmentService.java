package com.rootx.departmentservice.service;

import com.rootx.departmentservice.entity.Department;

import java.util.List;

public interface IDepartmentService {

    Department saveDepartment(Department department);

    List<Department> getDepartments();
}
