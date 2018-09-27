<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta charset="UTF-8">
<title>Consulter Materiel</title>
 <meta name="viewport" content="width=device-width">

  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/sb-admin.css" />">
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
                           Information sur Materiel
                        </h1>
                        
                        
                    </div>
                </div>
                <!-- /.row -->

                <div class="row" id="information-materiel">
                    <div class="col-lg-8">
                            <c:choose>
                              <c:when test="${requestScope.mat.joursRestantDansLeDelai >7 }">
                                 <div class="alert alert-success">
                                 <i class="fa fa-gears" aria-hidden="true"></i>  La prochaine operation sur ce produit devrait etre dans ${requestScope.mat.joursRestantDansLeDelai} jours
                                 </div>
                              </c:when>
                              <c:when test="${requestScope.mat.joursRestantDansLeDelai <7 && requestScope.mat.joursRestantDansLeDelai >0 }">
                                  <div class="alert alert-warning">
                                 <i class="fa fa-exclamation" aria-hidden="true"></i>  La prochaine operation sur ce produit devrait etre dans ${requestScope.mat.joursRestantDansLeDelai} jours
                                  </div>
                              </c:when>
                              <c:otherwise>
                                 <div class="alert alert-danger">
                                  <i class="fa fa-exclamation-triangle" aria-hidden="true"></i> La prochaine operation sur ce produit devrait etre dans ${requestScope.mat.joursRestantDansLeDelai} jours
                                  </div>
                              </c:otherwise>
                            </c:choose>
					    <table>
						   <tr><td> <p><strong>Designation : </strong></p></td>
						    <td><p> <c:out value="${requestScope.mat.designation }" /> </p></td></tr>
						 
						    <tr><td>  <p><strong>Description : </strong></p></td>
						      <td><p><c:out value="${requestScope.mat.description }" /> </p></td></tr>
						  
						   <tr><td>   <p> <strong>Categorie : </strong></p></td>
						     <td><p> <c:out value="${requestScope.mat.categorie }" /> </p></td></tr>
						 
						    <tr><td> <p><strong>État : </strong></p></td>
						      <td><p><c:out value="${requestScope.mat.etat }" /> </p></td></tr>
						 </table> 	
                        
                    </div>
                    <div class="col-lg-4">
                       <img src="<c:url value="/resources/images/materiel/${mat.id }.jpg" />" alt="materiel-image" class="image-materiel"/>
                    </div>
                    
                </div>
                <!-- /.row -->
                <br/><br/>
				<div class="row">
                      <div id="my-map"></div>
                </div>
                
                <div class="row" id="information-materiel">
                  <h2>Opération réalisé sur ce materiel </h2>
                  <a href="<c:url value="/user/ajouter-operation/${requestScope.mat.id }" />" class="btn btn-link">Ajouter Operation <i class="fa fa-plus"></i></a>
                  <table class="table">
                    <tr>
                       <th>Nom</th>
                       <th>Description</th>
                       <th>Date Operation</th>
                    </tr>
                    
                    <c:forEach items="${requestScope.ops }" var="item">
                       <tr>
                          <td> <c:out value="${item.nom }" /> </td>
                          <td> <c:out value="${item.description }" /> </td>
                          <td> <c:out value="${item.date_operation }" /> </td>
                       </tr>
                    </c:forEach>
                  </table>
                </div>
                <br/><br/>
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

   
   <script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
   <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    
	<script>
      function initMap() {
        var uluru = {lat: <c:out value="${requestScope.mat.latitude}" />, lng: <c:out value="${requestScope.mat.longitude}" />};
        var map = new google.maps.Map(document.getElementById('my-map'), {
          zoom: 10,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
    </script>
    
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBPjrXnETCcQkoDl-QXJTe8TBIHjJeyc8k&callback=initMap">
    </script>
   
</body>
</html>