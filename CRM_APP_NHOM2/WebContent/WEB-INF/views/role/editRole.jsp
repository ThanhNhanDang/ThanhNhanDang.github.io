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
    <title>Chỉnh sửa thông tin</title>
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
                <h3 class="mb-4 text-center">Chỉnh sửa thông tin</h3>
                <form method="post"
                action="<%=path%><%=URL.ROLE_ADD%>">
                    <div class="row">
                        <div class="col-md-6 m-auto">
                         <div class="form-group">
                                <label>ID</label>
                                
                                <input type="text" name="id" class="form-control" value="${roleEdit.id}" readonly />
                            </div>
                            <div class="form-group">
                                <label>Tên quyền</label>
                                
                                <input type="text" name="name" class="form-control" placeholder="name"value="${roleEdit.name}"  />
                            </div>
                            <div class="form-group">
                                <label>Mô tả</label>
                                <input type="text" name="description" class="form-control"placeholder="description"value="${roleEdit.description}" />
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-success">Lưu lại</button>
                                <a class="btn btn-secondary" href="<%=path%><%=URL.ROLE_LIST%>">Quay lại</a>
                            </div>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
    <jsp:include page="/components/footer.jsp" />
</body>

</html>