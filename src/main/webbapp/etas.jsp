<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Stat" %>
<%@ page import="java.util.List" %>

<%
List<Stat> stats = (List<Stat>) request.getAttribute("stats");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <h1>Etas</h1>
  <table border="1">
    <tr>
      <th>prevision</th>
      <th>Montant restant</th>
    </tr>
    <% for(Stat stat : stats){ %>
    <tr>
      <td><%= stat.getLibele() %></td>
      <td><%= stat.getMontant() %></td>
    </tr>
    <% } %>
  </table>
</body>
</html>