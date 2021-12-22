<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page trimDirectiveWhitespaces="true"%>


<title>Categories</title>
<link
	href="${pageContext.request.contextPath}/resources/plugins/malihu-custom-scrollbar/jquery.mCustomScrollbar.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/plugins/jquery-ui-1.12.1.custom/jquery-ui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/styles/categories.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/styles/categories_responsive.css">

<style>
  .pageInfo{
  	list-style : none;
  	display: inline-block;
    margin: 50px 0 0 100px;  	
  }
  .pageInfo li{
  	float: left;
    font-size: 20px;
    margin-left: 18px;
    padding: 7px;
    font-weight: 500;
  }
 a:link {color:black; text-decoration: none;}
 a:visited {color:black; text-decoration: none;}
 a:hover {color:black; text-decoration: underline;}
</style>




<%@ include file="./includes/header.jsp"%>

<div class="super_container">




	<!-- Products -->

	<div class="products">
		<div class="container">
			<div class="row">
				<div class="col-12">

					<br> <br> <br>
					<div class="search_wrap">
						<div class="blockquote text-center">
							<form id="searchFrom"
								action="${pageContext.request.contextPath}/list" method="get">
								<div class="search_input">
									<input type="text" name="keyword"
										value='<c:out value="${pageMaker.cri.keyword}"></c:out>'>
									<button class='btn search_btn'>검 색</button>
								</div>
							</form>
						</div>
					</div>


				</div>
				<div class="col-12">
					<div class="product_sorting clearfix">
						<div class="view">
							<div class="view_box box_view">
								<i class="fa fa-th-large" aria-hidden="true"></i>
							</div>
							<div class="view_box detail_view">
								<i class="fa fa-bars" aria-hidden="true"></i>
							</div>
						</div>
						<div class="sorting">
							<ul class="item_sorting">
								<li><span class="sorting_text">Show all</span> <i
									class="fa fa-caret-down" aria-hidden="true"></i>
									<ul>
										<li class="product_sorting_btn"
											data-isotope-option='{ "sortBy": "original-order" }'><span>Show
												All</span></li>
										<li class="product_sorting_btn"
											data-isotope-option='{ "sortBy": "price" }'><span>가격낮은순</span></li>
										<li class="product_sorting_btn"
											data-isotope-option='{ "sortBy": "stars" }'><span>가격높은순</span></li>
										<li class="product_sorting_btn"
											data-isotope-option='{ "sortBy": "price" }'><span>인기순</span></li>
									</ul></li>
								<li><span class="sorting_text">Show</span> <span
									class="num_sorting_text">12</span> <i class="fa fa-caret-down"
									aria-hidden="true"></i>
									<ul>
										<li class="num_sorting_btn"><span>3</span></li>
										<li class="num_sorting_btn"><span>6</span></li>
										<li class="num_sorting_btn"><span>12</span></li>
									</ul></li>
							</ul>
						</div>
					</div>
				</div>
			</div>


			<div class="row products_container">
				<div class="col">

					<!-- Products -->

					<div class="product_grid">

						<c:forEach items="${list}" var="lists">
							<div class="product">
								<div class="product_image">
									<img src="${lists.file_url}/${lists.file_name}" alt="">
								</div>
								<div class="product_content clearfix">
									<div class="product_info">
										<div class="product_name">
											<a href="product.html">${lists.product_title}</a>
										</div>
										<div class="product_price">${lists.product_price}원</div>
										<div class="product_count">${lists.max_count}개구매중</div>
										<div class="product_delivery">배송비
											${lists.delivery_charge}원</div>
									</div>
									<div class="product_options">
										<div class="product_buy product_option">
											<img src="images/shopping-bag-white.svg" alt="">
										</div>
										<div class="product_fav product_option">+</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>


		<div class='pull-right'>
			<ul class="pagination">
				<c:if test="${pageMaker.prev}">
					<li class="paginate_button previous ${pageMaker.cri.pageNum==1 ? 'disabled' : ''  }  " aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous">
						<a href="${pageMaker.cri.pageNum-1}">이전</a>
					</li>
				</c:if>
				
				<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
					<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active": "" } " aria-controls="dataTables-example" tabindex="0">
						<a href="${num}">${num}</a>
				</c:forEach>

					<li
						class="paginate_button next 
		                           	    ${pageMaker.next==false ? 'disabled' : '' } "
						aria-controls="dataTables-example" tabindex="0"
						id="dataTables-example_next"><a
						${pageMaker.next==false ? 'class="disabled"' : '' }
						href="${pageMaker.cri.pageNum+1 }">다음</a></li>
				</ul>
		</div>
		
		<form id='actionForm" action="list" method='get'>
			<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
			<input type='hidden' name='amount' value= '${pageMaker.cri.amount}'>
		</form>





		</div>


	</div>
</div>





<script type="text/javascript">
	$(document).ready(function() {
	
		var result = '<c:out value="${result}"/>';
		
		checkModal(result);
		
		history.replaceState({}, null, null);
		
		fuction checkModal(result) {
			if(result === '' || history.state) {
				return;
			}
			if(parseInt(result) > 0) {
				$(".modal-body").html(
						"게시글 " + parseImt(result) + "번이 등록되었습니다.");
			}
			
			$("#myModal").modal("show");
		}
		
		$("#regBtn").on("click", function() {
			
			self.location = "register";
		});
		
		var actionForm = $("#actionForm");
		
		$(".paginate_button a").on("click", function(e) {
			
			e.prevenDefault();
			
			console.log('click');
			
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit();
		});
		
		
	});

</script>





<%@ include file="./includes/footer.jsp"%>
<script
	src="${pageContext.request.contextPath}/resources/plugins/Isotope/isotope.pkgd.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/plugins/malihu-custom-scrollbar/jquery.mCustomScrollbar.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/plugins/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/categories_custom.js"></script>
