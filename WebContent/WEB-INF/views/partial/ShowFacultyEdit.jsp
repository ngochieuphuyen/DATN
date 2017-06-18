<%@page import="model.bean.Faculty"%>
<%Faculty faculty = (Faculty) request.getAttribute("faculty"); %>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">Add Faculty</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<form action="DoFacultyEdit" method="post">
					<div class="form-group">
						<label>Faculty Name</label>
						<input type="text" class="form-control"
							placeholder="Faculty Name" name="FacultyName" value="<%=faculty.getFacultyName() %>" required="required">
							
					</div>
					<div class="form-group" hidden="">
						<label>Faculty Name</label>
						<input type="text" class="form-control"
							 name="IdFaculty" value="<%=faculty.getIdFaculty() %>">
							
					</div>
					
					<div class="form-group">
						<div class="col-sm-1 col-xs-2">
						    <button type="submit" class="btn btn-success btn-medium">Ok</button>
						</div>
						<div class="col-sm-1 col-xs-2">
						    <a href="ShowFaculty" class="btn btn-primary btn-medium">Cancel</a>
						</div>
					</div>
					
				</form>
				
				<hr>
			</div>
		</div>
	</section>
	<!-- /.content -->
</div>