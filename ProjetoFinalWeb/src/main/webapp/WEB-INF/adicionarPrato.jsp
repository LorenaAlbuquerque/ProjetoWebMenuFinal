<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Adicionar Prato</title>
</head>
<body>
    <h1>Adicionar Prato</h1>
    <form action="adicionarPrato" method="post">
        Nome: <input type="text" name="nome"><br>
        Ingredientes: <input type="text" name="ingredientes"><br>
        Tipo: <input type="text" name="tipo"><br>
        <input type="submit" value="Adicionar">
    </form>
    <br/>
    <a href="listagemPratos.jsp">Voltar para a Lista de Pratos</a>
</body>
</html>
