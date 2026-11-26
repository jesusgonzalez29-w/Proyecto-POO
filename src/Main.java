import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Main {

    Banco banco; 


    public static void main(String[] args) {
       
        Main principal  = new Main();
    }


   public Main() {
        banco = new Banco();
        banco.cargarDatos();
        if (banco.getIndiceUsuarios() == 0) {
            banco.datosPrueba();
        }
        banco.autoSave();
        implementacionLogin();
        banco.parar();
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
        String opciones = "\n[1] Solicitar apertura de cuenta \n[2]Consultar saldo cuenta \n" +
        "[3] Realizar transaccion \n[4] Historial de transacciones\n[5] Solicitar credito "+
        "\n[6] Consultar solicitudes de credito\n[7] Abonar tarjeta de credito \n[8] Cancelar cuenta \n[9] Salir";
        String texto = "Menu clientes \n" +opciones;

        do{
             opc = Validacion.validaInt(texto);
            if(opc < 1 || opc > 9)
                JOptionPane.showMessageDialog(null, "Valor no valido, intente de nuevo");
        }while(opc < 1 || opc > 9);

        switch(opc){


            case 1:
                aperturaCuenta(banco);
                break;
            case 2:
                if(!Validacion.nuevoCliente(banco))
                    consultarCuenta(banco);
                else
                    JOptionPane.showMessageDialog(null, "No tienes cuentas bancarias activas");
                break;

            case 3:
                if(!Validacion.nuevoCliente(banco))
                    realizarTransaccion(banco);
                  else
                    JOptionPane.showMessageDialog(null, "No tienes cuentas bancarias activas");
                break;

            case 4:
                if(!Validacion.nuevoCliente(banco))
                    consultarTransacciones(banco);
                else
                    JOptionPane.showMessageDialog(null, "No tienes cuentas bancarias activas");
                break;

            case 5:
                if(!Validacion.nuevoCliente(banco))
                    solicitarCredito(banco);
                else
                     JOptionPane.showMessageDialog(null, "No tienes cuentas bancarias activas");
                break;

            case 6:
                if(!Validacion.nuevoCliente(banco))
                    consultarEstadosCredito(banco);
                else
                    JOptionPane.showMessageDialog(null, "No tienes cuentas bancarias activas");
                break;

            case 7:
                if (!Validacion.nuevoCliente(banco))
                    abonarTarjeta(banco);
                else
                    JOptionPane.showMessageDialog(null, "No tienes cuentas bancarias activas para realizar el abono");
                break;
            case 8:
                if(!Validacion.nuevoCliente(banco))
                    cancelarCuenta(banco);
                else
                    JOptionPane.showMessageDialog(null, "No tienes cuentas bancarias activas");
                break;

            case 9:
                bandera = 1;
                JOptionPane.showMessageDialog(null, "Saliendo...");
                break;



        }



        return bandera;
    }

    public int menuAdmin() {
        int bandera = 0;
        int opc = 0;
        String opciones = "\n[1] Consultar historial cliente"
                        + "\n[2] Aprobar / Rechazar creditos"
                        + "\n[3] Registrar nuevo usuario (Cliente / Admin)"
                        + "\n[4] Aplicar interes mensual a cuentas de ahorro"
                        + "\n[5] Ver reporte general del banco"
                        + "\n[6] Salir";
        String texto = "Menu administrador \n" + opciones;

        do {
            opc = Validacion.validaInt(texto);
            if (opc < 1 || opc > 6)
                JOptionPane.showMessageDialog(null, "Valor no valido, intente de nuevo");
        } while (opc < 1 || opc > 6);

        switch (opc) {
            case 1:
                adminConsultarCliente(banco);
                break;
            case 2:
                adminGestionarCreditos(banco);
                break;
            case 3:
                adminRegistrarUsuario(banco);
                break;
            case 4:
                Administrador admin = (Administrador) banco.getUsuarioActual();
                int total = admin.aplicarInteresCuentasAhorro(banco);
                JOptionPane.showMessageDialog(null, "Interes aplicado a " + total + " cuenta(s) de ahorro.");
                break;
            case 5:
                adminReporteGeneral(banco);
                break;
            case 6:
                bandera = 1;
                JOptionPane.showMessageDialog(null, "Saliendo...");
                break;
        }
        return bandera;
    }

    public void adminConsultarCliente(Banco banco) {
        String correo = JOptionPane.showInputDialog("Ingresa el correo del cliente a consultar:");
        Usuario u = banco.buscarUsuarioPorCorreo(correo);
        if (u != null && u instanceof Cliente) {
            Administrador admin = (Administrador) banco.getUsuarioActual();
            JOptionPane.showMessageDialog(null, admin.consultarHistorialCliente((Cliente) u));
            ((Cliente) u).reporteTransacciones(); // Imprime comprobantes en consola con su hilo
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro un cliente con ese correo.");
        }
    }

    public void adminGestionarCreditos(Banco banco) {
        Credito[] creditos = banco.getCreditos();
        int total = banco.getIndiceCreditos();
        String lista = "Solicitudes de credito:\n";
        boolean hayPendientes = false;

        for (int i = 0; i < total; i++) {
            lista += "[" + (i + 1) + "] " + creditos[i].toString() + "----------------\n";
            if (creditos[i].getEstado().equalsIgnoreCase("Pendiente")) {
                hayPendientes = true;
            }
        }

        if (!hayPendientes) {
            JOptionPane.showMessageDialog(null, "No hay solicitudes de credito pendientes.");
            return;
        }

        int sel = Validacion.validaInt(lista + "\nIngresa el numero de solicitud a evaluar:") - 1;
        if (sel < 0 || sel >= total || !creditos[sel].getEstado().equalsIgnoreCase("Pendiente")) {
            JOptionPane.showMessageDialog(null, "Seleccion invalida o la solicitud ya fue evaluada.");
            return;
        }

        int decision = Validacion.validaInt("Solicitud #" + creditos[sel].getIdSolicitud() + "\n[1] Aprobar y asignar tarjeta\n[2] Rechazar");
        Administrador admin = (Administrador) banco.getUsuarioActual();
        if (decision == 1) {
            admin.aprobarCreditos(creditos[sel], true);
            JOptionPane.showMessageDialog(null, "Credito aprobado y tarjeta generada:\n" + creditos[sel]);
        } else if (decision == 2) {
            admin.aprobarCreditos(creditos[sel], false);
            JOptionPane.showMessageDialog(null, "Solicitud rechazada.");
        }
    }

    public void adminRegistrarUsuario(Banco banco) {
        int tipo = Validacion.validaInt("Registrar nuevo usuario:\n[1] Cliente\n[2] Administrador");
        if (tipo != 1 && tipo != 2) {
            JOptionPane.showMessageDialog(null, "Opcion no valida");
            return;
        }

        String nombre = JOptionPane.showInputDialog("Nombre completo:");
        String correo = JOptionPane.showInputDialog("Correo:");
        if (banco.buscarUsuarioPorCorreo(correo) != null) {
            JOptionPane.showMessageDialog(null, "Ese correo ya esta registrado.");
            return;
        }
        String pass = JOptionPane.showInputDialog("Contrasena:");
        int id = 1000 + banco.getIndiceUsuarios();

        if (tipo == 1) {
            String rfc = JOptionPane.showInputDialog("RFC:");
            long tel = Long.parseLong(JOptionPane.showInputDialog("Telefono (10 digitos):"));
            banco.crearCliente(id, nombre, correo, pass, rfc, tel);
            JOptionPane.showMessageDialog(null, "Cliente registrado con ID: " + id);
        } else {
            int idEmp = Validacion.validaInt("ID de empleado:");
            banco.crearAdmin(id, nombre, correo, pass, idEmp);
            JOptionPane.showMessageDialog(null, "Administrador registrado con ID: " + id);
        }
    }

    public void adminReporteGeneral(Banco banco) {
        int clientes = 0, admins = 0;
        Usuario[] usuarios = banco.getUsuarios();
        for (int i = 0; i < banco.getIndiceUsuarios(); i++) {
            if (usuarios[i] instanceof Cliente) clientes++;
            else if (usuarios[i] instanceof Administrador) admins++;
        }

        String resumen = "--- RESUMEN GENERAL DEL BANCO ---\n"
                       + "Clientes registrados: " + clientes + "\n"
                       + "Administradores: " + admins + "\n"
                       + "Cuentas bancarias activas: " + banco.getIndiceCuentas() + "\n"
                       + "Solicitudes de credito: " + banco.getIndiceCreditos();
        JOptionPane.showMessageDialog(null, resumen);
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
                numeroCuenta = (int) (Math.random() * (max - min + 1)) + min;
                int nipAhorro = Validacion.validaLongitudNIP(Validacion.validaInt("Ingresar NIP de 4 digitos para cuenta de ahorro"));
                float saldoInicial = Validacion.validaFloat("Ingresa el deposito inicial para abrir la cuenta de ahorro:");
                if (saldoInicial < 500) {
                    JOptionPane.showMessageDialog(null, "El monto minimo de apertura es de $500");
                    break;
                }
                // Tasa mensual del 2% (0.02f)
                CuentaAhorro cuentaAhorro = ((Cliente) usuario).crearCuentaAhorro(numeroCuenta, saldoInicial, LocalDate.now(), 0.02f, (Cliente) usuario, nipAhorro);
                banco.agregarCuenta(cuentaAhorro);
                JOptionPane.showMessageDialog(null, "Cuenta de ahorro creada con tasa mensual del 2%\n" + cuentaAhorro);
                break;               
            


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

    public void abonarTarjeta(Banco banco) {
        Cliente cliente = (Cliente) banco.getUsuarioActual();
        if (!cliente.tieneTarjetasActivas()) {
            JOptionPane.showMessageDialog(null, "No cuentas con tarjetas de credito aprobadas");
            return;
        }

        int idxCred = Validacion.validaInt("Selecciona el numero de credito/tarjeta a abonar:\n" + cliente.getTarjetasC()) - 1;
        if (idxCred < 0 || idxCred >= cliente.getIndiceCreditos() || cliente.getCreditoEspecifico(idxCred).getTarjeta() == null) {
            JOptionPane.showMessageDialog(null, "Seleccion no valida");
            return;
        }

        Credito.TarjetaCredito tc = cliente.getCreditoEspecifico(idxCred).getTarjeta();
        if (tc.getSaldoDeudor() <= 0) {
            JOptionPane.showMessageDialog(null, "Esta tarjeta no tiene saldo deudor pendiente");
            return;
        }

        int idxCuenta = Validacion.validaInt("Selecciona la cuenta de cargo:\n" + cliente.getCuentasC()) - 1;
        if (idxCuenta < 0 || idxCuenta >= cliente.getIndiceCuentas()) {
            JOptionPane.showMessageDialog(null, "Cuenta no valida");
            return;
        }

        if (!cliente.coincideNIP(Validacion.validaInt("Ingresa tu NIP:"), idxCuenta)) {
            JOptionPane.showMessageDialog(null, "NIP incorrecto");
            return;
        }

        float abono = Validacion.validaFloat("Saldo deudor actual: $" + tc.getSaldoDeudor() + "\nIngresa cantidad a abonar:");
        if (abono <= 0 || abono > tc.getSaldoDeudor()) {
            JOptionPane.showMessageDialog(null, "Cantidad invalida (debe ser mayor a 0 y menor o igual al saldo deudor)");
            return;
        }

        if (cliente.getSaldoCuentaEspecifica(idxCuenta) < abono) {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente en la cuenta seleccionada");
            return;
        }

        cliente.retirar(abono, idxCuenta);
        tc.setSaldoDeudor(tc.getSaldoDeudor() - abono);
        cliente.aumentarPuntaje((int) (abono * 0.05));
        JOptionPane.showMessageDialog(null, "Abono exitoso.\nNuevo saldo deudor: $" + tc.getSaldoDeudor());
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

    public void solicitarCredito(Banco banco){
        Usuario usuario = banco.getUsuarioActual();
        if(!Validacion.validarPuntaje(banco)){
            JOptionPane.showMessageDialog(null, "Tu puntaje crediticio de "+ ((Cliente)usuario).getPuntaje()
                                                 + " es insuficiente para solicitar un credito \nPuntaje minimo: 650");
            return;
        }

        int min = 1000;
        int max = 5000;
        int idSolicitud = (int)(Math.random() * (max - min + 1)) + min;
        float monto = Validacion.validaFloat("Ingresar el monto solicitado");
        int meses = Validacion.validaInt("Ingresar el plazo a meses a pagar"); 
        Credito credito = ((Cliente)usuario).solicitarCredito(idSolicitud, monto, meses);
        banco.agregarCredito(credito);
        JOptionPane.showMessageDialog(null, "Solicitud creada\n"+credito);

            
        
    }

    public void consultarEstadosCredito(Banco banco){
        Usuario usuario = banco.getUsuarioActual();
        if(((Cliente)usuario).getIndiceCreditos() == 0){
            JOptionPane.showMessageDialog(null, "No ha solicitado creditos");
            return;
        }

       JOptionPane.showMessageDialog(null, "Creditos solicitados \n"+ ((Cliente)usuario).getCreditosC());

    }

    public void cancelarCuenta(Banco banco){
        Usuario usuario = banco.getUsuarioActual();
        int indice = 0; 
        do{
            String cuentas = "Cuentas a cancelar\n"+ ((Cliente)usuario).getCuentasC();
            indice = Validacion.validaInt(cuentas);
        }while(indice < 1 || indice> ((Cliente)usuario).getIndiceCuentas());

        if(((Cliente)usuario).coincideNIP(Validacion.validaInt("Ingresar NIP"),indice-1)){
            CuentaBancaria cuenta = ((Cliente)usuario).cancelarCuenta(indice-1);
            if(cuenta != null){
                banco.eliminarCuenta(cuenta);
                JOptionPane.showMessageDialog(null, "La cuenta "+cuenta.getNumeroCuenta() +" ha sido cancelada");
            }else
                JOptionPane.showMessageDialog(null, "La cuenta aun tiene saldo. Asegurate de retirar todo el efectivo antes de cancelar tu cuenta");
           
        }
            

    }

   
}