package com.rootx.departmentservice.service.impl;

import com.rootx.departmentservice.entity.Department;
import com.rootx.departmentservice.repository.IDepartmentRepository;
import com.rootx.departmentservice.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {

    private final IDepartmentRepository iDepartmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return iDepartmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return iDepartmentRepository.findAll();
    }
}
