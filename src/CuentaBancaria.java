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


    public float getSaldo() {
        return saldo;
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

    public int getNip(){
        return nip;
    }

     @Override
    public void depositar(float cantidad) {
        saldo+=cantidad;
    }

    @Override
    public void retirar(float cantidad) {
        this.saldo -= cantidad;
        System.out.println("Retiro procesado. Saldo restante: " +saldo);
    }



    
   
    @Override
    public String toString(){
        return "# de cuenta: "+numeroCuenta + "\nSaldo: "+saldo
                +"\nFecha de apertura: "+fechaApertura + "\nTitular: "+cliente.getNombre()
                +"\nNIP: "+ nip;
    }
}