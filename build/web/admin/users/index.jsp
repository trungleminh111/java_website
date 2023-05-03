<%-- 
    Document   : index
    Created on : May 3, 2023, 7:10:23 PM
    Author     : Administrator
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
    <body class="g-sidenav-show  bg-gray-200">

        <%@include file="../inc/sideBar.jsp" %>
        <main class="main-content border-radius-lg ">
            <%@include file="../inc/navbar.jsp" %>
            <div class="container-fluid py-4">
                <div class="row">

                    <div class="col-12">
                        <div class="card my-4">
                            <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                                <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                                    <h6 class="text-white text-capitalize ps-3">User table</h6>
                                </div>
                            </div>
                            <div class="card-body px-0 pb-2">
                                <div class="table-responsive p-0">
                                    <table class="table align-items-center mb-0">
                                        <thead>
                                            <tr>
                                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">name</th>
                                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">email</th>
                                                <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">password</th>
                                                <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">role</th>
                                                <th class="text-secondary opacity-7"></th>
                                                <th class="text-secondary opacity-7"></th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                        <div class="card-header">
                                            <a href="CreateUserServlet"><i class="fas fa-table me-1"></i> Create new User</a>

                                        </div>
                                        <c:forEach items="${userList}" var="user">
                                            <tr>
                                               
                                                <td>
                                                    <p class="text-xs font-weight-bold mb-0">${user.name}</p>
                                                    <p class="text-xs text-secondary mb-0"></p>
                                                </td>
                                                <td class="align-middle text-center text-sm">
                                                    <span class="badge badge-sm bg-gradient-secondary">${user.email}</span>
                                                </td>
                                                <td class="align-middle text-center">
                                                    <span class="text-secondary text-xs font-weight-bold">${user.password}</span>
                                                </td>
                                                <td class="align-middle text-center">
                                                    <span class="text-secondary text-xs font-weight-bold">${user.role}</span>
                                                </td>
                                                <td class="align-middle">
                                                    <a href="EditUserServlet?user_id=${user.id}" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Edit user">
                                                        Edit
                                                    </a>
                                                </td>
                                                <td class="align-middle">
                                                    <a href="DeleteUserServlet?user_id=${user.id}" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Edit user">
                                                        Delete
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <%@include file="../inc/footer.jsp" %>
        </main>

    </body>
</html>