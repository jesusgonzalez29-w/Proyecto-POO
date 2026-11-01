import java.util.Date;
import javax.swing.JOptionPane;

public class Main {

    Banco banco; 


    public static void main(String[] args) {
       
        Main principal  = new Main();
    }


    public Main(){

        banco = new Banco();
        banco.datosPrueba();
        implementacionLogin();

    }





    public int login(){

        String correo = JOptionPane.showInputDialog("Ingresa correo: ");
        String contrasena = JOptionPane.showInputDialog("Ingresa contrasena: ");
        
        int bandera = banco.validarLogin(); 

        if(bandera != -1)
            JOptionPane.showMessageDialog(null, "Bienvenido "+banco.getUsuarioActual().getNombre());

        return -1; 



    }




    public int implementacionLogin(){

        int bandera = login();
        //METODOS MENUS CAMBIAN LA BANDERA A 1, CUANDO LA BANDERA CAMBIA A 1, FIN DEL PROGRAMA 
        int banderaMenu = 0; 

        if(bandera == -1)
            JOptionPane.showMessageDialog(null, "Inicio de sesion denegado"); 
       
        while(banderaMenu == 0){


            if(bandera == 0)
                //PENDIENTE: HACER MENU PARA MOSTRAR A CLIENTES
                banderaMenu = menuClientes();
            else
                //PENDIENTE: HACER MENU PARA MOSTRAR A ADMIN
                banderaMenu = menuAdmin();


        }




    }
}