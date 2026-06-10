// Dibuat oleh NANDA - Thread validasi pembayaran
public class validasi implements Runnable {

    @Override
    public void run() {

        System.out.println("Memvalidasi data pembayaran...");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}