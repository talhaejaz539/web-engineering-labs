import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String loginID = request.getParameter("loginId");
        String password = request.getParameter("password");

        try {

            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1/university";

            Connection con = DriverManager.getConnection(url, "root", "root");

            Statement st = con.createStatement();

            String query = "Select * from logininfo where loginID ='" + loginID + "' AND password = '" + password
                    + "' ";

            ResultSet res = st.executeQuery(query);

            if (res.next()) {
                String msg = "Login Successful";
                request.setAttribute("key", msg);

                RequestDispatcher rd = request.getRequestDispatcher("/Success");

                rd.forward(request, response);

            }

            else {
                String msg = "Login Failure";
                request.setAttribute("key", msg);

                RequestDispatcher rd = request.getRequestDispatcher("/Error");

                rd.forward(request, response);
            }

            out.close();
            st.close();
            con.close();
        } catch (Exception e) {
            out.println(e);
        }
    }

}