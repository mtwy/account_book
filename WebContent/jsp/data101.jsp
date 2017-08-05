<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Meny</title>

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
			
			<!-- 选择录入数据的类型 -->
			<div style="display: none;">
			<div class="dialog-center-title">
				<span class="form-title-f" style="font-size: 20px">选择录入数据的类型</span>
			</div>	
			<div class="form-content dialog-form-content" style="height: 300px;margin-top: 20px">
			<label class="form-label"><input type="checkbox"> &nbsp;生活缴费</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<div style="width: 100%;height: 20px"></div>
			</div>
			<div class="form-content dialog-form-content">
				<button class="btn btn-status-select" ms-click="doSubmit" style="float: right;margin-right: 300px">确认</button>
			</div>
			</div>
			<div>
		<div class="form-content dialog-form-content">
				<table class="form-table">
					<tr class="form-table-tr">
						<td width="100">
							<span class="form-red">*</span>
							<label class="form-label">到车日期:</label>
						</td>
						<td width="400">
							<input type="text" ms-duplex="sendParams.buildTime" id="buildTime" name="buildTime" class="stext" readonly="readonly" placeholder="选择日期" value=""/>
						</td>
						<td width="120">
							<span class="form-red"></span>
							<label class="form-label">发货城市:</label>
						</td>
						<td>
							 <select id="province" name="province" ms-duplex="sendParams.province" style="width: 77px" data-duplex-changed="provinceOnChange">
     					    <option value="请选择">请选择</option>
							<option ms-repeat="provinceList" ms-attr-value="{{el.areaCode}}">{{el.areaName}}</option>
						  </select>
						   <select id="city" name="city" ms-duplex="sendParams.city" style="width: 77px" data-duplex-changed="cityOnChange">
						    <option value="请选择">请选择</option>
							<option ms-repeat="cityList" ms-attr-value="{{el.areaCode}}">{{el.areaName}}</option>
						  </select>
						   <select id="area" name="area" ms-duplex="sendParams.area" style="width: 77px">
						    <option value="请选择">请选择</option>
	    				   <option ms-repeat="areaList" ms-attr-value="{{el.areaCode}}">{{el.areaName}}</option>
						  </select>
						</td>
					</tr>
					<tr class="form-table-tr">
						<td>
							<span class="form-red">*</span>
							<label class="form-label">车牌号:</label>
						</td>
						<td>
							<input type="text" class="form-control detail-input edit-vehicleNo" name="vehicleNo" ms-duplex="sendParams.vehicleNo" maxlength="50"/>
						</td>
						<td>
							<span class="form-red">*</span>
							<label class="form-label">落地网点:</label>
						</td>
						<td>
							<select class="stext sselect edit-website" id="website" name="website" ms-duplex="sendParams.website">
								<option ms-repeat="websiteList" ms-attr-value="{{el.websiteNo}}">{{el.websiteName}}</option> 
							</select>
						</td>
					</tr>
					<tr class="form-table-tr">
						<td width="100">
							<span class="form-red"></span>
							<label class="form-label">司机姓名:</label>
						</td>
						<td width="400">
							<input type="text" class="form-control detail-input" id="driverName" name="driverName" ms-duplex="sendParams.driverName" maxlength="15" />
						</td>
						<td width="120">
							<span class="form-red">*</span>
							<label class="form-label">司机手机:</label>
						</td>
						<td>
							<input type="text" class="form-control detail-input edit-driverMobile" id="driverMobile" name="driverMobile" ms-duplex="sendParams.driverMobile" maxlength="11" />
						</td>
					</tr>
				</table>
			</div>
			<!-- 款项信息内容 -->
			 <div class="form-content dialog-form-content">
				<table class="form-table">
					<tr class="form-table-tr">
						<td width="100">
							<label class="form-label">支付方式:</label>
						</td>
						<td width="920">
							<select class="stext sselect" id="vehicleType" name="vehicleType" ms-duplex="sendParams.vehicleType" ms-change="landingChargesinfo">
							    <option value="请选择">现金</option> 
							    <option value="请选择">支付宝男</option> 
							    <option value="请选择">支付宝女</option> 
							    <option value="请选择">微信男</option>
							    <option value="请选择">微信女</option>  
							</select>
						</td>
					</tr>
					<tr class="form-table-tr">
						<td width="100">
							<label class="form-label">卸货费:</label>
						</td>
						<td width="920">
							<input type="text" class="form-control edit-landingCharges" id="landingCharges" name="landingCharges" ms-duplex="sendParams.landingCharges" maxlength="15" value="0" />元
						</td>
					</tr>
				</table>
			</div> 
			<!-- 操作 -->
			 <div class="form-content dialog-form-content">
				<table class="form-table">
					<tr class="form-table-tr">
						<td width="400">
						 <button class="btn btn-status-select" ms-click="doSubmit">提交</button>
			              <button class="btn btn-reset" ms-click="reSet">重置</button>
						</td>
						<td>
						</td>
					</tr>
				</table>
			</div> 
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