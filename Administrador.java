public class Administrador extends Usuario {
    private int idEmpleado;

    public Administrador(int idUsuario, String nombre, String correo, String contrasena, int idEmpleado) {
        super(idUsuario, nombre, correo, contrasena);
        this.idEmpleado = idEmpleado;
    }

    public void aprobarCreditos() {
        System.out.println("Aprobando crédito de cliente...");
    }

    public void consultarHistorialCliente() {
        System.out.println("Auditando historial del cliente...");
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}