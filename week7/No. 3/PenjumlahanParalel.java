import java.util.Scanner;

class SumTask extends Thread {
    private int start, end;
    private long partialSum = 0;
    private static long totalSum = 0;
    
    // Objek sebagai lock untuk Sinkronisasi
    private static final Object lock = new Object();

    public SumTask(int start, int end, String name) {
        super(name);
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        // Melakukan penjumlahan parsial
        for (int i = start; i <= end; i++) {
            partialSum += i;
        }
        
        System.out.println(Thread.currentThread().getName() + " bertugas menjumlahkan " + start + " - " + end);
        System.out.println(Thread.currentThread().getName() + " -> Hasil Parsial: " + partialSum);

        // Menambahkan hasil parsial ke total dengan Thread Safety
        synchronized (lock) {
            totalSum += partialSum;
        }
    }

    public static long getTotalSum() {
        return totalSum;
    }
}

public class PenjumlahanParalel {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Jumlah Thread: ");
        int numThreads = scanner.nextInt();
        
        System.out.print("Masukkan Angka Akhir: ");
        int maxNumber = scanner.nextInt();

        Thread[] threads = new Thread[numThreads];
        
        // Pembagian tugas (Divide and Conquer)
        int chunkSize = maxNumber / numThreads;
        int remainder = maxNumber % numThreads;
        
        int currentStart = 1;

        for (int i = 0; i < numThreads; i++) {
            // Thread terakhir mengambil sisa pembagian jika ada
            int currentEnd = currentStart + chunkSize - 1 + (i == numThreads - 1 ? remainder : 0);
            
            threads[i] = new SumTask(currentStart, currentEnd, "Thread-" + (i + 1));
            threads[i].start();
            
            currentStart = currentEnd + 1;
        }

        // Sinkronisasi: Menunggu semua thread selesai
        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }

        System.out.println("=====================================");
        System.out.println("Hasil akhir dari seluruh thread: " + SumTask.getTotalSum());
        scanner.close();
    }
}