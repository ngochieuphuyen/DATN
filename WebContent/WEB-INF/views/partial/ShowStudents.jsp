<%@page import="model.bean.Student"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<Student> listStudents = (ArrayList<Student>) request.getAttribute("listStudents");
%>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title col-sm-7">List Students</h3>
				<input type="text" class="col-sm-4" id="myInput" onkeyup="myFunction()"
				placeholder="Search for name...">
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<table class="table table-bordered" id="myTable">
					<thead>
						<tr>
							<th></th>
							<th>Full Name</th>
							<th>Student Number</th>
							<th>
								<div class="pull-right">
									<a href="ShowStudentAdd" class="btn btn-info"><i
										class="fa fa-plus" aria-hidden="true"></i></a>
								</div>
							</th>

						</tr>
					</thead>
					<%
						for (int i = 0; i < listStudents.size(); i++) {
					%>
					<tr>
						<td><%=(i + 1)%></td>
						<td><a
							href="ShowStudentDetail?idStudent=<%=listStudents.get(i).getIdStudent()%>"><%=listStudents.get(i).getFullName()%></a></td>

						<td><a
							href="ShowStudentDetail?idStudent=<%=listStudents.get(i).getIdStudent()%>"><%=listStudents.get(i).getStudentNumber()%></a></td>

						<td><div class="pull-right">
								<a
									href="ShowStudentEdit?idStudent=<%=listStudents.get(i).getIdStudent()%>"
									class="btn btn-primary"><i class="fa fa-pencil"
									aria-hidden="true"></i></a> <a href="#confirmDeleteStudent<%=i%>"
									role="button" data-toggle="modal" class="btn btn-danger"><i
									class="fa fa-trash" aria-hidden="true"></i></a>
							</div>

							<div class="modal fade" id="confirmDeleteStudent<%=i%>"
								role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Delete Student</h4>
										</div>
										<div class="modal-body">
											<p>Do you want to delete this student?</p>
											<br>
											<p></p>
										</div>
										<div class="modal-footer">
											<a
												href="DoStudentDelete?idStudent=<%=listStudents.get(i).getIdStudent()%>"
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