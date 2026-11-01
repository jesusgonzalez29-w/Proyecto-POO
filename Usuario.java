public class Usuario {
    // Atributos privados para aplicar encapsulamiento
    protected int idUsuario;
    protected String nombre;
    protected String correo;
    protected String contrasena;

    
    public Usuario(int idUsuario, String nombre, String correo, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo(){
        return correo; 
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }
    
}