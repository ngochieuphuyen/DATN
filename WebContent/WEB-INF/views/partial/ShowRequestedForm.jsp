<%@page import="model.bean.AccountOfForm"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<AccountOfForm> listRequestedForm = (ArrayList<AccountOfForm>) request.getAttribute("listRequestedForm"); %>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">List Requested Form</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<table class="table table-bordered" id="table1">
					<thead>
						<tr>
							<th></th>
							<th>Form name</th>
							<th>Time of registration</th>
							<th>Receiving time</th>
							
							
						</tr>
					</thead>
					<%
						for (int i = 0; i < listRequestedForm.size(); i++) {
					%>
					<tr>
						<td><%=(i + 1)%></td>
						<td><%=listRequestedForm.get(i).getFormName()%></td>
						<td><%=listRequestedForm.get(i).getTimeOfRegistration()%></td>
						<td><%=listRequestedForm.get(i).getReceivingTime()%></td>
						
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