package com.example.pawpalandiaDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pawpalandiaDB.exceptions.ServiceNotFoundException;
import com.example.pawpalandiaDB.model.ServiceEntity;
import com.example.pawpalandiaDB.service.ServiceService;

@RestController
@RequestMapping("/api/v4")
public class ServiceController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    //Método para mapear services
    @GetMapping("/services")
    public List<ServiceEntity> getServices() {
        return this.serviceService.getAll();
    }

    //Método para mapear getById() usando un PathVariable
    @GetMapping("/services/{id}")
    public ServiceEntity findById(@PathVariable(name = "id") Long id) {
        return this.serviceService.getById(id);
    }

    //Método para crear una nueva orden de servicio
    @PostMapping("/post-service")
    public ServiceEntity newService(@RequestBody ServiceEntity service){
        return this.serviceService.createService(service);
    }

    //Método para eliminar una orden de servicio mediante id
    @DeleteMapping("/delete-service/{id}")
    public void deleteService(@PathVariable(name = "id") Long id) {
        this.serviceService.deleteUser(id);
    }

    //Método para actualizar un servicio mediante mapeo en PUT
    
    @PutMapping("update-service/{id}")
	public ResponseEntity <ServiceEntity> updateService(@RequestBody ServiceEntity user, @PathVariable(name = "id") Long id){
		try{
			return ResponseEntity.ok(this.serviceService.updateUser(user, id));
		} catch(ServiceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
