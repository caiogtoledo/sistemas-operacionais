// import sun.misc.Signal;

public class App {
    public static void main(String[] args) throws Exception {
        Account account = new Account(1000);
        Client clients[] = {
            new Client(account, "Caio Toledo"),
            new Client(account, "Caio Rabi"),
            new Client(account, "Carol Perez"),
            new Client(account, "Guilherme Banza"),
        };
        
        // Signal.handle(new Signal("INT"), // CTRL+C
        //     (Signal signal) ‐> {
        //         System.out.println("Terminando a simulação...");
        //         for (Customer customer : customers) {
        //             customer.interrupt();
        //         }
        //     });
        for (Client client : clients) {
            client.start();
        }
    }
}
