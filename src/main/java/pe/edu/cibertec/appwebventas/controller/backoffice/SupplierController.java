package pe.edu.cibertec.appwebventas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.appwebventas.model.bd.Category;
import pe.edu.cibertec.appwebventas.model.bd.Supplier;
import pe.edu.cibertec.appwebventas.service.CategoryService;
import pe.edu.cibertec.appwebventas.service.SupplierService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/supplier")
public class SupplierController {

    private SupplierService supplierService;

    @GetMapping("/listar")
    @ResponseBody
    public List<Supplier> listarProveedores(){
        return supplierService.listarProveedores();
    }
}
