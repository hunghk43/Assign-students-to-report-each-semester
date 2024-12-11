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
            request.getRequestDispatcher("editStudent.jsp").forward(request, response);
        } else { 
            List<Student> students = studentDAO.getAllStudents();
            request.setAttribute("students", students);
            request.getRequestDispatcher("students.jsp").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8"); 
        response.setCharacterEncoding("UTF-8");
        String studentId = request.getParameter("studentId");
        String fullName = request.getParameter("fullName");
        int year = Integer.parseInt(request.getParameter("year"));
        String major = request.getParameter("major");
        String studentClass = request.getParameter("className");

        Student student = new Student(studentId == null ? 0 : Integer.parseInt(studentId), fullName, year, major, studentClass);
        if (studentId == null || studentId.isEmpty()) {
            // Thêm mới
            studentDAO.addStudent(student);
        } else {
            // Cập nhật
            studentDAO.updateStudent(student);
        }

        response.sendRedirect("students"); // Redirect để doGet được gọi lại
    }
}