<%@page import="model.bean.Student"%>
<%@page import="model.bean.Classes"%>
<%
	Classes classes = (Classes) request.getAttribute("class");
	Student student = (Student) request.getAttribute("student");
%>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">Information account</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<form>




					<div class="form-group">
						<label class="col-md-10">FullName</label>
						<div class="col-md-8">
							<input type="text" class="form-control" placeholder="full name"
								name="FullName" value="<%=student.getFullName()%>"
								readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-10">StudentNumber</label>
						<div class="col-md-8">
							<input type="text" class="form-control"
								placeholder="student number" name="StudentNumber"
								value="<%=student.getStudentNumber()%>" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-10"></label>
						<div class="col-md-8">
							<%
								if (student.isMale()) {
							%>
							<input type="radio" name="Male" value="false" readonly="readonly">
							Female <input type="radio" name="Male" value="true" checked
								readonly="readonly"> Male
							<%
								} else {
							%>
							<input type="radio" name="Male" value="false" checked
								readonly="readonly"> Female <input type="radio"
								name="Male" value="true" readonly="readonly"> Male
							<%
								}
							%>

						</div>

					</div>


					<div class="form-group">
						<label class="col-md-10">Birthday</label>
						<div class="col-md-8">
							<input type="date" class="form-control" placeholder="birthday"
								name="Birthday" required="required"
								value="<%=student.getBirthday()%>" readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-10">Faculty</label>
						<div class="col-md-8">
							<input type="text" class="form-control" placeholder="Faculty"
								name="Faculty" value="<%=classes.getFacultyName()%>"
								readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-10">Course</label>
						<div class="col-md-8">
							<input type="text" class="form-control" placeholder="Course"
								name="Course" value="<%=classes.getCourseName()%>"
								readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-10">Class</label>
						<div class="col-md-8">
							<input type="text" class="form-control" placeholder="Class"
								name="Class" value="<%=classes.getClassName()%>"
								readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-10">PhoneNumber</label>
						<div class="col-md-4">
							<input type="text" class="form-control"
								placeholder="Phone number" name="PhoneNumber"
								readonly="readonly" value="<%=student.getPhoneNumber()%>">
						</div>
						<div class="col-md-4">
							<input type="text" class="form-control" placeholder="Home phone"
								name="HomePhone" value="<%=student.getHomePhone()%>"
								readonly="readonly">
						</div>
					</div>
					<div class="form-group" hidden="">
						<label class="col-md-10"></label>
						<div class="col-md-8">
							<input type="text" class="form-control"
								value="<%=student.getIdStudent()%>" name="IdStudent">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-10"></label>
						<div class="col-md-10">
							<div class="col-sm-1 col-xs-2">
								<a href="ShowStudents?students=???"
									class="btn btn-primary btn-medium">Back</a>
							</div>
						</div>
					</div>

				</form>

				<hr>

			</div>
		</div>
	</section>
	<!-- /.content -->
</div>