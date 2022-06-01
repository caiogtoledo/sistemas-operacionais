import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int balance;
    // Buffer buffer;

    // Variável de lock para proteger as operações
    private final Lock lock = new ReentrantLock();
    // Variável de condição de saldo insuficiente
    private final Condition noBalance = lock.newCondition();

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int value, String name) throws InterruptedException {
        lock.lock();
        try {
            this.balance += value;
            System.out.println("Cliente: " + name + " depositou " + value);
            System.out.println("Conta: saldo atualizado de " + this.balance);
            noBalance.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int value, String name) throws InterruptedException {
        lock.lock();
        try {
            if (this.balance < value) {
                System.out.println("Saldo insuficiente");
                noBalance.await();
            }
                this.balance -= value;
                System.out.println("Cliente: " + name + " retirou " + value);
                System.out.println("Conta: saldo atualizado de " + this.balance);
        } finally {
            lock.unlock();
        }
    }
}
