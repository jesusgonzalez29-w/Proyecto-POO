import java.time.LocalDate;

public class CuentaCorriente extends CuentaBancaria {
    private float comisionPorManejo;
    private float limiteSobregiro;

    public CuentaCorriente(int numeroCuenta, float saldo, LocalDate fechaApertura,Cliente cliente, int nip, float comisionPorManejo, float limiteSobregiro) {
        super(numeroCuenta, saldo, fechaApertura, cliente, nip);
        this.comisionPorManejo = comisionPorManejo;
        this.limiteSobregiro = limiteSobregiro;
    }

    public void setLimiteSobregiro(float limiteSobregiro){
        this.limiteSobregiro = limiteSobregiro;
    }

    public float getLimiteSobregiro(){
        return limiteSobregiro;
    }


    public float getComisionPorManejo() {
        return comisionPorManejo;
    }

    public void setComisionPorManejo(float comisionPorManejo) {
        this.comisionPorManejo = comisionPorManejo;
    }

    @Override 
    public String toString(){
        return super.toString()+"\nComision anual por manejo: $"+comisionPorManejo
                                +"\nLimite de sobregiro: $"+limiteSobregiro;
    }
}