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
    <title>Danh sách thành viên</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
                <h3 class="mb-3">Danh sách thành viên</h3>
                <div class="row">
                 <c:if test="${userAfterLogin.roleName=='ROLE_ADMIN' }">
                    <div class="col-md-8">
                        <a href="<%=path%><%=URL.USER_ADD%>" class="btn btn-primary">Thêm mới</a>
                    </div>
                    </c:if>
                    <div class="col-md-4">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Tìm kiếm...">
                            <div class="input-group-append">
                                <span class="input-group-text" id="basic-addon2"><i class="fa fa-search"></i></span>
                            </div>
                        </div>
                    </div>
                </div>
                <table class="table table-bordered table-hover mt-3">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Họ Tên</th>
                            <th>Email</th>
                            <th>Avatar</th>
                            <th>Loại người dùng</th>
                           
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${user}" var="userItem">
                        <tr>
                            <td>${userItem.id}</td>
                            <td>${userItem.fullname}</td>
                            <td>${userItem.email}</td>
                            <td>${userItem.avatar}</td>
                            <td>${userItem.desRole}</td>
                            <c:if test="${userAfterLogin.roleName=='ROLE_ADMIN' }">
                            <td>
                               <a href="<%=path %><%=URL.USER_EDIT%>?id=${userItem.id}" class="btn btn-sm btn-info">
                                    <i class="fa fa-pencil-square-o"></i>
                                </a>
                                <a href="<%=path %><%=URL.USER_DELETE%>?id=${userItem.id}" class="btn btn-sm btn-danger">
                                    <i class="fa fa-trash-o"></i>
                                </a>
                         </td>
                         </c:if>
                        </tr>
                       
                      </c:forEach>
                    </tbody>
                </table>
            </section>
        </div>
    </div>
   <jsp:include page="/components/footer.jsp" />
</body>

</html>