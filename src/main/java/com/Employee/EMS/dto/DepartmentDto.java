package com.Employee.EMS.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Integer id;
    private String name;
    private String shortCode;
    private boolean status;


}
