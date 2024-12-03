package Controller;

import dao.*;
import model.*;
import util.*;

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
            JsonUtil.writeJsonResponse(response, student);
        } else {
            List<Student> students = studentDAO.getAllStudents();
            JsonUtil.writeJsonResponse(response, students);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = JsonUtil.readJsonRequest(request, Student.class);
        studentDAO.addStudent(student);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = JsonUtil.readJsonRequest(request, Student.class);
        studentDAO.updateStudent(student);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int studentId = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudent(studentId);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
