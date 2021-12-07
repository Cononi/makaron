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
				<div class="card-header" id="heading1	">
					<h5 class="mb-0">
						<button class="btn btn-link" type="button" data-toggle="collapse"
							data-target="#collapse1" aria-expanded="true"
							aria-controls="collapse1">▼ 주문취소/환불 시 포인트와 쿠폰은 복원되나요?</button>
					</h5>
				</div>

				<div id="collapse1" class="collapse" aria-labelledby="heading1"
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
				<div class="card-header" id="heading2">
					<h5 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapse2"
							aria-expanded="false" aria-controls="collapse2">▼ 환불을
							포인트로 받을 수 있나요?</button>
					</h5>
				</div>
				<div id="collapse2" class="collapse" aria-labelledby="heading2"
					data-parent="#accordionExample">
					<div class="card-body">
						안타깝지만, 주문취소 또는 환불의 경우 결제하셨던 수단으로만 환급이 가능합니다. <br> <br>
						따라서 포인트 환불은 어려운 점 양해 부탁 드립니다.&nbsp;
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="heading3">
					<h5 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapse3"
							aria-expanded="false" aria-controls="collapse3">▼
							환불은 언제 되나요?</button>
					</h5>
				</div>
				<div id="collapse3" class="collapse"
					aria-labelledby="heading3" data-parent="#accordionExample">
					<div class="card-body">
						[주문취소] <br> <br> 주문 취소 완료일로부터 아래와 같이 소요됩니다. <br> <br>
						<br> <br> [환불완료] <br> <br> 스토어측에서 반품 상품 입고/검수
						후 Makaron 측으로 [환불승인]이 접수되는 날로부터 아래와 같이 소요됩니다. <br> <br>
						<br> <br> ※결제수단 별 환불 소요기간&nbsp; <br> <br> -
						계좌를 통한 환급 : 환불 승인 또는 주문 취소 처리 완료일로부터 영업일 기준 1~2일 <br> <br>
						- 카드 취소를 통한 환급 : 환불 승인 또는 주문 취소 처리 완료일로부터 영업일 기준 1~4일 (카드사별 상이) <br>
						<br> - 핸드폰 결제 취소를 통한 환급 : 핸드폰 결제 즉시 취소&nbsp; (전월 결제 시 계좌 환급
						진행되며 환급 기간은 계좌를 통한 환급과 동일) <br> <br> - 카카오페이/네이버페이/토스 :
						환불승인 또는 주문취소 처리 완료일로부터 영업일 기준 1~3일 소요
					</div>
				</div>
			</div>

			<div class="card">
				<div class="card-header" id="heading4">
					<h5 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapse4"
							aria-expanded="false" aria-controls="collapse4">▼
							반품비는 환불금액에서 차감이 가능한가요?</button>
					</h5>
				</div>
				<div id="collapse4" class="collapse"
					aria-labelledby="heading4" data-parent="#accordionExample">
					<div class="card-body">
						Makaron의 경우, 여러 스토어가 입점한 플랫폼입니다.&nbsp; <br> <br> 따라서 각
						스토어마다 반품 방법과 배송비가 상이하며 현재는 배송비 차감 시스템이 제공되지 않습니다. <br> <br>
						번거로우시더라도 구매하신 스토어를 통하여 반품비 문의 후 입금 부탁드립니다.&nbsp; <br> <br>
						※ 반품비 입금이 늦어질 경우 환불처리가 지연될 수 있는 점 참고 바랍니다.
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="heading5">
					<h5 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapse5"
							aria-expanded="false" aria-controls="collapse5">▼
							교환/반품 시 택배비가 발생되나요?</button>
					</h5>
				</div>
				<div id="collapse5" class="collapse"
					aria-labelledby="heading5" data-parent="#accordionExample">
					<div class="card-body">
						무료배송은 구매한 상품이 최종적으로 [구매확정]되어야 제공되는 혜택입니다. <br> <br> 반품
						사유에 따라 배송비 지불 여부가 결정되며, &nbsp; 반품 시 스토어에서 부담한 [초기 배송비+반품/교환] 왕복
						배송비가 발생됩니다. <br> <br> <br> <br> 1. 교환/반품 비용이
						무료인 경우<br> <br> - 수령한 상품이 파손/불량이거나 상품이 잘못 배송된 경우에 해당
						됩니다. <br> <br> <br> <br> 2. 교환/반품 비용이 고객 부담인
						경우<br> <br> - 고객 단순 변심으로 인한 경우 비용이 발생됩니다. <br> <br>
						<br> <br> ※ 스토어마다 교환/반품 방법 및 금액이 상이하며 &nbsp; 배송비 차감 시스템이
						제공되지 않습니다. <br> <br> 따라서 환불요청 접수 시 [배송비 0원] 으로 표기되며,
						구매하신 스토어 측으로 반품비 관련 별도 문의 바랍니다.
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="heading6">
					<h5 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapse6"
							aria-expanded="false" aria-controls="collapse6">▼
							환불/교환 신청은 어떻게 하나요?</button>
					</h5>
				</div>
				<div id="collapse6" class="collapse" aria-labelledby="heading6"
					data-parent="#accordionExample">
					<div class="card-body">
						교환/반품 모두 Makaron APP 내의 [교환/환불요청] 버튼을 클릭 후 진행 가능합니다.&nbsp; <br>
						<br> <br> <br> - 교환을 원하실 경우 [교환/환불요청] &nbsp;▶
						[사유:교환] 접수로 진행 바라며, 교환 상품 수령 후 [환불요청 철회] 진행 하시면 됩니다. <br> <br>
						<br> <br> - 환불/교환 요청 접수 시 자동택배 회수 시스템이 제공되지 않습니다.&nbsp;
						<br> <br> 각 스토어마다 환불 및 교환의 규정에 차이가 있을 수 있어 구매한 스토어 고객센터로
						직접 관련 문의 바랍니다. <br> <br> <br> <br> 스토어 고객센터와
						연결이 어려울 경우 <br> <br> 주문/배송조회 ▶ 상품사진클릭 ▶ 상세페이지 ▶ Q&amp;A
						게시글 작성을 해주시면 영업일 기준 24시간 이내 판매자 답변을 받아 보실 수 있습니다.<br> <br>영업일
						기준 24시간 내 미답변 시, Makaron 고객센터 또는 카카오톡채널 [@Makaron]로 문의 바랍니다.
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="heading7">
					<h5 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapse7"
							aria-expanded="false" aria-controls="collapse7">▼
							주문을 취소하고 싶어요!</button>
					</h5>
				</div>
				<div id="collapse7" class="collapse"
					aria-labelledby="heading7" data-parent="#accordionExample">
					<div class="card-body">
						주문은 [MY 페이지] 메뉴에서 직접 취소 가능합니다. <br> <br> <br> <br>
						- 결제대기/결제완료/상품준비중 : 고객님께서 직접 주문취소 가능한 상태 <br> <br> -
						배송준비중 : 스토어 배송 준비 기간으로 결제일로부터 3영업일 (주말 제외)간 즉시 주문취소 불가 상태 <br>
						<br> <br> <br> 만일, 3영업일 이내 주문 취소를 원하실 경우 Makaron를
						통해 구매한 스토어 Q&amp;A/카카오톡/전화로 직접 주문취소 요청 또는 [Makaron 고객센터]로 가능 여부를
						확인해 주셔야 합니다. <br> <br> <br> <br> 스토어측 연락이 어려울
						경우, 주문/배송조회 ▶ 상품사진클릭 ▶ 상세페이지 ▶ Q&amp;A 게시글 작성 바랍니다.&nbsp; <br>
						<br> <br> <br> ※ 핸드메이드 카테고리의 경우 주문 제작 등의 이유로 취소버튼이
						보이지 않습니다.&nbsp; <br> <br> 취소를 희망하시는 스토어 고객센터로 문의 바랍니다.
					</div>
				</div>
			</div>

		</div>
	</div>



	<div id="frame" class="frame">
		<br><h3>주문/결제/배송 관련</h3>
		<div class="accordion" id="accordionExample">
			<div class="card">
				<div class="card-header" id="heading8">
					<h5 class="mb-0">
						<button class="btn btn-link" type="button" data-toggle="collapse"
							data-target="#collapse8" aria-expanded="true"
							aria-controls="collapse8">▼제주도 및 도서산간 지역도 무료배송인가요?</button>
					</h5>
				</div>

				<div id="collapse8" class="collapse"
					aria-labelledby="heading8" data-parent="#accordionExample">
					<div class="card-body">
						[브랜디 배송 &amp; 하루배송] 상품의 경우 제주도 및 도서 산간 지역 무료배송 됩니다.&nbsp;<br>
						<br> <br> <br>단, [일반배송(판매자)]상품은 추가 운임 비용이 발생할 수
						있으며,<br> <br>자세한 비용은 상품 상세 페이지 ▶ 주문정보 또는 스토어 개별안내를 통해 확인
						바랍니다.<br> <br>확인이 어려울 경우 구매하신 스토어 고객센터 및 상품 상세 페이지 ▶
						Q&amp;A &nbsp;문의 바랍니다.
					</div>
				</div>
				<div class="card">
					<div class="card-header" id="heading9">
						<h5 class="mb-0">
							<button class="btn btn-link collapsed" type="button"
								data-toggle="collapse" data-target="#collapse9"
								aria-expanded="false" aria-controls="collapse9">▼ 취소
								완료 됐는데 배송이 왔어요</button>
						</h5>
					</div>
					<div id="collapse9" class="collapse" aria-labelledby="heading9"
						data-parent="#accordionExample">
						<div class="card-body">
							스토어에서 미처 취소한 내역을 확인하지 못하고 출고되는 경우가 있습니다.<br> <br>이미 취소한
							상품이므로 상품을 수령하셨다면&nbsp;스토어 고객센터 또는 상품 상세 페이지 ▶ Q&amp;A로 문의 바랍니다.
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header" id="heading10">
						<h5 class="mb-0">
							<button class="btn btn-link collapsed" type="button"
								data-toggle="collapse" data-target="#collapse10"
								aria-expanded="false" aria-controls="collapse10">▼
								상품 못받았는데, 배송완료 처리되었어요!</button>
						</h5>
					</div>
					<div id="collapse10" class="collapse"
						aria-labelledby="heading10" data-parent="#accordionExample">
						<div class="card-body">
							먼저, 불편을 드려 죄송합니다.<br> <br>구입한 상품의 실제 배송과 택배 시스템의 차이가 있을
							수 있는 점 양해바랍니다.<br> <br> <br> <br>- 배송 조회 시
							이동중일 경우 1-3일내로 수령 가능합니다.<br> <br>- 배송 완료 장소를 확인하였으나
							수령하지 못 했을 경우 배송조회를 통해 담당 배송기사님께 문의 바랍니다.<br> <br>-
							장기적으로 상품배송을 받지 못하였을 경우 브랜디 고객센터 또는 카카오채널 [@브랜디]로 문의 바랍니다.
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header" id="heading11">
						<h5 class="mb-0">
							<button class="btn btn-link collapsed" type="button"
								data-toggle="collapse" data-target="#collapse11"
								aria-expanded="false" aria-controls="collapse11">▼
								주문한 상품과 다른 상품 또는 불량입니다!</button>
						</h5>
					</div>
					<div id="collapse11" class="collapse"
						aria-labelledby="heading11" data-parent="#accordionExample">
						<div class="card-body">
							먼저, 불편을 드려 죄송합니다.<br> <br>교환·환불 중 원하시는 처리방향에 대하여
							[교환/환불요청] 접수 통하여 신청 부탁드립니다<br> <br>이후 구매하신 브랜디 내, 스토어
							고객센터 또는 상품 상세 페이지 ▶ Q&amp;A로 문의 바랍니다.
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header" id="heading12">
						<h5 class="mb-0">
							<button class="btn btn-link collapsed" type="button"
								data-toggle="collapse" data-target="#collapse12"
								aria-expanded="false" aria-controls="collapse12">▼
								주문 취소한 가상계좌에 입금을 했어요!</button>
						</h5>
					</div>
					<div id="collapse12" class="collapse"
						aria-labelledby="heading12" data-parent="#accordionExample">
						<div class="card-body">
							주문 취소된 주문건으로 입금 하였을 경우 시스템 상 자동 환불이 되지 않습니다.<br> <br>번거로우시겠지만
							환급 받을 은행명/예금주명/계좌번호와 함께 브랜디 고객센터 또는 카카오채널 [@브랜디]로 문의 바랍니다.
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header" id="heading13">
						<h5 class="mb-0">
							<button class="btn btn-link collapsed" type="button"
								data-toggle="collapse" data-target="#collapse13"
								aria-expanded="false" aria-controls="collapse13">▼
								무통장입금 했는데 결제완료로 변경이 안돼요!</button>
						</h5>
					</div>
					<div id="collapse13" class="collapse"
						aria-labelledby="heading13" data-parent="#accordionExample">
						<div class="card-body">
							입금완료 후 결제완료로 변경까지는 최대 10분 - 30분정도 소요됩니다.<br> <br>시간이
							경과되었음에도 불구하고 결제대기로 확인될 경우 브랜디 고객센터 또는 카카오채널 [@브랜디]로 문의 바랍니다
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header" id="heading14">
						<h5 class="mb-0">
							<button class="btn btn-link collapsed" type="button"
								data-toggle="collapse" data-target="#collapse14"
								aria-expanded="false" aria-controls="collapse14">▼
								주문 후 결제 수단을 변경할 수 있나요?</button>
						</h5>
					</div>
					<div id="collapse14" class="collapse"
						aria-labelledby="heading14" data-parent="#accordionExample">
						<div class="card-body">
							주문 완료 후 결제 수단 변경은 불가합니다.<br> <br> <br> <br>결제
							수단 변경을 원하실 경우 상품 주문 취소 후 재주문 진행 바랍니다.<br> <br> <br>
							<br>- 결제완료/상품준비 : 직접 주문 취소 ( MY 페이지 ▶ 주문/배송조회 )<br> <br>-
							배송준비 : 구매하신 스토어로 취소 요청 문의<br> <br>- 배송중/배송완료 : 취소 불가하여
							반품 후 재주문 진행 ( 단, 반품배송비 발생 )<br> <br>- 구매확정 : 불가
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header" id="heading15">
						<h5 class="mb-0">
							<button class="btn btn-link collapsed" type="button"
								data-toggle="collapse" data-target="#collapse15"
								aria-expanded="false" aria-controls="collapse15">▼
								주문취소를 철회했는데 상품이 아직 안와요!</button>
						</h5>
					</div>
					<div id="collapse15" class="collapse"
						aria-labelledby="heading15" data-parent="#accordionExample">
						<div class="card-body">
							주문 취소를 철회 했을 경우 원활한 상품 준비를 위하여 구매하신 스토어측으로 주문 취소 철회 의사를 밝혀야 합니다.<br>
							<br>취소 철회에 대한 문의가 없을 경우 배송 누락, 지연 등 발생 될 수 있습니다.<br> <br>
							<br> <br>구매하신 스토어 고객센터 및 상품 상세 페이지 ▶ Q&amp;A &nbsp;문의
							바랍니다.
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header" id="heading16">
						<h5 class="mb-0">
							<button class="btn btn-link collapsed" type="button"
								data-toggle="collapse" data-target="#collapse16"
								aria-expanded="false" aria-controls="collapse16">▼
								상품에 대해 문의하고 싶어요!</button>
						</h5>
					</div>
					<div id="collapse16" class="collapse"
						aria-labelledby="heading16" data-parent="#accordionExample">
						<div class="card-body">
							상품에 대해 궁금하신 점이 있다면 해당 상품 페이지 내 Q&amp;A 를 이용바랍니다.<br> <br>문의글을
							작성하면 해당 스토어에서 확인 후 답변을 드립니다.<br> <br> <br> <br>문의방법
							:<br> <br>브랜디 APP/WEB ▶ MY페이지 ▶ 주문/배송조회 클릭 ▶ 상품의 이미지 클릭
							▶ &nbsp;상세페이지 접속▶ Q&amp;A 문의글 작성<br> <br>단, 비회원의 경우
							Q&amp;A 작성이 불가하니 참고바랍니다.
						</div>
					</div>
				</div>

			</div>

		</div>
	</div>






	<%@ include file="footer.jsp"%>
</body>
</html>

