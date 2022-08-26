import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class Success extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Profile</title></head>");
        out.println("<body>");

        String loginID = request.getParameter("loginId");

        String key = (String) request.getAttribute("key");

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1/university";

            Connection con = DriverManager.getConnection(url, "root", "root");

            Statement st = con.createStatement();

            String query = "Select * from profile where loginID ='" + loginID + "' ";

            ResultSet res = st.executeQuery(query);

            if (res.next()) {
                out.println("<h1>" + key + "</h1>");
                out.println("<h3>Login ID: " + res.getString(1) + " </h3>");
                out.println("<h3>First Name: " + res.getString(2) + " </h3>");
                out.println("<h3>Last Name: " + res.getString(3) + " </h3>");
                out.println("<h3>Email: " + res.getString(4) + " </h3>");
                out.println("<h3>Address: " + res.getString(5) + " </h3>");
                out.println("<h4>Contact No: " + res.getString(6) + " </h4>");
            }

            out.println("<a href=\"login.html\"> Login   </a>");

            out.println("</body></html>");

            out.close();
            st.close();
            con.close();

        } catch (Exception e) {

        }

    }

}
