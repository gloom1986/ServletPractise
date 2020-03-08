<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <body>

    <H1 style="text-align:center;">Hello, ${userName}</H1>
    <c:if test = "${cart != null}">
      <div style="text-align:center;">You have already chosen:</div>
      <c:forEach var="itemInCart" items="${cart}">
        <div style="text-align:center;">${itemInCart}</div>
      </c:forEach>
    </c:if>

    <form action="/shop" method="POST" style="text-align:center;">
      <div style="text-align:center;">Make your order:</div>
      <select name="selectedItem">
        <c:forEach var="item" items="${items}">
          <option>
            <span>${item}</span>
          </option>
        </c:forEach>
      </select>
      <br>
      <button>Add Item</button>
    </form>

    <form action="/order" method="POST" style="text-align:center;">
      <button>Submit</button>
    </form>

  </body>
</html>