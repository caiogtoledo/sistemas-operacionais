import java.util.Random;

public class Client extends Thread{
    private Account account;
    private String name;

    Buffer buffer;
    private int values[] = {10, 20, 50, 100};

    public Client(Account account, String name) {
        this.setAccount(account);
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getClientName() {
        return name;
    }

    public void execute() throws InterruptedException{
        Random random1 = new Random();
        int choice = random1.nextInt(1000);
        Random random2 = new Random();
        int randomIndex = random2.nextInt(4);

        if(choice % 2 == 0){
            account.deposit(values[randomIndex], name);
        }else{
            account.withdraw(values[randomIndex], name);
        }
     
    }

    @Override
	public void run() {
		try {
			// Tenta consumir um número inteiro
			while (true) {
                execute();
				// Dorme 200 ms
				Thread.sleep(1000);
				// Ou comente a linha anterior e
				// descomente a linha de baixo
				// e dê a chance para outra thread
				// Thread.yield();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
