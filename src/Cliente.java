import java.time.LocalDate;
public class Cliente extends Usuario {
    private String rfc;
    //long, ya que int no permite todo el rango de numeros telefonicos de 10 digitos
    private long telefono;
    private CuentaBancaria[] cuentas;
    private int indiceCuentas; 
    private Credito [] creditos; 
    private int indiceCreditos;
    private int puntaje; 

    // Constructor de clase hija, llamando primero a clase padre
    public Cliente(int idUsuario, String nombre, String correo, String contrasena, String rfc, long telefono) {
        super(idUsuario, nombre, correo, contrasena); // Obligatorio: invoca al constructor del padre
        this.rfc = rfc;
        cuentas = new CuentaBancaria[5];
        creditos = new Credito[5];
        indiceCreditos = 0;
        indiceCuentas = 0;
        this.telefono = telefono;
        puntaje = 0;
        
    }

    public void solicitarCredito() {
        // Al heredar, puede usar los métodos públicos del padre como getNombre()
        System.out.println("Solicitando credito a nombre de " + getNombre());
    }

    

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    } 

    public long getTelefono() {
        return telefono;
    }

    public int getIndiceCuentas(){
        return indiceCuentas;
    }

    public int getPuntaje(){
        return puntaje;
    }

    public int getIndiceCreditos(){
        return indiceCreditos;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public CuentaCorriente crearCuentaCorriente(int numeroCuenta, float saldo, LocalDate fechaApertura, Cliente cliente, int nip, float comisionPorManejo){
        CuentaCorriente cuenta = new CuentaCorriente(numeroCuenta, saldo, fechaApertura, cliente, nip, comisionPorManejo);
        cuentas[indiceCuentas++] = cuenta; 
        return cuenta;
    }

    public void crearCuentaAhorro(){

    }

    public float getSaldoCuentaEspecifica(int indice){
        return cuentas[indice].getSaldo();
    }

    public int getNumeroCuentaEspecifica(int indice){
        return cuentas[indice].getNumeroCuenta();
    }

    public String getCuentasC(){

        String listaCuentas = "";
        String tipoCuenta = "";

        for(int i = 0; i<indiceCuentas; i++){
            if(cuentas[i] instanceof CuentaCorriente)
                tipoCuenta = "Cuenta corriente";
            else
                tipoCuenta = "Cuenta de ahorro";
            listaCuentas += tipoCuenta+ "["+(i+1)+"]: " +cuentas[i].getNumeroCuenta()+"\n";
        }
        return listaCuentas;
    }

    public String consultarCuenta(int indice){
        return "\nNumero de cuenta: "+cuentas[indice].getNumeroCuenta()
                +"\nTitular: "+nombre
                +"\n Saldo cuenta: $" + cuentas[indice].getSaldo();
               
                
    } 

    public boolean coincideNIP(int NIP, int indice)
    {
        boolean estado = false;
        if(cuentas[indice].getNip() == NIP)
            estado = true;
        return estado; 
    }

    public void aumentarPuntaje(int cantidad){
        puntaje += cantidad;
    }

    public void depositar(float cantidad, int indice){
        cuentas[indice].depositar(cantidad);
    }

    public void retirar(float cantidad, int indice){
        cuentas[indice].retirar(cantidad);
    }

    public void reporteTransacciones(){

      
        Runnable reporte = ()->{
            System.out.println("\n---------Historial de transacciones por cuenta---------\n\n");
            for(int i = 0; i<indiceCuentas; i++){
                System.out.println("\nCuenta ["+(i+1)+"]: "+cuentas[i].getNumeroCuenta()+"\n");
                cuentas[i].mostrarComprobantes();
                try{
                Thread.sleep(1000);
                }catch(InterruptedException e){}

            }
        };
        Thread hilo = new Thread(reporte);
        hilo.start();
    }

    public Credito solicitarCredito(int idSolicitud, float monto, int plazo){
        Credito credito = new Credito(idSolicitud, monto, plazo);
        creditos[indiceCreditos++] = credito;
        return credito;
    }

    public String getCreditosC(){
        String texto = "";
        for(int i = 0; i<indiceCreditos; i++){
            texto+= "\nCredito ["+(i+1)+"] \n" + creditos[i].toString();
        }

        return texto;
    }


    public CuentaBancaria cancelarCuenta(int indice){
        if(cuentas[indice].getSaldo() > 0)
            return null;

        CuentaBancaria eliminado = cuentas[indice];
        cuentas[indice] = null; 
        CuentaBancaria []arregloNuevo = new CuentaBancaria[5];
        int j = 0;

        for(int i = 0; i<indiceCuentas; i++){
            if(cuentas[i] != null){
                arregloNuevo[j] = cuentas[i];
                j++;
            }
        }
        cuentas = arregloNuevo; 
        indiceCuentas--; 
        return eliminado;
    }




}