// Dibuat oleh NANDA - Thread pengiriman notifikasi pembayaran
public class notifikasi implements Runnable {

    @Override
    public void run() {

        System.out.println("Mengirim notifikasi pembayaran...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}