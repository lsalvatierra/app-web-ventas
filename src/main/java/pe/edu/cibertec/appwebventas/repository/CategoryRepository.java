package pe.edu.cibertec.appwebventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.appwebventas.model.bd.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
