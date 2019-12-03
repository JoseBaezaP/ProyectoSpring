<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"/>
    </head>

    <body>
        <div class="container">
            <h1>Agregar Libros</h1>
            <div class="row">
                <p>
                    <a href="<c:url value="add.htm"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>Agregar</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <th>Isbn</th>
                    <th>nombre</th>
                    <th>autor</th>
                    <th>version</th>
                    <th>editorial</th>
                    <th>acciones</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="libro">
                            <tr>
                                <td><c:out value="${libro.isbn}"/></td>
                                <td><c:out value="${libro.nombre}"/></td>
                                <td><c:out value="${libro.autor}"/></td>
                                <td><c:out value="${libro.version}"/></td>
                                <td><c:out value="${libro.editorial}"/></td>
                                <td>
                                <a href="<c:url value="edit.htm?isbn=${libro.isbn}"/>" class="btn btn-success"><span style="aria-hidden:true;" class="glyphicon glyphicon-pencil"></span>Editar</a>
                                <a href="<c:url value="delete.htm?isbn=${libro.isbn}"/>" class="btn btn-danger"><span style="aria-hidden:true;" class="glyphicon glyphicon-trash"></span>Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
