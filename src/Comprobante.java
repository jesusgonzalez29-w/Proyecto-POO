import java.time.LocalDate;
import java.io.Serializable;
public class Comprobante implements Serializable{
    private int idTransaccion;
    private String tipoTransaccion;
    private float montoTransaccion;
    private LocalDate fechaTransaccion; 
    private int cuentaOrigen;
    

    public Comprobante(String tipoTransaccion, float montoTransaccion, int cuentaOrigen) {
        this.tipoTransaccion = tipoTransaccion;
        this.montoTransaccion = montoTransaccion;
        fechaTransaccion = LocalDate.now();
        this.cuentaOrigen = cuentaOrigen;
    
    }

    public Comprobante(){
    }

    @Override
    public String toString(){
        String texto = "\nTipo transaccion: "+tipoTransaccion +"\nMonto Transaccion: "+montoTransaccion
                +"\nCuenta de origen: "+cuentaOrigen;
        

        return texto;
    }
}