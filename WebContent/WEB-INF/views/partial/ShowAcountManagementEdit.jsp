<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Decentralization"%>
<%@page import="model.bean.Account"%>
<%
	Account account = (Account) request.getAttribute("account");
	ArrayList<Decentralization> listDecentralization = (ArrayList<Decentralization>) request
			.getAttribute("listDecentralization");
%>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">Account</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<form
					action="DoAccountManagement?idAccount=<%=account.getIdAccount()%>"
					method="post">




					<div class="form-group">
						<label>Username</label> <input type="text" class="form-control"
							placeholder="Username" name="Username"
							value="<%=account.getUsername()%>" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Email</label> <input type="text" class="form-control"
							placeholder="Email" name="Email" value="<%=account.getEmail()%>"
							required="required">
					</div>

					<div class="form-group">
						<label>Decentralization</label> <select class="form-control"
							name="Decentralization">
							<%
								for (int i = 0; i < listDecentralization.size(); i++) {
							%>
							<%
								if (account.getTypeAccount() == listDecentralization.get(i).getIdDecentralization()) {
							%>
							<option
								value="<%=listDecentralization.get(i).getIdDecentralization()%>"
								selected="selected"><%=listDecentralization.get(i).getDecentralizationName()%></option>
							<%
								continue;
									}
							%>
							<option
								value="<%=listDecentralization.get(i).getIdDecentralization()%>"><%=listDecentralization.get(i).getDecentralizationName()%></option>
							<%
								}
							%>
						</select>
					</div>

					<div class="form-group">
						<div class="col-sm-1 col-xs-2">
							<button type="submit" class="btn btn-success btn-medium">Ok</button>
						</div>
						<div class="col-sm-1 col-xs-2">
							<a href="ShowAcountManagement" class="btn btn-primary btn-medium">Cancel</a>
						</div>
					</div>

				</form>

				<hr>
				<br>
				<br>
				<form id="changePassword" action="DoChangePassword" method="post">

					<div class="form-inline">
						<label class="col-md-3" hidden="">IdAccount <input
							type="text" name="idAccount" class="form-control"
							value="<%=account.getIdAccount()%>">
						</label> <label class="col-md-3">Pass: <input type="password"
							name="password" class="form-control" required="required">
						</label> <label class="col-md-4">New pass: <input type="password"
							name="newPassword" id="newPassword" class="form-control"
							required="required">
						</label> <label class="col-md-4">Confirm pass: <input
							type="password" name="confirmPassword" id="confirmPassword"
							class="form-control" required="required" onfocus="Focus(this)"
							onblur="ConfirmPassword(this)">
						</label> <input type="submit" class="btn btn-primary"
							id="changePasswordButton" value="Change">
					</div>

				</form>
			</div>
		</div>
	</section>
	<!-- /.content -->
</div>
<script type="text/javascript">
	function ConfirmPassword(object) {
		var password = document.getElementById("newPassword").value;
		var confirm = document.getElementById("confirmPassword").value;
		var pass = password.toString();
		var conf = confirm.toString();
		var n = pass.localeCompare(conf);
		if (n != 0) {
			object.value = "";
		} else {
			object.value = confirm;
		}
	}
</script>