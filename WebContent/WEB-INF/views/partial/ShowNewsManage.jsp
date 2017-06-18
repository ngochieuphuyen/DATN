<%@page import="model.bean.News"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<News> listNews = (ArrayList<News>) request.getAttribute("listNews");
%>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">List News</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<table class="table table-bordered" id="table1">
					<thead>
						<tr>
							<th></th>
							<th>Title</th>
							<th>PostTime</th>
							<th>Views</th>
							<th>
								<div class="pull-right">
									<a href="ShowNewsAdd" class="btn btn-info"><i
										class="fa fa-plus" aria-hidden="true"></i></a>
								</div>
							</th>

						</tr>
					</thead>
					<%
						for (int i = 0; i < listNews.size(); i++) {
					%>
					<tr>
						<td><%=(i + 1)%></td>
						<td style="width: 40%"><a
							href="ShowNewsManageDetail?idNews=<%=listNews.get(i).getIdNews()%>"><%=listNews.get(i).getTitle()%></a></td>
						<td><%=listNews.get(i).getPostTime()%></td>
						<td><%=listNews.get(i).getViews()%></td>
						<td><div class="pull-right">
								<a
									href="ShowNewsManageEdit?idNews=<%=listNews.get(i).getIdNews()%>"
									class="btn btn-primary"><i class="fa fa-pencil"
									aria-hidden="true"></i></a> <a href="#confirmDeleteNews<%=i%>"
									role="button" data-toggle="modal" class="btn btn-danger"><i
									class="fa fa-trash" aria-hidden="true"></i></a>
							</div>

							<div class="modal fade" id="confirmDeleteNews<%=i%>"
								role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Delete News</h4>
										</div>
										<div class="modal-body">
											<p>Do you want to delete this news?</p>
											<br>
											<p></p>
										</div>
										<div class="modal-footer">
											<a
												href="DoNewsDelete?idNews=<%=listNews.get(i).getIdNews()%>"
												class="btn btn-danger">Yes</a> <input type="button"
												class="btn btn-default" data-dismiss="modal" value="No">
										</div>

									</div>
								</div>
							</div></td>
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