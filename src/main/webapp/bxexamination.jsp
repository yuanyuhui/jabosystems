<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北大青鸟办公自动化管理系统</title>
<link href="/jabosystems/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/jabosystems/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnPass").click(function() {
			$("#opType").val("待审批");
			$("#form1").submit();
		}); //通过

		$("#btnRefuse").click(function() {
			$("#opType").val("已终止");
			$("#form1").submit();
		}); //拒绝

		$("#btnBack").click(function() {
			$("#opType").val("已打回");
			$("#form1").submit();
		}); //打回
	});
</script>
</head>

<body>
	<div class="top">
		<div class="global-width">
			<img src="/jabosystems/images/logo.gif" class="logo" />
		</div>
	</div>
	<div class="status">
		<div class="global-width">
			<span class="usertype">【登录角色：${Employee.ename}(${Employee.position.pname})】
			</span> 你好！欢迎访问青鸟办公管理系统！
		</div>
	</div>
	<div class="main">
		<div class="global-width">
			<div class="nav" id="nav">
				<div class="t"></div>
				<dl class="open">
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">报销单管理</dt>
					<dd>
						<a href="claimVoucherQueryAction.action" target="_self">查看报销单</a>
					</dd>
					<dd>
						<a href="claimVoucherToAddAction.action" target="_self">添加报销单</a>
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
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">我要销售</dt>
					<dd>信心收件箱</dd>
					<dd>信心发件箱</dd>
				</dl>
				<dl>
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">信息中心</dt>
					<dd>信心收件箱</dd>
					<dd>信心发件箱</dd>
				</dl>
			</div>
			<div class="action">
				<div class="t">审核报销单</div>
				<div class="pages">
					<table width="90%" border="0" cellspacing="0" cellpadding="0"
						class="addform-base">
						<caption>基本信息</caption>
						<c:forEach items="${bxVo.employee}" var="e">
							<tr>
								<td class="create_eid" create_eid="${e.eid}" width="25%">编&nbsp;&nbsp;号：${e.eid}</td>
								<td width="30%">填&nbsp;写&nbsp;人：${e.ename}</td>
								<td width="25%">部&nbsp;&nbsp;门：${e.department.dname}</td>
								<td>职&nbsp;&nbsp;位：${e.position.pname}</td>
							</tr>
						</c:forEach>
						<c:forEach items="${bxVo.voucher}" var="v">
							<tr class="vc_id" vc_id="${v.vc_id}">
								<td>总金额：${v.total_account}</td>
								<td>填报时间：<fmt:formatDate value="${v.create_time}" />
								</td>
								<c:forEach items="${v.checkresult}" var="c">
									<td class="statuss" status="${c.status}" cr_id=${c.cr_id }>状态：${c.status}</td>
									<c:forEach items="${list}" var="l">
										<c:if test="${l.eid==c.next_eid}">
											<td class="next_eid" next_eid="${l.eid}">待处理人：${l.ename}(${l.position.pname})</td>
										</c:if>
									</c:forEach>
								</c:forEach>
							</tr>
						</c:forEach>
					</table>
					<hr />
					<strong>报销清单</strong>
					<table width="90%" border="0" cellspacing="0" cellpadding="0"
						class="addform-item">
						<thead>
							<tr>
								<td width="30%">项目</td>
								<td width="25%">金额</td>
								<td width="25%">费用说明</td>
								<td width="25%">票据</td>
								<td>&nbsp;</td>
							</tr>
						</thead>
						<c:forEach items="${bxVo.voucher}" var="vv">
							<c:forEach items="${vv.voucher_detail}" var="vd">
								<tr>
									<td>${vd.item}</td>
									<td>￥${vd.account}</td>
									<td>${vd.explain}</td>
									<td>${vd.vd_path}</td>
								</tr>
							</c:forEach>
						</c:forEach>
					</table>
					<hr />
					<table width="90%" border="0" cellspacing="0" cellpadding="0"
						class="addform-base">
						<tr>
							<td>审核意见：</td>
						</tr>
						<tr>
							<td><textarea class="check_comment"
									name="checkResult.comment" id="textarea" cols="45" rows="5"></textarea></td>
						</tr>
						<!-- 自己看自己的 只能有返回 -->
						<c:forEach items="${bxVo.voucher}" var="v1">
							<c:forEach items="${v1.checkresult}" var="c1">
								<c:if test="${eidd!=c1.next_eid}">
									<tr>
										<td colspan="4" class="submit"><input type="button"
											name="button" id="button" value="返回" class="submit_01"
											onclick="window.location.href='claimVoucherQueryAction.action'" />
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</c:forEach>

						<!-- 自己看所掌管权限的 且是财务-->
						<c:forEach items="${bxVo.voucher}" var="v2">
							<c:forEach items="${v2.checkresult}" var="c2">
								<c:if test="${eidd==c2.next_eid&&c2.next_eid=='004'}">
									<tr>
										<td colspan="4" class="submit"><input type="button"
											name="btnPass" id="btnPass" value="审批通过" class="submit_01" />
											<input type="button" name="btnRefuse" id="btnRefuse"
											value="审批拒接" class="submit_01" /> <input type="button"
											name="btnBack" id="btnBack" value="打回" class="submit_01" />
											<input type="button" name="button" id="button" value="返回"
											class="submit_01"
											onclick="window.location.href='claimVoucherQueryAction.action'" />
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</c:forEach>

						<!-- 自己看所掌管权限的 -->
						<c:forEach items="${bxVo.voucher}" var="v3">
							<c:forEach items="${v3.checkresult}" var="c3">
								<c:if test="${eidd==c3.next_eid&&c3.next_eid!='004'}">
									<tr>
										<td colspan="4" class="submit"><input type="button"
											name="btnPass" id="btnPass" value="审批通过" class="submit_01" />
											<input type="button" name="button" id="button" value="返回"
											class="submit_01"
											onclick="window.location.href='claimVoucherQueryAction.action'" />
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</c:forEach>
						<!-- <tr>
								<td colspan="4" class="submit"><input type="button"
									name="btnPass" id="btnPass" value="审批通过" class="submit_01" />
									<input type="button" name="btnRefuse" id="btnRefuse"
									value="审批拒接" class="submit_01" /> <input type="button"
									name="btnBack" id="btnBack" value="打回" class="submit_01" /> <input
									type="button" name="button" id="button" value="返回"
									class="submit_01"
									onclick="window.location.href='claimVoucherQueryAction.action'" />
								</td>
							</tr> -->
					</table>
				</div>
				</form>
			</div>
		</div>
	</div>

	<div class="copyright">Copyright &nbsp; &copy; &nbsp; 北大青鸟</div>
</body>
<script type="text/javascript" src="/jabosystems/js/jquery-1.12.4.js"></script>
<script>
	$(function() {
		$(".submit").click(function() {
			var status = $(".statuss").attr("status");
			if (status == "部门经理待审核") {
				status = "部门经理审核通过";
			}
			if (status == "总经理待审核") {
				status = "总经理审核通过";
			}
			if (status == "财务待审核") {
				status = "财务审核通过";
			}
			if (status == "财务待打款") {
				status = "财务打款成功";
			}
			var json = {};
			json["cr_id"] = $(".statuss").attr("cr_id");
			json["vc_id"] = $(".vc_id").attr("vc_id");
			json["create_eid"] = $(".create_eid").attr("create_eid");
			json["next_eid"] = $(".next_eid").attr("next_eid");
			json["check_comment"] = $(".check_comment").val();
			json["status"] = status;
			console.log(json);
			$.ajax({
				url : "api/Voucher",
				data : JSON.stringify(json),
				contentType : "application/json",
				type : "post",
				dataType : "json",
				success : function(data) {

				}
			});
		})
	});
</script>
</html>