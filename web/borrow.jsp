<%-- 
    Document   : borrow
    Created on : Mar 10, 2017, 10:18:38 PM
    Author     : Tien Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/styte.css" rel="stylesheet" type="text/css"/>
        <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <jsp:useBean id="now" class="java.util.Date" />
        <s:date name="now" var="formattedDate" format="dd/MM/yyyy"/>
    
        <title>Mượn sách</title>
    </head>
    <body>
        <c:if test="${sessionScope.userId==null}">
            <jsp:forward page="login.jsp" />
        </c:if>

        <div id="wrapper">
            <h1>
                Aptech Library
            </h1>
            <div id="search" class="row">
                <form action="searchServlet" class="form-horizontal" method="post" accept-charset="utf-8">
                    <div class="col-sm-10">
                        <input class="form-control col-md-8"  type="text"  name="search"/>
                    </div>
                    <input type="submit" class="col-md-2 btn btn-primary" value="search" >
                </form>
            </div>
            <div class="row">
                <div class="btn-group" style="margin: 20px 15px;">
                    <a type="button" href="index.jsp" class="btn btn-primary">Trang chủ</a>
                    <a type="button" href="" class="btn btn-primary">Thông kê</a>
                    <a type="button" href="" class="btn btn-primary">Đăng xuất</a>
                </div>
            </div>



            <div class="panel panel-primary">
                <div class="panel-heading"> Tất cả sách</div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="BorrowServlet" method="post">
                        <input type="hidden"  class="form-control" id="fdsafs" name="idbook" value="${book.id}">
                        <input type="hidden"  class="form-control" id="ddd" name="idStaff" value="${sessionScope.userId}">
                        <div class="form-group">
                            <label for="sach" class="col-sm-2 control-label">Sách: </label>
                            <div class="col-sm-10">
                                <input type="type" disabled class="form-control" id="sach" value="${book.name}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">Tên người mượn: </label>
                            <div class="col-sm-10">
                                <input type="type" class="form-control" name="name" id="name" placeholder="Tên người mượn">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="date" class="col-sm-2 control-label">Ngày mượn: </label>
                            <div class="col-sm-10">
                                <input type="type" class="form-control" id="date" name="date" value="${now}" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="a" class="col-sm-2 control-label">Số ngày mượn: </label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="a" name="daynumber" value="7" placeholder="Số ngày mượn">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="b" class="col-sm-2 control-label">Ghi chú: </label>
                            <div class="col-sm-10">
                                <textarea type="type" class="form-control" name="note" id="b"></textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input type="submit" value="Submit" class="btn btn-default">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>

