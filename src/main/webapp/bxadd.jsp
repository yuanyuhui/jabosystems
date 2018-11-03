<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北大青鸟办公自动化管理系统</title>
<link href="/jabosystems/css/style.css" rel="stylesheet" type="text/css" />

</head>

<body>
	<div class="top">
		<div class="global-width">
			<img src="/jabosystems/images/logo.gif" class="logo" />
		</div>
	</div>
	<div class="status">
		<div class="global-width">
			<span class="usertype">【登录角色：${Employee.ename}(${Employee.position.pname})】</span>
			<span>张三</span>你好！欢迎访问青鸟办公管理系统！
		</div>
	</div>
	<div class="main">
		<div class="global-width">
			<div class="nav" id="nav">
				<div class="t"></div>
				<dl class="open">
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
						报销单管理</dt>
					<dd>
						<a href="claimVoucherQueryAction.action">查看报销单</a>
					</dd>
					<dd>
						<a href="claimVoucherToAddAction.action">添加报销单</a>
					</dd>
				</dl>
				<dl>
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">请假管理</dt>
					<dd>
						<a href="leaveQueryAction.action" target="_self">查看请假</a>
					</dd>
					<dd>
						<a href="leaveToAddAction.action" target="_self">申请请假</a>
					</dd>
				</dl>
				<dl>
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
						我要销售</dt>
					<dd>信心收件箱</dd>
					<dd>信心发件箱</dd>
				</dl>
				<dl>
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
						信息中心</dt>
					<dd>信心收件箱</dd>
					<dd>信心发件箱</dd>
				</dl>
			</div>
			<input type="hidden" name="claimVoucher.opType" id="opType" />
			<div class="action">
				<div class="t">增加报销单</div>
				<div class="pages">
					<form action="" method="post">
						<table width="90%" border="0" cellspacing="0" cellpadding="0"
							class="addform-base">
							<caption>基本信息</caption>
							<tr>
								<td width="25%">编&nbsp;&nbsp;号：<span class="eid">${Employee1.eid}</span></td>
								<td width="30%">填&nbsp;写&nbsp;人：<span class="ename">${Employee1.ename}</span></td>
								<td width="25%">部&nbsp;&nbsp;门：<span class="dname">${Employee1.department.dname}</span></td>
								<td>职&nbsp;&nbsp;位：<span class="pname">${Employee1.position.pname}</span></td>
							</tr>
							<tr>
								<td>总金额：￥<label id="sum"></label></td>
								<td>填报时间：<fmt:formatDate value="${date}" />
								</td>
								<td>状态：<span class="status">${Employee2.position.pname}待审核</span></td>
								<td>待处理人：${Employee2.ename}</td>
							</tr>
						</table>
						<p>&nbsp;</p>
						<table width="90%" border="0" cellspacing="0" cellpadding="0"
							class="addform-item" id="table">
							<thead>
								<tr>
									<td>项目</td>
									<td>金额</td>
									<td>费用说明</td>
									<td>票据</td>
									<td>&nbsp;</td>
								</tr>
							</thead>
							<tbody id="tb">
								<tr>
									<td width="25%"><select class="item">
											<option>城际交通费</option>
											<option>餐饮费</option>
											<option>住宿费</option>
									</select></td>
									<td width="30%"><input style="width: 80px;" type="text"
										name="money" id="money" class="input_01" />&nbsp;<span
										style="color: red;">*</span></td>
									<td width="25%"><input style="width: 80px;" type="text"
										name="description" id="textfield" class="input_01" />&nbsp;<span
										style="color: red;">*</span></td>
									<td width="25%"><input type="file" name="file" /></td>
									<td><a href="#"><img src="/jabosystems/images/add.gif"
											class="add" width="16" height="16" /></a></td>
								</tr>
							</tbody>
						</table>
						<table width="90%" border="0" cellspacing="0" cellpadding="0"
							class="addform-item">
							<!--报销单事由-->
							<tr>
								<td colspan="4" class="event"><label> 事 由： </label> <textarea
										name="claimVoucher.event" id="textarea" cols="45" rows="5">拜访客户</textarea></td>
							</tr>
							<!--表单提交行-->
							<tr>
								<td colspan="4" class="submit"><input type="button"
									name="btnSave" id="btnSave" value="保 存" class="submit_01" /> <input
									type="button" name="btnSaveAndSubmit" id="btnSaveAndSubmit"
									value="保存并提交" class="submit_01" /> <input type="button"
									name="button" id="butAdd" value="添加明细" class="submit_01" /></td>
							</tr>
						</table>
					</form>
					<!--增加报销单 区域 结束-->
				</div>
			</div>
		</div>
	</div>
	<div class="copyright">Copyright &nbsp; &copy; &nbsp; 北大青鸟</div>
</body>
<script type="text/javascript" src="/jabosystems/js/jquery-1.12.4.js"></script>
<script>
	$(function() {
		$("[name=button]")
				.click(
						function() {
							var tr = $('<tr>'
									+ '<td width="25%"><select class="item">'
									+ '<option>城际交通费</option>'
									+ '<option>餐饮费</option>'
									+ '<option>住宿费</option>'
									+ '</select></td>'
									+ '<td width="30%"><input style="width: 80px;" type="text"'+
				'name="money" id="money" class="input_01" />&nbsp;<span'+
				'style="color: red;">*</span></td>'
									+ '<td width="25%"><input style="width: 80px;" type="text"'+
				'name="description" id="textfield" class="input_01" />&nbsp;<span'+
				'style="color: red;">*</span></td>'
									+ '<td width="25%"><input type="file" name="file" /></td>'
									+ '<td><a href="#"><img src="/jabosystems/images/add.gif"'+
					'class="add" width="16" height="16" /></a></td>&nbsp;&nbsp;<td><a class="del" href="#">-</a></td>'
									+ '</tr>');
							$("#tb").append(tr);

							$(".del").click(function() {
								$(this).parent().parent().remove();
							});

						});

		$("#btnSave").click(function() {
			/* var Voucher={};
			Voucher["create_eid"]=;
			Voucher["next_eid"]=;
			Voucher["create_time"]=;
			Voucher["total_account"]=;
			Voucher["event"]=;
			var Checkresult={};
			Checkresult["vc_id"]=;
			Checkresult["create_eid"]=;
			Checkresult["next_eid"]=;
			Checkresult["time"]=;
			Checkresult["status"]=;
			Checkresult["check_comment"]=;
			var Voucher_detail={};
			Voucher_detail["vc_id"]=;
			Voucher_detail["item"]=;
			Voucher_detail["account"]=;
			Voucher_detail["explain"]=;
			Voucher_detail["vd_path"]=;
			Voucher["Checkresult"]=Checkresult;
			Voucher["Voucher_detail"]=Voucher_detail; */
			console.log(1);
			var para = $("form").serialize();
			console.log(para);
		});
	});
</script>
</html>
