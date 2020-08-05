<%@ include file="header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">    
  <div class="row">	
  <c:forEach items="${products}" var="product">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading"> ${product.name} </div>
        <div class="panel-body">
        	<p>Price : <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${product.price}"/> ${currency }</p>
		<p>Seller :  ${product.seller} </p>
        </div>
        <div class="panel-footer"> <button type="button" class="btn btn-primary btn-md"
           onClick="location.href='/products/${product.id} ' ">Browse</button></div>
      </div>
    </div>
    </c:forEach>
  </div>
</div><br>

</body>
</html>