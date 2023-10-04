package com.adrian.springbootproject.service;

import com.adrian.springbootproject.entity.Department;
import com.adrian.springbootproject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    @Override
    public List<Department> fetchDepartmentList(){
        return departmentRepository.findAll();
    }
    @Override
    public Department fetchDepartmentById(Long departmentId){
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department updatedDepartment) {
        Department depDB = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(updatedDepartment.getDepartmentName()) && !"".equalsIgnoreCase(updatedDepartment.getDepartmentName())){
            depDB.setDepartmentName(updatedDepartment.getDepartmentName());
        }
        if(Objects.nonNull(updatedDepartment.getDepartmentAddress()) && !"".equalsIgnoreCase(updatedDepartment.getDepartmentAddress())){
            depDB.setDepartmentAddress(updatedDepartment.getDepartmentAddress());
        }
        if(Objects.nonNull(updatedDepartment.getDepartmentCode()) && !"".equalsIgnoreCase(updatedDepartment.getDepartmentCode())){
            depDB.setDepartmentCode(updatedDepartment.getDepartmentCode());
        }
        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
