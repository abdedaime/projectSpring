<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/taglib.jsp"%>

<div class="container">

	<div id="forgot" style="display: none; margin-top: 50px;"
		class="mainbox  col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Mot de pass oubli�</div>
				<div
					style="float: right; font-size: 80%; position: relative; top: -10px">
					<a href="#" onclick="$('#forgot').hide(); $('#loginbox').show()">Sign
						In</a>
				</div>
			</div>

			<div style="padding-top: 30px" class="panel-body">

				<div style="display: none" id="login-alert"
					class="alert alert-danger col-sm-12"></div>

				<form id="form-password" class="form-horizontal" role="form">

					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input id="username"
							type="text" class="form-control" name="username" value=""
							placeholder="email">
					</div>

					<div style="margin-top: 10px" class="form-group">
						<!-- Button -->

						<div class="col-sm-12 controls">
							<button id="btn-login" class="btn btn-success pull-right">Envoyer</button>

						</div>
					</div>
				</form>



			</div>
		</div>
	</div>










	<div id="loginbox" style="margin-top: 50px;"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Sign In</div>
				<div
					style="float: right; font-size: 80%; position: relative; top: -10px">
					<a href="#" onclick="$('#forgot').show(); $('#loginbox').hide()">Mot
						de passe oubli�?</a>
				</div>
			</div>

			<div style="padding-top: 30px" class="panel-body">
				<c:if test="${param. login_error  eq 1}">
					<div class="alert alert-danger text-center">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong>Erreur!</strong> Donn�es invalide <br />
						<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
					</div>
				</c:if>

				<form id="loginform" class="form-horizontal" role="form"
					action='j_spring_security_check' method='POST'>

					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input id="email"
							type="text" class="form-control" name="email"
							placeholder="Email">
					</div>

					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span> <input id="password"
							type="password" class="form-control" name="password"
							placeholder="Password">
					</div>



					<div class="input-group">
						<div class="checkbox">
							<label> <input id="login-remember" type="checkbox"
								name="remember" value="1"> Remember me
							</label>
						</div>
					</div>


					<div style="margin-top: 10px" class="form-group">
						<!-- Button -->

						<div class="col-sm-12 controls">
							<button id="btn-login" class="btn btn-success">Se
								connecter</button>

						</div>
					</div>


					<div class="form-group">
						<div class="col-md-12 control">
							<div
								style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
								Vous n'avez pas encore un compte <a href="register.htm">
									Insrivez vous! </a>
							</div>
						</div>
					</div>
				</form>



			</div>
		</div>
	</div>

</div>

