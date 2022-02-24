import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class blabla {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();
	String kode, nama, gender, jabatan;
	int gaji, manager = 0, admin = 0, supervisor = 0;
	Vector<data> dt = new Vector<>();
	Vector<String> vkode = new Vector<>();

	public blabla() {
		int choose;

		do {
			System.out.println("1. Insert Data Karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan");
			System.out.println("5. Exit");
			System.out.println("choose >");
			choose = sc.nextInt();
			sc.nextLine();

			switch (choose) {
			case 1:
				insertData();
				break;
			case 2:
				view();
				break;
			case 3:
				updateData();
				break;
			case 4:
				delete();
				break;
			case 5:
				System.out.println("Thankyou for using this app!");
				break;
			}

		} while (choose != 5);
	}

	public void insertData() {

		do {
			kode = "\0";
			kode += (char) (rn.nextInt(26) + 'A');
			kode += (char) (rn.nextInt(26) + 'A');
			kode += "-";
			kode += (rn.nextInt(10));
			kode += (rn.nextInt(10));
			kode += (rn.nextInt(10));
			kode += (rn.nextInt(10));

		} while (dt.indexOf(kode) == 0);

		do {
			System.out.println("Nama karyawan (minimal 3 karakter) : ");
			nama = sc.nextLine();
		} while (nama.length() < 3);

		do {
			System.out.println("Jenis kelamin karyawan (Laki-Laki / Perempuan) [Case sensitive]:");
			gender = sc.nextLine();
		} while (!(gender.equals("Laki-Laki") || gender.equals("Perempuan")));

		do {
			System.out.println("Jabatan karyawan (Manager / Supervisor / Admin) [Case sensitive]:");
			jabatan = sc.nextLine();
		} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));

		if (jabatan.equals("Manager")) {
			gaji = 8000000;
			manager++;
			if ((manager - 1) % 3 == 0 && (manager - 1) != 0) {
				for (int i = 0; i < dt.size(); i++) {
					if (dt.get(i).jabatan2.equals("Manager")) {
						dt.get(i).gaji2 += dt.get(i).gaji2 * 10 / 100;
						vkode.add(dt.get(i).kode2);
					}
				}
				System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id");

				for (int j = 0; j < vkode.size(); j++) {
					if (j == vkode.size() - 1) {
						System.out.printf("%s.\n", vkode.get(j));
					} else {
						System.out.printf(" %s,", vkode.get(j));
					}
				}
				vkode.clear();
			}

		} else if (jabatan.equals("Supervisor")) {
			gaji = 6000000;
			supervisor++;
			if ((supervisor - 1) % 3 == 0 && (supervisor - 1) != 0) {
				for (int i = 0; i < dt.size(); i++) {
					if (dt.get(i).jabatan2.equals("Supervisor")) {
						dt.get(i).gaji2 += dt.get(i).gaji2 * 75 / 1000;
						vkode.add(dt.get(i).kode2);
					}
				}
				System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id");

				for (int j = 0; j < vkode.size(); j++) {
					if (j == vkode.size() - 1) {
						System.out.printf("%s.\n", vkode.get(j));
					} else {
						System.out.printf(" %s,", vkode.get(j));
					}
				}
				vkode.clear();
			}
		} else if (jabatan.equals("Admin")) {
			gaji = 4000000;
			admin++;
			if ((admin - 1) % 3 == 0 && (admin - 1) != 0) {
				for (int i = 0; i < dt.size(); i++) {
					if (dt.get(i).jabatan2.equals("Admin")) {
						dt.get(i).gaji2 += dt.get(i).gaji2 * 50 / 1000;
						vkode.add(dt.get(i).kode2);
					}
				}
				System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id");

				for (int j = 0; j < vkode.size(); j++) {
					if (j == vkode.size() - 1) {
						System.out.printf("%s.\n", vkode.get(j));
					} else {
						System.out.printf(" %s,", vkode.get(j));
					}
				}
				vkode.clear();
			}
		}

		data dat = new data(kode, nama, gender, jabatan, gaji);
		dt.add(dat);
		System.out.println("Enter to continue...");
		sc.nextLine();

	}

	public void view() {
		if (dt.isEmpty()) {
			System.out.println("Data tidak ditemukan, silakan pilih menu lainnya...");
			System.out.println("Enter to continue...");sc.nextLine();
		} else {
			sort();
			System.out.println(
					"|----|-----------------|------------------------------|---------------|--------------|-------------|");
			System.out.printf("|%-4s|%-17s|%-30s|%-15s|%-14s|%-13s|\n", "No", "Kode Karyawan", "Nama Karyawan",
					"Jenis Kelamin", "Jabatan", "Gaji Karyawan");
			System.out.println(
					"|----|-----------------|------------------------------|---------------|--------------|-------------|");
			for (int i = 0; i < dt.size(); i++) {
				System.out.printf("|%4s|%17s|%30s|%15s|%14s|%13s|\n", i + 1, dt.get(i).kode2, dt.get(i).nama2,
						dt.get(i).gender2, dt.get(i).jabatan2, dt.get(i).gaji2);

			}
			System.out.println(
					"|----|-----------------|------------------------------|---------------|--------------|-------------|");
		}

	}

	public void sort() {
		for (int i = 0; i < dt.size(); i++) {
			for (int j = 0; j < dt.size() - 1; j++) {
				if (dt.get(j).nama2.compareTo(dt.get(j + 1).nama2) > 0) {
					data temp = dt.get(j);
					dt.set(j, dt.get(j + 1));
					dt.set(j + 1, temp);
				}
			}
		}
	}

	public void updateData() {
		if (dt.isEmpty()) {
			System.out.println("Data tidak ditemukan, silakan pilih menu lainnya...");
			System.out.println("Enter to continue...");sc.nextLine();
		} else {
			view();
			int nmr;
			do {
				System.out.println("Input nomor urutan karyawan yang ingin diupdate : ");
				nmr = sc.nextInt();
				sc.nextLine();
			} while (nmr < 1 || nmr > dt.size());

			do {
				System.out.println("Nama karyawan (minimal 3 karakter) : ");
				nama = sc.nextLine();
			} while (!(nama.length() >= 3 || nama.equals("0")));

			do {
				System.out.println("Jenis kelamin karyawan (Laki-Laki / Perempuan) [Case sensitive]:");
				gender = sc.nextLine();
			} while (!(gender.equals("Laki-Laki") || gender.equals("Perempuan") || gender.equals("0")));

			do {
				System.out.println("Jabatan karyawan (Manager / Supervisor / Admin) [Case sensitive]:");
				jabatan = sc.nextLine();
			} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")
					|| jabatan.equals("0")));

			if (jabatan.equals("Manager")) {
				gaji = 8000000;
				manager++;
				if ((manager - 1) % 3 == 0 && (manager - 1) != 0) {
					for (int i = 0; i < dt.size(); i++) {
						if (dt.get(i).jabatan2.equals("Manager")) {
							dt.get(i).gaji2 += dt.get(i).gaji2 * 10 / 100;
							vkode.add(dt.get(i).kode2);
						}
					}
					System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id");

					for (int j = 0; j < vkode.size(); j++) {
						if (j == vkode.size() - 1) {
							System.out.printf("%s.\n", vkode.get(j));
						} else {
							System.out.printf(" %s,", vkode.get(j));
						}
					}
					vkode.clear();
				}

			} else if (jabatan.equals("Supervisor")) {
				gaji = 6000000;
				supervisor++;
				if ((supervisor - 1) % 3 == 0 && (supervisor - 1) != 0) {
					for (int i = 0; i < dt.size(); i++) {
						if (dt.get(i).jabatan2.equals("Supervisor")) {
							dt.get(i).gaji2 += dt.get(i).gaji2 * 75 / 1000;
							vkode.add(dt.get(i).kode2);
						}
					}
					System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id");

					for (int j = 0; j < vkode.size(); j++) {
						if (j == vkode.size() - 1) {
							System.out.printf("%s.\n", vkode.get(j));
						} else {
							System.out.printf(" %s,", vkode.get(j));
						}
					}
					vkode.clear();
				}
			} else if (jabatan.equals("Admin")) {
				gaji = 4000000;
				admin++;
				if ((admin - 1) % 3 == 0 && (admin - 1) != 0) {
					for (int i = 0; i < dt.size(); i++) {
						if (dt.get(i).jabatan2.equals("Admin")) {
							dt.get(i).gaji2 += dt.get(i).gaji2 * 50 / 1000;
							vkode.add(dt.get(i).kode2);
						}
					}
					System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id");

					for (int j = 0; j < vkode.size(); j++) {
						if (j == vkode.size() - 1) {
							System.out.printf("%s.\n", vkode.get(j));
						} else {
							System.out.printf(" %s,", vkode.get(j));
						}
					}
					vkode.clear();
				}

			}

			if (!nama.equals("0")) {
				dt.get(nmr - 1).nama2 = nama;
			}

			if (!gender.equals("0")) {
				dt.get(nmr - 1).gender2 = gender;
			}

			if (!jabatan.equals("0")) {
				if (dt.get(nmr - 1).equals("Manager")) {
					manager--;
				} else if (dt.get(nmr - 1).equals("Supervisor")) {
					supervisor--;
				} else if (dt.get(nmr - 1).equals("Admin")) {
					admin--;
				}
				dt.get(nmr - 1).jabatan2 = jabatan;
				dt.get(nmr - 1).gaji2 = gaji;
			}
			System.out.printf("Berhasil mengupdate karyawan dengan id %s\n", dt.get(nmr - 1).kode2);
			System.out.println("Enter to continue...");
		}

	}

	public void delete() {
		if (dt.isEmpty()) {
			System.out.println("Data tidak ditemukan, silakan pilih menu lainnya...");
			System.out.println("Enter to continue...");sc.nextLine();
		} else {
			view();
			int num;
			do {
				System.out.println("Input nomor urutan karyawan yang ingin dihapus : ");
				num = sc.nextInt();
				sc.nextLine();
			} while (num < 1 || num > dt.size());

			System.out.printf("Karyawan dengan kode %s berhasil dihapus\n", dt.get(num - 1).kode2);
			dt.remove(num - 1);
			System.out.println("Enter to continue...");
			sc.nextLine();
		}

	}

	public static void main(String[] args) {
		new blabla();

	}

}
