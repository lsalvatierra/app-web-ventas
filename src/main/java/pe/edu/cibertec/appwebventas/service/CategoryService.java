package pe.edu.cibertec.appwebventas.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appwebventas.model.bd.Category;
import pe.edu.cibertec.appwebventas.repository.CategoryRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {

    private CategoryRepository categoryRepository;


    public List<Category> listarCategorias(){
        return categoryRepository.findAll();
    }


}
