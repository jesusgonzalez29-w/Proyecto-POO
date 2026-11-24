public class Banco{

    //un unico arreglo polimorfico para clientes y administradores 
    private Usuario [] usuarios; 
    private int indiceUsuarios; 
    private Usuario usuarioActual; 


    public Banco(){

       
        usuarios = new Usuario[20];
        indiceUsuarios = 0;  
    
        


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




    public void datosPrueba(){

        //id usuario del 1 en adelante. ID del cliente del 1000 en adelante
        crearAdmin(1, "Carlos Huerta", "chuerta@algo.com", "123",1);
        crearCliente(1000, "Axel Suarez", "asuarez@algo.com", "234", "RFC...", 6641231234L);
        crearCliente(1001, "Jared Cruz", "jcruz@algo.com", "0123", "RFC..", 6645656528L);



    }


    public Usuario getUsuarioActual(){
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual){
        this.usuarioActual = usuarioActual;
    }












}