<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.java10.util.URL"%>

<%String path = request.getContextPath();%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Thêm mới dự án</title>
     <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     <link type="text/css" href="<c:url value="/static/assets/vendor/daterangepicker.css"/>" rel="stylesheet">

<!-- App CSS -->
<link type="text/css" href="<c:url value="/static/assets/css/app.css"/>" rel="stylesheet" />
<link type="text/css" href="<c:url value="/static/assets/css/app.rtl.css" />" rel="stylesheet" />
<jsp:include page="/components/header.jsp" />
    </head>
<body>
 <div class="d-flex justify-content-between">
   <!-- SIDE BAR -->
        <jsp:include page="/components/sliderBar.jsp" />
        <div id="admin-wrapper">
        <jsp:include page="/components/headerBar.jsp" />
        <section id="admin-content" class="p-3">
                <h3 class="mb-4 text-center">Thêm mới dự án</h3>
                <form method="post" 
                action="<%=path %><%=URL.USER_ADD_PROJECT%>"
                >
                   <div class="row">
                        <div class="col-md-6 m-auto">

                    
                            <div class="form-group">
                                <label>Email</label>
                                <input type="text" name="email" class="form-control" placeholder="email" value='${userEdit.email}' />
                            </div>
                            <div class="form-group">
                                <label>Mật khẩu</label>
                                <input type="password" name="password" class="form-control" placeholder="password"value='${userEdit.password}'  />
                            </div>
                            <div class="form-group">
                        
                		<label  for="dateRangePickerSample02">Range</label>
                			<input id="dateRangePickerSample02" type="text" name="range"class="form-control" placeholder="Range example" data-toggle="daterangepicker" data-daterangepicker-drops="up" data-daterangepicker-start-date="2000/1/01" data-daterangepicker-end-date="2000/1/02">
                           
   						</div>
                        
                        
                        <div class="col-12 mt-3">
                            <button type="submit" class="btn btn-success">Lưu lại</button>
                            <a class="btn btn-secondary" href="<%=path%><%=URL.USER_LIST%>">Quay lại</a>
                        </div>
                        </div>
                    </div>
                </form>
            </section>
   </div>
   </div>
   
     
    <!-- jQuery -->
    <script src="<c:url value="/static/assets/vendor/jquery.min.js"/>"></script>
     <script src="<c:url value="/static/assets/vendor/moment.min.js"/>"></script>
    <script src='<c:url value="/static/assets/vendor/daterangepicker.js"/>'></script>
    <script src="<c:url value="/static/assets/js/daterangepicker.js"/>"></script>
</body>
</html>