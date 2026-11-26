import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class Banco{

    //un unico arreglo polimorfico para clientes y administradores 
    private Usuario [] usuarios; 
    private int indiceUsuarios; 
    private Usuario usuarioActual; 
    private CuentaBancaria [] cuentas;
    private int indiceCuentas; 
    private Credito [] creditos; 
    private int indiceCreditos; 
    private boolean running;

    public Banco(){

       
        usuarios = new Usuario[20];
        indiceUsuarios = 0;  
        cuentas = new CuentaBancaria [30];
        indiceCuentas = 0;
        creditos = new Credito [15];
        indiceCreditos = 0;
        running = true; 


    }


    public void crearAdmin(int idUsuario, String nombre, String correo, String contrasena, int idEmpleado){

        Administrador a = new Administrador(idUsuario, nombre, correo, contrasena, idEmpleado);
        usuarios[indiceUsuarios++] = a; 

    }

    public void crearCliente(int idUsuario, String nombre, String correo, String contrasena, String rfc, long numeroTelefonico){
        Cliente c = new Cliente(idUsuario, nombre, correo, contrasena, rfc, numeroTelefonico);
        usuarios[indiceUsuarios++] = c; 
    }

    public Usuario buscarUsuarioPorCorreo(String correo){

        for(int i=0; i<indiceUsuarios; i++){
            if(usuarios[i].getCorreo().equals(correo))
                return usuarios[i];
        }
        return null;
    }

    public void agregarCuenta(CuentaBancaria cuenta){
        cuentas[indiceCuentas++]=cuenta;
    }

    public void agregarCredito(Credito credito){
        creditos[indiceCreditos++] = credito;
    }




    public void datosPrueba(){

        //id usuario del 1 en adelante. ID del cliente del 1000 en adelante
        crearAdmin(1, "Carlos Huerta", "chuerta@algo.com", "123",1);
        crearCliente(1000, "Axel Suarez", "asuarez@algo.com", "234", "RFC...", 6641231234L);
        crearCliente(1001, "Jared Cruz", "jcruz@algo.com", "0123", "RFC..", 6645656528L);
        crearCliente(1002, "Mario Cruz", "mcruz@algo.com", "111", "RFC..", 6645654321L);



    }


    public Usuario getUsuarioActual(){
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual){
        this.usuarioActual = usuarioActual;
    }

    public void eliminarCuenta(CuentaBancaria cuenta){

        int j = 0;
        CuentaBancaria [] nuevoArreglo = new CuentaBancaria[30];

        for(int i = 0; i<indiceCuentas;i++){
            if(cuentas[i] != cuenta){
                nuevoArreglo[j] = cuentas[i];
                j++;
            }
        }

        indiceCuentas--;
        cuentas = nuevoArreglo;

    }

    public boolean guardarDatos(){
        FileOutputStream flujo; 
		File archivo = new File("Banco.per");
		System.out.println("\n Guardando"); 

		

		try{

			//segundo parametro true agrega, false sobreescribe
			flujo = new FileOutputStream(archivo, false);
			ObjectOutputStream oos = new ObjectOutputStream(flujo);
			oos.writeObject(usuarios);
			oos.writeInt(indiceUsuarios);
			oos.writeObject(cuentas);
			oos.writeInt(indiceCuentas);
            oos.writeObject(creditos);
            oos.writeInt(indiceCreditos);
			//cerrar flujo
			oos.close(); 
			flujo.close();
			return true;


		}catch(Exception e) {
			System.out.println("Error al guardar");
			return false; 
		}

    }


    public void cargarDatos(){

        FileInputStream fisPer = null;

		try{

			//abrir flujo
			fisPer = new FileInputStream("Banco.per");
			ObjectInputStream oisPer = new ObjectInputStream(fisPer);
			//lee objetos
			usuarios = (Usuario[])oisPer.readObject();
			indiceUsuarios = oisPer.readInt();
			cuentas = (CuentaBancaria[])oisPer.readObject();
			indiceCuentas = oisPer.readInt();
            creditos = (Credito[])oisPer.readObject();
            indiceCreditos = oisPer.readInt();
			
			
		}catch(IOException | ClassNotFoundException e){
			System.out.println("\n Error fin de lectura");
		}
		//se ejecutar si o si, siempre.
		finally {
                    try {
                        if (fisPer != null) {
                            fisPer.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


    }

    public void autoSave(){

        Runnable guardar = () ->{

            while(running){
                System.out.println("Guardando...");
                guardarDatos();
                try{
                    Thread.sleep(10000);
                }catch(InterruptedException e){}
            }

        };
        Thread hilo = new Thread(guardar);
        hilo.start();

    }


    public void parar(){
        running = false; 
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public int getIndiceUsuarios() {
        return indiceUsuarios;
    }

    public CuentaBancaria[] getCuentas() {
        return cuentas;
    }

    public int getIndiceCuentas() {
        return indiceCuentas;
    }

    public Credito[] getCreditos() {
        return creditos;
    }

    public int getIndiceCreditos() {
        return indiceCreditos;
    }







}