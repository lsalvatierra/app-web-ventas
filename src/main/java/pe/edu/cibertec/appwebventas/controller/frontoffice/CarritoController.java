package pe.edu.cibertec.appwebventas.controller.frontoffice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/carrito")
public class CarritoController {

    @GetMapping("/principal")
    public String login(HttpServletRequest request){
        return "frontoffice/carrito/principal";
    }
}
