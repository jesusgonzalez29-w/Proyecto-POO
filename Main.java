import java.util.Date;

public class Main {
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
}