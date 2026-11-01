import java.util.Date;

public class CuentaAhorro extends CuentaBancaria {
    private float tasaInteresMensual;

    public CuentaAhorro(int numeroCuenta, float saldo, Date fechaApertura, float tasaInteresMensual) {
        super(numeroCuenta, saldo, fechaApertura); // Llama al constructor padre
        this.tasaInteresMensual = tasaInteresMensual;
    }

    public void aplicarInteres() {
        
    }
}