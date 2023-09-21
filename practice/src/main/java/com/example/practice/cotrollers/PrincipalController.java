package com.example.practice.cotrollers;

import com.example.practice.entity.Employee;
import com.example.practice.repository.EmpleadoRepository;
import com.example.practice.repository.JobsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
public class PrincipalController {
    final EmpleadoRepository empleadoRepository;
    final JobsRepository jobsRepository;
    public PrincipalController(EmpleadoRepository empleadoRepository,JobsRepository jobsRepository) {
        this.empleadoRepository = empleadoRepository;
        this.jobsRepository = jobsRepository;
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/reportes")
    public String reportes(){
        return "reportes";
    }
    @GetMapping("/historial")
    public String historial(){
        return "historial";
    }
    @GetMapping("/empleados")
    public String empleados(Model model ){
        List<Employee> listaempleados = empleadoRepository.findAll();
        model.addAttribute("listaempleados", listaempleados);
        return "empleados";
    }
    @PostMapping("/buscarPorNombre")
    String buscarPorNombre(@RequestParam("searchField") String searchField, Model model){
        List<Employee> listaempleados = empleadoRepository.listadonombreapellido(searchField);
        model.addAttribute("listaempleados", listaempleados);
        model.addAttribute("textoBuscado", searchField);
        return"empleados";
    }
    @GetMapping("/editE")
    public String editE(Model model,
                                      @RequestParam("id") int id) {

        Optional<Employee> optional = empleadoRepository.findById(id);

        if (optional.isPresent()) {
            Employee employee = optional.get();
            model.addAttribute("employee", employee);

            return "editEmpleado";
        } else {
            return "redirect:/empleados";
        }
    }
    @GetMapping("/borrarE")
    public String borrar(Model model,
                                      @RequestParam("id") int id,RedirectAttributes attr) {
        Optional<Employee> optional = empleadoRepository.findById(id);
        if (optional.isPresent()) {
            Employee employee = optional.get();
            String name = employee.getFirstName();
            empleadoRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Empleado " + name + " borrado exitosamente");
        }
        return "redirect:/empleados";

    }
    @GetMapping("/newEmpleado")
    public String newEmpleado(Model model) {
        model.addAttribute("listapuestos",jobsRepository.findAll());
        model.addAttribute("listajefe",empleadoRepository.findAll());
        return "newEmpleado";
    }
    @PostMapping("/saveEmpleado")
    public String guardarNuevoTransportista(RedirectAttributes attr, Model model, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("job") String job, @RequestParam("salary") BigDecimal salary, @RequestParam("manager") int manager, @RequestParam("department") int department ) {
        String estado = "creado" ;
        attr.addFlashAttribute("msg", "Empleado " + estado + " correctamente");
        empleadoRepository.ingresodatos(firstName,lastName,email,password,job,salary,manager,department);
        return "redirect:/empleados";
    }

    }
