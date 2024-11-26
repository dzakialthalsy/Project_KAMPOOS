import java.util.ArrayList;

public class KRS {
    private Mahasiswa mahasiswa;
    private ArrayList<MataKuliah> daftarKRS;

    public KRS(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
        this.daftarKRS = new ArrayList<>();
    }

    public void tambahMataKuliah(String kode, MataKuliah[] mataKuliah) {
        if (totalKredit() >= 12) {
            S.print("KRS sudah penuh (maksimal 12 kredit)!", 2, 18);
            S.delay(1500);
            return;
        }
        for (MataKuliah mk : mataKuliah) {
            if (mk.getKode().equals(kode) && !daftarKRS.contains(mk)) {
                daftarKRS.add(mk);
                return;
            }
        }
        S.print("Mata kuliah tidak ditemukan atau sudah ditambahkan!", 2, 18);
        S.delay(1500);
    }

    public void hapusMataKuliah(String kode) {
        daftarKRS.removeIf(mk -> mk.getKode().equals(kode));
    }

    public void tampilkanKRS() {
        S.print("KRS Mahasiswa", 2, 2);
        S.print("Nama: " + mahasiswa.getNama(), 2, 3);
        S.print("NIM : " + mahasiswa.getNim(), 2, 4);
        S.print("Mata Kuliah yang diprogram:", 2, 6);

        int y = 7;
        for (MataKuliah mk : daftarKRS) {
            S.print(mk.toString(), 2, y++);
        }

        S.print("Total Kredit: " + totalKredit(), 2, y + 1);
    }

    public ArrayList<MataKuliah> getDaftarKRS() {
        return daftarKRS;
    }

    public int totalKredit() {
        return daftarKRS.stream().mapToInt(MataKuliah::getKredit).sum();
    }

    // Tambahkan metode ini
    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }
}
