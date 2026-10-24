public class Cliente extends Usuario {
    private String rfc;
    private int telefono;
    private String listaCuenta;

    // Constructor de la subclase
    public Cliente(int idUsuario, String nombre, String correo, String contrasena, String rfc, int telefono, String listaCuenta) {
        super(idUsuario, nombre, correo, contrasena); // Obligatorio: invoca al constructor del padre
        this.rfc = rfc;
        this.telefono = telefono;
        this.listaCuenta = listaCuenta;
    }

    public void solicitarCredito() {
        // Al heredar, puede usar los métodos públicos del padre como getNombre()
        System.out.println("El cliente " + getNombre() + " está solicitando un crédito.");
    }

    public void consultarHistorial() {
        System.out.println("Consultando historial de transacciones...");
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getListaCuenta() {
        return listaCuenta;
    }

    public void setListaCuenta(String listaCuenta) {
        this.listaCuenta = listaCuenta;
    }
}