<%-- 
    Document   : index
    Created on : 15-abr-2013, 13:12:02
    Author     : vit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>QR Code in Java Servlet - viralpatel.net</title>
</head>
<body>
     
    <form action="qrservlet" method="get">
        <p>Enter Text to create QR Code</p>
        <input type="text" name="qrtext" value="http://192.168.1.110:8080/qrCodigo/actualizaOrden.jsp?qrtext=" />
        
        <input type="submit" value="Generate QR Code" />
    </form>
</body>
</html>