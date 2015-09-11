<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/taglib.jsp"%>



<div id="signupbox" style="margin-top: 50px"
	class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">Sign Up</div>
			<div
				style="float: right; font-size: 85%; position: relative; top: -10px">
				<a id="signinlink" href="login.htm">Sign In</a>
			</div>
		</div>
		<div class="panel-body">
		<c:if   test="${succes eq true }"  >
		  <div class="alert alert-success text-center">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong>Info!</strong>   Cv ajoutée
					</div>
		
		  </c:if>
			<form:form id="cvForm" modelAttribute="user" method="post"
				class="form-horizontal" role="form">

				<div id="signupalert" style="display: none"
					class="alert alert-danger">
					<p>Error:</p>
					<span></span>
				</div>



				<div class="form-group">
					<label for="email" class="col-md-3 control-label">Email</label>
					<div class="col-md-9">
						<form:input path="email" class="form-control" name="email"
							id="email" placeholder="Email Address" />
						<form:errors path="email" class="inline-help text text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label for="firstname" class="col-md-3 control-label">Nom</label>
					<div class="col-md-9">
						<form:input path="nom" class="form-control" id="nom" name="nom"
							placeholder="Nom" />


						<form:errors path="nom" cssClass="text text-danger">
						</form:errors>
					</div>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-md-3 control-label">Prénom</label>
					<div class="col-md-9">
						<form:input path="prenom" class="form-control" name="prenom"
							id="prenom" placeholder="prenom" />
						<form:errors path="prenom" cssClass="text text-danger" />
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-md-3 control-label">Password</label>
					<div class="col-md-9">
						<form:password path="password" class="form-control" id="password"
							name="password" placeholder="Password" />
						<form:errors path="password" cssClass="text text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label for="password1" class="col-md-3 control-label">Confirmez
						Password</label>
					<div class="col-md-9">
						<form:password path="confirmepass" class="form-control"
							id="confirmepass" name="confirmepass" placeholder="Password" />
						<form:errors path="confirmepass" cssClass="text text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label for="date" class="col-md-3 control-label">Date de
						Naissance</label>
					<div class="col-md-9">
						<form:input path="dateNaissance" class="form-control" id="date"
							name="date" placeholder="Date de naissance" />
						<form:errors path="dateNaissance" cssClass="text text-danger" />
					</div>
				</div>
				
				<div class="form-group">
					<!-- Button -->
					<div class="col-md-offset-3 col-md-9">
						<button id="btn-signup" type="submit" class="btn btn-info">
							<i class="icon-hand-right"></i>Enregistrer
						</button>

					</div>
				</div>





			</form:form>
		</div>
	</div>




</div>
