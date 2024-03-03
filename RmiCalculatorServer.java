import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiCalculatorServer implements RmiCalculatorInterface {

    public RmiCalculatorServer() {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public int divide(int a, int b) throws RemoteException {
        if (b != 0) {
            return a / b;
        } else {
            throw new RemoteException("Cannot divide by zero");
        }
    }

    public static void main(String[] args) {
        try {
            // Créer le serveur RMI
            RmiCalculatorServer server = new RmiCalculatorServer();
            RmiCalculatorInterface stub = (RmiCalculatorInterface) UnicastRemoteObject.exportObject(server, 0);

            // Enregistrement du stub dans le registre RMI
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RmiCalculator", stub);

            System.out.println("Serveur prêt...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
