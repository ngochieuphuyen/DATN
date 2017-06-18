<%@page import="model.bean.Classes"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<Classes> listClasses = (ArrayList<Classes>) request.getAttribute("listClasses");
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
				<form action="DoStudentAdd" method="post">




					<div class="form-group">
						<label class="col-md-10">FullName</label>
						<div class="col-md-8">
							<input type="text" class="form-control" placeholder="full name"
								name="FullName" required="required">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-10">StudentNumber</label>
						<div class="col-md-8">
							<input type="text" class="form-control"
								placeholder="student number" name="StudentNumber"
								required="required">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-10"></label>
						<div class="col-md-8">
							<input type="radio" name="Male" value="false"> Female <input
								type="radio" name="Male" value="true"> Male
						</div>

					</div>


					<div class="form-group">
						<label class="col-md-10">Birthday</label>
						<div class="col-md-8">
							<input type="date" class="form-control" placeholder="birthday"
								name="Birthday" required="required">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-10">Class</label>
						<div class="col-md-8">
							<select class="form-control" name="Class">
								<%
									for (int i = 0; i < listClasses.size(); i++) {
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
								required="required">
						</div>
						<div class="col-md-4">
							<input type="text" class="form-control" placeholder="Home phone"
								name="HomePhone">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-10">Email</label>
						<div class="col-md-8">
							<input type="text" class="form-control" placeholder="Email"
								name="Email" required="required">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-10"></label>
						<div class="col-md-10">
							<div class="col-sm-1 col-xs-2">
								<button type="submit" class="btn btn-success btn-medium">Ok</button>
							</div>
							<div class="col-sm-1 col-xs-2">
								<a href="ShowStudents?students=???"
									class="btn btn-primary btn-medium">Cancel</a>
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