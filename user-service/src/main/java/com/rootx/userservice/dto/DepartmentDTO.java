package com.rootx.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DepartmentDTO {
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
