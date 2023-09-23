package pe.edu.cibertec.appwebventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.appwebventas.model.bd.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
