<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>录入数据</title>

<meta name="description" content="A three dimensional and space efficient menu created with JavaScript and CSS 3.">
<meta name="author" content="Hakim El Hattab">

<meta name="viewport" content="width=800, user-scalable=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/bootstrap/bootstrap-2.3.0.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/matrix-style2.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/datetimepicker/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/uploadify/uploadify.css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sub/data101.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css">
</head>
<body>
<%@ include file="main.jsp" %> 
<input type="hidden" id="base_url" value="${pageContext.request.contextPath}">

<div class="contents">
<div id="dialog-content" ms-controller="content">
	<!-- 详细内容 -->
	<div class="dialog-center" >
		<form id="omno11" class="baseinfo" onSubmit="return false">
			<div class="form-all dialog-form-all">
			<div class="dialog-center-title">
				<span class="form-title-f" style="font-size: 20px">录入数据</span>
			</div>	
		<div class="form-content dialog-form-content">
				<table class="form-table">
					<tr class="form-table-tr">
							<td>
								<label class="form-label">账单类型:</label>
							</td>
							<td>
								<select class="stext sselect edit-website" id="type" name="type" ms-duplex="sendParams.type">
								<option value="02.defray">出账</option>
								<option value="01.income">入账</option>
								</select>
							</td>
						</tr>
							<tr class="form-table-tr">
						<td width="100">
							<label class="form-label">账单金额:</label>
						</td>
						<td width="400">
							<input type="text" class="form-control detail-input" id="driverName" name="driverName" ms-duplex="sendParams.driverName" maxlength="15" />
						    元
						</td>
					</tr>
					<tr class="form-table-tr" ms-if="sendParams.type == '01.income' ">
							<td>
								<label class="form-label">资金来源:</label>
							</td>
							<td>
								<select class="stext sselect edit-website" id="website" name="website" ms-duplex="sendParams.website">
									<!-- <option ms-repeat="websiteList" ms-attr-value="{{el.websiteNo}}">{{el.websiteName}}</option>  -->
								<option>工资</option>
								</select>
							</td>
						</tr>
						<tr class="form-table-tr" ms-if="sendParams.type == '01.income' ">
							<td>
								<label class="form-label">资金流向:</label>
							</td>
							<td>
								<select class="stext sselect edit-website" id="website" name="website" ms-duplex="sendParams.website">
									<!-- <option ms-repeat="websiteList" ms-attr-value="{{el.websiteNo}}">{{el.websiteName}}</option>  -->
								<option>现金男</option>
								</select>
							</td>
						</tr>
					<tr class="form-table-tr" ms-if="sendParams.type == '01.income' ">
						<td width="100">
							<label class="form-label">入账日期:</label>
						</td>
						<td width="400">
							<input type="text" ms-duplex="sendParams.buildTime" id="buildTime" name="buildTime" class="stext" readonly="readonly" placeholder="选择日期" value=""/>
						</td>
					</tr>
						<tr class="form-table-tr">
						<td width="100">
							<label class="form-label">备注:</label>
						</td>
						<td width="400">
							<input type="text" class="form-control detail-input" id="driverName" name="driverName" ms-duplex="sendParams.driverName" maxlength="15" />
						</td>
					</tr>
				
				</table>
			</div>

			<!-- 操作 -->
			 <div class="form-content dialog-form-content">
				<table class="form-table">
					<tr class="form-table-tr">
						<td width="400">
						 <button class="btn btn-status-select" ms-click="doSubmit" ms-if="sendParams.type == '01.income' ">提交</button>
			              <button class="btn btn-reset" ms-click="reSet" ms-if="sendParams.type != '01.income' ">增加明细</button>
						</td>
						<td>
						</td>
					</tr>
				</table>
			</div> 
			</div>
		</form>
	</div>
</div>
</div>

 <script src="${pageContext.request.contextPath}/plugin/jquery/jquery-1.8.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/meny.js"></script>
<script src="${pageContext.request.contextPath}/plugin/dataTables/jquery.dataTables-1.10.0.js"></script>
<script src="${pageContext.request.contextPath}/plugin/layer/layer.js"></script>
<script src="${pageContext.request.contextPath}/js/clds.layer.js"></script>
<script src="${pageContext.request.contextPath}/plugin/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugin/avalon/avalon.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/js/clds.validate.js"></script>
<script src="${pageContext.request.contextPath}/plugin/uploadify/jquery.uploadify.min.js"></script>
<script src="${pageContext.request.contextPath}/js/sub/data101.js"></script> 
<script>
	// Create an instance of Meny
	var meny = Meny.create({
		// The element that will be animated in from off screen
		menuElement: document.querySelector( '.meny' ),

		// The contents that gets pushed aside while Meny is active
		contentsElement: document.querySelector( '.contents' ),

		// [optional] The alignment of the menu (top/right/bottom/left)
		position: Meny.getQuery().p || 'left',

		// [optional] The height of the menu (when using top/bottom position)
		height: 200,

		// [optional] The width of the menu (when using left/right position)
		width: 260,

		// [optional] Distance from mouse (in pixels) when menu should open
		threshold: 40,

		// [optional] Use mouse movement to automatically open/close
		mouse: true,

		// [optional] Use touch swipe events to open/close
		touch: true
	});

	// API Methods:
	// meny.open();
	// meny.close();
	// meny.isOpen();

	// Events:
	// meny.addEventListener( 'open', function(){ console.log( 'open' ); } );
	// meny.addEventListener( 'close', function(){ console.log( 'close' ); } );

	// Embed an iframe if a URL is passed in
	if( Meny.getQuery().u && Meny.getQuery().u.match( /^http/gi ) ) {
		var contents = document.querySelector( '.contents' );
		contents.style.padding = '0px';
		contents.innerHTML = '<div class="cover"></div><iframe src="'+ Meny.getQuery().u +'" style="width: 100%; height: 100%; border: 0; position: absolute;"></iframe>';
	}
</script>
</body>
</html>