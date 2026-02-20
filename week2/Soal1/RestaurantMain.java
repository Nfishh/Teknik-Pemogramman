import java.util.Scanner;

public class RestaurantMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Restaurant menu = new Restaurant();

        menu.tambahMenuMakanan("Pizza", 250000, 20);
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);

        int pilihan;
        int jumlah;

        do {
            System.out.println("\n=== MENU RESTAURANT ===");
            menu.tampilMenuMakanan();
            System.out.println("99. Keluar");

            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            if (pilihan == 99) {
                System.out.println("Terima kasih!");
                break;
            }

            System.out.print("Masukkan jumlah pesanan: ");
            jumlah = input.nextInt();

            menu.pesanMenu(pilihan, jumlah);

        } while (true);

        input.close();
    }
}