<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.java10.util.URL"%>
<!DOCTYPE html>
<html lang="id" dir="ltr">

<head>
<style type="text/css">
#footer{
     text-align: center;
     position: fixed;
     margin-left: 530px;
     bottom: 0px
}	
</style>
     <meta charset="utf-8" />
     <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
     <meta name="description" content="" />
     <meta name="author" content="" />
     <!-- Title -->
     <title>Sorry, This Page Can't Be Accessed</title>
     <link rel="shortcut icon" href="<c:url value="/assets/images/favicon.ico" />" /> 
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
</head>

<body class="bg-dark text-white py-5">
     <div class="container py-5">
          <div class="row">
               <div class="col-md-2 text-center">
                    <p><i class="fa fa-exclamation-triangle fa-5x"></i><br/>Status Code: 403</p>
               </div>
               <div class="col-md-10">
                    <h3>OPPSSS!!!! Sorry...</h3>
                    <p>Sorry, your access is refused due to security reasons of our server and also our sensitive data.<br/>Please go back to the previous page to continue browsing.</p>
                    <a class="btn btn-danger" href="<c:url value="<%=URL.USER_PROFILE%>" />">Go Your Profile</a>
               </div>
          </div>
     </div>

     <div id="footer" class="text-center">
          thanhnhan.com
     </div>
</body>

</html>