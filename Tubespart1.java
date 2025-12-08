import java.util.Scanner;

public class Tubespart1 {
	public static String[] nama = new String [100];
	public static String[] nik = new String [100];
	public static String[] desa = new String [100];
	public static String[] status = new String [100];
	public static int jumlahData = 0;
	
	public static Scanner input = new Scanner (System.in);
	
	public static void dataAwal() {
		nik[0] = "1234";
		nama[0] = "Budi Susanto";
		desa[0] = "Sukapura";
		status[0] = "Sudah Menikah";
		
		nama[1] = "Kevin Santoso";
		nik[1] = "2121";
		desa[1] = "Sukabirus";
		status[1] = "Belum Menikah";
		
		nama[2] = "Jason Gamma";
		nik[2] = "1212";
		desa[2] = "Bojongsoang";
		status[2] = "Belum Menikah";
		jumlahData = 3;
	}
	
	public static void main (String[] args) {
		int pilihan = 0;
		do {
			System.out.println("\n===SISTEM INFORMASI DESA===");
			System.out.println("1. Informasi Desa");
            System.out.println("2. Data Penduduk (Cari & Tampil)");
            System.out.println("3. Edit Penduduk (Tambah & Hapus)");
            System.out.println("4. Keluar");
            
            System.out.print("\nPilih Menu (1-4): ");
            pilihan = input.nextInt();
            
		} while (pilihan != 4);
	}

	public static void informasiDesa(){
		String[] namaDesa = new String[jumlahData];
		int[] populasiDesa = new int[jumlahData];
		int jumlahDesa = 0;

		for (int i = 0; i < jumlahData; i++){
			String dataDesa = desa[i];
			boolean cekDesa = false;

			for(int j = 0; j < jumlahDesa; j++){
				if (namaDesa[i].equalsIgnoreCase(dataDesa)){
					populasiDesa[j]++;
					cekDesa = true;
					break;
				}
			}

			if (!cekDesa) {
                namaDesa[jumlahDesa] = dataDesa;
                populasiDesa[jumlahDesa] = 1;
                jumlahDesa++;
            }
        }

        System.out.println("+----------------------+-------------------+");
        System.out.printf("| %-20s | %-17s |\n", "NAMA DESA", "JUMLAH PENDUDUK");
        System.out.println("+----------------------+-------------------+");
        
        if (jumlahDesa == 0) {
            System.out.printf("| %-40s |\n", "Tidak ada data.");
        } else {
            for (int i = 0; i < jumlahDesa; i++) {
                System.out.printf("| %-20s | %-17d |\n", namaDesa[i], populasiDesa[i]);
            }
        }
        System.out.println("+----------------------+-------------------+");
        System.out.println("Total Total Penduduk Terdaftar: " + jumlahData);
		}
	}

