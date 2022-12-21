<%-- 
    Document   : cart.jsp
    Created on : Nov 24, 2022, 9:12:24 AM
    Author     : Laptop QHD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
        <link rel="stylesheet" href="./public/css/style.css">
        <link
            href="https://fonts.googleapis.com/css2?family=Open+Sans&family=Oswald:wght@300&family=Poppins:ital,wght@0,400;0,500;1,300&family=Roboto&display=swap"
            rel="stylesheet">
        <title>Cart</title>
    </head>

    <body>
        <!-- <--------top-header-------->
        <%@include file="./inc/menu.jsp" %>

        <!------------------ section------------------------- -->
        <div class="cart-content">
            <div class="cart-content-top">
                <h1>Shopping Cart</h1>
                <div class="home-item">
                    <ul>
                        <li>
                            <a class="home" href="HomeServlet">
                                <span><i class="fa-solid fa-house-chimney"></i></span>
                            </a>
                        </li>
                        <li class="shop-go">
                            <i class="fa-solid fa-chevron-right"></i>
                            <label class="shop">Shopping Cart</label>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="cart-item">
                <!-- left -->
                <div class="cart-item-left">
                    <table>
                        <thead>
                            <tr class="item-th">
                                <td>Product name</td>
                                <td>Quantity</td>
                                <td>Total</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${cart}" var="orderDetailSession">
                                <tr>
                                    <td class="cart-product">
                                        <a href="">
                                            <img src="${orderDetailSession.productImg}">
                                        </a>
                                        <div class="item-name">
                                            <a href="">${orderDetailSession.productName}</a>
                                    </td>
                                    <td>
                                        <div class="quantity">
                                            <form action="CartServlet" method="post" class="quantity-item">
                                                <input type="hidden" name="productId" value="${orderDetailSession.productId}"/>
                                                <input type="hidden" name="action" value="update"/>
                                                <input type="hidden" name="quantity" value="-1"/>
                                                <button type="submit"> - </button>
                                            </form>
                                            <div class="quantity-item">${orderDetailSession.quantity}</div>
                                            <form action="CartServlet" method="post" class="quantity-item">
                                                <input type="hidden" name="productId" value="${orderDetailSession.productId}"/>
                                                <input type="hidden" name="action" value="update"/>
                                                <input type="hidden" name="quantity" value="1"/>
                                                <button type="submit"> + </button>
                                            </form>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="total">
                                            <p>${orderDetailSession.quantity * orderDetailSession.productPrice}</p>

                                            <form action="CartServlet" method="post" class="delete">
                                                <input type="hidden" name="productId" value="${orderDetailSession.productId}"/>
                                                <input type="hidden" name="action" value="delete"/>
                                                <button type="submit" class="fa-solid fa-trash"></button>
                                            </form>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
                <!-- right -->
                <div class="cart-item-right">
                    <h2>Order summary</h2>
                    <div class="sub">
                        <label>Subtotal</label>
                        <p>$${total}</p>
                    </div>
                    <div class="delivery">
                        <label>Delivery</label>
                        <p>Free</p>
                    </div>
                    <div class="right-total">
                        <label>Total</label>
                        <p>$${total}</p>
                    </div>
                    <div class="coupon">
                        <input type="text" placeholder="Coupon">
                        <button type="submit" class="btn-primary">Apply</button>
                    </div>
                    <button class="pro-checkout">
                        <a href="CheckoutServlet">Process to checkout</a>
                    </button>

                </div>

            </div>
        </div>
        <!-- Footer -->
        <%@include file="./inc/footer.jsp" %>
        <!-- Footer -->
    </body>

</html>
