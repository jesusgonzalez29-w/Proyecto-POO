import java.time.LocalDate;

public class CuentaBancaria implements Transacciones {
    protected int numeroCuenta;
    protected float saldo;
    protected LocalDate fechaApertura;
    protected Cliente cliente;
    protected int nip; 

    public CuentaBancaria(int numeroCuenta, float saldo, LocalDate fechaApertura, Cliente cliente, int nip) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.cliente = cliente;
        this.nip = nip;
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

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente; 
    }

    public Cliente getCliente(){
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

    @Override
    public String toString(){
        return "# de cuenta: "+numeroCuenta + "\nSaldo: "+saldo
                +"\nFecha de apertura: "+fechaApertura + "\nCliente: "+cliente.getNombre()
                +"\nNIP: "+ nip;
    }
}