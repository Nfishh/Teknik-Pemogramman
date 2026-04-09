class Account {
    int balance = 150;
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        // Thread 1: Menjumlahkan/ transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            // Solusi: Kunci acc1 terlebih dahulu
            synchronized (acc1) { 
                System.out.println("Thread 1: Berhasil mengunci acc1, bersiap mengunci acc2...");
                try { Thread.sleep(100); } catch (Exception e) {} 

                // Kunci acc2 setelah mengamankan acc1
                synchronized (acc2) { 
                    System.out.println("Thread 1: Berhasil mengunci acc2. Memproses transfer...");
                    acc2.balance += acc1.balance;
                }
            }
        });

        // Thread 2: Menjumlahkan/ transfer fulus dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            // Solusi: Kunci acc1 TERLEBIH DAHULU (urutan yang sama dengan Thread 1)
            synchronized (acc1) { 
                System.out.println("Thread 2: Berhasil mengunci acc1, bersiap mengunci acc2...");
                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (acc2) { 
                    System.out.println("Thread 2: Berhasil mengunci acc2. Memproses transfer...");
                    acc1.balance += acc2.balance;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}