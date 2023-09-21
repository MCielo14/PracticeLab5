package com.example.practice.repository;

import com.example.practice.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Employee, Integer> {
    @Query(nativeQuery = true,value= "SELECT e.employee_id,e.first_name,e.last_name,e.email,e.password,e.phone_number,e.hire_date,e.job_id,e.salary,e.commission_pct,e.manager_id,e.department_id,e.enabled,d.department_name,loc.city FROM employees e  inner join departments d on(d.department_id=e.department_id) \n" +
            "inner join locations loc on(loc.location_id=d.location_id) inner join jobs j on (j.job_id=e.job_id)\n" +
            "WHERE  first_name= ?1 or last_name=?1 or j.job_title=?1 or TRIM(loc.city) = ?1 ;")
    List<Employee> listadonombreapellido(String textoIngreso);
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "INSERT INTO hr.employees (first_name, last_name, email, password,job_id,salary,manager_id,department_id)\n" +
            "VALUES (?1,?2,?3,SHA2(?4, 256),?5,?6,?7,?8);")
    void ingresodatos(String firstName, String lastName, String email, String password, String job, BigDecimal salary,int managerid,int deparmentid);
}
