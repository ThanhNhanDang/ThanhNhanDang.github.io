<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.java10.util.URL"%>
    
      <%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- SIDE BAR -->
        <div id="side-bar">
            <div class="logo">${ userAfterLogin.desRole}</div>
            <ul class="list-group rounded-0">
                <li class="dashboard">DASHBOARD</li>
                <c:choose>
                <c:when test="${userAfterLogin.roleName=='ROLE_ADMIN'}">
                	<li>
                    <a href="<%=request.getContextPath()%><%=URL.USER_LIST%>">
                        <i class="fa fa-user mr-2"></i> Quản lý thành viên
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%><%=URL.ROLE_LIST%>">
                        <i class="fa fa-book mr-2"></i> Quản lý quyền
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%><%=URL.ROLE_LIST%>">
                        <i class="fa fa-cogs mr-2"></i> Quản lý dự án
                    </a>
                </li>
                
                </c:when>
                <c:when test="${userAfterLogin.roleName=='ROLE_LEADER'}"> 
                <li>
                    <a href="<%=request.getContextPath()%><%=URL.USER_LIST%>">
                        <i class="fa fa-user mr-2"></i> Danh sách thành viên
                    </a>
                </li>
                
  
                <li>
                    <a href="<%=request.getContextPath()%><%=URL.USER_ADD_PROJECT%>">
                        <i class="fa fa-cogs mr-2"></i> Thêm mới dự án
                    </a>
                </li></c:when>
                </c:choose>
               <li>
                    <a href="<%=request.getContextPath()%><%=URL.USER_PROFILE%>">
                        <i class="fa fa-slack mr-2"></i> Thông tin cá nhân
                    </a>
                </li>
            </ul>
        </div>