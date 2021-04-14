package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccTermo implements Command {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
		response.sendRedirect("index.jsp");
    }
}
