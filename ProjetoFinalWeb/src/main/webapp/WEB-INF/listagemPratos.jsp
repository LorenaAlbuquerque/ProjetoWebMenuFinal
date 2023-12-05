<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Pratos</title>
</head>
<body>
    <h1>Lista de Pratos</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Ingredientes</th>
                <th>Tipo</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="prato" items="${pratos}">
                <tr>
                    <td>${prato.id}</td>
                    <td>${prato.nome}</td>
                    <td>${prato.ingredientes}</td>
                    <td>${prato.tipo}</td>
                    <td><a href="editarPrato.jsp?id=${prato.id}">Editar</a></td>
                    <td><a href="deletarPrato?id=${prato.id}">Deletar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br/>
    <a href="adicionarPrato.jsp">Adicionar Prato</a>
</body>
</html>
