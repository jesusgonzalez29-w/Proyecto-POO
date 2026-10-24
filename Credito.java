public class Credito {
    private int idSolicitud;
    private float montoSolicitado;
    private int plazoMeses;
    private String estado;

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
}