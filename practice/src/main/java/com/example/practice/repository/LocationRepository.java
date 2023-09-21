package com.example.practice.repository;

import com.example.practice.entity.Employee;
import com.example.practice.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query(nativeQuery = true,value= "SELECT * from employees where first_name=?1 or last_name=?1")
    List<Employee> listadonombreapellido(String textoIngreso);
}
