<%-- 
   Document   : cart
   Created on : Apr 14, 2023, 4:50:25 PM
   Author     : Administrator
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./public/img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
        <!-- Libraries Stylesheet -->
        <link href="./public/lib/animate/animate.min.css" rel="stylesheet">
        <link href="./public/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="./public/css/style.css" rel="stylesheet">
        <title>Cart</title>
    </head>

    <body>
        <!-- <--------top-header-------->
        <%@include file="./inc/header.jsp" %>
        <!-- Breadcrumb Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-12">
                    <nav class="breadcrumb bg-light mb-30">
                        <a class="breadcrumb-item text-dark" href="HomeServlet">Home</a>
                        <a class="breadcrumb-item text-dark" href="ShopServlet">Shop</a>
                        <span class="breadcrumb-item active">Shopping Cart</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->

        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-lg-8 table-responsive mb-5">
                    <table class="table table-light table-borderless table-hover text-center mb-0">
                        <thead class="thead-dark">
                            <tr>
                                <th>Products</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th>Remove</th>
                            </tr>
                        </thead>
                        <tbody class="align-middle">
                            <c:forEach items="${cart}" var="orderDetailSession">
                                <tr class="m-auto">
                                    <td class="align-middle"><img src="${orderDetailSession.productImg}" alt="" style="width: 50px;"> ${orderDetailSession.productName}</td>
                                    <td class="align-middle">${orderDetailSession.productPrice}</td>
                                    <td class="align-middle d-flex justify-content-center ">
                                        <div class="d-flex">
                                            <div class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m d-flex ">
                                                <form action="CartServlet" method="post" class="quantity-item">
                                                    <input type="hidden" name="product_id" value="${orderDetailSession.productId}"/>
                                                    <input type="hidden" name="action" value="update"/>
                                                    <input type="hidden" name="quantity" value="-1"/>
                                                    <button class="btn btn-sm btn-primary btn-minus" >
                                                        <i class="fa fa-minus"></i>
                                                    </button>

                                                </form>
                                            </div>
                                            <input type="text" class="form-control form-control-sm bg-secondary border-0 text-center w-50" value="${orderDetailSession.quantity}">
                                            <div class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m">
                                                <form action="CartServlet" method="post" class="quantity-item">
                                                    <input type="hidden" name="product_id" value="${orderDetailSession.productId}"/>
                                                    <input type="hidden" name="action" value="update"/>
                                                    <input type="hidden" name="quantity" value="1"/>
                                                    <button class="btn btn-sm btn-primary btn-plus">
                                                        <i class="fa fa-plus"></i>
                                                    </button>
                                                </form>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="align-middle">${orderDetailSession.quantity * orderDetailSession.productPrice}</td>
                                    <td class="align-middle"><button class="btn btn-sm btn-danger"><i class="fa fa-times"></i></button></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-4">
                    <form class="mb-30" action="">
                        <div class="input-group">
                            <input type="text" class="form-control border-0 p-4" placeholder="Coupon Code">
                            <div class="input-group-append">
                                <button class="btn btn-primary">Apply Coupon</button>
                            </div>
                        </div>
                    </form>
                    <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Cart Summary</span></h5>
                    <div class="bg-light p-30 mb-5">
                        <div class="border-bottom pb-2">
                            <div class="d-flex justify-content-between mb-3">
                                <h6>Subtotal</h6>
                                <h6>$${total}</h6>
                            </div>
                            <div class="d-flex justify-content-between">
                                <h6 class="font-weight-medium">Shipping</h6>
                                <h6 class="font-weight-medium">$10</h6>
                            </div>
                        </div>
                        <div class="pt-2">
                            <div class="d-flex justify-content-between mt-2">
                                <h5>Total</h5>
                                <h5>$${total}</h5>
                            </div>
                            <button class="btn btn-block btn-primary font-weight-bold my-3 py-3">Proceed To Checkout</button>
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