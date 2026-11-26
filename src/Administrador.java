import java.util.Date;
public class Administrador extends Usuario {
    private int idEmpleado;

    public Administrador(int idUsuario, String nombre, String correo, String contrasena, int idEmpleado) {
        super(idUsuario, nombre, correo, contrasena);
        this.idEmpleado = idEmpleado;
    }

    public void aprobarCreditos(Credito credito, boolean aprobar) {
        if (aprobar) {
            credito.setEstado("Aprobado");
            int numTarjeta = (int) (Math.random() * (999999 - 100000 + 1)) + 100000;
            int limite = (int) credito.getMontoSolicitado();
            // Se activa la clase anidada TarjetaCredito con saldo deudor inicial igual al monto aprobado
            credito.setTarjetaCredito(numTarjeta, limite, credito.getMontoSolicitado(), new Date());
        } else {
            credito.setEstado("Rechazado");
        }
    }

    public String consultarHistorialCliente(Cliente cliente) {
        return cliente.getHistorialCompleto();
    }

    public int aplicarInteresCuentasAhorro(Banco banco) {
        int actualizadas = 0;
        CuentaBancaria[] cuentas = banco.getCuentas();
        for (int i = 0; i < banco.getIndiceCuentas(); i++) {
            // Polimorfismo: solo aplica a las instancias de CuentaAhorro
            if (cuentas[i] instanceof CuentaAhorro) {
                ((CuentaAhorro) cuentas[i]).aplicarInteres();
                actualizadas++;
            }
        }
        return actualizadas;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}