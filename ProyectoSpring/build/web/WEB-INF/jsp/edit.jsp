<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo de Vista Spring</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"/>

    </head>

    <body>
        <h1>Añadir libro</h1>
        <form:form method="post" commandName="libros">
            <form:errors path="*" element="div" cssClass="alert alert-danger"/>
            <p>
                <form:label path="isbn" >Isbn:</form:label>
                <form:input path="isbn" cssClass="form-control"/>
            </p>
            <p>
                <form:label path="nombre">Nombre:</form:label>
                <form:input path="nombre" cssClass="form-control"/>
            </p>
            <p>
                <form:label path="autor">Autor:</form:label>
                <form:input path="autor" cssClass="form-control"/>
               </p>
               <p> 
               <form:label path="version">Version:</form:label>
                <form:input path="version" cssClass="form-control"/>
                </p>
                <p>
                <form:label path="editorial">Editorial:</form:label>
                <form:input path="editorial" cssClass="form-control"/>
                </p>
                <form:button>Enviar</form:button>
        </form:form>
    </body>
</html>
