import java.time.LocalDate;
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
        String opciones = "\n[1] Solicitar apertura de cuenta \n[2]Consultar saldo cuenta \n[3] Realizar transaccion \n [4] Historial de transacciones\n[5] Solicitar credito \n[6] Abonar tarjeta de credito \n[7] Cancelar cuenta \n[8] Salir";
        String texto = "Menu clientes \n" +opciones;

        do{
             opc = Validacion.validaInt(texto);
            if(opc < 1 || opc > 8)
                JOptionPane.showMessageDialog(null, "Valor no valido, intente de nuevo");
        }while(opc < 1 || opc > 8);

        switch(opc){


            case 1:
                aperturaCuenta(banco);
                break;
            case 2:
                if(!Validacion.nuevoCliente(banco))
                    consultarCuenta(banco);
                else
                    JOptionPane.showMessageDialog(null, "No tienes cuentas abiertas");
                break;

            case 3:
                if(!Validacion.nuevoCliente(banco))
                    realizarTransaccion(banco);
                  else
                    JOptionPane.showMessageDialog(null, "No tienes cuentas abiertas");
                break;

            case 4:
                if(!Validacion.nuevoCliente(banco))
                    consultarTransacciones(banco);
                else
                    JOptionPane.showMessageDialog(null, "No tienes cuentas abiertas");
                break;

            case 5:
                break;

            case 6:
                
                break;
            case 7:
                break;

            case 8:
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

    public void aperturaCuenta(Banco banco){

        int maxOpc = 1;
        int opc = 0;
        int min = 100000;
        int max = 500000;
        int numeroCuenta;
        String opciones = "[1] Crear cuenta corriente";
     
        if(!Validacion.nuevoCliente(banco) && Validacion.validarPuntaje(banco)){
            opciones+="\n[2] Crear cuenta de ahorro";
            maxOpc = 2;
        }
            
        String texto = "Apertura de cuentas\n" + opciones;
        do{
            opc = Validacion.validaInt(texto);
            if(opc < 1 || opc > maxOpc)
                JOptionPane.showMessageDialog(null, "Opcion no valida ");
        }while(opc<1 || opc>maxOpc); 

        Usuario usuario = banco.getUsuarioActual();
        switch(opc){

            case 1:
                CuentaCorriente cuenta = null;
                numeroCuenta = (int) (Math.random() * (max - min + 1)) + min;
                int nip = Validacion.validaLongitudNIP(Validacion.validaInt("Ingresar NIP de 4 digitos \nEste NIP sera utilizado para gestionar los movimientos de la cuenta"));
                LocalDate fecha = LocalDate.now();
                if(!Validacion.validarPuntaje(banco))
                    //clientes que no cumplan con el minimo de 650 de puntaje crediticio, sin limite de sobregiro y con comision por manejo de $1000 anuales
                    cuenta = ((Cliente)usuario).crearCuentaCorriente(numeroCuenta,0,fecha,((Cliente)usuario),nip,1000);
                else
                    cuenta =((Cliente)usuario).crearCuentaCorriente(numeroCuenta,0,fecha,((Cliente)usuario),nip,0); 
                JOptionPane.showMessageDialog(null, "Cuenta corriente creada\n"+cuenta);
                banco.agregarCuenta(cuenta);
                break; 

            case 2:
                ((Cliente)usuario).crearCuentaAhorro();
                
            


        }
       
    }

    public void consultarCuenta(Banco banco){

        Usuario usuario = banco.getUsuarioActual();
        int indice = 0;
        
        do{
            String cuentas = "Cuentas\n"+ ((Cliente)usuario).getCuentasC();
            indice = Validacion.validaInt(cuentas);
        }while(indice < 1 || indice >((Cliente)usuario).getIndiceCuentas());
        if(((Cliente)usuario).coincideNIP(Validacion.validaInt("Ingresar NIP"),indice-1)){
            String texto = ((Cliente)usuario).consultarCuenta(indice-1);
            JOptionPane.showMessageDialog(null,  "Consulta"+texto);
        }
        else{
            JOptionPane.showMessageDialog(null, "NIP incorrecto");
        }
       

    }

    public void depositar(Banco banco){
        Usuario usuario = banco.getUsuarioActual();
        int indice = 0;
        do{
            String cuentas = "Cuentas a depositar\n"+ ((Cliente)usuario).getCuentasC();
            indice = Validacion.validaInt(cuentas);
        }while(indice < 1 || indice > ((Cliente)usuario).getIndiceCuentas());
        
        if(((Cliente)usuario).coincideNIP(Validacion.validaInt("Ingresar NIP"),indice-1)){
            float cantidad = Validacion.validaFloat("Insertar Cantidad a depositar");
            ((Cliente)usuario).depositar(cantidad, indice-1);
        }else
            JOptionPane.showMessageDialog(null,"NIP incorrecto");
           
    }

    public void retirar(Banco banco){
        Usuario usuario = banco.getUsuarioActual();
        int indice = 0; 
        do{
            String cuentas = "Cuentas para retiro\n"+ ((Cliente)usuario).getCuentasC();
            indice = Validacion.validaInt(cuentas);
        }while(indice < 1 || indice> ((Cliente)usuario).getIndiceCuentas());
        
        if(((Cliente)usuario).coincideNIP(Validacion.validaInt("Ingresar NIP"),indice-1)){
            float cantidad = Validacion.validaFloat("Insertar Cantidad a retirar");
            if(cantidad < 1){
                JOptionPane.showMessageDialog(null, "Cantidad no valida");
                return;
            }
            if( ((Cliente)usuario).getSaldoCuentaEspecifica(indice-1) >= cantidad){
                JOptionPane.showMessageDialog(null, "Se retira la cantidad de " + cantidad 
                                              +"\nEl saldo de la cuenta tras el movimiento es de: "
                                              +(((Cliente)usuario).getSaldoCuentaEspecifica(indice-1)-cantidad));
                ((Cliente)usuario).retirar(cantidad, indice-1); 
            }
               
            else
                JOptionPane.showMessageDialog(null, "Saldo insuficiente");
        }else
            JOptionPane.showMessageDialog(null,"NIP incorrecto");
    }


    public void realizarTransaccion(Banco banco){
        int opcion = 0;
        String texto = "Transacciones\n"
                        + "[1] Depositar \n[2]Retirar";
       
        do{
             opcion =Validacion.validaInt(texto);
             if(opcion < 1 || opcion > 2)
                JOptionPane.showMessageDialog(null,"Numero no valido, vuelve a ingresar opcion");
        }while(opcion < 1 || opcion > 2);

        switch(opcion){
            case 1:
                depositar(banco);
                break;
            case 2:
                retirar(banco);
                break;
        }

    }

    public void consultarTransacciones(Banco banco){
        Usuario usuario = banco.getUsuarioActual();
        ((Cliente)usuario).reporteTransacciones();
    }

   
}