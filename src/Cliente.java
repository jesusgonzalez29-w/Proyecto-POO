public class Cliente extends Usuario {
    private String rfc;
    //long, ya que int no permite todo el rango de numeros telefonicos de 10 digitos
    private long telefono;
    private CuentaBancaria[] cuentas;
    private int indiceCuentas; 
    private Credito [] creditos; 

    // Constructor de clase hija, llamando primero a clase padre
    public Cliente(int idUsuario, String nombre, String correo, String contrasena, String rfc, long telefono) {
        super(idUsuario, nombre, correo, contrasena); // Obligatorio: invoca al constructor del padre
        this.rfc = rfc;
        this.telefono = telefono;
        
    }

    public void solicitarCredito() {
        // Al heredar, puede usar los métodos públicos del padre como getNombre()
        System.out.println("Solicitando credito a nombre de " + getNombre());
    }

    public void consultarHistorial() {
        System.out.println("Consultando historial de transacciones");
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    } 

    public long getTelefono() {
        return telefono;
    }

    public int getIndiceCuentas(){
        return indiceCuentas;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

}