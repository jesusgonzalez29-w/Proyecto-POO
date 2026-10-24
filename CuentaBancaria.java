import java.util.Date;

public class CuentaBancaria {
    private int numeroCuenta;
    private float saldo;
    private Date fechaApertura;

    public CuentaBancaria(int numeroCuenta, float saldo, Date fechaApertura) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }

    public void depositar(float cantidad) {
        this.saldo += cantidad;
        System.out.println("Depósito exitoso. Nuevo saldo: " + this.saldo);
    }

    public void retirar(float cantidad) {
        this.saldo -= cantidad;
        System.out.println("Retiro procesado. Saldo restante: " + this.saldo);
    }

    public float consultarSaldo() {
        return this.saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
}