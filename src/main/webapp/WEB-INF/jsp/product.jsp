<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="header.jsp" %>

<div class="container">    
  	
  
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading"> ${product.name} </div>
        <div class="panel-body">
        <p>Description : ${product.description}  </p>
			<p>Price : <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value=" ${product.price}"/> ${currency }</p>
		<p>Seller :  ${product.seller} </p>  
        </div>
        <div class="panel-footer"> <button type="button" class="btn btn-primary btn-md"
        	onClick="location.href='${pageContext.request.contextPath }/cart/buy/${product.id}' ">Buy</button></div>
      </div>
    </div>
   
  </div><br>

</body>
</html>