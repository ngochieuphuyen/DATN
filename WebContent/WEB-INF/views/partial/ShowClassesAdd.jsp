<%@page import="model.bean.Courses"%>
<%@page import="model.bean.Faculty"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Faculty> listFaculty = (ArrayList<Faculty>) request.getAttribute("listFaculty");
	ArrayList<Courses> listCourse = (ArrayList<Courses>) request.getAttribute("listCourse");%>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">Class</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<form action="DoClassesAdd" method="post">
	
					

					
					<div class="form-group">
						<label>Class Name</label>
						<input type="text" class="form-control"
							placeholder="Class name" name="ClassName" required="required">
					</div>
					<div class="form-group">
						<label>Total Number Student</label>
						<input type="number" class="form-control"
							placeholder="Total number student" name="TotalNumberStudent" required="required">
					</div>
					
					<div class="form-group">
						<label>Faculty</label>
						 <select class="form-control" name="Faculty">
							         <%for(int i=0;i<listFaculty.size();i++){ 
							         %>
							          <option value="<%=listFaculty.get(i).getIdFaculty()%>"><%=listFaculty.get(i).getFacultyName()%></option>
							          <%
							       } %>
							        </select>
					</div>
					
					<div class="form-group">
						<label>Course</label>
						 <select class="form-control" name="Course">
							         <%for(int i=0;i<listCourse.size();i++){ 
							         %>
							          <option value="<%=listCourse.get(i).getIdCourse()%>"><%=listCourse.get(i).getCourseName()%></option>
							          <%
							       } %>
							        </select>
					</div>
					
					<div class="form-group">
						<div class="col-sm-1 col-xs-2">
						    <button type="submit" class="btn btn-success btn-medium">Ok</button>
						</div>
						<div class="col-sm-1 col-xs-2">
						    <a href="ShowClasses?class=???" class="btn btn-primary btn-medium">Cancel</a>
						</div>
					</div>
					
				</form>
				
				<hr>
             	
			</div>
		</div>
	</section>
	<!-- /.content -->
</div>