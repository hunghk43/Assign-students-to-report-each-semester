package Controller;

import dao.*;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentController extends HttpServlet {
    private StudentDAO studentDAO;

    @Override
    public void init() {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String studentId = request.getParameter("id");
        if (studentId != null) {
            Student student = studentDAO.getStudentById(Integer.parseInt(studentId));
            // Sử dụng phương thức writeJsonResponse hoặc thay đổi để dùng form truyền thống
        } else {
            List<Student> students = studentDAO.getAllStudents();
            // Sử dụng phương thức writeJsonResponse hoặc thay đổi để dùng form truyền thống
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Đọc dữ liệu từ form truyền thống thay vì JSON
        String fullName = request.getParameter("fullName");
        int year = Integer.parseInt(request.getParameter("year"));
        String major = request.getParameter("major");
        String studentClass = request.getParameter("className");

        Student student = new Student(0, fullName, year, major, studentClass); // ID sẽ được auto-generated
        studentDAO.addStudent(student);
        response.sendRedirect("students.jsp"); // Điều hướng về trang danh sách sinh viên
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Đọc dữ liệu từ form truyền thống
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String fullName = request.getParameter("fullName");
        int year = Integer.parseInt(request.getParameter("year"));
        String major = request.getParameter("major");
        String studentClass = request.getParameter("className");

        // Tạo đối tượng sinh viên mới với ID đã có
        Student student = new Student(studentId, fullName, year, major, studentClass);

        // Cập nhật sinh viên trong cơ sở dữ liệu
        studentDAO.updateStudent(student);

        // Điều hướng lại đến trang sinh viên
        response.sendRedirect("students.jsp"); // Hoặc bạn có thể truyền thêm tham số để xác nhận
    }

   

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudent(studentId);
        response.sendRedirect("students.jsp"); // Điều hướng về trang danh sách sinh viên
    }
}
