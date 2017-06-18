<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Decentralization"%>
<%@page import="model.bean.Account"%>
<%
	Account account = (Account) session.getAttribute("account");
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
				<form>
					<div class="form-group">
						<label>Username</label> <input type="text" class="form-control"
							placeholder="Username" name="Username"
							value="<%=account.getUsername()%>" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Email</label> <input type="text" class="form-control"
							placeholder="Email" name="Email" value="<%=account.getEmail()%>"
							readonly="readonly">
					</div>

					<div class="form-group">
						<label>Decentralization</label> <input type="text"
							class="form-control" placeholder="Email" name="Email"
							value="<%=account.getDecentralizationName()%>"
							readonly="readonly">
					</div>

				</form>

				<hr>
				<br> <br>
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