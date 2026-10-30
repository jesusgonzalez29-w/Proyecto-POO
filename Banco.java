public class Banco{

    private Cliente [] clientes; 
    private Administrador [] administradores; 
    private int indiceClientes; 
    private int indiceAdministradores;
    private Usuario usuarioActual; 


    public Banco(){

        clientes = new Cliente[10]; 
        administradores = new Administrador[10];
        indiceAdministradores = 0; 
        indiceClientes = 0; 


    }


    public void crearAdmin(int idUsuario, String nombre, String correo, String contrasena, int idEmpleado){

        Administrador a = Administrador(idUsuario, nombre, correo, contrasena, idEmpleado);
        administradores[indiceAdministradores++] = a; 

    }

    public void crearCliente(int idUsuario, String nombre, String correo, String contrasena, String rfc, int numeroTelefonico){
        Cliente c = Cliente(idUsuario, nombre, correo, contrasena, rfc, numeroTelefonico);
        clientes[indiceClientes++] = c; 
    }




    public void datosPrueba(){

        //id usuario del 1 en adelante. ID del cliente del 1000 en adelante
        crearAdmin(1, "Carlos Huerta", "chuerta@algo.com", "123",1);
        crearCliente(1000, "Axel Suarez", "asuarez@algo.com", "234", "RFC...", 6641231234);



    }



    //devuelve 0 si es cliente, 1 si es admin y -1 si no fue posible iniciar sesion
    public int validarLogin(String correo, String contrasena){

        for(int i = 0; i < indiceAdministradores; i++){

            if(administradores[i].getCorreo().equals(correo) && administradores[i].getContrasena().equals(contrasena)){
                usuarioActual = administradores[i];
                return 1;
            }
        }

        for(int i = 0; i< indiceClientes; i++){

            if(clientes[i].getCorreo().equals(correo) && clientes[i].getContrasena().equals(contrasena)){
                usuarioActual = clientes[i];
                return 0;
            }

        return -1; 


        }


    }

    public Cliente getUsuarioActual(){
        return UsuarioActual;
    }












}