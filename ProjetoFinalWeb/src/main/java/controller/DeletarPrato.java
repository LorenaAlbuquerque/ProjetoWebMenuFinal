package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PratoDAO;

@WebServlet("/deletarPrato")
public class DeletarPrato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        PratoDAO pratoDAO = new PratoDAO();
        try {
            pratoDAO.deletarPrato(id);
            response.sendRedirect("listagemPratos.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro", "Erro ao deletar o prato. Detalhes: " + e.getMessage());
            request.getRequestDispatcher("listagemPratos.jsp").forward(request, response);
        }
	}
}
