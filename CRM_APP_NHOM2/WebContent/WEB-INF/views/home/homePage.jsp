<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.java10.util.URL"%>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
   <jsp:include page="/components/header.jsp" />
</head>

<body>

    <div class="d-flex justify-content-between">
        <!-- SIDE BAR -->
        <jsp:include page="/components/sliderBar.jsp" />
     
        <div id="admin-wrapper">
            <!-- HEADER -->
           
              <jsp:include page="/components/headerBar.jsp" />

            <!-- CONTENT -->
            <section id="admin-content" class="p-3">
                <div class="row">
                    <div class="col-md-6">
                        <canvas id="myChart" width="400" height="400"></canvas>
                    </div>
                    <div class="col-md-6">
                        <canvas id="myChart2" width="400" height="400"></canvas>
                    </div>
                    <div class="col-md-1"></div>
                </div>
            </section>
        </div>
    </div>
    <jsp:include page="/components/footer.jsp" />
    <script src='<%=path %>/static/js/chart.min.js'></script>
    <script src='<%=path %>/static/js/custom-chart.js'></script>
</body>

</html>