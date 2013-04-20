<%-- 
    Document   : DocXML
    Created on : 15-abr-2013, 14:26:40
    Author     : luify
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<body>
<script type="text/javascript">
var xmlDoc = null;
xmlDoc.async=false;
xmlDoc.load("C:\Users\vit\Desktop\Desarrollo\preordenActualizada.xml");

document.write("<table border='1'>");

var x=xmlDoc.getElementsByTagName("orden");
for (i=0;i<x.length;i++)
{
document.write("<tr>");
document.write("<td>");
document.write(
x.getElementsByTagName("numero_identificacion")[0].childNodes[0].nodeValue);
document.write("</td>");

document.write("<td>");
document.write(
x.getElementsByTagName("fecha_lectura")[0].childNodes[0].nodeValue);
document.write("</td>");

document.write("<td>");
document.write(
x.getElementsByTagName("status_orden")[0].childNodes[0].nodeValue);
document.write("</td>");
document.write("</tr>");
}
document.write("</table>");

</script>
</body>
</html>