# 🛍️ Belanjain: Full-Stack E-Commerce System

Aplikasi web E-commerce *multi-vendor* yang dirancang dengan arsitektur *Decoupled* (Frontend terpisah dari Backend)[cite: 1]. Platform ini tidak hanya memfasilitasi transaksi jual-beli yang mulus, tetapi juga memberikan kendali penuh kepada penjual melalui dasbor analitik dan otomatisasi operasional[cite: 1].

[![Demo Video](https://img.shields.io/badge/YouTube-Tonton_Demo_Aplikasi-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](https://www.youtube.com/watch?v=DCk8keAT7NQ)

---

## ✨ Tampilan Antarmuka & Bukti Fungsionalitas

*Antarmuka dirancang dengan mengedepankan prinsip inklusivitas dan estetika minimalis, menggunakan palet warna earthy-tone untuk memberikan kenyamanan visual bagi pengguna.*

| Katalog Produk (Pencarian & Filter) | Dasbor Analitik Penjual |
| :---: | :---: |
| <img src="https://github.com/user-attachments/assets/a6708d32-d375-4c6e-b2a7-2df381a7a338" width="400"> | <img src="https://github.com/user-attachments/assets/99b9a45a-9d3f-4a4f-945a-c4183ac4c986" width="400"> |
| **Manajemen Inventaris (Low Stock Alert)** | **Manajemen Pesanan Masuk (Siklus Transaksi)** |
| <img src="https://github.com/user-attachments/assets/921374ff-6488-4336-aa60-3fd469131471" width="400"> | <img src="https://github.com/user-attachments/assets/80583a01-b23b-4a74-9b17-7361d2ac1916" width="400"> |
| **Notifikasi Split Order Checkout** | **Otomatisasi Notifikasi Email** |
| <img src="https://github.com/user-attachments/assets/8591ec27-ada6-4d50-ab42-ba0d91e70eef" width="400"> | <img src="https://github.com/user-attachments/assets/02848eb7-c806-45c2-9d77-ee35247f7e73" width="400"> |

> *Catatan: Gambar di atas membuktikan kelancaran alur dari mulai pemilihan produk hingga laporan otomatis mingguan.*

---

## 🚀 Fitur Unggulan

*   **Logika Split Order (Multi-Vendor):** Mampu menangani satu keranjang belanja yang berisi produk dari berbagai toko berbeda, lalu memecahnya secara atomik menjadi beberapa Nomor Order terpisah secara otomatis saat *checkout*[cite: 1].
*   **Otomatisasi Laporan (Cron Jobs):** Sistem *background service* yang secara rutin memindai transaksi mingguan dan mengirimkan rekapitulasi pendapatan langsung ke email penjual via layanan SMTP Nodemailer[cite: 1].
*   **Manajemen Inventaris Cerdas:** Menghadirkan tabel stok interaktif (*inline editing*) yang dilengkapi dengan sistem *Low Stock Alerts* (indikator visual peringatan saat stok produk berada di bawah 10 unit)[cite: 1].
*   **Dasbor Analitik Penjual:** Menyajikan visualisasi tren penjualan harian, mingguan, dan bulanan yang mudah dipahami menggunakan pustaka grafik Recharts[cite: 1].
*   **Keamanan Berlapis:** Implementasi *Role-Based Access Control* (RBAC) untuk memisahkan hak akses Penjual dan Pembeli secara ketat, didukung oleh autentikasi berbasis JWT (*Access Token* & *Refresh Token*)[cite: 1].

---

## 🛠️ Teknologi yang Digunakan

**Frontend (Client-Side)**
*   **React.js:** Membangun antarmuka interaktif berbasis *Single Page Application* (SPA)[cite: 1].
*   **Tailwind CSS:** Penataan gaya (*styling*) untuk desain yang responsif dan modern[cite: 1].
*   **Axios:** Komunikasi data ke server dengan *Interceptor* untuk penyematan token otomatis[cite: 1].
*   **Recharts:** Rendering grafik visualisasi data pada dasbor[cite: 1].

**Backend (Server-Side)**
*   **NestJS:** Kerangka kerja Node.js berbasis TypeScript dengan arsitektur yang sangat modular[cite: 1].
*   **Prisma ORM:** Manajemen basis data dan eksekusi transaksi yang aman (*Database Transaction*)[cite: 1].
*   **MySQL:** Sistem manajemen basis data relasional utama[cite: 1].
*   **Bcrypt & JWT:** Enkripsi kata sandi dan manajemen token sesi otorisasi pengguna[cite: 1].

---

## 📊 Pengujian Sistem (Testing)

Sistem ini telah melewati pengujian komprehensif menggunakan **Jest** dan **Supertest** untuk memastikan keandalan logika bisnis yang kompleks[cite: 1]:
*   **63 Skenario Uji (End-to-End Testing):** 100% *Passed* tanpa kegagalan logika, memvalidasi fitur-fitur kritis seperti *Split Order* multi-penjual maupun pengembalian stok otomatis (*Restock on Cancel*)[cite: 1].
*   **86.9% Code Coverage:** Mengindikasikan bahwa hampir seluruh baris instruksi dan fungsi inti telah tereksekusi dan tervalidasi kebenarannya selama proses pengujian otomatis[cite: 1].
