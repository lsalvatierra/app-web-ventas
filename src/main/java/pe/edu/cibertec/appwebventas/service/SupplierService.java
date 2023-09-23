package pe.edu.cibertec.appwebventas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appwebventas.model.bd.Supplier;
import pe.edu.cibertec.appwebventas.repository.SupplierRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class SupplierService {

    private SupplierRepository supplierRepository;

    public List<Supplier> listarProveedores(){
        return supplierRepository.findAll();
    }

}
