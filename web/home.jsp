<%-- 
    Document   : home
    Created on : Apr 7, 2023, 8:46:23 AM
    Author     : Administrator
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List,trung.dev.dao.model.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="./public/css/util.css" />
        <link rel="stylesheet" type="text/css" href="./public/css/main.css" />
        <link rel="icon" type="image/png" href="./public/images/icons/favicon.png" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="./public/vendor/bootstrap/css/bootstrap.min.css" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="./public/fonts/font-awesome-4.7.0/css/font-awesome.min.css" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="./public/fonts/iconic/css/material-design-iconic-font.min.css" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="./public/fonts/linearicons-v1.0.0/icon-font.min.css" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="'./public/vendor/animate/animate.css" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="./public/vendor/css-hamburgers/hamburgers.min.css" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="./public/vendor/animsition/css/animsition.min.css" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="./public/vendor/select2/select2.min.css" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="./public/vendor/perfect-scrollbar/perfect-scrollbar.css" />
    </head>
    <body>
        <%@include file="./inc/header.jsp" %>

        <div class="bg0 m-t-23 p-b-140">
            <div class="container">
                <div class="flex-w flex-sb-m p-b-52">
                    <div class="flex-w flex-l-m filter-tope-group m-tb-10">
                        <button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5 how-active1" data-filter="*">
                            All Products
                        </button>

                        <button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".women">
                            Women
                        </button>

                        <button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".men">
                            Men
                        </button>

                        <button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".bag">
                            Bag
                        </button>

                        <button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".shoes">
                            Shoes
                        </button>

                        <button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".watches">
                            Watches
                        </button>
                    </div>

                    <div class="flex-w flex-c-m m-tb-10">
                        <div class="flex-c-m stext-106 cl6 size-104 bor4 pointer hov-btn3 trans-04 m-r-8 m-tb-4 js-show-filter">
                            <i class="icon-filter cl2 m-r-6 fs-15 trans-04 zmdi zmdi-filter-list"></i>
                            <i class="icon-close-filter cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"></i>
                            Filter
                        </div>

                        <div class="flex-c-m stext-106 cl6 size-105 bor4 pointer hov-btn3 trans-04 m-tb-4 js-show-search">
                            <i class="icon-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-search"></i>
                            <i class="icon-close-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"></i>
                            Search
                        </div>
                    </div>

                    <!-- Search product -->
                    <div class="dis-none panel-search w-full p-t-10 p-b-15">
                        <div class="bor8 dis-flex p-l-15">
                            <button class="size-113 flex-c-m fs-16 cl2 hov-cl1 trans-04">
                                <i class="zmdi zmdi-search"></i>
                            </button>

                            <input class="mtext-107 cl2 size-114 plh2 p-r-15" type="text" name="search-product" placeholder="Search">
                        </div>
                    </div>

                    <!-- Filter -->
                    <div class="dis-none panel-filter w-full p-t-10">
                        <div class="wrap-filter flex-w bg6 w-full p-lr-40 p-t-27 p-lr-15-sm">
                            <div class="filter-col1 p-r-15 p-b-27">
                                <div class="mtext-102 cl2 p-b-15">
                                    Sort By
                                </div>

                                <ul>
                                    <li class="p-b-6">
                                        <a href="#" class="filter-link stext-106 trans-04">
                                            Default
                                        </a>
                                    </li>

                                    <li class="p-b-6">
                                        <a href="#" class="filter-link stext-106 trans-04">
                                            Popularity
                                        </a>
                                    </li>

                                    <li class="p-b-6">
                                        <a href="#" class="filter-link stext-106 trans-04">
                                            Average rating
                                        </a>
                                    </li>

                                    <li class="p-b-6">
                                        <a href="#" class="filter-link stext-106 trans-04 filter-link-active">
                                            Newness
                                        </a>
                                    </li>

                                    <li class="p-b-6">
                                        <a href="#" class="filter-link stext-106 trans-04">
                                            Price: Low to High
                                        </a>
                                    </li>

                                    <li class="p-b-6">
                                        <a href="#" class="filter-link stext-106 trans-04">
                                            Price: High to Low
                                        </a>
                                    </li>
                                </ul>
                            </div>

                            <div class="filter-col2 p-r-15 p-b-27">
                                <div class="mtext-102 cl2 p-b-15">
                                    Price
                                </div>

                                <ul>
                                    <li class="p-b-6">
                                        <a href="#" class="filter-link stext-106 trans-04 filter-link-active">
                                            All
                                        </a>
                                    </li>

                                    <li class="p-b-6">
                                        <a href="#" class="filter-link stext-106 trans-04">
                                            $0.00 - $50.00
                                        </a>
                                    </li>

                                    <li class="p-b-6">
                                        <a href="#" class="filter-link stext-106 trans-04">
                                            $50.00 - $100.00
                                        </a>
                                    </li>

                                    <li class="p-b-6">
                                        <a href="#" class="filter-link stext-106 trans-04">
                                            $100.00 - $150.00
                                        </a>
                                    </li>

                                    <li class="p-b-6">
                                        <a href="#" class="filter-link stext-106 trans-04">
                                            $150.00 - $200.00
                                        </a>
                                    </li>

                                    <li class="p-b-6">
                                        <a href="#" class="filter-link stext-106 trans-04">
                                            $200.00+
                                        </a>
                                    </li>
                                </ul>
                            </div>

                            <div class="filter-col3 p-r-15 p-b-27">
                                <div class="mtext-102 cl2 p-b-15">
                                    Color
                                </div>

                                <ul>
                                    <li class="p-b-6">
                                        <span class="fs-15 lh-12 m-r-6" style="color: #222;">
                                            <i class="zmdi zmdi-circle"></i>
                                        </span>

                                        <a href="#" class="filter-link stext-106 trans-04">
                                            Black
                                        </a>
                                    </li>

                                    <li class="p-b-6">
                                        <span class="fs-15 lh-12 m-r-6" style="color: #4272d7;">
                                            <i class="zmdi zmdi-circle"></i>
                                        </span>

                                        <a href="#" class="filter-link stext-106 trans-04 filter-link-active">
                                            Blue
                                        </a>
                                    </li>

                                    <li class="p-b-6">
                                        <span class="fs-15 lh-12 m-r-6" style="color: #b3b3b3;">
                                            <i class="zmdi zmdi-circle"></i>
                                        </span>

                                        <a href="#" class="filter-link stext-106 trans-04">
                                            Grey
                                        </a>
                                    </li>

                                    <li class="p-b-6">
                                        <span class="fs-15 lh-12 m-r-6" style="color: #00ad5f;">
                                            <i class="zmdi zmdi-circle"></i>
                                        </span>

                                        <a href="#" class="filter-link stext-106 trans-04">
                                            Green
                                        </a>
                                    </li>

                                    <li class="p-b-6">
                                        <span class="fs-15 lh-12 m-r-6" style="color: #fa4251;">
                                            <i class="zmdi zmdi-circle"></i>
                                        </span>

                                        <a href="#" class="filter-link stext-106 trans-04">
                                            Red
                                        </a>
                                    </li>

                                    <li class="p-b-6">
                                        <span class="fs-15 lh-12 m-r-6" style="color: #aaa;">
                                            <i class="zmdi zmdi-circle-o"></i>
                                        </span>

                                        <a href="#" class="filter-link stext-106 trans-04">
                                            White
                                        </a>
                                    </li>
                                </ul>
                            </div>

                            <div class="filter-col4 p-b-27">
                                <div class="mtext-102 cl2 p-b-15">
                                    Tags
                                </div>

                                <div class="flex-w p-t-4 m-r--5">
                                    <a href="#" class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
                                        Fashion
                                    </a>

                                    <a href="#" class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
                                        Lifestyle
                                    </a>

                                    <a href="#" class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
                                        Denim
                                    </a>

                                    <a href="#" class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
                                        Streetstyle
                                    </a>

                                    <a href="#" class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
                                        Crafts
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row isotope-grid">
                    <c:forEach items="${productList}" var="product">


                        <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
                            <!-- Block2 -->
                            <div class="block2">
                                <div class="block2-pic hov-img0">
                                    <img src="${product.img}" alt="IMG-PRODUCT">

                                    <a href="#" class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                        Quick View
                                    </a>
                                </div>

                                <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                        <a href="productDetailServlet?product_id=${product.id}"" class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                            ${product.name}
                                        </a>

                                        <span class="stext-105 cl3">
                                            ${product.price}
                                        </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                        <a href="#" class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                            <img class="icon-heart1 dis-block trans-04" src="public/images/icons/icon-heart-01.png" alt="ICON">
                                            <img class="icon-heart2 dis-block trans-04 ab-t-l" src="public/images/icons/icon-heart-02.png" alt="ICON">
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </c:forEach>




                </div>

                <!-- Load more -->
                <div class="flex-c-m flex-w w-full p-t-45">
                    <a href="#" class="flex-c-m stext-101 cl5 size-103 bg2 bor1 hov-btn1 p-lr-15 trans-04">
                        Load More
                    </a>
                </div>
            </div>
        </div>

        <%@include file="./inc/footer.jsp" %>
        <script src="./public/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="./public/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="./public/vendor/bootstrap/js/popper.js"></script>
        <script src="./public/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="./public/vendor/select2/select2.min.js"></script>
         <script src="./public/js/main.js"></script>

    </body>

</html>