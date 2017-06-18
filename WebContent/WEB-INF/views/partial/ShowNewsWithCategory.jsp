<%@page import="model.bean.NewsCategory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.News"%>
<%
	ArrayList<News> listNewsWithCategory = (ArrayList<News>) request.getAttribute("listNewsWithCategory");
	ArrayList<News> listNewsHot = (ArrayList<News>) request.getAttribute("listNewsHot");
	NewsCategory newsCategory = (NewsCategory) request.getAttribute("newsCategory");
%>
<div class="content-wrapper" style="margin-left: 30px; margin-right: 20px">
	<!-- Main content -->
	<section class="content">
		<!-- Main row -->
		<div class="col-lg-8 col-sm-7">
					<div class="">
						<div class="row">
							<div class="">
								<h2 style="color: blue;"><%=newsCategory.getNewsCategoryName() %></h2>
							</div>
						</div>
						<%
							for (int i = 0; i < listNewsWithCategory.size(); i++) {
						%>
						<div class="row">
							<div class="">
								<div>
									<div>
										<i class="fa fa-eye"></i>
									</div>
									<h3><%=listNewsWithCategory.get(i).getTitle()%></h3>
									<p><%=listNewsWithCategory.get(i).getPostTime()%></p>
									<br>
									<p><%=listNewsWithCategory.get(i).getDescriptiveNews()%></p>
									<a class="big-link-1"
										href="ShowDetailNews?idNews=<%=listNewsWithCategory.get(i).getIdNews()%>">Read
										more</a>
								</div>
							</div>
						</div>

						<%
							}
						%>
					</div>
				</div>
		<div class="col-lg-3 col-sm-4">
			<!--Tin Hot -->
			<div class=" col-lg-3col-sm-4">
				<div class="">
					<div class="row">
						<div class="">
							<h2 style="color: blue;">News Hot</h2>
						</div>
					</div>
					<%
						for (int i = 0; i < listNewsHot.size(); i++) {
					%>
					<div class="row">
						<div class="">
							<div>

								<h4>
									<a class="big-link-1"
										href="ShowDetailNews?idNews=<%=listNewsHot.get(i).getIdNews()%>"><%=listNewsHot.get(i).getTitle()%></a>
								</h4>
								<p><%=listNewsHot.get(i).getPostTime()%></p>
							</div>
						</div>
					</div>

					<%
						}
					%>

				</div>
			</div>
		</div>

	</section>
	<!-- /.content -->
</div>