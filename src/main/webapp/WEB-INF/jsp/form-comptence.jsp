<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/taglib.jsp"%>

<div id="competence" style="margin-top: 50px"
	class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">Compétence</div>

		</div>
		<div class="panel-body">
			<c:if test="${cmptCreated eq true }">
				<div class="alert alert-success text-center">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Info!</strong> Compétence ajoutée
				</div>

			</c:if>
			<form:form id="comptForm" modelAttribute="competence"
				 action="addCompet.htm" method="post"
				class="form-horizontal" role="form">





				<div class="form-group">
					<label for="nom" class="col-md-3 control-label">Compétence</label>
					<div class="col-md-9">
						<form:input path="nom" class="form-control" name="nom"
							id="nom" placeholder="Compétence" />
						<form:errors path="nom" class="inline-help text text-danger" />
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
