# 🚀 Hướng dẫn chạy trang web

Hướng dẫn các bước để chạy trang web, bao gồm cài đặt Tomcat, kết nối MySQL, và các bước thiết lập cần thiết.

# 🎬 Demo
![Animation](https://i.imgur.com/g8PQ1eh.png)


## ✅ Yêu cầu

-   **Java Development Kit (JDK):** ☕ Yêu cầu phiên bản 8 trở lên. Tải về và cài đặt từ [trang chủ Eclipse](https://www.eclipse.org/downloads/).
-   **Apache Tomcat:** 🐱 Yêu cầu phiên bản 9 trở lên. Tải về từ [trang chủ Apache Tomcat](https://tomcat.apache.org/).
-   **MySQL:** 🐬 Yêu cầu phiên bản 8 trở lên. Tải về và cài đặt từ [trang chủ MySQL](https://www.mysql.com/downloads/).
-   **MySQL Connector/J:** 🔌 Tải về từ [trang chủ MySQL](https://www.mysql.com/products/connector/).

## 🛠️ Các bước thực hiện

### a. ⚙️ Cài đặt môi trường

#### a.1. ⚙️ Cài đặt Apache Tomcat

1. **Giải nén** file zip Apache Tomcat đã tải về vào thư mục bạn muốn cài đặt (ví dụ: `C:\Users\ADMIN\Downloads\apache-tomcat-9.0.93-windows-x64\apache-tomcat-9.0.93`).
2. **Cấu hình biến môi trường:** 💻 Cài đặt môi trường trong System Properties.
3. **Kiểm tra cài đặt:**
    -   Mở Command Prompt (hoặc Terminal).
    -   Chạy lệnh: `startup.bat` (Windows) để khởi động Tomcat.
    -   Mở trình duyệt và truy cập vào địa chỉ: `http://localhost:8080`. Nếu thấy trang chào mừng của Tomcat, bạn đã cài đặt thành công.

#### a.2. ⚙️ Cài đặt MySQL

1. **Cài đặt MySQL Server:**
    -   Chạy file cài đặt MySQL đã tải về.
    -   Chọn **Custom** installation type để có thể tùy chỉnh các thiết lập.
    -   Chọn **MySQL Workbench**.
    -   Đặt mật khẩu cho tài khoản `root`.
    -   Hoàn tất quá trình cài đặt.
2. **Tạo cơ sở dữ liệu:**
    -   Mở MySQL Workbench.
    -   Kết nối đến MySQL Server với tài khoản `root`.
    -   Chạy các câu lệnh SQL để tạo cơ sở dữ liệu.
3. **Thêm MySQL Connector/J vào Tomcat:**
    -   Copy file `mysql-connector.jar` vào thư mục `lib` của Tomcat (ví dụ: `C:\Users\ADMIN\eclipse-workspace\duanweb\src\main\webapp\WEB-INF\lib`).

### b. ▶️ Chạy project

-   Mở file index.jsp mà phanggg
