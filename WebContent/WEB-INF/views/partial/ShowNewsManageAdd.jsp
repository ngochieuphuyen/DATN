<%@page import="model.bean.NewsCategory"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<NewsCategory> listNewsCategory = (ArrayList<NewsCategory>) request
			.getAttribute("listNewsCategory");
%>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">News Add</h3>
			</div>
			<!--  ending header Table -->
			<div class="box-body">
				<form action="DoNewsManageAdd" method="post">
					<div class="form-group">
						<label>Title</label> <input type="text" class="form-control"
							placeholder="Title" name="Title" required="required">
					</div>

					<div class="form-group">
						<label>Descriptive</label> <input type="text" class="form-control"
							placeholder="Descriptive" name="DescriptiveNews"
							required="required">
					</div>

					<div class="form-group">
						<label>Content</label> <textarea rows="4" cols="50" class="form-control" placeholder="Content" name="Detail"
							required="required"></textarea>
					</div>

					<div class="form-group">
						<label>Category</label> <select class="form-control"
							name="Category">
							<%
								for (int i = 0; i < listNewsCategory.size(); i++) {
							%>
							<option value="<%=listNewsCategory.get(i).getIdNewsCategory()%>"><%=listNewsCategory.get(i).getNewsCategoryName()%></option>
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
							<a href="ShowNewsManage"
								class="btn btn-primary btn-medium">Cancel</a>
						</div>
					</div>

				</form>

				<hr>

			</div>
		</div>
	</section>
	<!-- /.content -->
</div>