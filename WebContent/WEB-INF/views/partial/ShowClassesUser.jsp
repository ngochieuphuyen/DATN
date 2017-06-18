<%@page import="model.bean.Student"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Student> listStudents = (ArrayList<Student>) request.getAttribute("listStudents"); %>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">List Students</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<table class="table table-bordered" id="table1">
					<thead>
						<tr>
							<th></th>
							<th>Full Name</th>
							<th>Student Number</th>
							
							
						</tr>
					</thead>
					<%
						for (int i = 0; i < listStudents.size(); i++) {
					%>
					<tr>
						<td><%=(i + 1)%></td>
						<td><a
							href="ShowDetailStudent?idStudent=<%=listStudents.get(i).getIdStudent()%>"><%=listStudents.get(i).getFullName()%></a></td>
						
						<td><a
							href="ShowDetailStudent?idStudent=<%=listStudents.get(i).getIdStudent()%>"><%=listStudents.get(i).getStudentNumber()%></a></td>
						
						
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