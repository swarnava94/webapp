import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "password";

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("user.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));

    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users (name, age) VALUES (?, ?)")) {
      ps.setString(1, name);
      ps.setInt(2, age);
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new ServletException("Database access error", e);
    }

    request.setAttribute("name", name);
    request.setAttribute("age", age);
    request.getRequestDispatcher("user.jsp").forward(request, response);
  }
}
