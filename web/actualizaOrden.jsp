<%-- 
    Document   : actualizaOrden
    Created on : 15-abr-2013, 13:29:31
    Author     : vit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle Orden</title>
    </head>
    <body>
        <form action="ServletXML" method="get">
        <input type="text" name="numeroOrden" />
        <input type="text" name="StatusOrden" />
        <input type="submit" value="Actualizar Orden" />
    </form>
    </body>
</html>
