# Tugas4

### **1. Import Library**
```java
import java.util.ArrayList; 
import java.util.Scanner;
```
- `import java.util.ArrayList;`  
  → Mengimpor kelas `ArrayList` dari pustaka `java.util` untuk menyimpan daftar tugas dalam bentuk list dinamis.  
- `import java.util.Scanner;`  
  → Mengimpor kelas `Scanner` yang digunakan untuk membaca input dari pengguna.

---

### **2. Deklarasi Kelas**
```java
public class ToDoList {
    private ArrayList<String> todoList;
```
- `public class ToDoList`  
  → Mendefinisikan kelas `ToDoList`, yang merupakan program daftar tugas (To-Do List).  
- `private ArrayList<String> todoList;`  
  → Mendeklarasikan variabel `todoList` sebagai **ArrayList** bertipe `String` untuk menyimpan daftar tugas.

---

### **3. Konstruktor**
```java
public ToDoList() {
    todoList = new ArrayList<>();
}
```
- **Konstruktor `ToDoList`**  
  → Dipanggil saat objek `ToDoList` dibuat.  
  → Menginisialisasi `todoList` sebagai **ArrayList** kosong.

---

### **4. Metode `addTask` (Menambahkan Tugas)**
```java
public void addTask(String task) {
    todoList.add(task);
    System.out.println("Tugas ditambahkan: " + task);
}
```
- **`addTask(String task)`**  
  → Menambahkan tugas ke dalam `todoList` menggunakan `add()`.  
  → Menampilkan pesan konfirmasi.

---

### **5. Metode `removeTask` (Menghapus Tugas Berdasarkan Nama)**
```java
public void removeTask(String task) {
    if (todoList.remove(task)) {
        System.out.println("Tugas dihapus: " + task);
    } else {
        System.out.println("Tugas tidak ditemukan: " + task);
    }
}
```
- **`removeTask(String task)`**  
  → Mencari dan menghapus tugas dari `todoList`.  
  → Jika tugas ditemukan dan dihapus, tampilkan pesan sukses.  
  → Jika tidak ditemukan, tampilkan pesan error.

---

### **6. Metode `removeTaskByIndex` (Menghapus Tugas Berdasarkan Indeks)**
```java
public void removeTaskByIndex(int index) {
    if (index >= 0 && index < todoList.size()) {
        String removedTask = todoList.remove(index);
        System.out.println("Tugas dihapus: " + removedTask);
    } else {
        System.out.println("Indeks tidak valid: " + index);
    }
}
```
- **`removeTaskByIndex(int index)`**  
  → Menghapus tugas berdasarkan indeks jika **indeks valid**.  
  → Jika indeks tidak valid, menampilkan pesan error.

---

### **7. Metode `displayTasks` (Menampilkan Semua Tugas)**
```java
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
```
- **`displayTasks()`**  
  → Menampilkan semua tugas yang ada di `todoList`.  
  → Jika daftar kosong, menampilkan pesan "Tidak ada tugas".

---

### **8. Metode `searchTask` (Mencari Tugas Berdasarkan Nama)**
```java
public void searchTask(String task) {
    if (todoList.contains(task)) {
        System.out.println("Tugas ditemukan: " + task);
    } else {
        System.out.println("Tugas tidak ditemukan: " + task);
    }
}
```
- **`searchTask(String task)`**  
  → Mengecek apakah tugas tertentu ada di `todoList`.  
  → Jika ditemukan, tampilkan pesan sukses.  
  → Jika tidak ditemukan, tampilkan pesan error.

---

### **9. Metode `main` (Program Utama)**
```java
public static void main(String[] args) {
    ToDoList app = new ToDoList();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;
```
- **`public static void main(String[] args)`**  
  → Metode utama yang dieksekusi pertama kali.  
- `ToDoList app = new ToDoList();`  
  → Membuat objek `app` untuk mengakses metode dalam kelas.  
- `Scanner scanner = new Scanner(System.in);`  
  → Membuat objek `scanner` untuk membaca input pengguna.  
- `boolean running = true;`  
  → Menentukan apakah aplikasi tetap berjalan.

---

### **10. Loop Menu Utama**
```java
while (running) {
```
- **`while (running)`**  
  → Loop terus berjalan hingga pengguna memilih keluar.

---

### **11. Menampilkan Menu**
```java
System.out.println("\nAplikasi Daftar To-Do");
System.out.println("1. Tambah Tugas");
System.out.println("2. Hapus Tugas Berdasarkan Nama Tugas");
System.out.println("3. Hapus Tugas Berdasarkan Indeks");
System.out.println("4. Cari Tugas Berdasarkan Nama Tugas");
System.out.println("5. Tampilkan Tugas");
System.out.println("6. Keluar");
System.out.print("Masukkan pilihan Anda: ");
```
- **Menampilkan menu pilihan kepada pengguna**.

---

### **12. Menerima Input Pilihan**
```java
int choice = scanner.nextInt();
scanner.nextLine();  // Mengonsumsi newline
```
- **`int choice = scanner.nextInt();`**  
  → Membaca pilihan pengguna.  
- **`scanner.nextLine();`**  
  → Mengonsumsi karakter newline agar tidak mengganggu input berikutnya.

---

### **13. Switch-Case untuk Pilihan Menu**
```java
switch (choice) {
    case 1:
        System.out.print("Masukkan tugas untuk ditambahkan: ");
        String taskToAdd = scanner.nextLine();
        app.addTask(taskToAdd);
        break;
```
- **Case 1**: Tambah tugas.  

```java
    case 2:
        System.out.print("Masukkan tugas untuk dihapus: ");
        String taskToRemove = scanner.nextLine();
        app.removeTask(taskToRemove);
        break;
```
- **Case 2**: Hapus tugas berdasarkan nama.

```java
    case 3:
        System.out.print("Masukkan indeks untuk dihapus: ");
        int indexToRemove = scanner.nextInt();
        app.removeTaskByIndex(indexToRemove - 1); // Sesuaikan untuk indeks berbasis 0
        break;
```
- **Case 3**: Hapus tugas berdasarkan indeks (dikurangi 1 agar sesuai dengan indeks `ArrayList`).

```java
    case 4:
        System.out.print("Masukkan tugas untuk dicari: ");
        String taskToSearch = scanner.nextLine();
        app.searchTask(taskToSearch);
        break;
```
- **Case 4**: Cari tugas berdasarkan nama.

```java
    case 5:
        app.displayTasks();
        break;
```
- **Case 5**: Tampilkan semua tugas.

```java
    case 6:
        running = false;
        System.out.println("Keluar dari aplikasi...");
        break;
```
- **Case 6**: Keluar dari aplikasi.

```java
    default:
        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
```
- **Default**: Jika pengguna memasukkan angka selain 1-6, tampilkan pesan error.

---

### **14. Menutup Scanner**
```java
scanner.close();
```
- **`scanner.close();`**  
  → Menutup scanner untuk mencegah kebocoran sumber daya.

---

## **Kesimpulan**
Program `ToDoList` adalah aplikasi **To-Do List berbasis Java** yang memungkinkan pengguna untuk **menambah, menghapus, mencari, dan menampilkan daftar tugas**. Program ini menggunakan **ArrayList** untuk menyimpan daftar tugas dan menggunakan **Scanner** untuk membaca input dari pengguna.
