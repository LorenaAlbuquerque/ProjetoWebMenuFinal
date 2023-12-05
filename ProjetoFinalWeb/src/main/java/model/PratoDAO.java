package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PratoDAO {
    public List<Prato> listarPratos() {
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
        return pratos;
    }

    public boolean adicionarPrato(Prato prato) {
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement ps = conexao.prepareStatement("INSERT INTO Prato (nome, ingredientes, tipo) VALUES (?, ?, ?)")) {

            ps.setString(1, prato.getNome());
            ps.setString(2, prato.getIngredientes());
            ps.setString(3, prato.getTipo());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizarPrato(Prato prato) {
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement ps = conexao.prepareStatement("UPDATE Prato SET nome=?, ingredientes=?, tipo=? WHERE id=?")) {

            ps.setString(1, prato.getNome());
            ps.setString(2, prato.getIngredientes());
            ps.setString(3, prato.getTipo());
            ps.setInt(4, prato.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletarPrato(int id) {
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement ps = conexao.prepareStatement("DELETE FROM Prato WHERE id=?")) {

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

