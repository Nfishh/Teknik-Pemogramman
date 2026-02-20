public class Restaurant {

    //attribute private
    private String[] namaMakanan;
    private double[] hargaMakanan;
    private int[] stok;
    private int id;

    //Constructor
    public Restaurant() {
        namaMakanan = new String[10];
        hargaMakanan = new double[10];
        stok = new int[10];
        id = 0;
    }

    //Getter
    public String getNamaMakanan(int index) {
        return namaMakanan[index];
    }

    public double getHargaMakanan(int index) {
        return hargaMakanan[index];
    }

    public int getStok(int index) {
        return stok[index];
    }

    //Setter
    public void setStok(int index, int stokBaru) {
        if (stokBaru >= 0) {
            stok[index] = stokBaru;
        } else {
            System.out.println("Stok tidak boleh negatif!");
        }
    }

    //Tambah menu
    public void tambahMenuMakanan(String nama, double harga, int stokAwal) {

        if (stokAwal < 0) {
            System.out.println("Stok tidak boleh negatif!");
            return;
        }

        namaMakanan[id] = nama;
        hargaMakanan[id] = harga;
        stok[id] = stokAwal;
        id++;
    }

    //Tampilkan menu
    public void tampilMenuMakanan() {
    for (int i = 0; i < id; i++) {

        String status = (stok[i] == 0) ? "[HABIS]" : "[" + stok[i] + "]";

        System.out.println(
            i + ". " + namaMakanan[i] +
            " " + status +
            " Rp. " + hargaMakanan[i]
            );
        }
    }

    public void pesanMenu(int index, int jumlah) {

        if (index < 0 || index >= id) {
            System.out.println("Menu tidak ditemukan.");
            return;
        }

        if (jumlah <= 0) {
            System.out.println("Jumlah pesanan tidak valid.");
            return;
        }

        //Cek stok mencukupi
        if (stok[index] >= jumlah) {
            stok[index] -= jumlah; // stok otomatis berkurang
            System.out.println("Pesanan berhasil!");
            System.out.println("Total bayar: Rp. " +
                    (hargaMakanan[index] * jumlah));
        } else {
            //ditolak jika stok tidak cukup
            System.out.println("Pesanan ditolak! Stok tidak mencukupi.");
        }
    }
}