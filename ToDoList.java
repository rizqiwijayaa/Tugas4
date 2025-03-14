import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> todoList;

    // Konstruktor untuk menginisialisasi ArrayList
    public ToDoList() {
        todoList = new ArrayList<>();
    }

    // Metode untuk menambahkan tugas
    public void addTask(String task) {
        todoList.add(task);
        System.out.println("Tugas ditambahkan: " + task);
    }

    // Metode untuk menghapus tugas berdasarkan nama tugas
    public void removeTask(String task) {
        if (todoList.remove(task)) {
            System.out.println("Tugas dihapus: " + task);
        } else {
            System.out.println("Tugas tidak ditemukan: " + task);
        }
    }

    // Metode untuk menghapus tugas berdasarkan indeks
    public void removeTaskByIndex(int index) {
        if (index >= 0 && index < todoList.size()) {
            String removedTask = todoList.remove(index);
            System.out.println("Tugas dihapus: " + removedTask);
        } else {
            System.out.println("Indeks tidak valid: " + index);
        }
    }

    // Metode untuk menampilkan semua tugas
    public void displayTasks() {
        if (todoList.isEmpty()) {
            System.out.println("Tidak ada tugas dalam daftar.");
        } else {
            System.out.println("Tugas dalam daftar:");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }

    // Metode untuk mencari tugas berdasarkan nama
    public void searchTask(String task) {
        if (todoList.contains(task)) {
            System.out.println("Tugas ditemukan: " + task);
        } else {
            System.out.println("Tugas tidak ditemukan: " + task);
        }
    }

    public static void main(String[] args) {
        ToDoList app = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Menampilkan menu
            System.out.println("\nAplikasi Daftar To-Do");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Hapus Tugas Berdasarkan Nama Tugas");
            System.out.println("3. Hapus Tugas Berdasarkan Indeks");
            System.out.println("4. Cari Tugas Berdasarkan Nama Tugas");
            System.out.println("5. Tampilkan Tugas");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Mengonsumsi newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan tugas untuk ditambahkan: ");
                    String taskToAdd = scanner.nextLine();
                    app.addTask(taskToAdd);
                    break;

                case 2:
                    System.out.print("Masukkan tugas untuk dihapus: ");
                    String taskToRemove = scanner.nextLine();
                    app.removeTask(taskToRemove);
                    break;

                case 3:
                    System.out.print("Masukkan indeks untuk dihapus: ");
                    int indexToRemove = scanner.nextInt();
                    app.removeTaskByIndex(indexToRemove - 1); // Sesuaikan untuk indeks berbasis 0
                    break;

                case 4:
                    System.out.print("Masukkan tugas untuk dicari: ");
                    String taskToSearch = scanner.nextLine();
                    app.searchTask(taskToSearch);
                    break;

                case 5:
                    app.displayTasks();
                    break;

                case 6:
                    running = false;
                    System.out.println("Keluar dari aplikasi...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }
}