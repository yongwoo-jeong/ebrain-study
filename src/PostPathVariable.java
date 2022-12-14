import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostPathVariable extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("RequestURI", req.getRequestURI());
        req.setAttribute("ContextPath", req.getContextPath());
        req.setAttribute("ServletPath", req.getServletPath());
        String num = req.getRequestURI().substring(req.getContextPath().length()+req.getServletPath().length()+1);
        req.setAttribute("num",num);
        req.getRequestDispatcher("board.jsp").forward(req,res);
    }
}
