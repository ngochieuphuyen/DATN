<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.News"%>
<%
	News news = (News) request.getAttribute("news");
	ArrayList<News> listNewsHot = (ArrayList<News>) request.getAttribute("listNewsHot");
%>
<div class="content-wrapper" style="margin-left: 30px">
	<!-- Main content -->
	<section class="content">
		<div id="fb-root"></div>
		<script>
			(function(d, s, id) {
				var js, fjs = d.getElementsByTagName(s)[0];
				if (d.getElementById(id))
					return;
				js = d.createElement(s);
				js.id = id;
				js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.9";
				fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'facebook-jssdk'));
		</script>
		<!-- Main row -->
		<div class="col-lg-8">
			<div class="box box-primary">
				<div class="box-header">
					<h1><%=news.getTitle()%></h1>
				</div>
				<!--  ending header Table -->
				<div class="box-body">
					<form>
						<h2><%=news.getDescriptiveNews()%></h2>
						<div class="form-group">
							<%=news.getDetail()%>
						</div>

						<div class="form-group">
							<%=news.getPostTime()%>
							<br>view:
							<%=news.getViews()%>
						</div>

						<div class="fb-like"
							data-href="http://192.168.137.1:8080/DATN/ShowDetailNews?idNews=<%=news.getIdNews()%>"
							data-layout="standard" data-action="like" data-size="large"
							data-show-faces="true" data-share="false"></div>

						<div class="fb-share-button"
							data-href="http://192.168.137.1:8080/DATN/ShowDetailNews?idNews=<%=news.getIdNews()%>"
							data-layout="button_count" data-size="large"
							data-mobile-iframe="false">
							<a class="fb-xfbml-parse-ignore" target="_blank"
								href="https://www.facebook.com/sharer/sharer.php?u=http%3A%2F%2F192.168.137.1%3A8080%2FDATN%2FShowDetailNews%3FidNews%3D<%=news.getIdNews()%>&amp;src=sdkpreparse">Share</a>
						</div>

						<div class="form-group">

							<div class="col-sm-1 col-xs-2">
								<a href="Home" class="btn btn-primary btn-medium">Back</a>
							</div>
							<div class="fb-comments"
								data-href="http://192.168.137.1:8080/DATN/ShowDetailNews?idNews=<%=news.getIdNews() %>"
								data-width=800" data-numposts="5"></div>
						</div>

					</form>

					<hr>

				</div>
			</div>
		</div>
		<div class="col-lg-3">
			<!--Tin Hot -->
			<div class="col-sm-6">
				<div class="container">
					<div class="row">
						<div class="col-sm-12">
							<h2 style="color: blue;">News Hot</h2>
						</div>
					</div>
					<%
						for (int i = 0; i < listNewsHot.size(); i++) {
					%>
					<div class="row">
						<div class="col-sm-5">
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