<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.java10.util.URL"%>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>		
    Thông tin cá nhân</title>
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
                <h3 class="mb-4">
               	Thông tin cá nhân</h3>
                <form method="post" action="<%=path%><%=URL.USER_PROFILE%>">
                   <div class="row">
                        <div class="col-md-6">
                        	<div class="form-group">
                                <label>ID</label>
                                <input type="text" name="id" class="form-control" value="${userAfterLogin.id}" readonly />
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="text" name="email" class="form-control" value='${userAfterLogin.email}'readonly/>
                            </div>
                             <div class="form-group">
                                <label>Password</label>
                               <input type="password" name="password" class="form-control" value="${userAfterLogin.password}" readonly /> 
                            </div>
                        </div>
                        <div class="col-md-6">
                        <div class="form-group">
                                <label>Họ tên</label>
                                <input type="text" name="fullname" class="form-control" value="${userAfterLogin.fullname}" readonly />
                            </div>
                            <div class="form-group">
                                <label>Loại người dùng</label>
                                 <input type="text" name="description" class="form-control" value="${userAfterLogin.desRole}" readonly />
                                
                            </div>
                           
                            <div class="form-group">
                                <label>Avatar</label>
                               <input type="text" name="avatar" class="form-control" value="${userAfterLogin.avatar}" readonly /> 
                            </div>
                           
                        </div>
                        <div class="col-12 mt-3">
                            <button type="submit" class="btn btn-success">Edit</button>
                            <a class="btn btn-secondary" href="<%=path%><%=URL.USER_LIST%>">Quay lại</a>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
   <jsp:include page="/components/footer.jsp" />
</body>

</html>