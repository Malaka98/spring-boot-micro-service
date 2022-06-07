package com.rootx.departmentservice.controller;

import com.rootx.departmentservice.entity.Department;
import com.rootx.departmentservice.service.impl.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {

        return ResponseEntity.ok().body(departmentService.saveDepartment(department));
    }

    @GetMapping("/")
    public ResponseEntity<List<Department>> getDepartments() {
        return ResponseEntity.ok().body(departmentService.getDepartments());
    }
}
