<%@page import="model.bean.RegistrationSituation"%>
<%@page import="model.bean.Form"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<RegistrationSituation> listRegistrationSituation = (ArrayList<RegistrationSituation>) request.getAttribute("listRegistrationSituation");
	Form form = (Form) request.getAttribute("form");
%>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">Form Register</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<form action="DoFormRegister" method="post">
					<div class="form-group">
						<label>Situation</label> <select class="form-control"
							name="IdSituation">
							<%
								for (int i = 0; i < listRegistrationSituation.size(); i++) {
									
							%>
							<option value="<%=listRegistrationSituation.get(i).getIdSituation()%>"><%=listRegistrationSituation.get(i).getSituationName()%></option>
							<%
								}
							%>
						</select>
					</div>
					<div class="form-group" hidden="">
						<label></label> <input type="text" class="form-control"
							placeholder="" name="idForm" value="<%=form.getIdForm()%>"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>Form Name</label> <input type="text" class="form-control"
							placeholder="Form Name" name="FormName"
							value="<%=form.getFormName()%>" readonly="readonly">
					</div>
					
					<div class="form-group">
						<label>Waiting Time</label> <input type="number"
							class="form-control" placeholder="Waiting time"
							name="WaitingTime" value="<%=form.getWaitingTime()%>"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>Descriptions</label> <input type="text"
							class="form-control" placeholder="Descriptions"
							name="Descriptions" value="<%=form.getDescriptions()%>" readonly="readonly">
					</div>

					<div class="form-group">
						<div class="col-sm-1 col-xs-2">
							<button type="submit" class="btn btn-success btn-medium">Register</button>
						</div>
						<div class="col-sm-1 col-xs-2">
							<a href="ShowForm" class="btn btn-primary btn-medium">Cancel</a>
						</div>
					</div>

				</form>

				<hr>

			</div>
		</div>
	</section>
	<!-- /.content -->
</div>