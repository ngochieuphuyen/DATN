<%@page import="model.bean.Faculty"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<Faculty> listFaculty = (ArrayList<Faculty>) request.getAttribute("listFaculty");
%>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title col-sm-7">List Faculty</h3>
				<input type="text" class="col-sm-4" id="myInput" onkeyup="myFunction()"
				placeholder="Search for faculty...">
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<table class="table table-bordered" id ="myTable">
					<thead>
						<tr>
							<th></th>
							<th>Faculty Name</th>
							<th>
								<div class="pull-right">
									<a href="ShowFacultyAdd" class="btn btn-info"><i
										class="fa fa-plus" aria-hidden="true"></i></a>
								</div>
							</th>

						</tr>
					</thead>
					<%
						for (int i = 0; i < listFaculty.size(); i++) {
					%>
					<tr>
						<td><%=(i + 1)%></td>
						<td><a
							href="ShowClasses?class=<%="FacultyWith" + listFaculty.get(i).getIdFaculty()%>"><%=listFaculty.get(i).getFacultyName()%></a></td>

						<td><div class="pull-right">
								<a
									href="ShowFacultyEdit?idFaculty=<%=listFaculty.get(i).getIdFaculty()%>"
									class="btn btn-primary"><i class="fa fa-pencil"
									aria-hidden="true"></i></a> <a href="#confirmDeleteFaculty<%=i%>"
									role="button" data-toggle="modal" class="btn btn-danger"><i
									class="fa fa-trash" aria-hidden="true"></i></a>
							</div>

							<div class="modal fade" id="confirmDeleteFaculty<%=i%>"
								role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Delete Faculty</h4>
										</div>
										<div class="modal-body">
											<p>Do you want to delete this faculty?</p>
											<br>
											<p></p>
										</div>
										<div class="modal-footer">
											<a
												href="DoFacultyDelete?idFaculty=<%=listFaculty.get(i).getIdFaculty()%>"
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