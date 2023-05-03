<%-- 
    Document   : index
    Created on : May 3, 2023, 8:55:26 AM
    Author     : Administrator
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css"
              href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
        <!-- Nucleo Icons -->
        <link href="./public/admin/assets/css/nucleo-icons.css" rel="stylesheet" />
        <link href="./public/admin/assets/css/nucleo-svg.css" rel="stylesheet" />
        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <!-- Material Icons -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
        <!-- CSS Files -->
        <link id="pagestyle" href="./public/admin/assets/css/material-dashboard.css?v=3.0.5" rel="stylesheet" />
    </head>
    <body class="g-sidenav-show  bg-gray-100">
        <%@include file="inc/sideBar.jsp" %>
        <main class="main-content border-radius-lg ">
            <%@include file="inc/navbar.jsp" %>
            <div class="container-fluid py-4">
                <div class="row min-vh-80 h-100">
                    <div class="col-12">

                    </div>
                </div>
            </div>
            <%@include file="inc/footer.jsp" %>
        </main>

    </body>
</html>
