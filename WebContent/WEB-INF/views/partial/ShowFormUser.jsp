<%@page import="model.bean.Form"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<Form> listForm = (ArrayList<Form>) request.getAttribute("listForm");
%>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">List Form</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<table class="table table-bordered" id="table1">
					<thead>
						<tr>
							<th></th>
							<th>Form Name</th>
							

						</tr>
					</thead>
					<%
						for (int i = 0; i < listForm.size(); i++) {
					%>
					<tr>
						<td><%=(i + 1)%></td>
						<td><a
							href="ShowFormRegistration?idForm=<%=listForm.get(i).getIdForm()%>"><%=listForm.get(i).getFormName()%></a></td>


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