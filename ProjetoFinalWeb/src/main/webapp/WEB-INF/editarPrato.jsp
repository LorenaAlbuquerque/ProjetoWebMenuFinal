<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Prato</title>
</head>
<body>
    <h1>Editar Prato</h1>
    <form action="editarPrato" method="post">
        ID: <input type="text" name="id" value="${prato.id}" readonly><br>
        Nome: <input type="text" name="nome" value="${prato.nome}"><br>
        Ingredientes: <input type="text" name="ingredientes" value="${prato.ingredientes}"><br>
        Tipo: <input type="text" name="tipo" value="${prato.tipo}"><br>
        <input type="submit" value="Salvar">
    </form>
    <br/>
    <a href="listagemPratos.jsp">Voltar para a Lista de Pratos</a>
</body>
</html>
