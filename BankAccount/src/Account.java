// import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Account {
    private int balance;
    // Buffer buffer;

    // Variável de lock para acessar a fila compartilhada
	private final Lock lock = new ReentrantLock();

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public void deposit(int value, String name) throws InterruptedException{
        lock.lock();
        try{
            this.balance += value;
            System.out.println("Cliente: "+ name + " depositou " + value);
            System.out.println("Conta: saldo atualizado de "+this.balance);
        }finally{
            lock.unlock();
        }
    }

    public void withdraw(int value, String name) throws InterruptedException{
        if(this.balance > value){
            // criar variavel que causa o await()
            this.balance -= value;
            System.out.println("Cliente: "+ name + " retirou " + value);
            System.out.println("Conta: saldo atualizado de "+this.balance);
        }else{
            System.out.println("Saldo insuficiente");
            System.out.println("Conta: saldo atualizado de "+this.balance);
        }
    }
}
