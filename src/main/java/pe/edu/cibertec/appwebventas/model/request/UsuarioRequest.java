package pe.edu.cibertec.appwebventas.model.request;

import lombok.Data;

@Data
public class UsuarioRequest {
    private Integer idusuario;
    private String nomusuario;
    private String nombres;
    private String apellidos;
    private Boolean activo;
    private String email;
}
