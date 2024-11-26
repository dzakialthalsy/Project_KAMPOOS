public class MataKuliah {
    private String kode;
    private String nama;
    private int kredit;
    private char nilaiHuruf;

    public MataKuliah(String kode, String nama, int kredit) {
        this.kode = kode;
        this.nama = nama;
        this.kredit = kredit;
    }

    public String getKode() {
        return kode;
    }

    public int getKredit() {
        return kredit;
    }

    public char getNilaiHuruf() {
        return nilaiHuruf;
    }

    public void setNilaiHuruf(char nilaiHuruf) {
        this.nilaiHuruf = nilaiHuruf;
    }

    public String getNama() {
        return nama;
    }
    

    @Override
    public String toString() {
        return String.format("%-6s %-30s %2d", kode, nama, kredit);
    }

    public static MataKuliah[] getAllMataKuliah() {
        return new MataKuliah[]{
            new MataKuliah("MK11", "Pemrograman Dasar", 5),
            new MataKuliah("MK12", "Jaringan Komputer", 2),
            new MataKuliah("MK13", "Pengantar Ilmu Komputer", 2),
            new MataKuliah("MK31", "Statistika", 3),
            new MataKuliah("MK32", "Pemrograman Berorientasi Objek", 4),
            new MataKuliah("MK33", "Rekayasa Sistem Informasi", 5),
            new MataKuliah("MK51", "Pemrograman Mobile", 4),
            new MataKuliah("MK52", "Sistem Manajemen Bisnis", 3),
            new MataKuliah("MK53", "Praktikum ABCD", 4),
            new MataKuliah("MK71", "Skripsi", 6)
        };
    }

    public static void tampilkanMataKuliah(MataKuliah[] mataKuliah) {
        S.print("Daftar Mata Kuliah:", 2, 5);
        int y = 6;
        for (MataKuliah mk : mataKuliah) {
            S.print(mk.toString(), 2, y++);
        }
    }
}
