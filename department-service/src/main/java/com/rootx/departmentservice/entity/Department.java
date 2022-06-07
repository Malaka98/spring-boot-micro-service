package com.rootx.departmentservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Department {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
