<%@page import="model.bean.Decentralization"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Decentralization> listDecentralization = (ArrayList<Decentralization>) request.getAttribute("listDecentralization"); %>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">List Decentralization</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<table class="table table-bordered" id="table1">
					<thead>
						<tr>
							<th></th>
							<th> Name</th>
							<th>
								<div class="pull-right">
									<a href="ShowDecentralizationAdd" class="btn btn-info"><i
										class="fa fa-plus" aria-hidden="true"></i></a>
								</div>
							</th>

						</tr>
					</thead>
					<%
						for (int i = 0; i < listDecentralization.size(); i++) {
					%>
					<tr>
						<td><%=(i + 1)%></td>
						<td><a
							href="ShowDecentralization?idDecantrlization=<%=listDecentralization.get(i).getIdDecentralization()%>"><%=listDecentralization.get(i).getDecentralizationName()%></a></td>

						<td><div class="pull-right">
								<a
									href="ShowDecantralizationEdit?idDecantralization=<%=listDecentralization.get(i).getIdDecentralization()%>"
									class="btn btn-primary"><i class="fa fa-pencil"
									aria-hidden="true"></i></a> <a href="#confirmDelete<%=i%>"
									role="button" data-toggle="modal" class="btn btn-danger"><i
									class="fa fa-trash" aria-hidden="true"></i></a>
							</div>

							<div class="modal fade" id="confirmDelete<%=i%>"
								role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Delete Decentralization</h4>
										</div>
										<div class="modal-body">
											<p>Do you want to delete this decentralization?</p>
											<br>
											<p></p>
										</div>
										<div class="modal-footer">
											<a
												href="DoDecentralizationDelete?idDecentralization=<%=listDecentralization.get(i).getIdDecentralization()%>"
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