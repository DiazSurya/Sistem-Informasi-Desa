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

		nama[3] = "Muhammad Febryan";
		nik[3] = "4321";
		desa[3] = "Sukapura";
		status[3] = "Sudah Menikah";
		jumlahData = 4;
	}

	public static void informasiDesa(){
		String[] namaDesa = new String[jumlahData];
		int[] populasiDesa = new int[jumlahData];
		int jumlahDesa = 0;

		for (int i = 0; i < jumlahData; i++){
			String dataDesa = desa[i];
			boolean cekDesa = false;

			for(int j = 0; j < jumlahDesa; j++){
				if (namaDesa[j].equalsIgnoreCase(dataDesa)){
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

		System.out.println(); 
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

		System.out.print("\nTekan enter untuk melanjutkan...");
		input.nextLine();
	}

	public static void cariPenduduk(String Cari) {
        boolean ditemukan = false;
        System.out.println("\n+----------------+--------------------------+----------------+--------------------------+");
        System.out.printf("| %-14s | %-24s | %-14s | %-24s |\n", "NIK", "NAMA LENGKAP", "DESA", "STATUS PERNIKAHAN");
        System.out.println("+----------------+--------------------------+----------------+--------------------------+");
       
		for (int i = 0; i < jumlahData; i++) {
            // Pencarian case-insensitive dan bisa parsial (contains)
            if (nik[i].contains(Cari) || nama[i].toLowerCase().contains(Cari.toLowerCase())) {
                System.out.printf("| %-14s | %-24s | %-14s | %-24s |\n", nik[i], nama[i], desa[i], status[i]);
                ditemukan = true;
            }
        }

        System.out.println("+----------------+--------------------------+----------------+--------------------------+");
        if (!ditemukan) System.out.println("Data tidak ditemukan.");
        System.out.print("\nTekan enter untuk melanjutkan...");
		input.nextLine();
    }

	public static void pendudukDesa(String cariPendudukDesa) {
        boolean ditemukan = false;
        System.out.println("\n+----------------+--------------------------+----------------+--------------------------+");
        System.out.printf("| %-14s | %-24s | %-14s | %-24s |\n", "NIK", "NAMA LENGKAP", "DESA", "STATUS PERNIKAHAN");
        System.out.println("+----------------+--------------------------+----------------+--------------------------+");
        for (int i = 0; i < jumlahData; i++) {
            if (desa[i].equalsIgnoreCase(cariPendudukDesa)) {
                System.out.printf("| %-14s | %-24s | %-14s | %-24s |\n", nik[i], nama[i], desa[i], status[i]);
                ditemukan = true;
            }
        }
        System.out.println("+----------------+--------------------------+----------------+--------------------------+");
        if (!ditemukan) System.out.println("Tidak ada penduduk di desa " + desa);
        System.out.print("\nTekan enter untuk melanjutkan...");
		input.nextLine();
    }
	 public static void dataPenduduk() {
        int pilihan;
        do {
           	System.out.println(); 
    		System.out.println("+-------------------------------------------+");
			System.out.printf("| %-41s |\n", "MENU DATA PENDUDUK");
   			System.out.println("+-------------------------------------------+");
            System.out.println("1. Cari Penduduk (Nama / NIK)");
            System.out.println("2. Tampilkan Penduduk per Desa");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.println("+-------------------------------------------+");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
			input.nextLine();

            if (pilihan == 1) {
                System.out.print("Masukkan Nama atau NIK yang dicari: ");
                String Cari = input.nextLine();
                cariPenduduk(Cari);
            } else if (pilihan == 2) {
                System.out.print("Masukkan Nama Desa: ");
                String cariPendudukDesa = input.nextLine();
				pendudukDesa(cariPendudukDesa);
            }else if (pilihan != 3) {
				System.out.println("Pilihan tidak valid.");
			}
        } while (pilihan != 3);
    }

	
	public static void main (String[] args) {
		dataAwal();
		int pilihan = 0;
		do {
			System.out.println(); 
    		System.out.println("+-------------------------------------------+");
			System.out.printf("| %-41s |\n", "SISTEM INFORMASI DESA");
   			System.out.println("+-------------------------------------------+");
			System.out.println("1. Informasi Desa");
            System.out.println("2. Data Penduduk (Cari & Tampil)");
            System.out.println("3. Edit Penduduk (Tambah & Hapus)");
            System.out.println("4. Keluar");
            System.out.println("+-------------------------------------------+");
           
			System.out.print("Pilih Menu (1-4): ");
            pilihan = input.nextInt();
			input.nextLine();

			switch (pilihan){
				case 1:
					informasiDesa();
					break;
				case 2:
					dataPenduduk();
					break;
				case 4:
					System.out.println("\nTerima kasih telah menggunakan sistem ini ^_^");
					break;
				default:
					System.out.println("Pilihan tidak valid.");
					break;
			}
            
		} while (pilihan != 4);
	}
}

//anjing