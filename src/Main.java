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

        int bandera = Validacion.validaUsuario(banco, correo, contrasena);
        if(bandera != -1)
        {
            JOptionPane.showMessageDialog(null, "Bienvenido "+banco.getUsuarioActual().getNombre());
            return bandera;
        }
            
        return -1; 



    }




    public void implementacionLogin(){

        int bandera = login();
        //METODOS MENUS CAMBIAN LA BANDERA A 1, CUANDO LA BANDERA CAMBIA A 1, FIN DEL PROGRAMA 
        int banderaMenu = 0; 

        if(bandera == -1){
            JOptionPane.showMessageDialog(null, "El correo o la contrasena no coinciden");
            return;
        }
             
       
        while(banderaMenu == 0){


            if(bandera == 0)
                //PENDIENTE: HACER MENU PARA MOSTRAR A CLIENTES
                banderaMenu = menuClientes();
            else
                //PENDIENTE: HACER MENU PARA MOSTRAR A ADMIN
                banderaMenu = menuAdmin();


        }

    }

    public int menuClientes(){
        return 1;
    }



    public int menuAdmin(){
        return 1;
    }
}