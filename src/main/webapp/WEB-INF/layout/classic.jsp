<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url   value="/resources/styles/css/bootstrap.min.css" />">
<link rel="stylesheet"
	href="<c:url   value="/resources/styles/css/bootstrap-datetimepicker.min.css" />">
<link rel="stylesheet"
	href="<c:url   value="/resources/styles/css/bootstrap-theme.min.css" />">

<link rel="stylesheet"
	href="<c:url   value="/resources/styles/css/font-awesome.min.css" />">
<link rel="stylesheet"
	href="<c:url   value="/resources/styles/css/style.css" />">




<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<tilesx:useAttribute name="current" />

	<div class="container">
		<div class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">E-Recrutement</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'index' ? 'active' : ''}"><a
								href="index.htm">Accueil</a></li>
						</security:authorize>
						<li><a href="#">Profil</a></li>
						<security:authorize access="isAuthenticated()">
							<li><a href="<spring:url value="/logout" />">Déconnexion</a></li>
						</security:authorize>

						<security:authorize access="!isAuthenticated()">
							<li class="${current == 'login' ? 'active' : ''}"><a
								href="login.htm">Authentification</a></li>
						</security:authorize>
												<security:authorize access="hasRole('ROLE_User')">
							<li class="${current == 'cv' ? 'active' : ''}"><a
								href="addCv.htm">Cv théque</a></li>
						</security:authorize>


					</ul>
					<!--           <ul class="nav navbar-nav navbar-right"> -->
					<!--             <li><a href="../navbar/">Default</a></li> -->
					<!--             <li><a href="../navbar-static-top/">Static top</a></li> -->
					<!--             <li class="active"><a href="./">Fixed top <span class="sr-only">(current)</span></a></li> -->
					<!--           </ul> -->
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</div>



	</div>







	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />

	<script type="text/javascript"
		src="<c:url   value="/resources/javascript/jquery-2.1.4.min.js" />">
		
	</script>
	<script type="text/javascript"
		src="<c:url   value="/resources/javascript/bootstrap.min.js" />">
		
	</script>
	<script type="text/javascript"
		src="<c:url   value="/resources/javascript/bootstrap-datetimepicker.min.js" />">
		
	</script>
	<script type="text/javascript"
		src="<c:url   value="/resources/javascript/bootstrap-datetimepicker.fr.js" />">
		
	</script>

	<script type="text/javascript"
		src="<c:url   value="/resources/javascript/jquery.validate.min.js" />">
		
	</script>
	<script type="text/javascript"
		src="<c:url   value="/resources/javascript/app.js" />">
		
	</script>


</body>
</html>