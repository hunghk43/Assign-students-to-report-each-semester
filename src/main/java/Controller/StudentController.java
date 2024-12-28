package Controller;

import dao.StudentDAO;
import model.Student;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        if ("delete".equals(action)) {
            int studentId = Integer.parseInt(request.getParameter("id"));
            studentDAO.deleteStudent(studentId);
            response.sendRedirect("students");
        } else if ("edit".equals(action)) {
            int studentId = Integer.parseInt(request.getParameter("id"));
            Student student = studentDAO.getStudentById(studentId);
            request.setAttribute("student", student);
            request.getRequestDispatcher("students/editStudent.jsp").forward(request, response);
        } else if ("list".equals(action)) {
            List<Student> students = studentDAO.getAllStudents();
            request.setAttribute("students", students);
            request.getRequestDispatcher("students/listStudents.jsp").forward(request, response);
        }else {
            // Xử lý mặc định hoặc chuyển hướng đến trang chính
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

         if ("add".equals(action)) {
            String fullName = request.getParameter("fullName");
            int year = Integer.parseInt(request.getParameter("year"));
            String major = request.getParameter("major");
            String studentClass = request.getParameter("className");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
             Student student = new Student(0, 0, fullName, year, major, studentClass, email, phone);
             studentDAO.addStudent(student);
             response.sendRedirect("students?action=list");
        } else if ("update".equals(action)) {
             int studentId = Integer.parseInt(request.getParameter("studentId"));
             String fullName = request.getParameter("fullName");
             int year = Integer.parseInt(request.getParameter("year"));
             String major = request.getParameter("major");
             String studentClass = request.getParameter("className");
             String email = request.getParameter("email");
             String phone = request.getParameter("phone");
             Student student = new Student(studentId, 0, fullName, year, major, studentClass, email, phone);
             studentDAO.updateStudent(student);
             response.sendRedirect("students?action=list");
        } else {
             // Xử lí mặc định
             response.sendRedirect(request.getContextPath() + "/");
        }
    }
}