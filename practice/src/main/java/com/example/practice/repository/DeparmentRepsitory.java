package com.example.practice.repository;

import com.example.practice.entity.Department;
import com.example.practice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeparmentRepsitory extends JpaRepository<Department, Integer> {
    @Query(nativeQuery = true,value= "SELECT * from departments where department_name=?1")
    List<Employee> listadonombreapellido(String textoIngreso);
}
