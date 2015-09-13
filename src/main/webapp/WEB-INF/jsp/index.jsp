<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/taglib.jsp"%>



<div class="container">

	<div class="row">
		<div id="sidebar" class="col-md-3">
			<div class="well">
				<h4 class="text-center">Niveau</h4>

				<ul class="list-group checked-list-box">
					<li class="list-group-item">&nbsp;&nbsp; Bac+2</li>
					<li class="list-group-item">&nbsp;&nbsp; Bac+3</li>
					<li class="list-group-item">&nbsp;&nbsp; Bac+4</li>
					<li class="list-group-item">&nbsp;&nbsp; Bac+5</li>

				</ul>
			</div>

			<div class="well">
				<h4 class="text-center">Années d'experience</h4>

				<div class="form-group">
					<label for="amount" class="control-label">Entre:</label>
					<div class="">
						<input type="number" class="form-control" id="amount"
							name="amount">
					</div>
					<label for="amount" class="control-label">Et:</label>
					<div class="">
						<input type="number" class="form-control" id="amount"
							name="amount">
					</div>
				</div>
			</div>

			<div class="well">
				<h4 class="text-center">Langues</h4>

				<ul class="list-group checked-list-box">
					<li class="list-group-item">&nbsp;&nbsp; Arabe</li>
					<li class="list-group-item">&nbsp;&nbsp; Anglais</li>
					<li class="list-group-item">&nbsp;&nbsp; Français</li>
					<li class="list-group-item">&nbsp;&nbsp; Espagnol</li>

				</ul>
			</div>

			<div class="well">
				<h4 class="text-center">Ville</h4>

				<div class="form-group">
					<div class="">
						<select>
							<option>Casablanca</option>
							<option>Mohammedia</option>
							<option>Rabat</option>
							<option>Tanger</option>
							<option>Marrakech</option>
						</select>
					</div>
				</div>
			</div>


		</div>
		<!-- END Col sidebar-->


		<div id="main" class="col-md-9">
			<form   method="post">
				<div class="input-group">

					<input type="text"   name="search" class="form-control" placeholder="Rechercher...">

					<span class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</button>
					</span>

				</div>
				<!-- /input-group -->
			</form>

			<div>&nbsp;</div>
			<div>&nbsp;</div>

			<!-- NAV TABS START -->
			<div class="panel with-nav-tabs panel-default">
				<div class="panel-heading">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab1default" data-toggle="tab">Résultat</a></li>
						<li><a href="#tab2default" data-toggle="tab">...</a></li>
						<li><a href="#tab3default" data-toggle="tab">....</a></li>
					</ul>
				</div>

				<div class="panel-body">
					<div class="tab-content">
						<div class="tab-pane fade in active" id="tab1default">
							<!-- RESULT LIST START -->
							<div class="well well-sm">
							   
							                                                                  <c:forEach   var="cmp"      items="${userr}">
							      <p1>      </p1> 

							   <div class="row">
									<div class="col-xs-3 col-md-3 text-center">
										<img
											src="${pageContext.servletContext.contextPath}/resources/img/profile.png"
											alt="Image" class="img-rounded img-responsive" />
									</div>
									<div class="col-xs-9 col-md-9 section-box">
										<h2>
									      ${cmp.cv.user.nom}     ${cmp.cv.user.prenom } <a href="#" target="_blank"><span
												class="glyphicon glyphicon-new-window"> </span></a>
										</h2>
										<p>${cmp.cv.titre}</p>
										<hr />
										<div class="row details">
											<div class="col-md-12">
												<span class="glyphicon glyphicon-eye-open"> </span>Vues (36)
											</div>
										</div>
									</div>
								</div>

							   </c:forEach>
							
								
														<!-- RESULT LIST END -->
						</div>
						<!-- END TAB RESULT -->


						<div class="tab-pane fade" id="tab2default">...</div>
						<div class="tab-pane fade" id="tab3default">....</div>
					</div>
				</div>
			</div>
			<!-- NAV TABS END -->








		</div>
		<!-- END Col Main-->


	</div>