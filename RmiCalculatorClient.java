import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RmiCalculatorClient {

    public static void main(String[] args) {
        try {
            // Obtenez le registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Obtenez le stub de l'interface RMI
            RmiCalculatorInterface calculator = (RmiCalculatorInterface) registry.lookup("RmiCalculator");

            // Boucle d'interaction avec l'utilisateur
            Scanner scanner = new Scanner(System.in);
            boolean continueExecution = true;

            while (continueExecution) {
                System.out.print("Code de l'opération (1: add, 2: subtract, 3: multiply, 4: divide): ");
                int operationCode = scanner.nextInt();

                System.out.print("Premier opérande: ");
                int operand1 = scanner.nextInt();

                System.out.print("Deuxième opérande: ");
                int operand2 = scanner.nextInt();

                int result;

                // Appel de la méthode appropriée en fonction du code d'opération
                switch (operationCode) {
                    case 1:
                        result = calculator.add(operand1, operand2);
                        break;
                    case 2:
                        result = calculator.subtract(operand1, operand2);
                        break;
                    case 3:
                        result = calculator.multiply(operand1, operand2);
                        break;
                    case 4:
                        result = calculator.divide(operand1, operand2);
                        break;
                    default:
                        System.out.println("Code d'opération invalide.");
                        continue;
                }

                System.out.println("Résultat: " + result);

                // Demande à l'utilisateur s'il veut continuer
                System.out.print("Voulez-vous arrêter l'exécution? (true/false): ");
                continueExecution = !scanner.nextBoolean();
            }

            System.out.println("Client terminé.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
