package Controller;

import dao.LecturerDAO;
import model.Lecturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/lecturers")
public class LecturerController extends HttpServlet {
    private LecturerDAO lecturerDAO;

    @Override
    public void init() {
        lecturerDAO = new LecturerDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int lecturerId = Integer.parseInt(request.getParameter("id"));
            lecturerDAO.deleteLecturer(lecturerId);
            response.sendRedirect("lecturers");
        } else if ("edit".equals(action)) {
            int lecturerId = Integer.parseInt(request.getParameter("id"));
            Lecturer lecturer = lecturerDAO.getLecturerById(lecturerId);
            request.setAttribute("lecturer", lecturer);
            request.getRequestDispatcher("lecturers/editLecturer.jsp").forward(request, response);
        } else if ("list".equals(action)) {
            List<Lecturer> lecturers = lecturerDAO.getAllLecturers();
            request.setAttribute("lecturers", lecturers);
            request.getRequestDispatcher("lecturers/listLecturers.jsp").forward(request, response);
        }else {
            // Xử lý mặc định hoặc chuyển hướng đến trang chính
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

         if ("add".equals(action)) {
            String fullName = request.getParameter("fullName");
            String department = request.getParameter("department");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
             Lecturer lecturer = new Lecturer(0, 0, fullName, department, email, phone);
             lecturerDAO.addLecturer(lecturer);
             response.sendRedirect("lecturers?action=list");
        } else if ("update".equals(action)) {
             int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
             String fullName = request.getParameter("fullName");
             String department = request.getParameter("department");
             String email = request.getParameter("email");
             String phone = request.getParameter("phone");
             Lecturer lecturer = new Lecturer(lecturerId, 0, fullName, department, email, phone);
             lecturerDAO.updateLecturer(lecturer);
             response.sendRedirect("lecturers?action=list");
        } else {
             // Xử lí mặc định
             response.sendRedirect(request.getContextPath() + "/");
        }
    }
}