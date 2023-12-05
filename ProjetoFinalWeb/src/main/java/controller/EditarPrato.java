package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prato;
import model.PratoDAO;

@WebServlet("/editarPrato")
public class EditarPrato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String ingredientes = request.getParameter("ingredientes");
        String tipo = request.getParameter("tipo");

        Prato pratoEditado = new Prato(id, nome, ingredientes, tipo);

        PratoDAO pratoDAO = new PratoDAO();
        try {
            pratoDAO.atualizarPrato(pratoEditado);
            response.sendRedirect("listagemPratos.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro", "Erro ao atualizar o prato. Detalhes: " + e.getMessage());
            request.getRequestDispatcher("editarPrato.jsp").forward(request, response);
        }
    }
}
