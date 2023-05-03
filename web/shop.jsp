<%-- 
    Document   : shop
    Created on : Apr 21, 2023, 7:36:47 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./public/img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="./public/lib/animate/animate.min.css" rel="stylesheet">
        <link href="./public/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="./public/css/style.css" rel="stylesheet">

    </head>
    <body>
        <%@include file="./inc/header.jsp" %>
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-12">
                    <nav class="breadcrumb bg-light mb-30">
                        <a class="breadcrumb-item text-dark" href="HomeServlet">Home</a>
                        <a class="breadcrumb-item text-dark" href="ShopServlet">Shop</a>
                        <span class="breadcrumb-item active">Shop List</span>
                    </nav>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row px-xl-5">
                <%@include file="./inc/sideBar.jsp" %>
                <div class="col-lg-9 col-md-8">
                    <div class="row pb-3">
                        <div class="col-12 pb-1">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <div>
                                    <button class="btn btn-sm btn-light"><i class="fa fa-th-large"></i></button>
                                    <button class="btn btn-sm btn-light ml-2"><i class="fa fa-bars"></i></button>
                                </div>
                                <div class="ml-2">
                                    <form action="ShopServlet" method="get">
                                        <label for="sortOrder">Sắp xếp theo:</label>
                                        <select id="sortOrder" class="py-1 border-0" name="sortOrder">
                                            <option value="priceAsc">Giá từ thấp đến cao</option>
                                            <option value="priceDesc">Giá từ cao đến thấp</option>
                                            <option value="newest">Sản phẩm mới nhất</option>
                                        </select>
                                        <button class="py-1 border-0 px-2 bg-warning" type="submit">Lọc</button>
                                    </form>

                                </div>
                            </div>
                        </div>
                        <c:forEach items="${productList}" var="product" begin="">
                            <div class="col-lg-4 col-md-6 col-sm-6 pb-1">
                                <div class="product-item bg-light mb-4">
                                    <div class="product-img position-relative overflow-hidden">
                                        <img class="img-fluid w-100" src="${product.img}" alt="">
                                        <div class="product-action">
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
                                        </div>
                                    </div>
                                    <div class="text-center py-4">
                                        <a class="h6 text-decoration-none text-truncate" href="ProductDetailServlet?product_id=${product.id}">${product.name}</a>
                                        <div class="d-flex align-items-center justify-content-center mt-2">
                                            <h5>${product.price}</h5><h6 class="text-muted ml-2"><del>$123.00</del></h6>
                                        </div>
                                        <div class="d-flex align-items-center justify-content-center mb-1">
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small>(99)</small>
                                        </div>
                                    </div>

                                </div>

                            </div>
                        </c:forEach>

                    </div>

                </div>
                <div class="col-12">
                    <nav>
                        <ul class="pagination justify-content-center">
                            <li class="page-item disabled"><a class="page-link" href="#">Previous</span></a></li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#">Next</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <%@include file="./inc/footer.jsp" %>
    </body>
</html>
