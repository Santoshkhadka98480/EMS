package com.Employee.EMS.service;

import com.Employee.EMS.dto.DepartmentDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
    DepartmentDto savDepartment(DepartmentDto departmentDto );

    List<DepartmentDto> findAll();

    DepartmentDto findById(Integer id);

    void deleteDepartmentById(Integer id);
}
