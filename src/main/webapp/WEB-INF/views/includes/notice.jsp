<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ include file="header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/styles/notice.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<div id="frame" class="frame">
		<h3>취소/환불/교환 관련</h3>
		<div class="accordion" id="accordionExample">
			<div class="card">
				<div class="card-header" id="headingOne">
					<h5 class="mb-0">
						<button class="btn btn-link" type="button" data-toggle="collapse"
							data-target="#collapseOne" aria-expanded="true"
							aria-controls="collapseOne">▼ 주문취소/환불 시 포인트와 쿠폰은 복원되나요?</button>
					</h5>
				</div>

				<div id="collapseOne" class="collapse" aria-labelledby="headingOne"
					data-parent="#accordionExample">
					<div class="card-body">
						[포인트]&nbsp; <br> <br> - 취소/환불 완료 즉시 환급됩니다. (MakaronAPP ▶
						MY페이지 ▶ 포인트) <br> <br> - 단, 부분 취소/환불의 경우 실 결제하신 상품가 전액
						환급되며, 포인트는 환급되지 않습니다. <br> <br> [쿠폰] <br> <br>
						- 취소/환불 완료 즉시 복원됩니다.&nbsp; <br> <br> - 유효 기간이 지났을 경우
						자동소멸됩니다.
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingTwo">
					<h5 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapseTwo"
							aria-expanded="false" aria-controls="collapseTwo">▼ 환불을
							포인트로 받을 수 있나요?</button>
					</h5>
				</div>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionExample">
					<div class="card-body">
						안타깝지만, 주문취소 또는 환불의 경우 결제하셨던 수단으로만 환급이 가능합니다. <br> <br>
						따라서 포인트 환불은 어려운 점 양해 부탁 드립니다.&nbsp;
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingThree">
					<h5 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapseThree"
							aria-expanded="false" aria-controls="collapseThree">▼
							환불은 언제 되나요?</button>
					</h5>
				</div>
				<div id="collapseThree" class="collapse"
					aria-labelledby="headingThree" data-parent="#accordionExample">
					<div class="card-body">
						[주문취소] <br> <br> 주문 취소 완료일로부터 아래와 같이 소요됩니다. <br> <br>
						<br> <br> [환불완료] <br> <br> 스토어측에서 반품 상품 입고/검수
						후 Makaron 측으로 [환불승인]이 접수되는 날로부터 아래와 같이 소요됩니다. <br> <br> <br>
						<br> ※결제수단 별 환불 소요기간&nbsp; <br> <br> - 계좌를 통한 환급 :
						환불 승인 또는 주문 취소 처리 완료일로부터 영업일 기준 1~2일 <br> <br> - 카드 취소를
						통한 환급 : 환불 승인 또는 주문 취소 처리 완료일로부터 영업일 기준 1~4일 (카드사별 상이) <br> <br>
						- 핸드폰 결제 취소를 통한 환급 : 핸드폰 결제 즉시 취소&nbsp; (전월 결제 시 계좌 환급 진행되며 환급 기간은
						계좌를 통한 환급과 동일) <br> <br> - 카카오페이/네이버페이/토스 : 환불승인 또는 주문취소
						처리 완료일로부터 영업일 기준 1~3일 소요
					</div>
				</div>
			</div>

			<div class="card">
				<div class="card-header" id="headingFour">
					<h5 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapseFour"
							aria-expanded="false" aria-controls="collapseFour">▼ 
							반품비는 환불금액에서 차감이 가능한가요?</button>
					</h5>
				</div>
				<div id="collapseFour" class="collapse"
					aria-labelledby="headingFour" data-parent="#accordionExample">
					<div class="card-body">
						Makaron의 경우, 여러 스토어가 입점한 플랫폼입니다.&nbsp; <br>
						<br> 따라서 각 스토어마다 반품 방법과 배송비가 상이하며 현재는 배송비 차감 시스템이 제공되지 않습니다.
						<br>
						<br> 번거로우시더라도 구매하신 스토어를 통하여 반품비 문의 후 입금 부탁드립니다.&nbsp; <br>
						<br> ※ 반품비 입금이 늦어질 경우 환불처리가 지연될 수 있는 점 참고 바랍니다.
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingFive">
					<h5 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapseFive"
							aria-expanded="false" aria-controls="collapseFive">▼ 
							교환/반품 시 택배비가 발생되나요?</button>
					</h5>
				</div>
				<div id="collapseFive" class="collapse"
					aria-labelledby="headingFive" data-parent="#accordionExample">
					<div class="card-body">
						무료배송은 구매한 상품이 최종적으로 [구매확정]되어야 제공되는 혜택입니다. <br>
						<br> 반품 사유에 따라 배송비 지불 여부가 결정되며, &nbsp; 반품 시 스토어에서 부담한 [초기
						배송비+반품/교환] 왕복 배송비가 발생됩니다. <br>
						<br>
						<br>
						<br> 1. 교환/반품 비용이 무료인 경우<br>
						<br> - 수령한 상품이 파손/불량이거나 상품이 잘못 배송된 경우에 해당 됩니다. <br>
						<br>
						<br>
						<br> 2. 교환/반품 비용이 고객 부담인 경우<br>
						<br> - 고객 단순 변심으로 인한 경우 비용이 발생됩니다. <br>
						<br>
						<br>
						<br> ※ 스토어마다 교환/반품 방법 및 금액이 상이하며 &nbsp; 배송비 차감 시스템이 제공되지
						않습니다. <br>
						<br> 따라서 환불요청 접수 시 [배송비 0원] 으로 표기되며, 구매하신 스토어 측으로 반품비 관련 별도
						문의 바랍니다.
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingSix">
					<h5 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapseSix"
							aria-expanded="false" aria-controls="collapseSix">▼ 
							환불/교환 신청은 어떻게 하나요?</button>
					</h5>
				</div>
				<div id="collapseSix" class="collapse"
					aria-labelledby="headingSix" data-parent="#accordionExample">
					<div class="card-body">
						교환/반품 모두 Makaron APP 내의 [교환/환불요청] 버튼을 클릭 후 진행 가능합니다.&nbsp; <br>
						<br>
						<br>
						<br> - 교환을 원하실 경우 [교환/환불요청] &nbsp;▶ [사유:교환] 접수로 진행 바라며, 교환 상품
						수령 후 [환불요청 철회] 진행 하시면 됩니다. <br>
						<br>
						<br>
						<br> - 환불/교환 요청 접수 시 자동택배 회수 시스템이 제공되지 않습니다.&nbsp; <br>
						<br> 각 스토어마다 환불 및 교환의 규정에 차이가 있을 수 있어 구매한 스토어 고객센터로 직접 관련 문의
						바랍니다. <br>
						<br>
						<br>
						<br> 스토어 고객센터와 연결이 어려울 경우 <br>
						<br> 주문/배송조회 ▶ 상품사진클릭 ▶ 상세페이지 ▶ Q&amp;A 게시글 작성을 해주시면 영업일 기준
						24시간 이내 판매자 답변을 받아 보실 수 있습니다.<br>
						<br>영업일 기준 24시간 내 미답변 시, Makaron 고객센터 또는 카카오톡채널 [@Makaron]로 문의 바랍니다.
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingSeven">
					<h5 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapseSeven"
							aria-expanded="false" aria-controls="collapseSeven">▼ 
							주문을 취소하고 싶어요!</button>
					</h5>
				</div>
				<div id="collapseSeven" class="collapse"
					aria-labelledby="headingSeven" data-parent="#accordionExample">
					<div class="card-body">
						주문은 [MY 페이지] 메뉴에서 직접 취소 가능합니다. <br>
						<br>
						<br>
						<br> - 결제대기/결제완료/상품준비중 : 고객님께서 직접 주문취소 가능한 상태 <br>
						<br> - 배송준비중 : 스토어 배송 준비 기간으로 결제일로부터 3영업일 (주말 제외)간 즉시 주문취소 불가
						상태 <br>
						<br>
						<br>
						<br> 만일, 3영업일 이내 주문 취소를 원하실 경우 Makaron를 통해 구매한 스토어
						Q&amp;A/카카오톡/전화로 직접 주문취소 요청 또는 [Makaron 고객센터]로 가능 여부를 확인해 주셔야 합니다. <br>
						<br>
						<br>
						<br> 스토어측 연락이 어려울 경우, 주문/배송조회 ▶ 상품사진클릭 ▶ 상세페이지 ▶ Q&amp;A 게시글
						작성 바랍니다.&nbsp; <br>
						<br>
						<br>
						<br> ※ 핸드메이드 카테고리의 경우 주문 제작 등의 이유로 취소버튼이 보이지 않습니다.&nbsp; <br>
						<br> 취소를 희망하시는 스토어 고객센터로 문의 바랍니다.
					</div>
				</div>
			</div>

		</div>
	</div>


	<%@ include file="footer.jsp"%>
</body>
</html>

