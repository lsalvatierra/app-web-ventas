package pe.edu.cibertec.appwebventas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appwebventas.model.bd.Product;
import pe.edu.cibertec.appwebventas.repository.ProductRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {
    private ProductRepository productRepository;

    public List<Product> listarProductos(){
        return productRepository.findAll();
    }
    public void registrarProducto(Product product){
        productRepository.save(product);
    }
    public void eliminarProducto(Integer idproducto){
        productRepository.deleteById(idproducto);
    }
}
