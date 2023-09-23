package pe.edu.cibertec.appwebventas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.appwebventas.model.bd.Category;
import pe.edu.cibertec.appwebventas.service.CategoryService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/category")
public class CategoriaController {

    private CategoryService categoryService;

    @GetMapping("/listar")
    @ResponseBody
    public List<Category> listarCategorias(){
        return categoryService.listarCategorias();
    }
}
