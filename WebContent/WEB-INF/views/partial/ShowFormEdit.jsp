<%@page import="model.bean.Form"%>
<%@page import="model.bean.TypeOfForm"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<TypeOfForm> listTypeOfForm = (ArrayList<TypeOfForm>) request.getAttribute("listTypeOfForm");
	Form form = (Form) request.getAttribute("form");
%>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">Form Edit</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<form action="DoFormEdit" method="post">
					<div class="form-group" hidden="">
						<label></label> <input type="text" class="form-control"
							placeholder="" name="idForm" value="<%=form.getIdForm()%>"
							required="required">
					</div>
					<div class="form-group">
						<label>Form Name</label> <input type="text" class="form-control"
							placeholder="Form Name" name="FormName"
							value="<%=form.getFormName()%>" required="required">
					</div>
					<div class="form-group">
						<label>Type of form</label> <select class="form-control"
							name="IdTypeOfForm">
							<%
								for (int i = 0; i < listTypeOfForm.size(); i++) {
									if (form.getIdTypeOfForm() == listTypeOfForm.get(i).getIdTypeOfForm()) {
							%>
							<option value="<%=listTypeOfForm.get(i).getIdTypeOfForm()%>"
								selected="selected"><%=listTypeOfForm.get(i).getTypeOfFormName()%></option>
							<%
								continue;
									}
							%>
							<option value="<%=listTypeOfForm.get(i).getIdTypeOfForm()%>"><%=listTypeOfForm.get(i).getTypeOfFormName()%></option>
							<%
								}
							%>
						</select>
					</div>
					<div class="form-group">
						<label>Waiting Time</label> <input type="number"
							class="form-control" placeholder="Waiting time"
							name="WaitingTime" value="<%=form.getWaitingTime()%>"
							required="required">
					</div>
					<div class="form-group">
						<label>Descriptions</label> <input type="text"
							class="form-control" placeholder="Descriptions"
							name="Descriptions" value="<%=form.getDescriptions()%>">
					</div>

					<div class="form-group">
						<div class="col-sm-1 col-xs-2">
							<button type="submit" class="btn btn-success btn-medium">Ok</button>
						</div>
						<div class="col-sm-1 col-xs-2">
							<a href="ShowFormManage" class="btn btn-primary btn-medium">Cancel</a>
						</div>
					</div>

				</form>

				<hr>

			</div>
		</div>
	</section>
	<!-- /.content -->
</div>