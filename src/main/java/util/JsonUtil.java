package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonUtil {
    // Khởi tạo ObjectMapper duy nhất cho toàn bộ ứng dụng
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Đọc dữ liệu JSON từ request và ánh xạ sang đối tượng kiểu T
     *
     * @param request   HttpServletRequest chứa JSON cần đọc
     * @param valueType Class kiểu T cần ánh xạ
     * @param <T>       Loại đối tượng cần ánh xạ
     * @return Đối tượng kiểu T được ánh xạ từ JSON
     * @throws IOException Nếu xảy ra lỗi khi đọc hoặc ánh xạ JSON
     */
    public static <T> T readJsonRequest(HttpServletRequest request, Class<T> valueType) throws IOException {
        // Kiểm tra nếu request có chứa dữ liệu và là JSON
        if (request.getContentType() != null && request.getContentType().equals("application/json")) {
            // Kiểm tra xem luồng dữ liệu có sẵn không
            if (request.getInputStream().available() > 0) {
                try {
                    // Đọc JSON từ request và ánh xạ vào đối tượng
                    return objectMapper.readValue(request.getInputStream(), valueType);
                } catch (IOException e) {
                    throw new IOException("Lỗi khi ánh xạ JSON sang đối tượng " + valueType.getName() + ": " + e.getMessage(), e);
                }
            } else {
                throw new IOException("Request không chứa dữ liệu JSON.");
            }
        } else {
            throw new IOException("Request không chứa dữ liệu JSON hợp lệ.");
        }
    }

    /**
     * Ghi đối tượng dưới dạng JSON vào response
     *
     * @param response HttpServletResponse để ghi dữ liệu
     * @param object   Đối tượng cần chuyển đổi sang JSON
     * @throws IOException Nếu xảy ra lỗi khi ghi JSON
     */
    public static void writeJsonResponse(HttpServletResponse response, Object object) throws IOException {
        // Đặt header để chỉ định dữ liệu trả về là JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            // Ghi đối tượng vào response dưới dạng JSON
            objectMapper.writeValue(response.getWriter(), object);
        } catch (Exception e) {
            throw new IOException("Lỗi khi ghi đối tượng JSON vào response: " + e.getMessage(), e);
        }
    }
}
