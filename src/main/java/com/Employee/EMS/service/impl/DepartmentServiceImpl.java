package com.Employee.EMS.service.impl;

import com.Employee.EMS.dto.DepartmentDto;
import com.Employee.EMS.entities.Department;
import com.Employee.EMS.repo.DepartmentRepository;
import com.Employee.EMS.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

//        List<DepartmentDto> ddto = new ArrayList<>();
        List<Department> departments = departmentRepository.findAll();
//        for(Department d: departments) {
//            ddto.add(new DepartmentDto(d.getId(), d.getName(), d.getShortCode(),d.isStatus()));
//
//        }
        return departments.stream().map(d ->
                DepartmentDto.builder()
                        .id(d.getId())
                        .name(d.getName())
                        .shortCode(d.getShortCode())
                        .status(d.isStatus())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto findById(Integer id) {
//        Department department = departmentRepository.findById(id);
        Department d;
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            d = optionalDepartment.get();
            return DepartmentDto.builder()
                    .id(d.getId())
                    .name(d.getName())
                    .shortCode(d.getShortCode())
                    .status(d.isStatus())
                    .build();
        }
        return null;
    }

    @Override
    public void deleteDepartmentById(Integer id) {
        departmentRepository.deleteById(id);
    }
}
