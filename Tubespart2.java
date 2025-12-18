import java.util.Scanner;

public class Tubespart2 {
	public static String[] nama = new String [100];
	public static String[] nik = new String [100];
	public static String[] desa = new String [100];
	public static String[] status = new String [100];
	public static int jumlahData = 0;
	
	public static Scanner input = new Scanner (System.in);
	
	public static String[] daftarDesa = {
        "Pasawahan", "Dayeuhkolot", "Citeureup", "Sukapura", "Sukabirus"};
    
    public static String[] alamatDesa = {
        "Jl. Cisirung No. 10", "Jl. Raya Dayeuhkolot", "Jl. Raya Citeureup", "Jl. Mengger Hilir", "Jl. Raya sukabirus"
	};

	public static int[] dataRT = {14, 11, 18, 87,18};
    public static int[] dataRW = {5, 9, 11, 6,9};

	public static void dataAwal() {
		nik[0] = "1234";
		nama[0] = "Budi Susanto";
		desa[0] = "Sukapura";
		status[0] = "Sudah Menikah";
		
		nama[1] = "Kevin Santoso";
		nik[1] = "2121";
		desa[1] = "Dayeuhkolot";
		status[1] = "Belum Menikah";
		
		nama[2] = "Jason Gamma";
		nik[2] = "1212";
		desa[2] = "Pasawahan";
		status[2] = "Belum Menikah";

		nama[3] = "Muhammad Febryan";
		nik[3] = "4321";
		desa[3] = "Sukapura";
		status[3] = "Sudah Menikah";

        nama[4] = "Jason";
        nik[4] = "3451";
        desa[4] = "sukabirus";
        status[4] = "sudah menikah";
		jumlahData = 5;
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
            System.out.println("2. Data Penduduk");
			System.out.println("3. Cari Penduduk");
            System.out.println("4. Edit Data Penduduk");
			System.out.println("5. Tambah Data Penduduk");
			System.out.println("6. Hapus Data Penduduk");
            System.out.println("7. Keluar");
            System.out.println("+-------------------------------------------+");
          
			System.out.print("Pilih Menu (1-7): ");
            pilihan = input.nextInt();
			input.nextLine();

			switch (pilihan){
				case 1:
					informasiDesa();
					break;
				case 2:
					tampilkanSemua();
					break;
				case 3:
					cariDataPenduduk();
					break;
				case 4:
					editDatapenduduk();
					break;
				case 5:
					tambahDatapenduduk();
					break;
				case 6:
					hapusDataPenduduk();
					break;
				case 7:
					System.out.println("\nTerima kasih telah menggunakan sistem ini ^_^");
					break;
				default:
					System.out.println("Pilihan tidak valid.");
					break;
			}
            
		} while (pilihan != 7);
	}

	public static void informasiDesa() {
    	System.out.println("\n+--------------------------------------------------------------------------------------+");
    	System.out.printf("| %-20s | %-25s | %-5s | %-5s | %-17s |\n","NAMA DESA", "LOKASI DESA", "RT", "RW", "JUMLAH PENDUDUK");
    	System.out.println("+--------------------------------------------------------------------------------------+");

	    for (int i = 0; i < daftarDesa.length; i++) {
    	    String desaTerdaftar = daftarDesa[i];
        	int hitungOrang = 0;

        	for (int j = 0; j < jumlahData; j++) {
            	if (desa[j].equalsIgnoreCase(desaTerdaftar)) {
                	hitungOrang++;
            	}
        	}

        	System.out.printf("| %-20s | %-25s | %-5d | %-5d | %-17d |\n", desaTerdaftar, alamatDesa[i], dataRT[i], dataRW[i], hitungOrang);
    	}
    
		System.out.println("+--------------------------------------------------------------------------------------+");
    	System.out.println("Total Seluruh Penduduk Terdaftar: " + jumlahData + " Jiwa");
    
   		System.out.print("\nTekan enter untuk melanjutkan...");
    	input.nextLine();
	}

	public static void tampilkanSemua() {
    	if (jumlahData == 0) {
        	System.out.println("\nBelum ada data penduduk yang terdaftar.");
    	} else {
        	System.out.println("\n+--------------+---------------------------+-----------------------+-----------------------+");
        	System.out.printf("| %-12s | %-25s | %-21s | %-21s |\n", "NIK", "NAMA LENGKAP", "DESA", "STATUS");
        	System.out.println("+--------------+---------------------------+-----------------------+-----------------------+");

        	for (int i = 0; i < jumlahData; i++) {
            	System.out.printf("| %-12s | %-25s | %-21s | %-21s |\n", nik[i], nama[i], desa[i], status[i]);
        	}
        
       		System.out.println("+--------------+---------------------------+-----------------------+-----------------------+");
    	}
        System.out.print("\nTekan enter untuk melanjutkan...");
    	input.nextLine();
	}

	public static void cariDataPenduduk() {
        int pilihan;
        do {
           	System.out.println(); 
    		System.out.println("+-------------------------------------------+");
			System.out.printf("| %-41s |\n", "CARI DATA PENDUDUK");
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

	public static void cariPenduduk(String Cari) {
        boolean ditemukan = false;
        System.out.println("\n+----------------+--------------------------+----------------+--------------------------+");
        System.out.printf("| %-14s | %-24s | %-14s | %-24s |\n", "NIK", "NAMA LENGKAP", "DESA", "STATUS PERNIKAHAN");
        System.out.println("+----------------+--------------------------+----------------+--------------------------+");
       
		for (int i = 0; i < jumlahData; i++) {
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
	 
    public static void editDatapenduduk(){
        int pilihan;
        do { 
            System.out.println();
            System.out.println("+-------------------------------------------+");
			System.out.printf("| %-41s |\n", "EDIT DATA PENDUDUK");
   			System.out.println("+-------------------------------------------+");
            System.out.println("1. Edit Desa");
            System.out.println("2. Edit Data Diri");
            System.out.println("3. Edit Status Pernikahan");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.println("+-------------------------------------------+");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch(pilihan){
                case 1:
                    pindahDesa();
                    break;
                case 2:
                    editDatadiri();
                    break;
                case 3:
                    editStatusPernikahan();
                    break;
                 case 4:
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");

            }

        } while (pilihan != 4);
    }

   public static int cariDanpilihpenduduk(String Cari){
        int idx = -1; 
        int jumlahKetemu = 0; 
        int[] indexKetemu = new int[jumlahData]; 

        for (int i = 0; i < jumlahData; i++) {
            if  (nik[i].contains(Cari)||nama[i].toLowerCase().contains(Cari.toLowerCase())) {
                indexKetemu[jumlahKetemu] = i;
                jumlahKetemu++;
            }
        }

       
        if (jumlahKetemu == 0) {
            System.out.println("Tidak ditemukan penduduk dengan Nama/NIK '" + Cari + "'");
            System.out.print("Tekan enter untuk kembali...");
            input.nextLine();
            return -1;
        } else if (jumlahKetemu == 1) {
            return indexKetemu[0];  
        } else  {
            System.out.println("\n+----+-------------------+-------------+--------+");
            System.out.println("| No | Nama              | Desa        | NIK    |");
            System.out.println("+----+-------------------+-------------+--------+");
    
            for (int i = 0; i < jumlahKetemu; i++) {
                idx = indexKetemu[i];
                System.out.printf("| %-2d | %-17s | %-11s | %-6s |\n",  i+1, nama[idx], desa[idx], nik[idx]);
            }
        }

        System.out.println("+----+-------------------+-------------+--------+");
        System.out.print("Pilih nomor: ");
        int pilih = input.nextInt();
        input.nextLine();

        if (pilih < 1 || pilih > jumlahKetemu) {
             return -1;
        }
             
        return idx = indexKetemu[pilih - 1];

    }
        
    public static void pindahDesa(){
        if (jumlahData == 0) {
            System.out.println("Belum ada data!");
            return;
        }
        
        System.out.print("Masukkan Nama/NIK yang ingin pindah desa: ");
        String Cari = input.nextLine();

        int index = cariDanpilihpenduduk(Cari);

        if (index == -1) {
            return;
        }
  

        System.out.printf("\n%30s\n", "============= PINDAH  DESA =============");
        System.out.println("Nama: " + nama[index]);
        System.out.println("Desa sekarang: " + desa[index]);
        System.out.println("=".repeat(40));
        
        System.out.println("\n+-------------------------------------------+");
	    System.out.printf("| %-41s |\n", "PILIH DESA BARU");
   		System.out.println("+-------------------------------------------+");
        
        for (int i = 0; i < daftarDesa.length; i++) {
            System.out.println((i + 1) + ". " + daftarDesa[i]);
        }
        System.out.print("Pilih (1-" + daftarDesa.length + "): ");
        int pilihDesa = input.nextInt();
        input.nextLine();
    
        if (pilihDesa < 1 || pilihDesa > daftarDesa.length) {
            System.out.println("Pilihan salah!");
            return;
        }
    
        String desaBaru = daftarDesa[pilihDesa - 1];
        String desaLama = desa[index];
        desa[index] = desaBaru;       
        
        System.out.println("\nBERHASIL!");
        System.out.println(nama[index] + " pindah dari " + desaLama + " ke " + desaBaru);
        System.out.print("\nTekan enter untuk melanjutkan...");
		input.nextLine();
  
   
    }

    public static void editDatadiri(){
        if (jumlahData == 0) {
            System.out.println("Belum ada data!");
            return;
        }
        
        System.out.print("Masukkan Nama/NIK yang akan diedit: ");
        String keyword = input.nextLine();

        int index = cariDanpilihpenduduk(keyword);

        if (index == -1) {
            return;
        }

        System.out.printf("\n%30s\n", "============ EDIT DATA DIRI ============");
        System.out.println("Data saat ini:");
        System.out.println("Nama: " + nama[index]);
        System.out.println("Desa sekarang: " + desa[index]);
        System.out.println("=".repeat(40));

        System.out.println("\n+-------------------------------------------+");
	    System.out.printf("| %-41s |\n", "PILIH DATA YANG INGIN DIUBAH");
   		System.out.println("+-------------------------------------------+");
        System.out.println("1. Edit NIK");
        System.out.println("2. Edit Nama");
        System.out.println("3. Batal");
        System.out.print("Pilih (1-3): ");
        int pilihan = input.nextInt();
        input.nextLine();

         switch(pilihan) {
            case 1:
                System.out.print("\nMasukkan NIK baru: ");
                String nikBaru = input.nextLine();
                
                for (int i = 0; i < jumlahData; i++) {
                    if (i != index && nik[i].equals(nikBaru)) {
                        System.out.println("NIK sudah terdaftar!");
                        System.out.print("Tekan enter untuk melanjutkan...");
                        input.nextLine();
                        return;
                    }
                }
                
                nik[index] = nikBaru;
                System.out.println("NIK berhasil diubah!");
                break;
                
            case 2:
                System.out.print("\nMasukkan Nama baru: ");
                nama[index] = input.nextLine();
                System.out.println("Nama berhasil diubah!");
                break;
                
            case 3:
                System.out.println("Edit dibatalkan.");
                return;
                
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }
        
        System.out.print("\nTekan enter untuk melanjutkan...");
        input.nextLine();
    }

    public static void editStatusPernikahan() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data!");
            return;
        }
        
        System.out.print("Masukkan Nama/NIK yang akan diubah statusnya: ");
        String keyword = input.nextLine();

        int index = cariDanpilihpenduduk(keyword);

        if (index == -1) {
            return;
        }

        System.out.printf("\n%30s\n", "========== EDIT STATUS PERNIKAHAN ==========");
        System.out.println("Data saat ini:\n");
        System.out.println("Nama   : " + nama[index]);
        System.out.println("Status : " + status[index]);
        System.out.println("=".repeat(40));
        
        System.out.println("\n+-------------------------------------------+");
	    System.out.printf("| %-41s |\n", "PILIH STATUS BARU");
   		System.out.println("+-------------------------------------------+");
        System.out.println("1. Sudah Menikah");
        System.out.println("2. Belum Menikah");
        System.out.println("3. Batal");
        System.out.print("Pilih (1-3): ");
        int pilihan = input.nextInt();
        input.nextLine();
        
        switch(pilihan) {
            case 1:
                status[index] = "Sudah Menikah";
                System.out.println("Status berhasil diubah menjadi 'Sudah Menikah'");
                break;
                
            case 2:
                status[index] = "Belum Menikah";
                System.out.println("Status berhasil diubah menjadi 'Belum Menikah'");
                break;
                
            case 3:
                System.out.println("Edit dibatalkan.");
                return;
                
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }
        
        System.out.print("\nTekan enter untuk melanjutkan...");
        input.nextLine();
    }


    public static void tambahDatapenduduk(){
        if (jumlahData >= 100) {
            System.out.println("Database penuh!");
            return;
        }
        
        System.out.printf("\n%30s\n", "========== TAMBAH DATA PENDUDUK ==========");
        
       System.out.print("Masukkan NIK : ");
        String nikBaru = input.nextLine();

        // Cek NIK sudah ada
         boolean nikSudahAda = false;
        for (int i = 0; i < jumlahData; i++) {
            if (nik[i].equals(nikBaru)) {
                nikSudahAda = true;
                break;
            }
        }
        

         if (nikSudahAda) {
            System.out.println("NIK '" + nikBaru + "' sudah terdaftar!");
            System.out.print("Masukkan NIK yang berbeda atau ketik 'batal': ");
            nikBaru = input.nextLine();
            
            if (nikBaru.equalsIgnoreCase("batal")) {
                System.out.println("Data batal ditambah");
                System.out.print("Tekan enter...");
                input.nextLine();
                return;
            }
        }
        
        
        // Input Nama
        System.out.print("Masukkan Nama: ");
        String namaBaru = input.nextLine();
        
        System.out.println("\n+-------------------------------------------+");
	    System.out.printf("| %-41s |\n", "PILIH DESA BARU");
   		System.out.println("+-------------------------------------------+");
        for (int i = 0; i < daftarDesa.length; i++) {
            System.out.println((i + 1) + ". " + daftarDesa[i]);
        }
        System.out.print("Pilih: ");
        int pilihDesa = input.nextInt();
        input.nextLine();
        
        String desaBaru;
        if (pilihDesa >= 1 && pilihDesa <= daftarDesa.length) {
            desaBaru = daftarDesa[pilihDesa - 1];
        } else {
            System.out.println("Pilihan tidak valid! Data tidak disimpan.");
            System.out.print("Tekan enter...");
            input.nextLine();
            return;
        }
        
        System.out.println("\n+-------------------------------------------+");
	    System.out.printf("| %-41s |\n", "PILIH STATUS BARU");
   		System.out.println("+-------------------------------------------+");
        System.out.println("1. Sudah Menikah");
        System.out.println("2. Belum Menikah");
        System.out.print("Pilih: ");
        int pilihStatus = input.nextInt();
        input.nextLine();
        
        String statusBaru;
        if (pilihStatus == 1) {
            statusBaru = "Sudah Menikah";
        } else {
            statusBaru = "Belum Menikah";
        }
        
        nik[jumlahData] = nikBaru;
        nama[jumlahData] = namaBaru;
        desa[jumlahData] = desaBaru;
        status[jumlahData] = statusBaru;
        jumlahData++;
        
        System.out.println("\nData berhasil ditambahkan!");
        System.out.print("Tekan enter...");
        input.nextLine();
    }

    public static void hapusDataPenduduk() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data!");
            return;
        }
        
        System.out.print("Masukkan Nama/NIK data yang ingin di hapus: ");
        String keyword = input.nextLine();
        int index = cariDanpilihpenduduk(keyword);
        
        if (index == -1){
             return;
        }

        System.out.printf("\n%30s\n", "========= HAPUS DATA PENDUDUK =========");
        System.out.println("Data yang akan dihapus:");
        System.out.println("NIK    : " + nik[index]);
        System.out.println("Nama   : " + nama[index]);
        System.out.println("Desa   : " + desa[index]);
        System.out.println("=".repeat(40));

        System.out.print("\nApakah Anda yakin data ingin hapus? (y/n): ");
        String konfirmasi = input.nextLine();
        
        if (konfirmasi.equalsIgnoreCase("y")) {
            for (int i = index; i < jumlahData - 1; i++) {
                nama[i] = nama[i + 1];
                nik[i] = nik[i + 1];
                desa[i] = desa[i + 1];
                status[i] = status[i + 1];
            }
             jumlahData--;
            System.out.println("Data berhasil dihapus!");
        } else {
            System.out.println("Dibatalkan");
        }
        
        System.out.print("Tekan enter untuk kembali...");
        input.nextLine();
    }
        

    
}

  