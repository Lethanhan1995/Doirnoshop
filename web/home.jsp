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
        <title>Dorno-shop</title>
    </head>

    <body>
        <!-- <--------top-header-------->
        <%@include file="./inc/menu.jsp" %>

        <!-- <--------banner--------->
        <%@include file="./inc/banner.jsp" %>

        <div class="wrapper">
            <div class="container">
                <!-- category -->
                <div class="category">
                    <div class="row">
                        <c:forEach items="${categoryList}" var="category">
                            <div class="col">
                                <a href="CategoryServlet?categoryId=${category.id}"><img src="${category.img}"></a>
                                <p>${category.name}</p>
                            </div>
                        </c:forEach>


                    </div>
                </div>
                <!-- ---------product Seller--------- -->
                <div class="product">
                    <div class="product-header">
                        <h3>
                            <span class="word1">Best</span>
                            <span class="word2">Seller</span>
                            <span class="word3">Products</span>
                        </h3>
                        <p>Add our hot products to your weekly lineup</p>
                        <lable><i class="fa-solid fa-grip-lines"></i></i></lable>
                    </div>
                    <!------- product item---- -->
                    <div class="product-item">
                        <div class="row row-cols-5">
                            <c:forEach items="${productList}" var="product">
                                <div class="col">
                                    <div class="product-item-thump">
                                        <div class="box-lable">
                                            <span class="box-lable-new">New</span>
                                        </div>
                                        <a href="ProductDetailServlet?productId=${product.id}">
                                            <img src="${product.image}">
                                        </a>
                                        <div class="button-group">
                                            <div class="inner">
                                                <button type="button"><i class="fa-solid fa-eye"></i></button>
                                                <button type="button"><i class="fa-solid fa-share"></i></button>
                                                <button type="button"><i class="fa-solid fa-heart"></i></button>
                                            </div>
                                        </div>
                                        <div class="rating">
                                            <span class="rating-item"><i class="fa-solid fa-star"></i></span>
                                            <span class="rating-item"><i class="fa-solid fa-star"></i></span>
                                            <span class="rating-item"><i class="fa-solid fa-star"></i></span>
                                            <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                            <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        </div>
                                        <h4>
                                            <a href="ProductDetailServlet?productId=${product.id}">${product.name}</a>
                                        </h4>
                                        <p class="price">$${product.price}</p>
                                        
                                        <form action="CartServlet" method="post">
                                            <input type="hidden" name="productId" value="${product.id}"/>
                                            <input type="hidden" name="quantity" value="1"/>
                                            <input type="hidden" name="action" value="create"/>
                                            <button type="submit" class="button-cart">Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                    </div>
                    <!-------- product sale----- -->
                    <div class="product-sale">
                        <div class="sale-image">
                            <a href="">
                                <img src="./public/image/sale1.jpg">
                            </a>
                            <a href="">
                                <img src="./public/image/sale2.jpg">
                            </a>
                        </div>
                    </div>
                    <!--------- product-say------ -->
                    <div class="product-say">
                        <div class="product-say-head">
                            <h3>
                                <span class="wordsay">What Our</span>
                                <span class="word">Cilent Say</span>
                            </h3>
                            <p>Welcome to my personal presentation</p>
                            <lable><i class="fa-solid fa-grip-lines"></i></lable>
                        </div>
                        <div class="row row-cols-4">
                            <div class="col">
                                <div class="product-say-item">
                                    <a href="">
                                        <img src="./public/image/say1.png">
                                    </a>
                                    <div class="rating">
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                    </div>
                                    <p>“ Perfect Themes and the best of all that you have many options to choose! Best
                                        Support team ever!Very fast responding and experts on their fields! Thank you very
                                        much! ”</p>
                                    <span>Lindsy Neloms</span>
                                </div>
                            </div>
                            <div class="col">
                                <div class="product-say-item">

                                    <a href="">
                                        <img src="./public/image/say2.png">
                                    </a>
                                    <div class="rating">
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                    </div>
                                    <p>“ When a beautiful design is combined with powerful technology,
                                        it truly is an artwork. I love how my website operates and looks with this theme.
                                        Thank you.”</p>
                                    <span>Amber Laha</span>
                                </div>
                            </div>
                            <div class="col">
                                <div class="product-say-item">

                                    <a href="">
                                        <img src="./public/image/say3.png">
                                    </a>
                                    <div class="rating">
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                    </div>
                                    <p>“ Code, template and others are very good. The support has served me immediately and
                                        solved my problems when I need help. Are to be congratulated. Att Renan Andrade. ”
                                    </p>
                                    <span>Rebecka Filson</span>
                                </div>
                            </div>
                            <div class="col">
                                <div class="product-say-item">

                                    <a href="">
                                        <img src="./public/image/say4.png">
                                    </a>
                                    <div class="rating">
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                        <span class="rating-item"><i class="fa-regular fa-star"></i></span>
                                    </div>
                                    <p>“ Perfect Themes and the best of all that you have many options to choose! Best
                                        Support team ever!Very fast responding and experts on their fields! Thank you very
                                        much! ”</p>
                                    <span>Lindsy Neloms</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--------- --------product-sub-------- -->
                    <div class="product-sub">
                        <div class="product-sub-head">
                            <h3>
                                <span class="word-sub1">Sign Up</span>
                                <span class="word-sub2">For Latest News</span>
                            </h3>
                            <p>Newsletter</p>
                            <lable><i class="fa-solid fa-grip-lines"></i></lable>
                        </div>
                        <div class="product-sub-newsletter">
                            <input type="text" class="newsletter-email" placeholder="Please enter your email to subscribe">
                            <button type="button" class="primary-btn">Subscribe</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer -->
        <%@include file="./inc/footer.jsp" %> 
        <!-- Footer -->

    </body>

</html>
