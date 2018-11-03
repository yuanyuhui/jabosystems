<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北大青鸟办公自动化管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="top">
		<div class="global-width">
			<img src="images/logo.gif" class="logo" />
		</div>
	</div>
	<div class="status">
		<div class="global-width">
			<span class="usertype">【登录角色：部门经理】</span> <span>叶宁</span>你好！欢迎访问青鸟办公管理系统！
		</div>
	</div>
	<div class="main">
		<div class="global-width">
			<div class="nav" id="nav">
				<div class="t"></div>
				<dl>
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">报销单管理</dt>
					<dd>
						<a href="bxlist.html" target="_self">查看报销单</a>
					</dd>
					<dd>
						<a href="claimVoucherToAddAction.action" target="_self">添加报销单</a>
					</dd>
				</dl>
				<dl class="open">
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">请假管理</dt>
					<dd>
						<a href="qjlist.html" target="_self">查看请假</a>
					</dd>
					<dd>
						<a href="qjsave.html" target="_self">申请请假</a>
					</dd>
				</dl>
				<dl>
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">统计报表</dt>
					<dd>报销单月度统计</dd>
					<dd>报销单年度统计</dd>
				</dl>
				<dl>
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">信息中心</dt>
					<dd>信心收件箱</dd>
					<dd>信心发件箱</dd>
				</dl>
			</div>
			<div class="action">
				<div class="t">查看请假</div>
				<s:if test="leavesList!=null">
					<s:iterator value="leavesList">
						<div class="pages">
							<!--增加报销单 区域 开始-->
							<table width="90%" border="0" cellspacing="0" cellpadding="0"
								class="addform-base">
								<caption>基本信息</caption>
								<tr>
									<td width="50%">姓名：<span>张平</span></td>
									<td width="50%">部门：<span>平台研发部</span></td>
								</tr>
								<tr>
									<td>开始时间：<span>2018-06-06 12:00</span></td>
									<td>结束时间：<span>2018-06-07 12:00</span></td>
								</tr>
								<tr>
									<td>请假天数：<span>1</span></td>
									<td>休假类型：<span>事假</span></td>
								</tr>
								<tr>
									<td>请假事由：<span>2</span></td>
									<td>审批状态：<span>已审核</span></td>
								</tr>
								<tr>
									<td colspan="2"><p>----------------------------------------------------------------------------------------</p></td>
								</tr>
								<tr>
									<td>审批意见：</td>
								</tr>
								<tr>
									<td><span>通过</span></td>
								</tr>
							</table>
							<table width="90%" border="0" cellspacing="0" cellpadding="0"
								class="addform-item">
								<tr>
									<td colspan="4" class="submit" style="text-align: left;">
										<input type="button" name="button" id="button" value="返回"
										class="submit_01" />
									</td>
								</tr>
							</table>

						</div>
					</s:iterator>
				</s:if>
			</div>
		</div>
	</div>

	<div class="copyright">Copyright &nbsp; &copy; &nbsp; 北大青鸟</div>
</body>
</html>