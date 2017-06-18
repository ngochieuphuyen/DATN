<%@page import="model.bean.Student"%>
<%@page import="model.bean.Classes"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<Classes> listClasses = (ArrayList<Classes>) request.getAttribute("listClasses");
	Student student = (Student) request.getAttribute("student");
%>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">Student</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<form action="DoStudentEdit" method="post">




					<div class="form-group">
						<label class="col-md-10">FullName</label>
						<div class="col-md-8">
							<input type="text" class="form-control" placeholder="full name"
								name="FullName" value="<%=student.getFullName()%>"
								required="required">
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
							<input type="radio" name="Male" value="false"> Female <input
								type="radio" name="Male" value="true" checked> Male
							<%
								} else {
							%>
							<input type="radio" name="Male" value="false" checked>
							Female <input type="radio" name="Male" value="true"> Male
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
								value="<%=student.getBirthday()%>">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-10">Class</label>
						<div class="col-md-8">
							<select class="form-control" name="Class">
								<%
									for (int i = 0; i < listClasses.size(); i++) {
										if (student.getIdClass() == listClasses.get(i).getIdClass()) {
								%>
								<option value="<%=listClasses.get(i).getIdClass()%>"
									selected="selected"><%=listClasses.get(i).getClassName()%></option>
								<%
									continue;
										}
								%>
								<option value="<%=listClasses.get(i).getIdClass()%>"><%=listClasses.get(i).getClassName()%></option>
								<%
									}
								%>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-10">PhoneNumber</label>
						<div class="col-md-4">
							<input type="text" class="form-control"
								placeholder="Phone number" name="PhoneNumber"
								required="required" value="<%=student.getPhoneNumber()%>">
						</div>
						<div class="col-md-4">
							<input type="text" class="form-control" placeholder="Home phone"
								name="HomePhone" value="<%=student.getHomePhone()%>">
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
								<button type="submit" class="btn btn-success btn-medium">Ok</button>
							</div>
							<div class="col-sm-1 col-xs-2">
								<a href="ShowStudents?students=???" class="btn btn-primary btn-medium">Cancel</a>
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