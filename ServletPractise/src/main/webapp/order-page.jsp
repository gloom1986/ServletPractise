<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <body>

    <H1 style="text-align:center;">Dear ${userName}, your order:</H1>
    <c:forEach var="itemInCart" items="${cart}" varStatus="counter">
      <form style="text-align:center;">
        <tr>
          <td>${counter.count}</td>
          <td>${itemInCart.itemName}</td>
          <td>${itemInCart.itemPrice}$</td>
        </tr>
      </form>
    </c:forEach>
    <br>
    <div style="text-align:center;">Total: ${totalPrice}$</div>

  </body>
</html>