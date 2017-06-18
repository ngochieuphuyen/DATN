<%@page import="model.bean.Function"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Decentralization"%>
<%Decentralization decentralization = (Decentralization) request.getAttribute("decentralization");
ArrayList<Function> listFunctions = (ArrayList<Function>) request.getAttribute("listFunction");
ArrayList<Integer> listIdFunction = (ArrayList<Integer>) request.getAttribute("listIdFunction"); %>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">Decentralization Edit</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<form action="DoDecentralizationEdit" method="post">
					<div class="form-group" hidden="">
						<label></label> <input type="text" class="form-control"
							 name="idDecentralization"
							value="<%=decentralization.getIdDecentralization()%>"
							required="required">
					</div>
					<div class="form-group">
						<label>Decentralization Name</label> <input type="text" class="form-control"
							name="DecentralizationName"
							value="<%=decentralization.getDecentralizationName()%>"
							readonly="readonly">
					</div>
					<%
						for (int i = 0; i < listFunctions.size(); i++) {
							if (Function.checkedFunction(listFunctions.get(i).getIdFunction(), listIdFunction)) {
					%>
					<div >
						 <input type="checkbox"
							 name="function<%=i %>" value="<%=listFunctions.get(i).getIdFunction()%>" checked="checked"><%=listFunctions.get(i).getFunctionName() %>
					</div>
					<%
						continue;
							}
					%>
					<div >
						 <input type="checkbox"
							 name="function<%=i %>" value="<%=listFunctions.get(i).getIdFunction()%>"><%=listFunctions.get(i).getFunctionName() %>
					</div>
					<%
						}
					%>


					<div class="form-group">
						<div class="col-sm-1 col-xs-2">
							<button type="submit" class="btn btn-success btn-medium">Ok</button>
						</div>
						<div class="col-sm-1 col-xs-2">
							<a href="ShowDecentralization" class="btn btn-primary btn-medium">Cancel</a>
						</div>
					</div>

				</form>

				<hr>

			</div>
		</div>
	</section>
	<!-- /.content -->
</div>