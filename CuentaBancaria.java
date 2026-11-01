import java.util.Date;

public class CuentaBancaria implements Transacciones {
    protected int numeroCuenta;
    protected float saldo;
    protected Date fechaApertura;
    protected Cliente cliente;

    public CuentaBancaria(int numeroCuenta, float saldo, Date fechaApertura) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
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

    public void setCliente(Cliente cliente){
        this.cliente = cliente; 
    }

    public void getCliente(){
        return cliente;
    }


    
    @Override
    public void depositar(float cantidad) {
        this.saldo += cantidad;
        System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
    }

    @Override
    public void retirar(float cantidad) {
        this.saldo -= cantidad;
        System.out.println("Retiro procesado. Saldo restante: " +saldo);
    }
}