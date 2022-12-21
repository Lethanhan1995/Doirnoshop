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
        <title>Product-Detail</title>
    </head>

    <body>
        <!-- <--------top-header-------->
        <%@include file="./inc/menu.jsp" %>
        <div class="header-bottom">
            <div class="home-item">
                <ul>
                    <li>
                        <a class="home" href="HomeServlet">
                            <span><i class="fa-solid fa-house-chimney"></i></span>
                        </a>
                    </li>
                    <li class="shop-go">
                        <i class="fa-solid fa-chevron-right"></i>
                        <label class="shop">${product.name}</label>
                    </li>
                </ul>
            </div>
        </div>
        <div class="info-content">
            <div class="info-content-left">
                <div class="info-content-left-big-image">
                    <img src="${product.image}">

                </div>
                <div class="info-content-left-small-image">
                    <img src="./public/image/product10.jpg">
                    <img src="./public/image/product5.jpg">
                    <img src="./public/image/product3.jpg">
                    <img src="./public/image/product4.jpg">


                </div>

            </div>
            <div class="info-content-right">
                <div class="rating">
                    <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                    <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                    <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                    <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                    <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                </div>
                <h4>${product.name}</h4>
                <p class="price">$${product.price}</p>
                <ul class="list-unstyle">
                    <li>
                        Brand:
                        <a href="">Apple</a>
                    </li>
                    <li>
                        Product Code:
                        <span>headphone-product</span>
                    </li>
                    <li>
                        Availability:
                        <span>In Stock</span>
                    </li>
                </ul>
                <div class="qty">
                    <lable>Qty</lable>
                    <input type="text" name="" value="1">
                </div>
                <div class="form-group">
                    <form action="CartServlet" method="post">
                        <input type="hidden" name="productId" value="${product.id}"/>
                        <input type="hidden" name="quantity" value="1"/>
                        <input type="hidden" name="action" value="create"/>
                        <button type="submit" class="cart">Add to cart</button>
                    </form>

                    <button class="heart" type="button"><i class="fa-solid fa-heart"></i></button>
                    <button class="heart" type="button"><i class="fa-solid fa-share"></i></button>
                </div>
                <p class="product-tag">
                    Tag:
                    <span>Palazathemes,</span>
                    <span>Table,</span>
                    <span>Woo,</span>
                    <span>e-Commerce.</span>
                </p>

            </div>


        </div>
        <div class="content-bottom">
            <div class="description">
                <h5>Description</h5>
            </div>
            <div class="tab-content">
                <p>
                    ${product.description}
                </p>
            </div>
        </div>
        <!-- Footer -->
        <%@include file="./inc/footer.jsp" %> 
        <!-- Footer -->

    </body>

</html>