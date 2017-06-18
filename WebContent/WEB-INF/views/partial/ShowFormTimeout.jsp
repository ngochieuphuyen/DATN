<%@page import="model.bean.AccountOfForm"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<AccountOfForm> listTimeout = (ArrayList<AccountOfForm>) request
			.getAttribute("listTimeout");
%>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title col-sm-7">List Time out</h3>
				<input type="text" class="col-sm-4" id="myInput" onkeyup="myFunction()"
					placeholder="Search for username...">
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<table class="table table-bordered" id="table1">
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
						for (int i = 0; i < listTimeout.size(); i++) {
					%>
					<tr>
						<td><%=(i + 1)%></td>
						<td><%=listTimeout.get(i).getUsername() %></td>
						<td><%=listTimeout.get(i).getFormName() %></td>
						<td><%=listTimeout.get(i).getTimeOfRegistration()%></td>
						<td><%=listTimeout.get(i).getReceivingTime() %></td>
						<td><div class="pull-right">
								<a href="#confirmDeleteFormJustRegistered<%=i%>"
									role="button" data-toggle="modal" class="btn btn-danger"><i
									class="fa fa-expeditedssl" aria-hidden="true"></i></a>
							</div>

							<div class="modal fade" id="confirmDeleteFormJustRegistered<%=i%>"
								role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Receive Form</h4>
										</div>
										<div class="modal-body">
											<p>Would you like to receive this form</p>
											<br>
											<p></p>
										</div>
										<div class="modal-footer">
											<a
												href="DoFormTimeout?idAccountOfForm=<%=listTimeout.get(i).getIdAccountOfForm()%>"
												class="btn btn-danger">Yes</a> <input type="button"
												class="btn btn-primary" data-dismiss="modal" value="No">
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

						// Loop through all table rows, and hide those who don't match the search query
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