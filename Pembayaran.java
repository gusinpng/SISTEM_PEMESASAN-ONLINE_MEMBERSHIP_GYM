// Dibuat oleh Indra - Class pembayaran
public class Pembayaran {

    private Pemesanan pemesanan;
    private boolean status;

    // Dibuat oleh NANDA - Penggunaan static final sebagai konstanta
    public static final String BANK = "BCA";
    public static final String NOMOR_REKENING = "12345678";

    public Pembayaran(Pemesanan pemesanan) {
        this.pemesanan = pemesanan;
        this.status = false;
    }

    // Dibuat oleh Matthew - Validasi pembayaran menggunakan custom exception
    public void bayar(String rekening, int nominal)
            throws InvalidPaymentException {

        double hargaPaket = pemesanan.getPaket().getHarga();

        if (!rekening.equals(NOMOR_REKENING)) {
            throw new InvalidPaymentException(
                    "Harap memasukkan nomor rekening yang benar!");
        }

        if (nominal < hargaPaket) {
            throw new InvalidPaymentException(
                    "Nominal pembayaran kurang.");
        }

        status = true;
    }

    public boolean isStatus() {
        return status;
    }

    public Pemesanan getPemesanan() {
        return pemesanan;
    }
}