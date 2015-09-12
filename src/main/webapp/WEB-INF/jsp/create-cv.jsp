<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/taglib.jsp"%>

<style>
.wizard {
	margin: 20px auto;
	background: #fff;
}

.wizard .nav-tabs {
	position: relative;
	margin: 40px auto;
	margin-bottom: 0;
	border-bottom-color: #e0e0e0;
}

.wizard>div.wizard-inner {
	position: relative;
}

.connecting-line {
	height: 2px;
	background: #e0e0e0;
	position: absolute;
	width: 80%;
	margin: 0 auto;
	left: 0;
	right: 0;
	top: 50%;
	z-index: 1;
}

.wizard .nav-tabs>li.active>a,.wizard .nav-tabs>li.active>a:hover,.wizard .nav-tabs>li.active>a:focus
	{
	color: #555555;
	cursor: default;
	border: 0;
	border-bottom-color: transparent;
}

span.round-tab {
	width: 70px;
	height: 70px;
	line-height: 70px;
	display: inline-block;
	border-radius: 100px;
	background: #fff;
	border: 2px solid #e0e0e0;
	z-index: 2;
	position: absolute;
	left: 0;
	text-align: center;
	font-size: 25px;
}

span.round-tab i {
	color: #555555;
}

.wizard li.active span.round-tab {
	background: #fff;
	border: 2px solid #5bc0de;
}

.wizard li.active span.round-tab i {
	color: #5bc0de;
}

span.round-tab:hover {
	color: #333;
	border: 2px solid #333;
}

.wizard .nav-tabs>li {
	width: 25%;
}

.wizard li:after {
	content: " ";
	position: absolute;
	left: 46%;
	opacity: 0;
	margin: 0 auto;
	bottom: 0px;
	border: 5px solid transparent;
	border-bottom-color: #5bc0de;
	transition: 0.1s ease-in-out;
}

.wizard li.active:after {
	content: " ";
	position: absolute;
	left: 46%;
	opacity: 1;
	margin: 0 auto;
	bottom: 0px;
	border: 10px solid transparent;
	border-bottom-color: #5bc0de;
}

.wizard .nav-tabs>li a {
	width: 70px;
	height: 70px;
	margin: 20px auto;
	border-radius: 100%;
	padding: 0;
}

.wizard .nav-tabs>li a:hover {
	background: transparent;
}

.wizard .tab-pane {
	position: relative;
	padding-top: 50px;
}

.wizard h3 {
	margin-top: 0;
}

@media ( max-width : 585px ) {
	.wizard {
		width: 90%;
		height: auto !important;
	}
	span.round-tab {
		font-size: 16px;
		width: 50px;
		height: 50px;
		line-height: 50px;
	}
	.wizard .nav-tabs>li a {
		width: 50px;
		height: 50px;
		line-height: 50px;
	}
	.wizard li.active:after {
		content: " ";
		position: absolute;
		left: 35%;
	}
}
</style>


<div class="container">
	<div class="row">
		<section>
			<div class="wizard">
				<div class="wizard-inner">
					<div class="connecting-line"></div>
					<ul class="nav nav-tabs" role="tablist">

						<li role="presentation" class="active"><a href="#step1"
							data-toggle="tab" aria-controls="step1" role="tab"
							title="Creér votre  cv "> <span class="round-tab"> <i
									class="glyphicon glyphicon-folder-open"></i>
							</span>
						</a></li>

						<li role="presentation" class="disabled"><a href="#step2"
							data-toggle="tab" aria-controls="step2" role="tab"
							title="Formation"> <span class="round-tab"> <i
									class="glyphicon glyphicon-pencil"></i>
							</span>
						</a></li>
						<li role="presentation" class="disabled"><a href="#step3"
							data-toggle="tab" aria-controls="step3" role="tab"
							title="Experience"> <span class="round-tab"> <i
									class="glyphicon glyphicon-picture"></i>
							</span>
						</a></li>

						<li role="presentation" class="disabled"><a href="#complete"
							data-toggle="tab" aria-controls="complete" role="tab"
							title="	Comptence"> <span class="round-tab"> <i
									class="glyphicon glyphicon-ok"></i>
							</span>
						</a></li>
					</ul>
				</div>


				<div class="tab-content">
					<div class="tab-pane active" role="tabpanel" id="step1">

						<div id="addcv"
							class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
							<div class="panel panel-info">
								<div class="panel-heading">
									<div class="panel-title">Cv</div>

								</div>
								<div class="panel-body">
									<c:if test="${cvcreated eq true }">
										<div class="alert alert-success text-center">
											<a href="#" class="close" data-dismiss="alert"
												aria-label="close">&times;</a> <strong>Info!</strong>
											Cv bien ajouté
										</div>

									</c:if>
									<form:form id="addcvForm" modelAttribute="cv" method="post"
										class="form-horizontal" role="form">
										<div class="form-group">
											<label for="titre" class="col-md-3 control-label">Titre</label>
											<div class="col-md-9">
												<form:input path="titre" class="form-control" name="titre"
													id="titre" placeholder="titre" />
												<form:errors path="titre" cssClass="text text-danger" />
											</div>
										</div>
										<div class="form-group">
											<label for="description" class="col-md-3 control-label">Description</label>
											<div class="col-md-9">
												<form:textarea path="description" class="form-control"
													name="description" id="description"
													placeholder="description" />
												<form:errors path="description" cssClass="text text-danger" />
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


					</div>
					<div class="tab-pane" role="tabpanel" id="step2">
						<jsp:include page="form-formation.jsp"></jsp:include>
					</div>
					<div class="tab-pane" role="tabpanel" id="step3">
						<jsp:include page="form-experience.jsp"></jsp:include>
					</div>
					<div class="tab-pane" role="tabpanel" id="complete">
						  <jsp:include page="form-comptence.jsp"></jsp:include>
					</div>
					<div class="clearfix"></div>
				</div>

			</div>
		</section>
	</div>
</div>