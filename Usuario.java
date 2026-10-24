public class Usuario {
    // Atributos privados para ocultar y proteger los datos
    private int idUsuario;
    private String nombre;
    private String correo;
    private String contrasena;

    // Constructor para inicializar el objeto cuando se cree
    public Usuario(int idUsuario, String nombre, String correo, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // Método de acción principal
    public void iniciarSesion() {
        // Aquí irá la lógica para validar credenciales
        System.out.println("Iniciando sesión para: " + this.correo);
    }

    // Métodos Getters y Setters para acceder a los datos (Ejemplo con el nombre)
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
    
}