<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="container">
	<div class="my-page-box">
		<div class="notice-list-print">
			<div class="pageheader" style="font-size: 20px;">
				<div style="text-align: center;">
					<h1>
						공지사항
						<div class="reviewRight" style="float: right;">
							<!-- 공지사항 검색 -->
							<c:if test="${loginUserinfo.memberStatus==9}">
								<button type="button" class="btn btn-primary"
									onclick="location.href='<c:url value="/notice/write"/>';">작성</button>
							</c:if>
						</div>
					</h1>
				</div>

			</div>
			<div class="panel-body">
				<c:choose>
					<c:when test="${empty(noticeList) }">
						<div class="panel panel-default">
							<div align="center" class="boardEmptyWriting">
								<h3>확인 내역이 없습니다.</h3>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<c:set var="su" value="${number}" />
						<c:forEach var="notice" items="${noticeList }" varStatus="status">
							<c:set var="number2" value="${su-status.index}" />
							<div class="panel-group accordion" id="accordion">
								<!-- 문의글 -->
								<div class="panel panel-default">
									<div class="">
										<table class="table table-hover personalTable">
											<tbody>
												<tr>
													<td class="accordionBoard" style="width: 70px;"><strong>${number2 }</strong></td>
													<td class="accordionBoard" style="width: auto;"><a
														data-toggle="collapse" data-parent="#accordion"
														href="#detail_${number2 }" class="accordionBoard"
														aria-expanded="false">${notice.noticeServiceTitle }</a></td>
													<td class="accordionBoard" style="width: 100px;">${fn:substring({notice.noticeServiceDate},1,12)}</td>
													<td class="accordionBoard"
														style="width: 90px; text-align: justify;">${notice.memberName }</td>
													<td class="accordionBoard" style="width: 65px;">${notice.noticeServiceHits }</td>
												</tr>
											</tbody>
										</table>
									</div>
									<!-- 글 상세내용 -->
									<div id="detail_${number2 }" class="panel-collapse collapse"
										aria-expanded="false" style="height: 0px;">
										<div class="personalContent">${notice.noticeServiceContent}
											<c:if test="${loginUserinfo.memberStatus==9}">
												<div class="reviewRight">
													<button class="btn btn-primary" type="button"
														data-toggle="modal" data-target="#modal_${number2 }">수정</button>
													<button class="btn btn-primary" type="button"
														onclick="remove(${notice.noticeServiceNo})">삭제</button>
												</div>
											</c:if>
										</div>
									</div>
								</div>
							</div>
							<!-- 수정페이지 모달 -->
							<div class="modal fade" id="modal_${number2 }" role="dialog">
								<div class="modal-dialog" id="modal-dialog"
									style="text-align: left;">
									<div class="modal-content">
										<div class="modal-header">
											<div class="logo-location">
												<a href="<c:url value="/"/>" class="modal-header-logo"><i
													class="icon-layers"></i>오늘의 짐</a>
											</div>
										</div>
										<div class="modal-body">
											<div id="login-wrapper">
												<div class="panel panel-primary">
													<div class="panel-heading">
														<h3 class="panel-title">공지사항 수정</h3>
													</div>
													<form action="<c:url value='/notice/modify'/>" method="post"
														class="form-horizontal" role="form">
														<div class="form-group">
															<label for="inputTitle" class="col-sm-2 control-label">제목</label>
															<div class="col-sm-10">
																<input type="hidden" name="noticeServiceNo"
																	class="form-control" value="${notice.noticeServiceNo }">
																<input type="text" name="noticeServiceTitle"
																	class="form-control" value="${notice.noticeServiceTitle }">
															</div>
														</div>
														<div class="form-group">
															<label for="inputTitle" class="col-sm-2 control-label">내용</label>
															<div class="col-sm-10">
																<textarea name="noticeServiceContent"
																	class="form-control">${notice.noticeServiceContent}</textarea>
															</div>
														</div>
														<div class="reviewRight">
															<button type="submit" class="btn btn-primary">수정</button>
															<button type="button" class="btn btn-primary"
																onclick="location.href='<c:url value="/notice/list"/>';">목록</button>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<%-- 페이지 번호 출력 --%>
				<div class="panel panel-default">
					<div class="panel-body" id="pageNumDiv"></div>
				</div>
				<br>				
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	var page = 1; //현재 요청 페이지 번호를 저장하기 위한 전역 변수
	var html = ""; //페이지 번호 출력하기 위한 전역 변수
	
	//페이징 처리 
	//[처음], [이전] 이동 설정
	if (${pager.startPage} > ${pager.blockSize}) {
		html += "<a href='<c:url value="/notice/list/"/>?pageNum=1'>[처음]</a>";
		html += "<a href='<c:url value="/notice/list/"/>?pageNum=${pager.prevPage}'>[<]</a>";
	} else {
		html += "[처음][<]";
	}
	//페이지 번호 설정
	for (var i = ${pager.startPage}; i <= ${pager.endPage}; i++) {
		if (${pager.pageNum} != i) {
			html += "<a href='<c:url value="/notice/list/"/>?pageNum="+i+"'> [" + i + "] </a>";
		} else {
			html += "[" + i + "]";
		}
	}
	//[다음],[마지막] 이동 설정
	if (${pager.endPage} != ${pager.totalPage}) {
		html += "<a href='<c:url value="/notice/list/"/>?pageNum=${pager.nextPage}'>[>]</a>";
		html += "<a href='<c:url value="/notice/list/"/>?pageNum=${pager.totalPage}'>[마지막]</a>";
	} else {
		html += "[>][마지막]";
	}
		
	//페이징 처리 결과 출력
	$("#pageNumDiv").html(html);

	//게시글 [삭제]버튼을 클릭한 경우 호출되는 이벤트 처리 함수
	function remove(num) {
		if(confirm("게시글을 삭제 하시겠습니까?")) {
			location.href="<c:url value='/notice/remove/"+num+"'/>";
		}
	};
	
	// 글 수정시 유효성 검사 구현 해야 하지 않나?
	$(document).ready(function() {
		$("#updateBtn").click(function() {
			var noticeServiceNo=$("#updateNum").val();
			var noticeServiceTitle=$("#updateTitle").val();
			var noticeServiceContent=$("#updateContent").val();
			var noticeServiceCategory=$("#updateCategory").val();
			
			if(noticeServiceTitle=="") {
				alert("제목을 입력해 주세요.");
				noticeServiceTitle.focus();
				return false;
			}
			
			if(noticeServiceContent=="") {
				alert("내용을 입력해 주세요.");
				noticeServiceContent.focus();
				return;
			}
			
		});
	});
	
	</script>
</html>







