import java.util.Date;

public class CuentaCorriente extends CuentaBancaria {
    private float comisionPorManejo;
    private float limiteSobregiro;

    public CuentaCorriente(int numeroCuenta, float saldo, Date fechaApertura, float comisionPorManejo, float limiteSobregiro) {
        super(numeroCuenta, saldo, fechaApertura);
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
}