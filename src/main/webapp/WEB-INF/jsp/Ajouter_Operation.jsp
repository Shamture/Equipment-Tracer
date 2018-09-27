<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta charset="UTF-8">
<title>Ajouter Operation</title>
 <meta name="viewport" content="width=device-width">

  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/sb-admin.css" />">
     <!-- DatePicker CSS -->
    <link href="<c:url value="/resources/css/datepicker.css" />" rel="stylesheet">
</head>
<body>
 <div id="wrapper">

         <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">SB Admin</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <c:out value="${sessionScope.nom } ${sessionScope.prenom }"/> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        
                        <li>
                            <a href="<c:url value="/deconnecter" />"><i class="fa fa-fw fa-power-off"></i> Deconnecter</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <c:if test="${sessionScope.role == 'Admin' }">
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-users"></i> Gerer Utilisateurs <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
                            <li>
                                <a href="<c:url value="/admin/ajouter-utilisateur" />">Ajouter Utilisateur</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/liste-utilisateurs" />">Liste Utilisateur</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo1"><i class="fa fa-fw fa-bookmark-o"></i> Gerer Categories <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo1" class="collapse">
                            <li>
                                <a href="<c:url value="/admin/ajouter-categorie" />">Ajouter Categorie</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/liste-categorie" />">Liste Categories</a>
                            </li>
                        </ul>
                    </li>
                    </c:if>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo2"><i class="fa fa-fw fa-gear"></i> Gerer Materiels <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo2" class="collapse">
                            <li>
                                <a href="<c:url value="/user/ajouter-materiel" />">Ajouter Mateiel</a>
                            </li>
                            <li>
                                <a href="<c:url value="/user/liste-materiel" />">Liste Materiels</a>
                            </li>
                        </ul>
                    </li>
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Ajouter Operation Sur Materiel
                        </h1>
                        
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">
						<c:if test="${requestScope.success == true }">
						   <div class="alert alert-success">
						      Operation Ajoute avec succes !
						   </div>
						</c:if>
                        <form:form method="post" action="" modelAttribute="newOp"  id="materiel-form">
                          <div class="form-group">
                            <label>Nom Operation : </label>
                            <form:input type="text" path="nom" class="form-control" placeHolder = "Nom Operation"/>
                          </div>
                          
                          
                          
                          <div class="form-group">
                            <label>Date Operation</label>
                            <form:input type="text" path="date_operation" class="datepicker form-control" data-date-format="yyyy-mm-dd" placeHolder = "Date Operation"/>
                          </div>
                          
                          
                          <div class="form-group">
                            <label>Description</label>
                            <form:textarea  path="description" class="form-control description-field" placeHolder = "Description"/>
                          </div>
                          <br/><br/>
                          <input type="submit" class="btn btn-danger" value="Ajouter Operation"/>
                        </form:form>


                    </div>
                    <div class="col-lg-6">
                       
                    </div>
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

   <script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js" />"></script>
<script type="text/javascript">
$(function () {
$('.datepicker').datepicker({
    startDate: '-3d'
});
});
</script>

</body>
</html>