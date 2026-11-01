import java.util.Date;

public class Credito {
    private int idSolicitud;
    private float montoSolicitado;
    private int plazoMeses;
    private String estado;
    private TarjetaCredito tarjeta; 


    public Credito(int idSolicitud, float montoSolicitado, int plazoMeses, String estado) {
        this.idSolicitud = idSolicitud;
        this.montoSolicitado = montoSolicitado;
        this.plazoMeses = plazoMeses;
        this.estado = estado;
    }

    public void evaluarElegibilidad() {
        System.out.println("Evaluando elegibilidad para el crédito #" + idSolicitud + " por $" + montoSolicitado);
        this.estado = "En revisión";
        System.out.println("Estado actual: " + this.estado);
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public float getMontoSolicitado() {
        return montoSolicitado;
    }

    public void setMontoSolicitado(float montoSolicitado) {
        this.montoSolicitado = montoSolicitado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTarjetaCredito(int numeroTarjeta, int limiteCredito, float saldoDeudor, Date fechaCorte){
       tarjeta = new TarjetaCredito(numeroTarjeta,limiteCredito,saldoDeudor,fechaCorte);
    }

    //clase anidada, ya que tarjeta de credito es un producto asociado al credito solicitado pro el cliente
    public class TarjetaCredito{

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



}