<%-- 
    Document   : index
    Created on : Mar 7, 2017, 5:33:25 PM
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
        <title>Home</title>
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
            <jsp:useBean id="book" class="edu.ass.model.ViewBookBean" />


            <div class="panel panel-primary">
                <div class="panel-heading"> Tất cả sách</div>
                <div class="panel-body">
                    <c:forEach var="b" items="${book.list}">
                        <div class="book" >
                                <div class="thumbnail">
                                    <div class="caption">
                                        <h3>${b.name} - <span style="color: #555; font-size: 13px">${b.code}</span></h3>
                                        <p>Tác giả: ${b.author}</p>
                                        <p>Số lượng: ${b.quantity}</p>
                                        <c:if test="${b.status == true}">
                                            <p>Trạng thái: <span>Hết sách</span></p>
                                            <p><a href="#" class="btn btn-primary" disabled="disabled" role="button">Mượn sách</a></p>
                                        </c:if>
                                        <c:if test="${b.status == false}">
                                            <p>Trạng thái: <span>Còn sách</span></p>
                                            <p><a href="BorrowServlet?book=${b.id}" class="btn btn-primary" role="button">Mượn sách</a></p>
                                        </c:if>
                                    </div>
                                </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

    </body>
</html>
