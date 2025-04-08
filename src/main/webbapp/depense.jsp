<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prevision" %>
<%@ page import="java.util.List" %>
<%
List<Prevision> previsions = (List<Prevision>) request.getAttribute("previsions");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <h1>Ajout d un depnse</h1>
  <form action="addDepense" method="post">
    <div>
      <label for="prevision"> Prevision
          <select id="prevision" name="id_prevision" required>
          <option value="">Selectionner une prevision</option>
          <% for(Prevision pre : previsions){ %>
            <option value="<%= pre.getId() %>"><%= pre.getLibele() %></option>
            <% } %>
          </select>
      </label>
      <div>
        <label for="montant">Montant</label>
        <input type="number" name="montant" min="0" id="montant" required>
      </div>
      <button type="submit" >Valider</button>
    </div>
  </form>
</body>
</html>