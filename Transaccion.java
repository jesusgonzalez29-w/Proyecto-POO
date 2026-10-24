public class Transaccion {
    private int idTransaccion;
    private String tipoTransaccion;
    private float montoTransaccion;
    private int cuentaOrigen;
    private int cuentaDestino;

    public Transaccion(int idTransaccion, String tipoTransaccion, float montoTransaccion, int cuentaOrigen, int cuentaDestino) {
        this.idTransaccion = idTransaccion;
        this.tipoTransaccion = tipoTransaccion;
        this.montoTransaccion = montoTransaccion;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
    }

    public void generarComprobante() {
        System.out.println("--- COMPROBANTE DE TRANSACCIÓN ---");
        System.out.println("ID: " + idTransaccion + " | Tipo: " + tipoTransaccion);
        System.out.println("Monto: $" + montoTransaccion);
        System.out.println("Origen: " + cuentaOrigen + " | Destino: " + cuentaDestino);
    }
}