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

        int banderaTipoUsuario = login();
        //METODOS MENUS CAMBIAN LA BANDERA A 1, CUANDO LA BANDERA CAMBIA A 1, FIN DEL PROGRAMA 
        int banderaMenu = 0; 

        if(banderaTipoUsuario == -1){
            JOptionPane.showMessageDialog(null, "El correo o la contrasena no coinciden");
            return;
        }
             
       
        while(banderaMenu == 0){


            if(banderaTipoUsuario == 0)
                //PENDIENTE: HACER MENU PARA MOSTRAR A CLIENTES
                banderaMenu = menuClientes();
            else
                //PENDIENTE: HACER MENU PARA MOSTRAR A ADMIN
                banderaMenu = menuAdmin();


        }

    }

    public int menuClientes(){

        int bandera = 0;
        int opc = 0; 
        String opciones = "\n[1] Solicitar apertura de cuenta \n[2]Solicitar saldo cuenta \n[3] Realizar transaccion \n[4] Solicitar credito \n[5] Abonar tarjeta de credito \n[6] Cancelar cuenta \n[6] Salir";
        String texto = "Menu clientes \n" +opciones;

        do{
             opc = Validacion.validaInt(texto);
            if(opc < 1 || opc > 7)
                JOptionPane.showMessageDialog(null, "Valor no valido, intente de nuevo");
        }while(opc < 1 || opc > 7);

        switch(opc){


            case 1:
                break;
            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                bandera = 1;
                JOptionPane.showMessageDialog(null, "Saliendo...");
                break;




        }



        return bandera;
    }

    public int menuAdmin(){
        int bandera = 0;
        int opc = 0; 
        String opciones = "\n[1] Consultar historial cliente \n[2]Aprobar creditos \n[3] Salir";
        String texto = "Menu administrador \n" +opciones;

        do{
             opc = Validacion.validaInt(texto);
            if(opc < 1 || opc > 3)
                JOptionPane.showMessageDialog(null, "Valor no valido, intente de nuevo");
        }while(opc < 1 || opc > 3);

        switch(opc){


            case 1:
                break;
            case 2:
                break;

            case 3:
                bandera = 1;
                JOptionPane.showMessageDialog(null, "Saliendo...");
                break;




        }



        return bandera;
    }



   
}