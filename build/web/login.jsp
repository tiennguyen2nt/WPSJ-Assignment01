<%-- 
    Document   : login
    Created on : Mar 10, 2017, 5:01:24 PM
    Author     : Tien Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Aptech Library</title>

    <!-- Bootstrap Core CSS -->
    <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styte.css" rel="stylesheet" type="text/css"/>
    <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

  

</head>

<body>
 <c:if test="${sessionScope.user!=null}">
            <jsp:forward page="index.jsp" />
        </c:if>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Đăng nhập</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" action="LoginServlet" method="post">
                            <fieldset>
                                <p style="color: red; text-align: center;">${msg}</p>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Tài khoản" name="email" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Mật khẩu" name="password" type="password" value="">
                                </div>
                                
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Nhớ tài khoản
                                    </label>
                                </div>
                                
                                <!-- Change this to a button or input when using this as a form -->
                                <input type="submit"  class="btn btn-lg btn-success btn-block" value="Đăng nhập">
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

   

   

</body>

</html>

