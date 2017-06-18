<%@page import="model.bean.Account"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<Account> listAccount = (ArrayList<Account>) request.getAttribute("listAccount");
%>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title col-sm-7">List Account</h3>
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
							<th>Email</th>

						</tr>
					</thead>
					<%
						for (int i = 0; i < listAccount.size(); i++) {
					%>
					<tr>
						<td><%=i+1%></td>
						<td><%=listAccount.get(i).getUsername()%></td>
						<td><%=listAccount.get(i).getEmail()%></td>

						<td><div class="pull-right">
								<a
									href="ShowAccountManagementEditServlet?idAccount=<%=listAccount.get(i).getIdAccount()%>"
									class="btn btn-primary"><i class="fa fa-pencil"
									aria-hidden="true"></i></a>
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
			</div>
		</div>
	</section>
	<!-- /.content -->
</div>