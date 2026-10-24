import java.util.Date;

public class TarjetaCredito extends CuentaBancaria {
    private int numeroTarjeta;
    private int limiteCredito;
    private float saldoDeudor;
    private Date fechaCorte;

    public TarjetaCredito(int numeroCuenta, float saldo, Date fechaApertura, int numeroTarjeta, int limiteCredito, float saldoDeudor, Date fechaCorte) {
        super(numeroCuenta, saldo, fechaApertura);
        this.numeroTarjeta = numeroTarjeta;
        this.limiteCredito = limiteCredito;
        this.saldoDeudor = saldoDeudor;
        this.fechaCorte = fechaCorte;
    }

    public void realizarCompra(float monto) {
        System.out.println("Compra procesada por: " + monto);
    }

    public void pagarTarjeta(float monto) {
        System.out.println("Abono a saldo deudor por: " + monto);
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(int limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public float getSaldoDeudor() {
        return saldoDeudor;
    }

    public void setSaldoDeudor(float saldoDeudor) {
        this.saldoDeudor = saldoDeudor;
    }
    
    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }
}