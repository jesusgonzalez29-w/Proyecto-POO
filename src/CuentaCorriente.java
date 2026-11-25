import java.time.LocalDate;

public class CuentaCorriente extends CuentaBancaria {
    private float comisionPorManejo;
    private float limiteSobregiro;

    public CuentaCorriente(int numeroCuenta, float saldo, LocalDate fechaApertura,Cliente cliente, int nip, float comisionPorManejo) {
        super(numeroCuenta, saldo, fechaApertura, cliente, nip);
        this.comisionPorManejo = comisionPorManejo;
    }

   


    public float getComisionPorManejo() {
        return comisionPorManejo;
    }

    public void setComisionPorManejo(float comisionPorManejo) {
        this.comisionPorManejo = comisionPorManejo;
    }
   


    @Override 
    public String toString(){
        return super.toString()+"\nComision anual por manejo: $"+comisionPorManejo;
                                
    }
}