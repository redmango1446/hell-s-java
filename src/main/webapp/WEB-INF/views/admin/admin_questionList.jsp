<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<!DOCTYPE html>

<div class="userList">
	<div class="admin-title">
		<h2>관리자 페이지</h2>
	</div>
	<div class="userList-content">
		<div class="userList-side admin-Panel admin-listPanel">
			<div class="admin-side-bar">
				<ul>
					<li onclick="location.href='<c:url value="/admin/userList"/>';">회원목록</li>
					<li onclick="location.href='<c:url value="/admin/trainerList"/>';">트레이너 목록
						<ul>
							<li class="admin-side-bar-tlist1">트레이너 목록</li>
							<li class="admin-side-bar-tlist2">트레이너 신청 목록</li>
						</ul>
					</li>
					<li onclick="location.href='<c:url value="/admin/questionList"/>';">1:1문의 목록</li>
				</ul>
			</div>
		</div>
		<div class="userList-body admin-Panel">
			<div class="admin-side-bar">
				<h4>1:1문의 목록</h4>
				
				<%-- 게시글 출력하는 영역 --%>
				<div class="admin-list-body-list" id="restAdminQAListDiv"></div>
			
			</div>	
		</div>
	</div>
	
	<%-- 페이지 번호를 출력하는 영역 --%>
	<div id="pageNumDiv"></div>
</div>

	<script id="admin_qa_template" type="text/x-handlebars-template">

		<table class="admin-list-body-list-table" >
						<colgroup>
							<col style="width:140px">
							<col style="width:150px">
							<col style="width:100px">
							<col style="width:140px">
							<col style="width:200px">
							<col style="width:100px">
							<col style="width:110px">
						</colgroup>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">카테고리</th>
							<th scope="col">제목</th>
							<th scope="col"></th>
							<th scope="col">아이디</th>
							<th scope="col">날짜</th>
							<th scope="col">답변상태</th>
						</tr>
						
			{{#each .}}
						<tr class="admin-list-body-listTitle">
							<td>번호</td>
							<td>카테고리</td>
							<td>제목</td>
							<td></td>
							<td>아이디</td>
							<td>날짜</td>
							<td>답변</td>
						</tr>
						
						<tr class="admin-list-body-listBody">
							<td colspan="7">
								<h4>소개</h4>
								<hr>
								<ul>
									<li class="alblb">
										<button class="admin-list-body-listBody-btn1" type="button">답변</button>
									</li>
								</ul>
								<form action="">
									<ul class="admin-list-body-listBody-review alblb">
										<li> <textarea class="admin-list-review" rows="" cols=""></textarea> </li>
										<li class="alblb">
											<button type="submit">작성</button> 
											<button type="reset">초기화</button>
											<button class="admin-list-body-listBody-btn2" type="button">취소</button>
										</li>
									</ul>
								</form>
								<form action="">
									<ul class="">
										<li>
											<h4>답변</h4>
											<p class="texttest"></p>
										</li>
										<li class="alblb">
											<button class="admin-list-body-listBody-btn3" type="button">수정</button>
											<button class="admin-list-body-listBody-btn4" type="submit">입력</button>
											<button class="admin-list-body-listBody-btn5" type="button">취소</button>
										</li>
									</ul>
								</form>
							</td>
						</tr>
		{{/each}}	
</table>

						
	</script>

	<script type="text/javascript">
		$(function(){
			$(".admin-list-body-listBody").hide();
			$(".admin-list-body-listBody-review").hide();
			$(".admin-list-body-listBody-btn4").hide();
			$(".admin-list-body-listBody-btn5").hide();
		});
		
		$(".admin-list-body-listTitle").click(function() {
			$(".admin-list-body-listBody").toggle();
		});
		
		$(".admin-list-body-listBody-btn1").click(function() {
			$(".admin-list-body-listBody-review").show();
			$(".admin-list-body-listBody-btn1").hide();
		});
		
		$(".admin-list-body-listBody-btn2").click(function() {
			$(".admin-list-body-listBody-review").hide();
			$(".admin-list-body-listBody-btn1").show();
		});
		
		$(".admin-list-body-listBody-btn3").click(function() {
			$(".texttest").contents().unwrap().wrap( '<textarea class="admin-list-review rr" rows="" cols=""></textarea>' );
			$(".admin-list-body-listBody-btn3").hide();
			$(".admin-list-body-listBody-btn4").show();
			$(".admin-list-body-listBody-btn5").show();
			
		});
		
		$(".admin-list-body-listBody-btn5").click(function() {
			$(".admin-list-review.rr").contents().unwrap().wrap( '<p class="texttest"></p>' );
			$(".admin-list-body-listBody-btn3").show();
			$(".admin-list-body-listBody-btn4").hide();
			$(".admin-list-body-listBody-btn5").hide();
			
		});
		
		var page=1; //현재 요청 페이지 번호를 저장하기 위한 전역 변수
		boardDisplay(page);

		/* 게시글 목록을 검색하여 JSON 텍스트로 응답하는 웹프로그램을 AJAX로 요청하여 처리하는 함수 */
		function boardDisplay(pageNum) {
				page=pageNum;
				$.ajax({
					type: "get",
					url: "admin/questionList?pageNum="+pageNum,
					dataType: "json",
					success: function(json) {		
						if(json.restAdminQAList.length==0){
							$("#restAdminQAListDiv").html("<tr class='admin-list-body-listBody'><td colspan='7'>검색된 1:1 문의가 존재하지 않습니다.</td></tr>");
							return;
						}
						
						//응답된 게시글 목록을 HTML로 변환하도록 Handlebars 자바스크립트 라이브러리 이용
						var source=$("#admin_qa_template").html();//템플릿 코드를 반환받아 저장
						
						//템플릿 코드를 전달받아 템플릿 객체로 생성하여 저장
						var template=Handlebars.compile(source);
						
						//템플릿 객체에 JavaScript 객체(게시글 목록)를 전달하여 HTML 태그로 변환하여 출력
						$("#restAdminQAListDiv").html(template(json.restAdminQAList));
						
						//페이지 번호를 출력하는 함수 호출
						pagerDisplay(json.pager);
						
					},
					error: function(xhr) {
						alert("에러코드 = "+xhr.status);
					}
				});		
			} 

						
			/* 페이지 번호를 출력하는 함수 */
			function pagerDisplay(pager) {
				var html="";
				
				if(pager.startPage>pager.blockSize) {
					html+="<a href='javascript:boardDisplay(1);'>[처음]</a>";
					html+="<a href='javascript:boardDisplay("+pager.prevPage+");'>[이전]</a>";
				} else {
					html+="[처음][이전]";
				}
				
				for(i=pager.startPage;i<=pager.endPage;i++) {
					if(pager.pageNum!=i) {
						html+="<a href='javascript:boardDisplay("+i+");'>["+i+"]</a>";
					} else {
						html+="["+i+"]";
					}
				}
				
				if(pager.endPage!=pager.totalPage) {
					html+="<a href='javascript:boardDisplay("+pager.nextPage+");'>[다음]</a>";
					html+="<a href='javascript:boardDisplay("+pager.totalPage+");'>[마지막]</a>";
				} else {
					html+="[다음][마지막]";
				}
				
				$("#pageNumDiv").html(html);
			}
	</script>