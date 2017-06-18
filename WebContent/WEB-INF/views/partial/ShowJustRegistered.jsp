<%@page import="model.bean.AccountOfForm"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<AccountOfForm> listJustRegistered = (ArrayList<AccountOfForm>) request
			.getAttribute("listJustRegistered");
%>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title col-sm-7">List Just Registered</h3>
				<input type="text" class="col-sm-4" id="myInput" onkeyup="myFunction()"
					placeholder="Search for username...">
			</div>
			
			<!--  ending header Table -->
			<div class="box-body">
				<table class="table table-bordered" id="myTable">
					<thead>
						<tr>
							<th></th>
							<th>Username</th>
							<th>Form</th>
							<th>Time Of Registration</th>
							<th>Receiving Time</th>

						</tr>
					</thead>
					<%
						for (int i = 0; i < listJustRegistered.size(); i++) {
					%>
					<tr>
						<td><%=(i + 1)%></td>
						<td><%=listJustRegistered.get(i).getUsername() %></td>
						<td><%=listJustRegistered.get(i).getFormName() %></td>
						<td><%=listJustRegistered.get(i).getTimeOfRegistration()%></td>
						<td><%=listJustRegistered.get(i).getReceivingTime() %></td>
						<td><div class="pull-right">
								<a href="#confirmReceivingForm<%=i%>"
									role="button" data-toggle="modal" class="btn btn-warning"><i
									class="fa fa-check-square" aria-hidden="true"></i></a>
							</div>

							<div class="modal fade" id="confirmReceivingForm<%=i%>"
								role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Receive Form</h4>
										</div>
										<div class="modal-body">
											<p>Would you like to pay 30000vnd to get this form?</p>
											<br>
											<p></p>
										</div>
										<div class="modal-footer">
											<a
												href="DoUnsubscribe?idAccountOfForm=<%=listJustRegistered.get(i).getIdAccountOfForm()%>"
												class="btn btn-danger">Yes</a> <input type="button"
												class="btn btn-default" data-dismiss="modal" value="No">
										</div>

									</div>
								</div>
							</div></td>
						
						
						
						
						<td><div class="pull-right">
								<a href="#confirmDeleteFormJustRegistered<%=i%>"
									role="button" data-toggle="modal" class="btn btn-danger"><i
									class="fa fa-trash" aria-hidden="true"></i></a>
							</div>

							<div class="modal fade" id="confirmDeleteFormJustRegistered<%=i%>"
								role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Unsubscribe Form</h4>
										</div>
										<div class="modal-body">
											<p>Do you want to unsubscribe from this form?</p>
											<br>
											<p></p>
										</div>
										<div class="modal-footer">
											<a
												href="DoUnsubscribe?idAccountOfForm=<%=listJustRegistered.get(i).getIdAccountOfForm()%>"
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
				<script>
					function myFunction() {
						// Declare variables 
						var input, filter, table, tr, td, i;
						input = document.getElementById("myInput");
						filter = input.value.toUpperCase();
						table = document.getElementById("myTable");
						tr = table.getElementsByTagName("tr");
						for (i = 0; i < tr.length; i++) {
							td = tr[i].getElementsByTagName("td")[1];
							if (td) {
								if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
									tr[i].style.display = "";
								} else {
									tr[i].style.display = "none";
								}
							}
						}
					}
				</script>
				<!-- Change by import page here -->
			</div>
		</div>
	</section>
	<!-- /.content -->
</div>