import java.time.LocalDate;
public class CuentaAhorro extends CuentaBancaria {
    private float tasaInteresMensual;

    public CuentaAhorro(int numeroCuenta, float saldo, LocalDate fechaApertura, float tasaInteresMensual,Cliente cliente, int nip) {
        super(numeroCuenta, saldo, fechaApertura, cliente, nip); // Llama al constructor padre
        this.tasaInteresMensual = tasaInteresMensual;
    }

    public void aplicarInteres() {
        
    }
   

}