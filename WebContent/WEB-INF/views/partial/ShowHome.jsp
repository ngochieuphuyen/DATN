<%@page import="model.bean.News"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<News> listEvent = (ArrayList<News>) request.getAttribute("listEvent");
	ArrayList<News> listNotification = (ArrayList<News>) request.getAttribute("listNotification");
	ArrayList<News> listScholarship = (ArrayList<News>) request.getAttribute("listScholarship");
	ArrayList<News> listRecruitment = (ArrayList<News>) request.getAttribute("listRecruitment");
%>
<section id="slider">
	<!--slider-->
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div id="slider-carousel" class="carousel slide col-sm-12"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#slider-carousel" data-slide-to="0"
							class="active"></li>
						<li data-target="#slider-carousel" data-slide-to="1"></li>
					</ol>

					<div class="carousel-inner">
						<div class="item active">

							<div class="col-sm-12">
								<img src="assets/images/home/DaiPhunNuoc.jpg"
									class="girl img-responsive" alt="" />x
							</div>
						</div>
						<div class="item">
							<div class="col-sm-12">
								<img src="assets/images/home/banchieu.PNG"
									class="girl img-responsive" alt="" />
							</div>
						</div>

					</div>

					<a href="#slider-carousel" class="left control-carousel hidden-xs"
						data-slide="prev"> <i class="fa fa-angle-left"></i>
					</a> <a href="#slider-carousel"
						class="right control-carousel hidden-xs" data-slide="next"> <i
						class="fa fa-angle-right"></i>
					</a>
				</div>

				<div class="col-sm-12">
					<!--Tin tuc su kien -->
					<div class="col-sm-6">
						<div class="container">
							<div class="row">
								<div class="col-sm-12">
									<h2 style="color: blue;">Event</h2>
								</div>
							</div>
							<%
								for (int i = 0; i < listEvent.size(); i++) {
							%>
							<div class="row">
								<div class="col-sm-5">
									<div>
										<div>
											<i class="fa fa-eye"></i>
										</div>
										<h5><%=listEvent.get(i).getTitle()%></h5>
										<p><%=listEvent.get(i).getPostTime()%></p>
										<br>
										<p><%=listEvent.get(i).getDescriptiveNews()%></p>
										<a class="big-link-1"
											href="ShowDetailNews?idNews=<%=listEvent.get(i).getIdNews()%>">Read
											more</a>
									</div>
								</div>
							</div>

							<%
								}
							%>
						</div>
					</div>

					<!--Thong Bao -->
					<div class="col-sm-6">
						<div class="container">
							<div class="row">
								<div class="col-sm-12">
									<h2 style="color: blue;">Notification</h2>
								</div>
							</div>

							<%
								for (int i = 0; i < listNotification.size(); i++) {
							%>
							<div class="row">
								<div class="col-sm-5">
									<div>
										<div>
											<i class="fa fa-eye"></i>
										</div>
										<h5><%=listNotification.get(i).getTitle()%></h5>
										<p><%=listNotification.get(i).getPostTime()%></p>
										<br>
										<p><%=listNotification.get(i).getDescriptiveNews()%></p>
										<a class="big-link-1"
											href="ShowDetailNews?idNews=<%=listNotification.get(i).getIdNews()%>">Read
											more</a>
									</div>
								</div>
							</div>

							<%
								}
							%>


						</div>
					</div>
				</div>
				<div class="col-sm-12">
					<!--Hoc Bong -->
					<div class="col-sm-6">
						<div class="container">
							<div class="row">
								<div class="col-sm-12">
									<h2 style="color: blue;">Scholarship</h2>
								</div>
							</div>
							<%
								for (int i = 0; i < listScholarship.size(); i++) {
							%>
							<div class="row">
								<div class="col-sm-5">
									<div>
										<div>
											<i class="fa fa-eye"></i>
										</div>
										<h5><%=listScholarship.get(i).getTitle()%></h5>
										<p><%=listScholarship.get(i).getPostTime()%></p>
										<br>
										<p><%=listScholarship.get(i).getDescriptiveNews()%></p>
										<a class="big-link-1"
											href="ShowDetailNews?idNews=<%=listScholarship.get(i).getIdNews()%>">Read
											more</a>
									</div>
								</div>
							</div>

							<%
								}
							%>

						</div>
					</div>


					<!--Tuyen Dung -->
					<div class="col-sm-6">
						<div class="container">
							<div class="row">
								<div class="col-sm-12">
									<h2 style="color: blue;">Recruitment</h2>
								</div>
							</div>

							<%
								for (int i = 0; i < listRecruitment.size(); i++) {
							%>
							<div class="row">
								<div class="col-sm-5">
									<div>
										<div>
											<i class="fa fa-eye"></i>
										</div>
										<h5><%=listRecruitment.get(i).getTitle()%></h5>
										<p><%=listRecruitment.get(i).getPostTime()%></p>
										<br>
										<p><%=listRecruitment.get(i).getDescriptiveNews()%></p>
										<a class="big-link-1"
											href="ShowDetailNews?idNews=<%=listRecruitment.get(i).getIdNews()%>">Read
											more</a>
									</div>
								</div>
							</div>

							<%
								}
							%>


						</div>
					</div>
				</div>

			</div>


		</div>

	</div>
	</div>
</section>
<!--/slider-->