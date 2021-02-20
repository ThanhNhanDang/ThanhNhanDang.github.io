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
    <title>Danh sách quyền</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <jsp:include page="/components/header.jsp" />
</head>

<body>

    <div class="d-flex justify-content-between">
        <jsp:include page="/components/sliderBar.jsp" />

        <div id="admin-wrapper">
            <!-- HEADER -->
             <jsp:include page="/components/headerBar.jsp" />

            <!-- CONTENT -->
            <section id="admin-content" class="p-3">
                <h3 class="mb-3">Danh sách quyền</h3>
                <div class="row">
                    <div class="col-md-8">
                        <a href="<%=path%><%=URL.ROLE_ADD%>" class="btn btn-primary">Thêm mới</a>
                    </div>
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
                            <th>Tên Quyền</th>
                            <th>Mô Tả</th>
                               <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${role}" var="roleItem">
                        <tr>
                            <td>${roleItem.id}</td>
                            <td>${roleItem.name }</td>
                            <td>${roleItem.description }</td>
                            
                            <td>
                                <a href="<%=path %><%=URL.ROLE_EDIT%>?id=${roleItem.id}" class="btn btn-sm btn-info">
                                    <i class="fa fa-pencil-square-o"></i>
                                </a>
                                <a href="<%=path %><%=URL.ROLE_DELETE%>?id=${roleItem.id}" class="btn btn-sm btn-danger">
                                    <i class="fa fa-trash-o"></i>
                                </a>
                            </td>
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