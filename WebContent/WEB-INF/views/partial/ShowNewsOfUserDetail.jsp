<%@page import="model.bean.NewsOfUser"%>
<% NewsOfUser news = (NewsOfUser) request.getAttribute("newsOfUser"); %>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h1><%=news.getTitle() %></h1>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<form>
				<h2><%=news.getDescriptive() %></h2>
					<div class="form-group">
						<%=news.getDetail() %>
					</div>

					

					<div class="form-group">
						<%=news.getPostTime() %>  
					</div>

					

					<div class="form-group">
						
						<div class="col-sm-1 col-xs-2">
							<a href="DoNewsAccept?idNewsOfUser=<%=news.getIdNewsOfUser() %>" class="btn btn-success btn-medium">Accept</a>
						</div>
						<div class="col-sm-1 col-xs-2">
							<a href="DoNewsOfUserDelete?idNewsOfUser=<%=news.getIdNewsOfUser() %>" class="btn btn-danger btn-medium">Delete</a>
						</div>
					</div>

				</form>

				<hr>

			</div>
		</div>
	</section>
	<!-- /.content -->
</div>