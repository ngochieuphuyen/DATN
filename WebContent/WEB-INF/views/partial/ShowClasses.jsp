<%@page import="model.bean.Classes"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Classes> listClass = (ArrayList<Classes>) request.getAttribute("listClass"); %>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title col-sm-7">List Classes</h3>
				<input type="text" class="col-sm-4" id="myInput" onkeyup="myFunction()"
				placeholder="Search for class...">
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<table class="table table-bordered" id="myTable">
					<thead>
						<tr>
							<th></th>
							<th>Class Name</th>
							<th>
								<div class="pull-right">
									<a href="ShowClassesAdd" class="btn btn-info" ><i
										 class="fa fa-plus"  aria-hidden="true"></i></a>
								</div>
							</th>
							
						</tr>
					</thead>
					<%
						for (int i = 0; i < listClass.size(); i++) {
					%>
					<tr>
						<td><%=(i + 1)%></td>
						<td><a
							href="ShowStudents?students=<%=listClass.get(i).getIdClass()%>"><%=listClass.get(i).getClassName()%></a></td>

						<td><div class="pull-right">
								<a
									href="ShowClassesEdit?idClass=<%=listClass.get(i).getIdClass()%>"
									class="btn btn-primary"><i class="fa fa-pencil"
									aria-hidden="true"></i></a> <a href="#confirmDeleteClass<%=i%>"
									role="button" data-toggle="modal" class="btn btn-danger"><i
									class="fa fa-trash" aria-hidden="true"></i></a>
							</div>

							<div class="modal fade" id="confirmDeleteClass<%=i%>"
								role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Delete Class</h4>
										</div>
										<div class="modal-body">
											<p>Do you want to delete this class?</p>
											<br>
											<p></p>
										</div>
										<div class="modal-footer">
											<a
												href="DoClassesDelete?idClass=<%=listClass.get(i).getIdClass()%>"
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