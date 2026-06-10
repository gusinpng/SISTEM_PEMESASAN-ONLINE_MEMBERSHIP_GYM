// Dibuat oleh Indra - Relasi Association antara Member dan PaketGym
public class Pemesanan {

    private Member member;
    private PaketGym paket;

    public Pemesanan(Member member, PaketGym paket) {
        this.member = member;
        this.paket = paket;
    }

    public Member getMember() {
        return member;
    }

    public PaketGym getPaket() {
        return paket;
    }
}