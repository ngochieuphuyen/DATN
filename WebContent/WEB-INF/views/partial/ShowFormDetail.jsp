<%@page import="model.bean.Form"%>
<%
	Form form = (Form) request.getAttribute("form");
	String typeOfFormName = (String) request.getAttribute("typeOfFormName");
%>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">Form Detail</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<form>
					<div class="form-group">
						<label>Form Name</label> <input type="text" class="form-control"
							placeholder="Form Name" name="FormName"
							value="<%=form.getFormName()%>" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Type of form</label> <input type="text"
							class="form-control" placeholder="Form Name"
							value="<%=typeOfFormName%>" readonly="readonly">
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
							name="Descriptions" value="<%=form.getDescriptions()%>"
							readonly="readonly">
					</div>

					<div class="form-group">
						<div class="col-sm-1 col-xs-2">
							<a href="ShowFormManage" class="btn btn-primary btn-medium">Back</a>
						</div>
					</div>

				</form>

				<hr>

			</div>
		</div>
	</section>
	<!-- /.content -->
</div>