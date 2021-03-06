<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">Add Course</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<form action="DoCourseAdd" method="post">
					<div class="form-group">
						<label>Faculty Name</label>
						<input type="text" class="form-control"
							placeholder="Course Name" name="CourseName" required="required">
					</div>
					<div class="form-group">
						<div class="col-sm-1 col-xs-2">
						    <button type="submit" class="btn btn-success btn-medium">Ok</button>
						</div>
						<div class="col-sm-1 col-xs-2">
						    <a href="ShowCourses" class="btn btn-primary btn-medium">Cancel</a>
						</div>
					</div>
					
				</form>
				
				<hr>
			</div>
		</div>
	</section>
	<!-- /.content -->
</div>