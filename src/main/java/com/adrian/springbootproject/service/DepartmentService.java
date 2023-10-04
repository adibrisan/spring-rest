package com.adrian.springbootproject.service;

import com.adrian.springbootproject.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);
    public List<Department> fetchDepartmentList();
    public Department fetchDepartmentById(Long departmentId);
    public void deleteDepartmentById(Long departmentId);
    public Department updateDepartment(Long departmentId,Department updatedDepartment); // updatedDepartment=the department you want to update
    public Department fetchDepartmentByName(String departmentName);
}
