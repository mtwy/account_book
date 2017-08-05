window.baseUrl = $("#base_url").val();
$(function(){
    // 表单验证初始化
//	$(".baseinfo").cldsValid({
//		rules:[{
//			className: "edit-customer",
//			validNames:{
//				required: true
//			},
//			messages:{
//				required:"客户不能为空"
//			},
//			position: "right"
//		},{
//			className: "edit-customerUsername",
//			validNames:{
//				required: true
//			},
//			messages:{
//				required:"请选择客户用户"
//			},
//			position: "right"
//		},{
//			className: "edit-vehicleNo",
//			validNames:{
//				required: true
//			},
//			messages:{
//				required:"车牌号不能为空"
//			},
//			position: "right"
//		},{
//			className: "edit-website",
//			validNames:{
//				required: true
//			},
//			messages:{
//				required:"请选择落地网点"
//			},
//			position: "right"
//		},{
//			className: "edit-driverMobile",
//			validNames:{
//				required: true,
//				isPhones:true,
//			},
//			messages:{
//				required:"司机手机不能为空",
//				isPhones:"手机号格式错误"
//			},
//			position: "right"
//		},{
//			className: "edit-landingCharges",
//			validNames:{
//				required: true,
//				isZZZs:true
//			},
//			messages:{
//				required:"卸货费不能为空",
//				isZZZs:"输入正实数"
//			},
//			position: "right"
//		}]
//	});
	
	
    //开单日期初始化
//    $('#omno11').find("#buildTime").datetimepicker({
//		language : 'zh-CN',
//		format : 'yyyy-mm-dd',
//		minView : 2,
//		autoclose : true,
//		todayHighlight : true,
//	});
    
	avalon.ready(function(){
		/*avalon初始化*/
		window.vmcontent = avalon.define({
			$id: "content",
		
			sendParams: {
	      
	        },
//	        landingChargesinfo: function(){
//	        	//根据车型获取卸货费
//	        	if(window.vmcontent.sendParams.chargeType == '01.vehicletype'){
//	        		$.ajax({
//						url: $("#base_url").val() + "/client/bill/ltnlo01f004",
//						type: "post",
//						data: {
//							vehicleType : window.vmcontent.sendParams.vehicleType
//						},
//						dataType: "json",
//						success: function(res) {
//							if (res.isSuccess) {
//								if(res.data != null){
//									window.vmcontent.sendParams.landingCharges = res.data.charges
//								}else{
//									window.vmcontent.sendParams.landingCharges = "0"
//								}
//							}
//						}
//					});
//	        	}else{
//	        		var reg = /^\d+(\.\d+)?$/;
//	        		if(!reg.test($("#chargeValue").val())){
//	        			clds_layer.msg("请输入正实数！","warn");
//	        			window.vmcontent.sendParams.landingCharges = "0";
//						return false;
//	        		}
//	        		//得到每吨多少钱
//	        		$.ajax({
//						url: $("#base_url").val() + "/client/bill/ltnlo01f005",
//						type: "post",
//						data: {
//						},
//						dataType: "json",
//						success: function(res) {
//							if (res.isSuccess) {
//								if(res.data != null){
//									if(res.data.activeFlag == "Y"){
//										if(window.vmcontent.sendParams.chargeValue == ""){
//											window.vmcontent.sendParams.landingCharges = "0";
//										}else{
//											window.vmcontent.sendParams.landingCharges = parseInt(res.data.value) *  parseInt(window.vmcontent.sendParams.chargeValue)
//										}
//									}else{
//										window.vmcontent.sendParams.landingCharges = "0"
//									}
//								}
//							}
//						}
//					});
//	        	}
//	        },
			doSubmit: function() {
				var validFlag = $(".baseinfo").cldsValid("valid");
				if (validFlag) {
					var waybilllist = [];
					var order = {};
					for (var i = 0;i < tableObj.data().length;i++) {
						order = {};
						order = tableObj.data()[i];
						waybilllist.push(order);
					}
					if(waybilllist.length == 0){
						clds_layer.msg("请导入订单信息","error");
					}else{
						window.newDialog = layer.confirm('您确定要提交订单吗？', {
							title:'提交订单',
							skin: 'layui-layer-style1',
						    btn: ['确定','取消'] //按钮
						}, function(){
							cldsLoading();
								window.vmcontent.sendParams.lOrderList =  JSON.stringify(waybilllist);
								window.vmcontent.sendParams.websiteName = $("#website option:selected").text();
								$.ajax({
									url: $("#base_url").val() + "/client/bill/ltnlo01f001",
									type: "post",
									data: vmcontent.sendParams,
									dataType: "json",
									success: function(res) {
										cldsLoaded();
										if (res.isSuccess) {
											window.al = layer.confirm("订单已经提交成功，落地编号："+res.data,{
												title:'信息',
												skin: 'layui-layer-style1',
											    btn: ['继续下单','进入落地车次'], //按钮
											    area:'402px'
											},function(){
												window.vmcontent.reSet();
												window.layer.close(window.al);
											},function(){
												window.vmcontent.reSet();
												/*打开标签页后的操作*/
												window.parent.afterOpenTab = function(){
													var iframeWindow = window.parent.getIframeWindow('AUTH020602');   // 获取指定子页面的contentWindow
													var ifvmcontent = iframeWindow.window.vmcontent;	 // 获取指定子页面的avalon对象
													iframeWindow.window.orderTable.ajax.reload();
													//iframeWindow.location.reload();
												};
												/*跳转指定标签页*/
												window.parent.goTabId('AUTH020602', window.parent.afterOpenTab);
											});
											//clds_layer.msg("下单成功","info");
										}else{
											clds_layer.msg("下单失败","error");
										}
									},
									error: function(){
										clds_layer.msg("下单超时,请重新下单!","erroe");
									}
								});
					}, function(){
					});
					}
				}
			},
			
			
		});
		avalon.scan();
	});
});
