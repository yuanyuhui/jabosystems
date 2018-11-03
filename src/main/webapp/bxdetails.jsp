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
				<div class="t">查看报销单</div>
				<div class="pages">
					<table width="90%" border="0" cellspacing="0" cellpadding="0"
						class="addform-base">
						<caption>基本信息</caption>
						<c:forEach items="${bxVo.employee}" var="e">
							<tr>
								<td width="25%">编&nbsp;&nbsp;号：${e.eid}</td>
								<td width="30%">填&nbsp;写&nbsp;人：${e.ename}</td>
								<td width="25%">部&nbsp;&nbsp;门：${e.department.dname}</td>
								<td>职&nbsp;&nbsp;位：${e.position.pname}</td>
							</tr>
						</c:forEach>
						<c:forEach items="${bxVo.voucher}" var="v">
							<tr>
								<td>总金额：${v.total_account}</td>
								<td>填报时间：<fmt:formatDate value="${v.create_time}" />
								</td>
								<c:forEach items="${v.checkresult}" var="c">
									<td>状态：${c.status}</td>
									<c:forEach items="${list_Employee}" var="l">
										<c:if test="${l.eid==c.next_eid}">
											<td>待处理人：${l.ename}(${l.position.pname})</td>
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
					<strong>审核清单</strong>
					<table width="90%" border="0" cellspacing="0" cellpadding="0"
						class="addform-item">
						<c:forEach items="${list_checkresult}" var="lc">
							<tr>
								<c:forEach items="${list_Employee}" var="list">
									<c:if test="${list.eid==lc.next_eid}">
										<td width="25%">审 批
											人：${list.ename}(${list.position.pname})</td>
									</c:if>
								</c:forEach>
								<td width="25%">审批时间：<fmt:formatDate value="${lc.time}" />
								</td>
								<td width="25%">审核：<strong style="color: red;">${lc.status}</strong></td>
								<td width="25%">审核意见：<strong style="color: black;">${lc.check_comment}</strong></td>
							</tr>
						</c:forEach>
					</table>
					<hr />
					<table width="90%" border="0" cellspacing="0" cellpadding="0"
						class="addform-item">
						<tr>
							<td colspan="4" class="submit" style="text-align: left;"><input
								type="button" name="button" id="button" value="返回"
								class="submit_01"
								onclick="document.location='claimVoucherQueryAction.action'" />
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div class="copyright">Copyright &nbsp; &copy; &nbsp; 北大青鸟</div>
</body>

</html>