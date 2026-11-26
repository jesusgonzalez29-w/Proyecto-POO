import java.time.LocalDate;
public class CuentaAhorro extends CuentaBancaria {
    private float tasaInteresMensual;

    public CuentaAhorro(int numeroCuenta, float saldo, LocalDate fechaApertura, float tasaInteresMensual,Cliente cliente, int nip) {
        super(numeroCuenta, saldo, fechaApertura, cliente, nip); // Llama al constructor padre
        this.tasaInteresMensual = tasaInteresMensual;
    }

    public void aplicarInteres() {
        float interes = saldo * tasaInteresMensual;
        if (interes > 0) {
            saldo += interes;
            comprobantes[indiceComprobantes++] = new Comprobante("Interes mensual", interes, numeroCuenta);
        }
    }

    public float getTasaInteresMensual() {
        return tasaInteresMensual;
    }
   

}