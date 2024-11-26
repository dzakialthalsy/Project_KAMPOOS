import java.util.ArrayList;
import java.util.Scanner;

public class KHS {
    private KRS krs;

    public KHS(KRS krs) {
        this.krs = krs;
    }

    public void isiNilai(Scanner scanner) {
        ArrayList<MataKuliah> daftarKRS = krs.getDaftarKRS();
        for (MataKuliah mk : daftarKRS) {
            boolean validInput = false;
            char nilaiHuruf = ' ';
            while (!validInput) {
                // Bersihkan layar sepenuhnya untuk memberikan pengalaman input yang rapi
                S.clear();
                S.print("Masukkan Nilai Huruf untuk " + mk.getKode() + ": ", 2, 2);
                
                nilaiHuruf = scanner.next().toUpperCase().charAt(0);
                if (nilaiHuruf >= 'A' && nilaiHuruf <= 'E') {
                    validInput = true;
                } else {
                    S.print("Input tidak valid! Masukkan A, B, C, D, atau E.", 2, 4);
                    S.delay(1000); // Tampilkan error sebentar
                }
            }
            mk.setNilaiHuruf(nilaiHuruf);
        }
    }
    
    

    public void tampilkanKHS() {
        S.clear();
        S.print("KHS Mahasiswa", 2, 2);
        S.print("Nama: " + krs.getMahasiswa().getNama(), 2, 3);
        S.print("NIM : " + krs.getMahasiswa().getNim(), 2, 4);
        S.print("Daftar Mata Kuliah:", 2, 6);

        int totalKredit = 0;
        int totalMutu = 0;

        int y = 7;
        for (MataKuliah mk : krs.getDaftarKRS()) {
            String nilai = mk.getNilaiHuruf() != '\0' ? String.valueOf(mk.getNilaiHuruf()) : "-";
            S.print(String.format("%-6s %-30s %2d - Nilai: %s", 
                mk.getKode(), mk.getNama(), mk.getKredit(), nilai), 2, y++);
            totalKredit += mk.getKredit();
            totalMutu += hitungNilaiMutu(mk.getNilaiHuruf()) * mk.getKredit();
        }

        double ipk = totalKredit > 0 ? (double) totalMutu / totalKredit : 0.0;
        S.print("Total Kredit: " + totalKredit, 2, y + 1);
        S.print("IPK: " + String.format("%.2f", ipk), 2, y + 2);
    }

    private int hitungNilaiMutu(char nilaiHuruf) {
        switch (nilaiHuruf) {
            case 'A': return 4;
            case 'B': return 3;
            case 'C': return 2;
            case 'D': return 1;
            case 'E': return 0;
            default: return 0;
        }
    }
}
