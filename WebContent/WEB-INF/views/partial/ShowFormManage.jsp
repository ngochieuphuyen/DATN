<%@page import="model.bean.Form"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Form> listForm = (ArrayList<Form>) request.getAttribute("listForm"); %>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">List Form</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<table class="table table-bordered" id="table1">
					<thead>
						<tr>
							<th></th>
							<th>Form Name</th>
							<th>
								<div class="pull-right">
									<a href="ShowFormAdd" class="btn btn-info" ><i
										 class="fa fa-plus"  aria-hidden="true"></i></a>
								</div>
							</th>
							
						</tr>
					</thead>
					<%
						for (int i = 0; i < listForm.size(); i++) {
					%>
					<tr>
						<td><%=(i + 1)%></td>
						<td><a
							href="ShowFormDetail?idForm=<%=listForm.get(i).getIdForm()%>"><%=listForm.get(i).getFormName()%></a></td>

						<td><div class="pull-right">
								<a
									href="ShowFormEdit?idForm=<%=listForm.get(i).getIdForm()%>"
									class="btn btn-primary"><i class="fa fa-pencil"
									aria-hidden="true"></i></a> <a href="#confirmDeleteForm<%=i%>"
									role="button" data-toggle="modal" class="btn btn-danger"><i
									class="fa fa-trash" aria-hidden="true"></i></a>
							</div>

							<div class="modal fade" id="confirmDeleteForm<%=i%>"
								role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Delete Form</h4>
										</div>
										<div class="modal-body">
											<p>Do you want to delete this form?</p>
											<br>
											<p></p>
										</div>
										<div class="modal-footer">
											<a
												href="DoFormDelete?idForm=<%=listForm.get(i).getIdForm()%>"
												class="btn btn-danger">Yes</a> <input type="button"
												class="btn btn-default" data-dismiss="modal" value="No">
										</div>

									</div>
								</div>
							</div></td>
					</tr>
					<%
						}
					%>

				</table>
				<!-- Change by import page here -->
			</div>
		</div>
	</section>
	<!-- /.content -->
</div>