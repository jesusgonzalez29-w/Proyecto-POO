import java.util.Date;

public class CuentaCorriente extends CuentaBancaria {
    private float comisionPorManejo;
    private float limiteSobregiro;

    public CuentaCorriente(int numeroCuenta, float saldo, Date fechaApertura, float comisionPorManejo, float limiteSobregiro) {
        super(numeroCuenta, saldo, fechaApertura);
        this.comisionPorManejo = comisionPorManejo;
        this.limiteSobregiro = limiteSobregiro;
    }

    public void aplicarInteres() {
        System.out.println("Aplicando intereses sobre el sobregiro...");
    }

    @Override
    public void retirar(float cantidad) {
        // La etiqueta @Override indica que reescribimos el método del padre
        System.out.println("Evaluando límite de sobregiro de " + limiteSobregiro + " antes del retiro...");
    }

    public float getComisionPorManejo() {
        return comisionPorManejo;
    }

    public void setComisionPorManejo(float comisionPorManejo) {
        this.comisionPorManejo = comisionPorManejo;
    }
}