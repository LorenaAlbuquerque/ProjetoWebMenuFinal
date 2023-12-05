package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prato;
import model.ConexaoBD;

@WebServlet("/prato")
public class PratoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Prato> pratos = new ArrayList<>();
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement ps = conexao.prepareStatement("SELECT * FROM Prato");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Prato prato = new Prato(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("ingredientes"),
                    rs.getString("tipo")
                );
                pratos.add(prato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("pratos", pratos);
        request.getRequestDispatcher("/prato.jsp").forward(request, response);
    }
}
