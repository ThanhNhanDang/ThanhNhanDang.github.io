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
    <title>Thêm mới thành viên</title>
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
                <h3 class="mb-4">Thêm mới thành viên</h3>
                <form method="post" 
                action="<%=path %><%=URL.USER_ADD%>"
                >
                   <div class="row">
                        <div class="col-md-6">

                    
                            <div class="form-group">
                                <label>Email</label>
                                <input type="text" name="email" class="form-control" placeholder="email" value='${userEdit.email}' />
                            </div>
                            <div class="form-group">
                                <label>Mật khẩu</label>
                                <input type="password" name="password" class="form-control" placeholder="password"value='${userEdit.password}'  />
                            </div>
                            
                        </div>
                        <div class="col-md-6">
                        <div class="form-group">
                                <label>Họ tên</label>
                                <input type="text" name="fullname" class="form-control" placeholder="fullname" value='${userEdit.fullname}' />
                            </div>
                            <div class="form-group">
                                <label>Loại người dùng</label>
                                
                                <select class="form-control" name="roleId">
                                <c:forEach items = "${listNameRole}" var="item">
                                    <option value="${item.id}"
                                    		
                                    		 >${item.description}
                                    </option>
                                    
                                 </c:forEach>
                                </select>
                                
                            </div>
                           
                            <div class="form-group">
                                <label>Avatar</label>
                                
                               <input type="file" name="avatar"  accept="image/*"class="form-control"/>
                            </div>
                        </div>
                        <div class="col-12 mt-3">
                            <button type="submit" class="btn btn-success">Lưu lại</button>
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