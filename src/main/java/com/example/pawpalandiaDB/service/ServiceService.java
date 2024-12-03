package com.example.pawpalandiaDB.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pawpalandiaDB.exceptions.ServiceNotFoundException;
import com.example.pawpalandiaDB.model.ServiceEntity;
import com.example.pawpalandiaDB.repository.ServiceRepository;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    //Inyectar en el constructor
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    //Método para obtener todas las órdenes de servicios
    public List<ServiceEntity> getAll() { 
        return serviceRepository.findAll(); 
    }

    //Método para obtener una orden de servicio por id
    public ServiceEntity getById(Long id) {
		return this.serviceRepository.findById(id)
				.orElseThrow(()-> new ServiceNotFoundException(id));
	}

    //Método para registrar una nueva orden de servicio
    public ServiceEntity createService(ServiceEntity newService) {
		return this.serviceRepository.save(newService);
	} 

    //Método para eliminar una orden de servicio mediante id
    public void deleteUser(Long id) {
		if (this.serviceRepository.existsById(id)) {
			this.serviceRepository.deleteById(id);
		} else {
			throw new ServiceNotFoundException(id);
		}
	}

    //Método para actualizar una orden de servicio usando mapeo en PUT
    public ServiceEntity updateUser(ServiceEntity service, Long id) {
        return this.serviceRepository.findById(id).map(serviceMap ->{
            serviceMap.setIdServiceOrder(service.getIdServiceOrder());
            serviceMap.setClientName(service.getClientName());
            serviceMap.setPetName(service.getPetName());
            serviceMap.setEmail(service.getEmail());
            serviceMap.setPhoneNumber(service.getPhoneNumber());
            serviceMap.setDate(service.getDate());
            serviceMap.setKindOfService(service.getKindOfService());
            serviceMap.setComment(service.getComment());
            serviceMap.setPrivacyPolicyAccepted(service.getPrivacyPolicyAccepted());
            return this.serviceRepository.save(serviceMap);
        })
        .orElseThrow(()->new ServiceNotFoundException(id));
    }
}
