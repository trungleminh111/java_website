<%-- 
    Document   : edit
    Created on : May 3, 2023, 6:12:07 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="./public/admin/assets/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
        <!-- Nucleo Icons -->
        <link href="./public/admin/assets/css/nucleo-icons.css" rel="stylesheet" />
        <link href="./public/admin/assets/css/nucleo-svg.css" rel="stylesheet" />
        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <!-- Material Icons -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
        <!-- CSS Files -->
        <link id="pagestyle" href="./public/admin/assets/css/material-dashboard.css?v=3.0.5" rel="stylesheet" />
        <!-- Nepcha Analytics (nepcha.com) -->
        <!-- Nepcha is a easy-to-use web analytics. No cookies and fully compliant with GDPR, CCPA and PECR. -->
        <script defer data-site="YOUR_DOMAIN_HERE" src="https://api.nepcha.com/js/nepcha-analytics.js"></script>
    </head>
    <body class="g-sidenav-show  bg-gray-100">
        <%@include file="../inc/sideBar.jsp" %>
        <main class="main-content border-radius-lg ">
            <%@include file="../inc/navbar.jsp" %>
            <div class="container-fluid py-4">
                <div class="row min-vh-80 h-100">
                    <div class="col-12">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">category</h1>

                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-table me-1"></i>
                                        Edit category
                                    </div>
                                    <div class="card-body">
                                        <form action="EditCategoryServlet" method="post">
                                            <input type="hidden" name="category_id" value="${category.id}"/>
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">Name</label>
                                                <input type="text" name="name" value="${category.name}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name">

                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">Image</label>
                                                <input type="text" name="img" value="${category.img}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter image">

                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputPassword1">Description</label>
                                                <input type="text" name="description" value="${category.description}" class="form-control" id="exampleInputPassword1" placeholder="Description">
                                            </div>
                                            <button type="submit" class="btn btn-primary">Submit</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </main>
                    </div>
                </div>
            </div>
            <%@include file="../inc/footer.jsp" %>
        </main>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./public/admin/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="./public/admin/assets/demo/chart-area-demo.js"></script>
        <script src="./public/admin/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="./public/admin/js/datatables-simple-demo.js"></script>
    </body>
</html>
