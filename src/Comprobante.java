import java.time.LocalDate;
public class Comprobante {
    private int idTransaccion;
    private String tipoTransaccion;
    private float montoTransaccion;
    private LocalDate fechaTransaccion; 
    private int cuentaOrigen;
    private int cuentaDestino = 0;

    public Comprobante(String tipoTransaccion, float montoTransaccion, int cuentaOrigen) {
        this.tipoTransaccion = tipoTransaccion;
        this.montoTransaccion = montoTransaccion;
        fechaTransaccion = LocalDate.now();
        this.cuentaOrigen = cuentaOrigen;
        //this.cuentaDestino = cuentaDestino;
    }

    public Comprobante(){
    }

    @Override
    public String toString(){
        String texto = "\nTipo transaccion: "+tipoTransaccion +"\nMonto Transaccion: "+montoTransaccion
                +"\nCuenta de origen: "+cuentaOrigen;
        if(cuentaDestino != 0)
            texto+="\nCuenta destino: "+cuentaDestino;

        return texto;
    }
}