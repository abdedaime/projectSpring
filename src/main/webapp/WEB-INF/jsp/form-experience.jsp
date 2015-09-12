<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/taglib.jsp"%>

<div id="experience" style="margin-top: 50px"
	class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">Expérience</div>

		</div>
		<div class="panel-body">
			<c:if test="${expCreated eq true }">
				<div class="alert alert-success text-center">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Info!</strong> Experience ajoutée
				</div>

			</c:if>
			<form:form id="experForm" modelAttribute="experience"
				 action="addExper.htm" method="post"
				class="form-horizontal" role="form">





				<div class="form-group">
					<label for="entrerpise" class="col-md-3 control-label">Entrerpise</label>
					<div class="col-md-9">
						<form:input path="entrerpise" class="form-control" name="entrerpise"
							id="entrerpise" placeholder="Entrerpise" />
						<form:errors path="entrerpise" class="inline-help text text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label for="mission" class="col-md-3 control-label">mission</label>
					<div class="col-md-9">
						<form:input path="mission" class="form-control" name="mission"
							id="mission" placeholder="Mission" />
					
						<form:errors path="mission" class="inline-help text text-danger" />
					</div>
				</div>


				<div class="form-group">
					<label for="datedebut" class="col-md-3 control-label">Date
						Début </label>
					<div class="col-md-9">
						<form:input path="dateDebut" class="form-control madate" id="datedebut"
							name="datedebut" placeholder="Date Début" />
						<form:errors path="dateDebut" cssClass="text text-danger" />
					</div>
				</div>
				<div class="form-group">
					<label for="dateFin" class="col-md-3 control-label">Date
						Fin </label>
					<div class="col-md-9">
						<form:input path="dateFin" class="form-control   madate"
							id="datefin" name="datefin" placeholder="Date Fin" />
						<form:errors path="dateFin" cssClass="text text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label for="comm" class="col-md-3 control-label">Commentaire
					</label>
					<div class="col-md-9">
						<form:textarea path="commentaire" class="form-control " id="comm"
							name="comm" placeholder="Commentaire" />
						<form:errors path="commentaire" cssClass="text text-danger" />
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
