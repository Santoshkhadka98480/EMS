package com.Employee.EMS.service.impl;

import com.Employee.EMS.dto.DepartmentDto;
import com.Employee.EMS.entities.Department;
import com.Employee.EMS.repo.DepartmentRepository;
import com.Employee.EMS.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto savDepartment(DepartmentDto departmentDto) {
        Department entity = new Department();
        entity.setId(departmentDto.getId());
        entity.setName(departmentDto.getName());
        entity.setShortCode(departmentDto.getShortCode());
        entity.setStatus(departmentDto.isStatus());

        entity = departmentRepository.save(entity);
        return DepartmentDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .shortCode(entity.getShortCode())
                .status(entity.isStatus())
                .build();
    }

    @Override
    public List<DepartmentDto> findAll() {
        return null;
    }

    @Override
    public DepartmentDto findById(Integer id) {
        return null;
    }

    @Override
    public void deleteDepartmentById(Integer id) {

    }
}
