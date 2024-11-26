import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MataKuliah[] mataKuliah = MataKuliah.getAllMataKuliah();
        Scanner scanner = new Scanner(System.in);

        S.clear();
        S.print("Masukkan Nama Mahasiswa: ", 2, 2);
        String nama = scanner.nextLine();
        S.print("Masukkan NIM Mahasiswa: ", 2, 3);
        String nim = scanner.nextLine();

        Mahasiswa mahasiswa = new Mahasiswa(nama, nim);
        KRS krs = new KRS(mahasiswa);

        boolean selesai = false;
        while (!selesai) {
            S.clear();
            krs.tampilkanKRS();
            MataKuliah.tampilkanMataKuliah(mataKuliah);
            S.print("Opsi: Tambah (T) | Hapus (H) | Lanjut (L): ", 2, 16);
            char opsi = scanner.next().toUpperCase().charAt(0);

            selesai = pilihMatkul(mataKuliah, scanner, krs, selesai, opsi);
        }

        KHS khs = new KHS(krs);
        khs.isiNilai(scanner);
        khs.tampilkanKHS();

        boolean ulang = true;
        while (ulang) {
            S.print("Opsi: Nilai Ulang (N) | Selesai (S): ", 2, 20);
            char opsi = scanner.next().toUpperCase().charAt(0);
            if (opsi == 'N') {
                khs.isiNilai(scanner);
                khs.tampilkanKHS();
            } else if (opsi == 'S') {
                ulang = false;
            }
        }

        S.clear();
        khs.tampilkanKHS();
        S.print("Program Selesai!", 1, 22);
    }

    private static boolean pilihMatkul(MataKuliah[] mataKuliah, Scanner scanner, KRS krs, boolean selesai, char opsi) {
        switch (opsi) {
            case 'T': // Tambah mata kuliah
            case 'H': // Hapus mata kuliah
                String action = (opsi == 'T') ? "Tambah" : "Hapus";
                S.print("Masukkan Kode Mata Kuliah untuk " + action + ": ", 2, 17);
                String kode = scanner.next().toUpperCase();
    
                if (opsi == 'T') {
                    krs.tambahMataKuliah(kode, mataKuliah);
                } else {
                    krs.hapusMataKuliah(kode);
                }
                break;
    
            case 'L': // Lanjutkan
                selesai = true;
                break;
    
            default:
                S.print("Opsi tidak valid!", 2, 18);
                S.delay(1000);
        }
        return selesai;
    }    
}
