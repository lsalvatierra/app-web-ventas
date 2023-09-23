package pe.edu.cibertec.appwebventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.appwebventas.model.bd.Supplier;

@Repository
public interface SupplierRepository extends
        JpaRepository <Supplier, Integer>
{

}
