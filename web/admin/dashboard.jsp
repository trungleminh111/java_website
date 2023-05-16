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
                      
                        <div class="container-fluid py-4">
                            <div class="row">
                                <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
                                    <div class="card">
                                        <div class="card-header p-3 pt-2">
                                            <div class="icon icon-lg icon-shape bg-gradient-dark shadow-dark text-center border-radius-xl mt-n4 position-absolute">
                                                <i class="material-icons opacity-10">weekend</i>
                                            </div>
                                            <div class="text-end pt-1">
                                                <p class="text-sm mb-0 text-capitalize">Total Product</p>
                                                <h4 class="mb-0">${countProduct}</h4>
                                            </div>
                                        </div>
                                        <hr class="dark horizontal my-0">
                                        <div class="card-footer p-3">
                                            <p class="mb-0"><span class="text-success text-sm font-weight-bolder">+55% </span>than last week</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
                                    <div class="card">
                                        <div class="card-header p-3 pt-2">
                                            <div class="icon icon-lg icon-shape bg-gradient-primary shadow-primary text-center border-radius-xl mt-n4 position-absolute">
                                                <i class="material-icons opacity-10">person</i>
                                            </div>
                                            <div class="text-end pt-1">
                                                <p class="text-sm mb-0 text-capitalize">Total User</p>
                                                <h4 class="mb-0">${countUser}</h4>
                                            </div>
                                        </div>
                                        <hr class="dark horizontal my-0">
                                        <div class="card-footer p-3">
                                            <p class="mb-0"><span class="text-success text-sm font-weight-bolder">+3% </span>than last month</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
                                    <div class="card">
                                        <div class="card-header p-3 pt-2">
                                            <div class="icon icon-lg icon-shape bg-gradient-success shadow-success text-center border-radius-xl mt-n4 position-absolute">
                                               <i class="material-icons opacity-10">weekend</i>
                                            </div>
                                            <div class="text-end pt-1">
                                                <p class="text-sm mb-0 text-capitalize">Total Order</p>
                                                <h4 class="mb-0">${countOrder}</h4>
                                            </div>
                                        </div>
                                        <hr class="dark horizontal my-0">
                                        <div class="card-footer p-3">
                                            <p class="mb-0"><span class="text-danger text-sm font-weight-bolder">-2%</span> than yesterday</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-3 col-sm-6">
                                    <div class="card">
                                        <div class="card-header p-3 pt-2">
                                            <div class="icon icon-lg icon-shape bg-gradient-info shadow-info text-center border-radius-xl mt-n4 position-absolute">
                                                <i class="material-icons opacity-10">weekend</i>
                                            </div>
                                            <div class="text-end pt-1">
                                                <p class="text-sm mb-0 text-capitalize">Total pending order</p>
                                                <h4 class="mb-0">${countPendingOrder}</h4>
                                            </div>
                                        </div>
                                        <hr class="dark horizontal my-0">
                                        <div class="card-footer p-3">
                                            <p class="mb-0"><span class="text-success text-sm font-weight-bolder">+5% </span>than yesterday</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col-lg-4 col-md-6 mt-4 mb-4">
                                    <div class="card z-index-2 ">
                                        <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2 bg-transparent">
                                            <div class="bg-gradient-primary shadow-primary border-radius-lg py-3 pe-1">
                                                <div class="chart">
                                                    <canvas id="chart-bars" class="chart-canvas" height="170"></canvas>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-body">
                                            <h6 class="mb-0 ">Area Chart Example</h6>
                                            <p class="text-sm ">Last Campaign Performance</p>
                                            <hr class="dark horizontal">
                                            <div class="d-flex ">
                                                <i class="material-icons text-sm my-auto me-1">schedule</i>
                                                <p class="mb-0 text-sm"> campaign sent 2 days ago </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6 mt-4 mb-4">
                                    <div class="card z-index-2  ">
                                        <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2 bg-transparent">
                                            <div class="bg-gradient-success shadow-success border-radius-lg py-3 pe-1">
                                                <div class="chart">
                                                    <canvas id="chart-line" class="chart-canvas" height="170"></canvas>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-body">
                                            <h6 class="mb-0 ">  Order Chart </h6>
                                            <p class="text-sm "> (<span class="font-weight-bolder">+15%</span>) increase in today sales. </p>
                                            <hr class="dark horizontal">
                                            <div class="d-flex ">
                                                <i class="material-icons text-sm my-auto me-1">schedule</i>
                                                <p class="mb-0 text-sm"> updated 4 min ago </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 mt-4 mb-3">
                                    <div class="card z-index-2 ">
                                        <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2 bg-transparent">
                                            <div class="bg-gradient-dark shadow-dark border-radius-lg py-3 pe-1">
                                                <div class="chart">
                                                    <canvas id="chart-line-tasks" class="chart-canvas" height="170"></canvas>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-body">
                                            <h6 class="mb-0 ">Completed Tasks</h6>
                                            <p class="text-sm ">Last Campaign Performance</p>
                                            <hr class="dark horizontal">
                                            <div class="d-flex ">
                                                <i class="material-icons text-sm my-auto me-1">schedule</i>
                                                <p class="mb-0 text-sm">just updated</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
            <%@include file="inc/footer.jsp" %>
        </main>
        <script>

            var ctx = document.getElementById("chart-bars").getContext("2d");
            new Chart(ctx, {
            type: "bar",
                    data: {
                    labels: ["Pending", "Shipping", "Delivered", "Canceled"],
                            datasets: [{
                            label: "Status",
                                    tension: 0.4,
                                    borderWidth: 0,
                                    borderRadius: 4,
                                    borderSkipped: false,
                                    backgroundColor: "rgba(255, 255, 255, .8)",
                                    data: [${countPendingOrder}, ${countShippingOrder}, ${countDeliveredOrder}, ${countCanceledOrder}],
                                    maxBarThickness: 6
                            }, ],
                    },
                    options: {
                    responsive: true,
                            maintainAspectRatio: false,
                            plugins: {
                            legend: {
                            display: false,
                            }
                            },
                            interaction: {
                            intersect: false,
                                    mode: 'index',
                            },
                            scales: {
                            y: {
                            grid: {
                            drawBorder: false,
                                    display: true,
                                    drawOnChartArea: true,
                                    drawTicks: false,
                                    borderDash: [5, 5],
                                    color: 'rgba(255, 255, 255, .2)'
                            },
                                    ticks: {
                                    suggestedMin: 0,
                                            suggestedMax: 500,
                                            beginAtZero: true,
                                            padding: 10,
                                            font: {
                                            size: 14,
                                                    weight: 300,
                                                    family: "Roboto",
                                                    style: 'normal',
                                                    lineHeight: 2
                                            },
                                            color: "#fff"
                                    },
                            },
                                    x: {
                                    grid: {
                                    drawBorder: false,
                                            display: true,
                                            drawOnChartArea: true,
                                            drawTicks: false,
                                            borderDash: [5, 5],
                                            color: 'rgba(255, 255, 255, .2)'
                                    },
                                            ticks: {
                                            display: true,
                                                    color: '#f8f9fa',
                                                    padding: 10,
                                                    font: {
                                                    size: 14,
                                                            weight: 300,
                                                            family: "Roboto",
                                                            style: 'normal',
                                                            lineHeight: 2
                                                    },
                                            }
                                    },
                            },
                    },
            });
            var ctx2 = document.getElementById("chart-line").getContext("2d");
            new Chart(ctx2, {
            type: "line",
                    data: {
                    labels: [<c:forEach items="${dateList}" var="date">
                    "${date}",
            </c:forEach>],
                            datasets: [{
                            label: "order",
                                    tension: 0,
                                    borderWidth: 0,
                                    pointRadius: 5,
                                    pointBackgroundColor: "rgba(255, 255, 255, .8)",
                                    pointBorderColor: "transparent",
                                    borderColor: "rgba(255, 255, 255, .8)",
                                    borderColor: "rgba(255, 255, 255, .8)",
                                    borderWidth: 4,
                                    backgroundColor: "transparent",
                                    fill: true,
                                    data: [<c:forEach items="${countEachDay}" var="count">
                ${count},</c:forEach>],
                                    maxBarThickness: 6

                            }],
                    },
                    options: {
                    responsive: true,
                            maintainAspectRatio: false,
                            plugins: {
                            legend: {
                            display: false,
                            }
                            },
                            interaction: {
                            intersect: false,
                                    mode: 'index',
                            },
                            scales: {
                            y: {
                            grid: {
                            drawBorder: false,
                                    display: true,
                                    drawOnChartArea: true,
                                    drawTicks: false,
                                    borderDash: [5, 5],
                                    color: 'rgba(255, 255, 255, .2)'
                            },
                                    ticks: {
                                    display: true,
                                            color: '#f8f9fa',
                                            padding: 10,
                                            font: {
                                            size: 14,
                                                    weight: 300,
                                                    family: "Roboto",
                                                    style: 'normal',
                                                    lineHeight: 2
                                            },
                                    }
                            },
                                    x: {
                                    grid: {
                                    drawBorder: false,
                                            display: false,
                                            drawOnChartArea: false,
                                            drawTicks: false,
                                            borderDash: [5, 5]
                                    },
                                            ticks: {
                                            display: true,
                                                    color: '#f8f9fa',
                                                    padding: 10,
                                                    font: {
                                                    size: 14,
                                                            weight: 300,
                                                            family: "Roboto",
                                                            style: 'normal',
                                                            lineHeight: 2
                                                    },
                                            }
                                    },
                            },
                    },
            });
            var ctx3 = document.getElementById("chart-line-tasks").getContext("2d");
            new Chart(ctx3, {
            type: "line",
                    data: {
                    labels: ["Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                            datasets: [{
                            label: "Mobile apps",
                                    tension: 0,
                                    borderWidth: 0,
                                    pointRadius: 5,
                                    pointBackgroundColor: "rgba(255, 255, 255, .8)",
                                    pointBorderColor: "transparent",
                                    borderColor: "rgba(255, 255, 255, .8)",
                                    borderWidth: 4,
                                    backgroundColor: "transparent",
                                    fill: true,
                                    data: [50, 40, 300, 220, 500, 250, 400, 230, 500],
                                    maxBarThickness: 6

                            }],
                    },
                    options: {
                    responsive: true,
                            maintainAspectRatio: false,
                            plugins: {
                            legend: {
                            display: false,
                            }
                            },
                            interaction: {
                            intersect: false,
                                    mode: 'index',
                            },
                            scales: {
                            y: {
                            grid: {
                            drawBorder: false,
                                    display: true,
                                    drawOnChartArea: true,
                                    drawTicks: false,
                                    borderDash: [5, 5],
                                    color: 'rgba(255, 255, 255, .2)'
                            },
                                    ticks: {
                                    display: true,
                                            padding: 10,
                                            color: '#f8f9fa',
                                            font: {
                                            size: 14,
                                                    weight: 300,
                                                    family: "Roboto",
                                                    style: 'normal',
                                                    lineHeight: 2
                                            },
                                    }
                            },
                                    x: {
                                    grid: {
                                    drawBorder: false,
                                            display: false,
                                            drawOnChartArea: false,
                                            drawTicks: false,
                                            borderDash: [5, 5]
                                    },
                                            ticks: {
                                            display: true,
                                                    color: '#f8f9fa',
                                                    padding: 10,
                                                    font: {
                                                    size: 14,
                                                            weight: 300,
                                                            family: "Roboto",
                                                            style: 'normal',
                                                            lineHeight: 2
                                                    },
                                            }
                                    },
                            },
                    },
            });
        </script>

    </body>
</html>
