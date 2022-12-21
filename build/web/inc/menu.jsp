<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <--------top-header-------->
<header>
    <div class="logo">
        <a href="HomeServlet">
            <img src="./public/image/dorno.png" />
        </a>
    </div>
    <div class="menu">
        <li class="menu-item"><a href="HomeServlet">Home</a></li>
        <li class="menu-item"><a href="CategoryServlet">Shop</a></li>
        <li class="menu-item"><a href="">Accessories</a></li>
        <li class="menu-item"><a href="">Specials</a></li>
        <li class="menu-item"><a href="">Contact Us</a></li>
        <li class="menu-item"><a href="">Blog</a></li>
    </div>
    <div class="other">
        <li>
            <form action="ProductSearchServlet" method="get">
                <input name="search" type="text" placeholder="Tìm kiếm"><i class="fa-solid fa-magnifying-glass" href=""></i>
            </form>
        </li>
        <li><a class="fa-solid fa-cart-shopping" href="CartServlet"></a></li>
        <li>
        <c:if test="${sessionScope.user == null}">
            <a class="fa-solid fa-user" href="LoginServlet"></a>
        </c:if>
        <c:if test="${sessionScope.user != null}">
            <a href="LogoutServlet">Logout</a>
        </c:if>
        </li>
    </div>
</header>
