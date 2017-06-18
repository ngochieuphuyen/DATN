<%@page import="model.bean.Account"%>
<%@page import="model.bean.News"%>
<%
	News news = (News) request.getAttribute("news");
	String username = (String) request.getAttribute("username");
%>
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
				<h2><%=news.getDescriptiveNews() %></h2>
					<div class="form-group">
						<%=news.getDetail() %>
					</div>

					<div class="form-group">
						by <%=username %>
					</div>

					<div class="form-group">
						<%=news.getPostTime() %>  
						<br>view:  <%=news.getViews() %>
					</div>

					

					<div class="form-group">
						
						<div class="col-sm-1 col-xs-2">
							<a href="ShowNewsManage" class="btn btn-primary btn-medium">Back</a>
						</div>
					</div>

				</form>

				<hr>

			</div>
		</div>
	</section>
	<!-- /.content -->
</div>