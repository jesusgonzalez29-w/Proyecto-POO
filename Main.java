import java.util.Date;
import javax.swing.JOptionPane;

public class Main {

    Banco banco; 


    public static void main(String[] args) {
        // Instanciamos un objeto Cliente
        Cliente cliente1 = new Cliente(1, "Mario", "mario@algo.com", "pass123", "RFC12345", 6641234, "CuentaAhorro");

        // Instanciamos un objeto CuentaAhorro
        CuentaAhorro cuenta1 = new CuentaAhorro(987654, 5000.0f, new Date(), 0.05f);

        // Probamos los métodos del cliente
        System.out.println("--- OPERACIONES DEL CLIENTE ---");
        cliente1.iniciarSesion();
        cliente1.solicitarCredito();

        // Probamos los métodos de la cuenta
        System.out.println("\n--- MOVIMIENTOS BANCARIOS ---");
        System.out.println("Saldo inicial: $" + cuenta1.consultarSaldo());
        cuenta1.depositar(1500.0f);
        cuenta1.retirar(300.0f);
        cuenta1.aplicarInteres();
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