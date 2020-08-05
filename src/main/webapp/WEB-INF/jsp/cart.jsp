<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp" %>

<div class="container">
	<div class="row">
		<div class="panel panel-primary">
			<div class="panel-heading">Cart </div>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col"></th>
			      <th scope="col">Name</th>
			      <th scope="col">Price</th>
			      <th scope="col">Quantity</th>
			      <th scope="col">Options</th>
			      <th scope="col" class = "text-right" align="right">Subtotal</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
		<c:set var="total" value="0"></c:set>
		<c:forEach var="item" items="${sessionScope.cart.getItems() }">
			<tr>
				<td align="center"></td>
				<td>${item.product.name }</td>
				<td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.product.price }"/> ${currency }</td>
				<td>${item.quantity }</td>
				<td align="left">
				<a href="${pageContext.request.contextPath }/cart/buy/${item.product.id }" class="btn btn-primary btn-sm"
					onclick="return confirm('Are you sure?')">Add more</a>
				<a href="${pageContext.request.contextPath }/cart/remove/${item.product.id }" class="btn btn-primary btn-sm"
					onclick="return confirm('Are you sure?')">Remove</a>
				</td>
				<td align="right"> <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.subTotal }"/> ${currency }</td>			
				<td></td>	
			</tr>
		</c:forEach>
		<c:forEach var="discounts" items="${sessionScope.cart.getOrderDiscounts() }">
		<tr>
			<td colspan="5" align="right" class = "text-danger">${ discounts.discountMsg}</td>
			<td align="right" class = "text-danger">
			<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${discounts.discountAmount }"/> ${currency }</td>
			<td></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="right"><strong>Total:</strong></td>
			<td align="right"> <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${cart.grandTotal}"/> ${currency }</td>
			<td></td>
		</tr>
			</table>
		</div>	
	</div>
	<div class="panel-footer" align="right"> <button type="button" class="btn btn-primary btn-lg"
        	onClick="location.href='#' ">Checkout</button></div>
</div>