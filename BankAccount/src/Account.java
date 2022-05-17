public class Account {
    private int balance;
    // Buffer buffer;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public void deposit(int value, String name) throws InterruptedException{
        this.balance += value;
        // buffer.put(1);
        System.out.println("Cliente: "+ name + " depositou " + value);
        System.out.println("Conta: saldo atualizado de "+this.balance);
    }

    public void withdraw(int value, String name) throws InterruptedException{
        if(this.balance > value){
            this.balance -= value;
            // buffer.get();
            System.out.println("Cliente: "+ name + " retirou " + value);
            System.out.println("Conta: saldo atualizado de "+this.balance);
        }else{
            System.out.println("Saldo insuficiente");
            System.out.println("Conta: saldo atualizado de "+this.balance);
        }
    }
}
