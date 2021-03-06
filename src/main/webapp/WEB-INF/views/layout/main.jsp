<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<form action="<spring:url value="/content/search"/>" method="post">
	<div class="main-search-area" style="margin-top: 100px; margin-bottom: 50px;">
		<select name="searchKeyword" class="btn btn-primary dropdown-toggle">
			<option value="member_name" selected="selected">트레이너명</option>
			<option value="trainer_centername">센터명</option>
			<option value="trainer_address">센터 주소(동)</option>
		</select>
		<!-- <input class="main-search" class="form-control" placeholder="트레이너명/지역/헬스장 이름" name ="searchValue"> -->
		<input class="main-search" placeholder="트레이너명/지역/헬스장 이름" name ="searchValue">
		<button type="submit" class="fa fa-search main-contorller"></button>
	</div>
</form>
<section id="pricing">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
                 <header>
                     <h1 class="main-h1">이달의 트레이너</h1>
                     <div class="spacer"></div>
                     <br>
                 </header>
             </div>
		</div>		
		<c:forEach var="trainerInfo" items="${trainerInfo}" varStatus="status">
			<div class="panel panel-primary" id="trainer-content" style="float: left; <c:if test='${status.index == 1 }'>margin: 0px 5%;</c:if>" onclick="location='<c:url value="/posting/detail/${trainerInfo.trainerNo }"/>'">
				<div class="panel-heading">
					<h2 class="panel-title" style="text-align: center;">     
						${trainerInfo.memberName }&nbsp; 트레이너<%--트레이너 이름 --%>
					</h2>
				</div>
				<div class="panel-body" style="text-align: center;">
					<form class="form-horizontal" role="form">
						<div class="profile-pic text-center mainProfileImg">
							<img src="<spring:url value="/profileImages/${trainerInfo.trainerProfileImg }"/>" alt="" class="img-circle">
						</div>
						<!-- <span class="text-muted">소속센터명</span> -->
						<div class="form-group">
							<p>${fn:substring(trainerInfo.postingSelfIntroduction,0,160) }</p>
						</div>
					 </form>
				</div>
			</div>
		</c:forEach>
	</div>

</section>
<section id="pricing">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
                 <header>
                     <h1 class="main-h1">많이 도움된 리뷰</h1>
                     <div class="spacer"></div>
                     <br>
                 </header>
             </div>
		</div>
		<c:forEach var="reviewInfo" items="${reviewInfo}" varStatus="status">
			<div class="panel panel-primary" id="trainer-review-content" style="float: left; <c:if test='${status.index == 1 }'>margin: 0px 5%;</c:if>" >
				<div class="panel-heading">
					<h2 class="panel-title" style="text-align: center;">     
						<strong>${reviewInfo.reviewHewonName }</strong> 회원님의 후기
					</h2>
				</div>
				<div class="panel-body mainReviewBody" onclick="location='<c:url value="/posting/detail/${reviewInfo.trainerNo }"/>'">
					<form class="form-horizontal" role="form">
						<div class="mainReviewTitle">
							<p>${reviewInfo.ptServiceTitle }</p>
						</div>
						<hr>
						
						<div class="form-group mainReviewContent" >
							<p>${reviewInfo.ptServiceContent }</p>
						</div>
						<p class="review-trainer-name" >${reviewInfo.memberName }&nbsp;트레이너</p>
						<div class="main-review-panel-score">
							<div style="float: left;">
								<i type="button" class="fa fa-heart"></i>
								<label>${reviewInfo.ptServiceGood }</label>
							</div>
							<div style="text-align: right;">
							<div >
								<fmt:parseNumber var="star" value="${reviewInfo.ptServiceStars }" integerOnly="true" />
								<c:set var="starhalf" value="${(reviewInfo.ptServiceStars /0.5)%2 }" />

								<c:forEach begin="1" step="1" end="${star}">
									<i class="fa fa-star"></i>
								</c:forEach>
								<c:if test="${starhalf == 1}">
									<i class="fa fa-star-half-o"></i>

									<c:forEach begin="1" step="1" end="${(5-starhalf)-star}">
										<i class="fa fa-star-o"></i>
									</c:forEach>
								</c:if>
								<c:if test="${starhalf != 1}">
									<c:forEach begin="1" step="1" end="${5-star}">
										<i class="fa fa-star-o"></i>
									</c:forEach>
								</c:if>
							</div>
							</div>
			
							
						</div>
					 </form>
				</div>
			</div>
		</c:forEach>
		
	</div>
</section>

<script type="text/javascript">

	let curPos = 0; // 현재 보이는 요소의 인덱스 번호
	
	function prev(){
	    if(curPos > 0){
	        $("button").removeAttr("disabled") // 모든 버튼 사용할 수 있게!
	        // toggleClass : 클래스가 있으면 제거, 없으면 생성!
	        $($(".imgItem")[curPos]).toggleClass("activeMainImg")
	        $($(".step")[curPos]).toggleClass("active-step")
	        $(".imgItem").hide();
	        curPos -= 1 *1;
	        $($(".imgItem")[curPos]).toggleClass("activeMainImg")
	        $($(".step")[curPos]).toggleClass("active-step")
	        $(".activeMainImg").fadeIn(800); // 새로운 액티브 요소만 스르륵 나타난다
	    };
	    if(curPos == 0){
	        $(".prev")[0].setAttribute("disabled",'true')
	    };
	};
	function next(){
	    if(curPos < 3){
	        $("button").removeAttr("disabled")
	        $($(".imgItem")[curPos]).toggleClass("activeMainImg")
	        $($(".step")[curPos]).toggleClass("active-step")
	        $(".imgItem").hide();
	     	curPos += 1;
	        $($(".imgItem")[curPos]).toggleClass("activeMainImg")
	        $($(".step")[curPos]).toggleClass("active-step")
	        $(".activeMainImg").fadeIn(800); 
	    };
	    if(curPos == 3){
	        $(".next")[0].setAttribute("disabled",'true')
	    };
	};
	function init(){
	    $(".imgItem").hide()
	    $(".activeMainImg").show()
	    $(".prev").click(prev)
	    $(".next").click(next)
	    $(".step").click(cicleclick(this))
	};
	$(document).ready(function(){
	
	    init();
	});
	
	function cicleclick(ths){
		let curPos2 = 0;
		curPos2 = $(ths).val();
		$("button").removeAttr("disabled")
        $($(".imgItem")[curPos]).toggleClass("activeMainImg")
        $($(".step")[curPos]).toggleClass("active-step")
        $(".imgItem").hide();
		curPos = curPos2;
		curPos = curPos * 1;//스트링 변환을 막기위한 곱셈
        $($(".imgItem")[curPos2]).toggleClass("activeMainImg")
        $($(".step")[curPos2]).toggleClass("active-step")
        $(".activeMainImg").fadeIn(800); 
	}
</script>