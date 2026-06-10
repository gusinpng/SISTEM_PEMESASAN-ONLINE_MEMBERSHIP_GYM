import java.util.Scanner;

// Dibuat oleh Indra - Main class untuk menjalankan aplikasi
public class Main {

    public static void main(String[] args) { // Dibuat oleh Indra - Membuat objek Scanner untuk input pengguna

        Scanner input = new Scanner(System.in);

// Dibuat oleh Indra - Inisialisasi variabel untuk menyimpan data member, pemesanan, dan pembayaran
        Member member = null;
        Pemesanan pemesanan = null;
        Pembayaran pembayaran = null;

// Dibuat oleh Indra - Variabel untuk mengontrol jalannya aplikasi
        boolean jalan = true;

// Dibuat oleh Indra - Loop utama untuk menampilkan menu dan menangani pilihan pengguna
        while (jalan) {

            System.out.println("\n====================================");
            System.out.println(" SELAMAT DATANG DI FITNESS CITY");
            System.out.println("====================================");
            System.out.println("1. Registrasi");
            System.out.println("2. Lihat Paket Gym");
            System.out.println("3. Buat Pemesanan");
            System.out.println("4. Lihat Data Member");
            System.out.println("5. Pembayaran");
            System.out.println("6. Keluar");

            System.out.print("\nPilih menu : ");
            int menu = input.nextInt();
            input.nextLine();

// dibuat oleh indra - Validasi registrasi member agar hanya bisa dilakukan satu kali
    if (menu == 1) {

    if (member != null) {
        System.out.println("\nAnda sudah registrasi.");
        System.out.println("Registrasi hanya dapat dilakukan satu kali.");
    } else {

        System.out.println("\n===== REGISTRASI MEMBER =====");

        System.out.print("Nama : ");
        String nama = input.nextLine();

        System.out.print("No HP : ");
        String noHp = input.nextLine();

        System.out.print("Email : ");
        String email = input.nextLine();

// dibuat oleh matthew - Validasi data member menggunakan custom exception
        try {

            member = new Member(nama, noHp, email);

            System.out.println("\nRegistrasi berhasil!");

        } catch (InvalidMemberDataException e) {

            System.out.println("\n" + e.getMessage());

        }
    }

// dibuat oleh indra - Menampilkan daftar paket gym menggunakan konsep inheritance dan polymorphism
            } else if (menu == 2) {

                System.out.println("\n===== DAFTAR PAKET GYM =====");
                System.out.println("Alamat : " + Alamat.getAlamatGym());

                PaketGym bulanan = new PaketBulanan();
                PaketGym tahunan = new PaketTahunan();

                System.out.println();
                bulanan.tampilkanInfo();

                System.out.println();
                tahunan.tampilkanInfo();

// dibuat oleh indra - Menambahkan validasi data member dan status pembayaran sebelum membuat pemesanan
            } else if (menu == 3) {

                if (member == null) {

                    System.out.println("\nSilakan registrasi terlebih dahulu.");

                } else if (pembayaran != null && pembayaran.isStatus()) {

                    System.out.println("\nMembership sudah aktif.");
                    System.out.println("Paket aktif : " + pemesanan.getPaket().getNamaPaket());
                    System.out.println("Anda tidak dapat membuat pemesanan baru.");

                } else {

                    System.out.println("\n===== MEMILIH PAKET MEMBERSHIP GYM =====");
                    System.out.println("1. Paket Bulanan (150000) ");
                    System.out.println("2. Paket Tahunan (1200000)");

                    System.out.print("Pilih paket : ");
                    int pilihPaket = input.nextInt();
                    input.nextLine();

                    PaketGym paket = null;

                    if (pilihPaket == 1) {

                        paket = new PaketBulanan();

                    } else if (pilihPaket == 2) {

                        paket = new PaketTahunan();

                    }

                    if (paket != null) {

                        pemesanan = new Pemesanan(member, paket);
                        pembayaran = new Pembayaran(pemesanan);

                        System.out.println("\nPemesanan berhasil dibuat!");

                    } else {

                        System.out.println("\nPaket tidak tersedia.");

                    }
                }

// dibuat oleh indra - Menambahkan validasi data member sebelum menampilkan informasi
            } else if (menu == 4) {

                if (member == null) {

                    System.out.println("\nBelum ada data member.");

                } else {

                    System.out.println("\n===== DATA MEMBER =====");

                    System.out.println("Nama   : " + member.getNama());
                    System.out.println("No HP  : " + member.getNoHp());
                    System.out.println("Email  : " + member.getEmail());
                    

                    if (pemesanan != null) {

                        System.out.println("Paket  : "
                                + pemesanan.getPaket().getNamaPaket());

                    } else {

                        System.out.println("Paket  : ---");

                    }

                    if (pembayaran != null && pembayaran.isStatus()) {

                        System.out.println("Status : Membership Aktif");

                    } else {

                        System.out.println("Status : Membership Tidak Aktif");

                    }
                }
// dibuat oleh indra - Menambahkan validasi data member sebelum menampilkan informasi
            } else if (menu == 5) {

                if (member == null) {

                    System.out.println("\nGagal memvalidasi data!");
                    System.out.println("Harap melakukan registrasi terlebih dahulu.");

                } else {

//dibuat oleh matthew - Validasi paket menggunakan custom exception
                    try {

                        if (pemesanan == null) {

                            throw new PaketBelumDipilihException(
                                    "Belum ada paket yang dipilih.\nSilakan membuat pemesanan terlebih dahulu.");

                        }

                        if (pembayaran != null && pembayaran.isStatus()) {

                            System.out.println("\nMembership sudah aktif.");
                            System.out.println("Tidak perlu melakukan pembayaran lagi.");

                        } else {

                            System.out.println("\n===== PEMBAYARAN =====");
                            System.out.println("Paket Dipilih : "
                                    + pemesanan.getPaket().getNamaPaket());
                            System.out.println("Pembayaran melalui Bank " + Pembayaran.BANK);
                            System.out.println("No Rekening Tujuan : " + Pembayaran.NOMOR_REKENING);
                            System.out.println("Nominal Pembayaran : Rp"
                                    + (int) pemesanan.getPaket().getHarga());

                            System.out.println("\nNOTE :");
                            System.out.println("- Masukkan nomor rekening dengan benar.");
                            System.out.println("- Masukkan nominal sesuai harga paket yang dipilih.");

                            System.out.print("\nMasukkan rekening : ");
                            String rekening = input.nextLine();

                            System.out.print("Masukkan nominal transfer : Rp");
                            Integer nominal = input.nextInt();
                            input.nextLine();
                            
                            //dibuat oleh NANDA - Thread simulasi proses pembayaran
                            Thread t1 = new Thread(new validasi());
                            Thread t2 = new Thread(new server());
                            Thread t3 = new Thread(new notifikasi());

                            t1.start();
                            t2.start();
                            t3.start();

                            try {

                                t1.join();
                                t2.join();
                                t3.join();

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            pembayaran.bayar(
                                    rekening,
                                    nominal);

                            System.out.println("\nStatus : BERHASIL");
                            System.out.println("Membership berhasil diaktifkan.");

                        }

                        //dibuat oleh matthew - Menangani multiple exception dalam satu blok catch
                    } catch (PaketBelumDipilihException e) {

                        System.out.println("\n" + e.getMessage());

                    } catch (InvalidPaymentException e) {

                        System.out.println("\nStatus : GAGAL");
                        System.out.println(e.getMessage());

                    }
                }
// dibuat oleh indra - Menambahkan opsi keluar dari aplikasi dengan validasi input
            } else if (menu == 6) {

                jalan = false;
                System.out.println("\nTerima kasih telah mengunjungi ");
                System.out.println("Gym Fitnes city.");

            } else {
                System.out.println("\nMenu tidak tersedia.");

            }
        }
// Dibuat oleh Indra - Menutup objek Scanner sebelum keluar dari aplikasi
        input.close();
    }
}