package pe.edu.cibertec.appwebventas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.appwebventas.model.bd.Category;
import pe.edu.cibertec.appwebventas.model.bd.Product;
import pe.edu.cibertec.appwebventas.model.bd.Supplier;
import pe.edu.cibertec.appwebventas.model.request.ProductRequest;
import pe.edu.cibertec.appwebventas.model.response.ResultadoResponse;
import pe.edu.cibertec.appwebventas.service.ProductService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @GetMapping("")
    public String frmMantSala(Model model){
        model.addAttribute("listaProductos",
                productService.listarProductos());
        return "backoffice/product/frmMantProduct";
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Product> listarSalas(){
        return productService.listarProductos();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public ResultadoResponse registrarSala(@RequestBody
                                           ProductRequest productoRequest){
        String mensaje = "Producto registrado correctamente";
        Boolean respuesta = true;
        try{
            Product objProducto = new Product();
            if(productoRequest.getProductid() > 0){
                objProducto.setProductid(productoRequest.getProductid());
            }
            objProducto.setProductname(productoRequest.getProductname());
            objProducto.setUnitprice(productoRequest.getUnitprice());
            objProducto.setDiscontinued(productoRequest.getDiscontinued());
            Category objCategory = new Category();
            objCategory.setCategoryid(productoRequest.getCategoryid());
            objProducto.setCategories(objCategory);
            Supplier objSupplier = new Supplier();
            objSupplier.setSupplierid(productoRequest.getSupplierid());
            objProducto.setSuppliers(objSupplier);
            productService.registrarProducto(objProducto);
        }catch (Exception ex){
            mensaje = "Producto no registrada";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta).build();
    }

    @DeleteMapping("/eliminarSala")
    @ResponseBody
    public ResultadoResponse eliminarSala(@RequestBody
                                              ProductRequest productoRequest){
        String mensaje = "Sala eliminada correctamente";
        Boolean respuesta = true;
        try{
            productService.eliminarProducto(productoRequest.getProductid());
        }catch (Exception ex){
            mensaje = "Sala no eliminada";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje).respuesta(respuesta).build();
    }

}
