import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        out.println("<html>");
        out.println("<head><title>Login Successful</title></head>");
        out.println("<body>");

        try {

            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1/class_test";

            Connection con = DriverManager.getConnection(url, "root", "root");

            Statement st = con.createStatement();

            String query = "Select * from login_details where login='" + login + "' ";
            // out.println(query);

            ResultSet res = st.executeQuery(query);

            if (res.next()) {
                String pa = res.getString("password");
                if (pa.equals(password))
                    out.println("<h1>Successful</h1>");

            } else {
                out.println("<h1>Un-Successful</h1>");
            }

            out.println("</body></html>");

            st.close();
            con.close();
        } catch (Exception e) {
            out.println(e);
        }
    }

}