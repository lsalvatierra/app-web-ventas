package pe.edu.cibertec.appwebventas.controller.backoffice;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.appwebventas.model.bd.Usuario;
import pe.edu.cibertec.appwebventas.model.request.UsuarioRequest;
import pe.edu.cibertec.appwebventas.model.response.ResultadoResponse;
import pe.edu.cibertec.appwebventas.service.UsuarioService;

@AllArgsConstructor
@Controller
@RequestMapping("/seguridad")
public class SeguridadController {

    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public String frmMantUsuario(Model model){
        model.addAttribute("listaUsuarios",
                usuarioService.listarUsuario());
        return "backoffice/seguridad/frmMantUsuario";
    }

    @PostMapping("/usuario")
    @ResponseBody
    public ResultadoResponse registrarUsuario(@RequestBody
                                 UsuarioRequest usuarioRequest){
        String mensaje = "Usuario registrado correctamente";
        boolean respuesta = true;
        try{
            Usuario usuario = new Usuario();
            usuario.setNombres(usuarioRequest.getNombres());
            usuario.setApellidos(usuarioRequest.getApellidos());
            if(usuarioRequest.getIdusuario() > 0){
                usuario.setIdusuario(usuarioRequest.getIdusuario());
                usuario.setActivo(usuarioRequest.getActivo());
                usuarioService.updateUser(usuario);
            }else{
                usuario.setNomusuario(usuarioRequest.getNomusuario());
                usuario.setEmail(usuarioRequest.getEmail());
                usuarioService.saveUser(usuario);
            }
        }catch (Exception ex){
            mensaje = "Usuario no registrado, error en la BD "+ ex.getMessage();
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje)
                .respuesta(respuesta).build();

    }

    @GetMapping("/usuario/{id}")
    @ResponseBody
    public Usuario frmMantUsuario(@PathVariable("id") int id){
        return usuarioService.obtenerUsuarioxId(id);
    }
}
