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
        <title>Category</title>
    </head>

    <body>
        <!-- <--------top-header-------->
        <%@include file="./inc/menu.jsp" %>

        <!------------------ section------------------------- -->
        <div class="category-content">
            <div class="category-content-top">
                <h1>Shop Headphones</h1>
                <div class="home-item">
                    <ul>
                        <li>
                            <a class="home" href="HomeServlet">
                                <span><i class="fa-solid fa-house-chimney"></i></span>
                            </a>
                        </li>
                        <li class="shop-go">
                            <i class="fa-solid fa-chevron-right"></i>
                            <label class="shop">Shop Headphones</label>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="category-content-section">
                <div class="category-content-left">
                    <div class="category-content-cate">
                        <h3>Categories</h3>
                        <ul>
                            <li class="cate-item"><a href="">Games & Consoles</a></li>
                            <li class="cate-item"><a href="">Appliances</a></li>
                            <li class="cate-item"><a href="">Bakeware</a></li>
                            <li class="cate-item"><a href="">Cookies & Crackers</a></li>
                            <li class="cate-item"><a href="">Mobile & Tablet</a></li>
                            <li class="cate-item"><a href="">Smartwatch</a></li>
                            <li class="cate-item"><a href="">Shop Headphones</a>
                                <ul>
                                    <c:forEach items="${categoryList}" var="category">
                                        <li class="cate-item-thump"><a href="CategoryDetailServlet?categoryId=${category.id}">${category.name}</a></li>
                                        </c:forEach>
                                </ul>
                            </li>
                            <li class="cate-item"><a href="">Bakery</a>
                            <li class="cate-item"><a href="">Breakfast</a>
                            <li class="cate-item"><a href="">Tv & Audio</a>
                        </ul>
                    </div>
                    <div class="cate-sale">
                        <a href="">
                            <img src="./public/image/salecate.jpg">
                        </a>
                    </div>
                </div>
                <div class="category-content-right">
                    <p>We Assist you in Different Fields of Digital Marketing and Web Designing. Skilled Designers.
                        Effective Services. Highlights: Highly Skilled Developers And Designers Available, Providing
                        Effective And Result Oriented Services.</p>
                    <div class="tool-bar">
                        <span>Shop Headphones</span>
                        <div class="form-group">
                            <div class="color">
                                <lable>Color:</lable>
                                <select>
                                    <option value="">Black</option>
                                    <option value="">Red</option>
                                    <option value="">White</option>
                                    <option value="">Green</option>
                                    <option value="">Yellow</option>
                                </select>
                            </div>
                            <form action="CategoryDetailServlet" method="get" class="price">
                                <lable>Price:</lable>
                                <input type="hidden" name="categoryId" value="${categoryId}"/>
                                <input type="hidden" name="orderBy" value="price"/>
                                <select name="order" onchange="this.form.submit()">
                                    <option <c:if test="${order == 'asc' && orderBy == 'price'}">selected</c:if> value="asc">Low to High</option>
                                    <option <c:if test="${order == 'desc' && orderBy == 'price'}">selected</c:if> value="desc">High to Low</option>
                                    </select>
                                </form>

                                <form action="CategoryDetailServlet" method="get" class="sort-by">
                                    <lable>Sort By:</lable>
                                    <input type="hidden" name="categoryId" value="${categoryId}"/>
                                <input type="hidden" name="orderBy" value="name"/>
                                <select name="order" class="sortby" onchange="this.form.submit()">
                                    <option <c:if test="${order == 'asc' && orderBy == 'name'}">selected</c:if> value="asc">Name(A-Z)</option>
                                    <option <c:if test="${order == 'desc' && orderBy == 'name'}">selected</c:if> value="desc">Name(Z-A)</option>
                                    </select>
                                </form>
                            </div>
                        </div>
                        <div class="category-content-item">
                            <div class="container">
                                <div class="row row-cols-3">
                                <c:forEach items="${productList}" var="product">
                                    <div class="col">
                                        <div class="category-content-thump">
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
                                                <a href="">${product.name}</a>
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
                    </div>

                </div>

            </div>
        </div>
    </div>
    <!------- footer----- -->
    <%@include file="./inc/footer.jsp" %>
    <!-- Footer -->
</body>

</html>