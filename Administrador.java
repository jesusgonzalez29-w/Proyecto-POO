public class Administrador extends Usuario {
    private int idEmpleado;

    public Administrador(int idUsuario, String nombre, String correo, String contrasena, int idEmpleado) {
        super(idUsuario, nombre, correo, contrasena);
        this.idEmpleado = idEmpleado;
    }

    public void aprobarCreditos() {
       
    }

    public void consultarHistorialCliente() {
        
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}