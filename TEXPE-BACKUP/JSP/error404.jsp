<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="apperror.jsp"%> 

<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta name="author" content="IsmGroup35">
    <meta name="description" content="error404TEXPE">
    <meta name="keywords" content="HTML,CSS,XML,JavaScript">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    
    <!-- Title -->
    <title>Error 404</title>
    
    <!-- Place icon in the root directory -->
    <link rel="apple-touch-icon" href="images/favicon16x16.png">
    <link rel="shortcut icon" type="image/ico" href="images/favicon16x16.png" />
    
    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    
    <!-- Plugin-CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <!-- Bootstrap CSS-->
    <!--<link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">-->
    
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">
    
    <!-- Main-Stylesheets -->
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="css/responsive.css">
    <script src="vendor/modernizr-2.8.3.min.js"></script>
    
    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">


    <!--[if lt IE 9]>
        <script src="//oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="//oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

    
    
<body data-spy="scroll" data-target="#primary-menu" >
    
    
    <!--Mainmenu-area-->
    
    <div class="mainmenu-area" data-spy="affix" data-offset-top="100">
        <div class="container">
            
            <!--Logo-->
            
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#primary-menu">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="./index.jsp" class="navbar-brand logo">
                    
                    <h2>T-Expe</h2>
                    <div>
                           <h5><font color="aliceblue">Tracking Expences</font></h5> 
                    </div>   
                </a>
            </div>
            <!--Logo/-->
            
            <nav class="collapse navbar-collapse" id="primary-menu">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="./index.jsp">Home</a></li>
                    <li class="active"><a href="./login.jsp">Log-in</a></li>
                    <li><a href="./register.jsp">Sign-Up</a></li>
                   
                    <li><a href="./about.jsp">About</a></li>
                </ul>
            </nav>
        </div>
    </div>
    <!--Mainmenu-area/-->




    <!--Header-area-->
      <section class="gray-bg section-padding"> 
            <div class="container" >
                <div class="login-wrap">
                    <div class="login-content" style="background-color: #476068">
                        <div class="page-header">
                            <h1><font color="aliceblue">404</font></h1>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-md-10 col-lg-8">
                                
                                <div class="alert alert-info">
                                    <strong>PAGE NOT FOUND</strong>
                                    <br>
                                    The link you clicked may be broken or the page may have been removed.
                                </div>

                            </div>

                        </div>
            
                    </div>       
                </div>
            </div>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
        </section>
    <!--Header-area/-->

     <%@include file="footer.jsp"%>
   
    </body>
</html>
