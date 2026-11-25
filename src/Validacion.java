import javax.swing.JOptionPane;

public class Validacion{

    public static int validaInt(String mensaje){

        while(true){
            //fragmento de codigo a probar
            try{
                int valor = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                return valor;
            //error que va a evaluar. Si se da el error, el codigo debajo de catch no se ejecuta hasta 
            //que el bloque catch se pueda ejecutar sin error
            //Exception para todas las excepciones posibles
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingresa valor entero valido");


            }
        }
    }


    public static float validaFloat(String mensaje){
        while(true){
            try{
                float valor = Float.parseFloat(JOptionPane.showInputDialog(mensaje));
                return valor;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Ingresa valor valido"); 
            }
        }
    }

    //devuelve 0 si es cliente, 1 si es admin y -1 si no fue posible iniciar sesion

    public static int validaUsuario(Banco banco, String correo, String contrasena){
        Usuario usuario = banco.buscarUsuarioPorCorreo(correo);
        //si existe un usuario con ese correo y si la contraseña coincide
        if(usuario != null && usuario.getContrasena().equals(contrasena)){

            banco.setUsuarioActual(usuario);
            if(usuario instanceof Cliente)
                return 0;
            else
                return 1; 
        }

        return -1;


    }

    public static int validaLongitudNIP(int numero){
        
        
        int div = numero/1000; 
        while(div < 1 || div > 9){
           numero = validaInt("El NIP ingresado no es de 4 digitos, ingresa un numero valido");
           div = numero/1000;
        }
        return numero; 
    }

    public static boolean nuevoCliente(Banco banco){
        boolean ban = false; 
        Usuario usuario = banco.getUsuarioActual();
        if(usuario instanceof Cliente)
            if(((Cliente)usuario).getIndiceCuentas() ==0)
                ban = true; 
        
        
        return ban;
    }

    public static boolean validarPuntaje(Banco banco){
        boolean ban = false; 
        Usuario usuario = banco.getUsuarioActual();

        if(usuario instanceof Cliente)
            if(((Cliente)usuario).getPuntaje() >= 650)
                ban = true; 
        
        return ban;
    }

}