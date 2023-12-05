package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prato;
import model.PratoDAO;

@WebServlet("/adicionarPrato")
public class AdicionarPrato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String ingredientes = request.getParameter("ingredientes");
        String tipo = request.getParameter("tipo");

        Prato novoPrato = new Prato(0, nome, ingredientes, tipo); 

        PratoDAO pratoDAO = new PratoDAO();
        try {
            pratoDAO.adicionarPrato(novoPrato);
            response.sendRedirect("listagemPratos.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro", "Erro ao adicionar o prato. Detalhes: " + e.getMessage());
            request.getRequestDispatcher("adicionarPrato.jsp").forward(request, response);
        }
	}
}