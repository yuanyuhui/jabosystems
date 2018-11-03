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
			<span class="usertype">【登录角色：${Employee.ename}(${Employee.position.pname})】</span> <span>张三</span>！欢迎访问青鸟办公管理系统！
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
						<a href="bxlist.html" target="_self">查看报销单</a>
					</dd>
					<dd>
						<a href="/jabosystems/Employee/bxadd" target="_self">添加报销单</a>
					</dd>
				</dl>
				<dl>
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
			<form action="claimVoucherQueryAction.action" id="myForm"
				method="post">
				<input type="hidden" name="curPage" value="1" id="curPage">
					<div class="action">
						<div class="t">查看报销单</div>
						<div class="pages">
							报销单状态: <select><option>待审核</option>
								<option>已审核</option></select> 开始时间：<input type="date"> 结束时间：<input
								type="date"> <input type="submit" value="查询" /> <!--增加报销单 区域 开始-->
									<table width="90%" border="0" cellspacing="0" cellpadding="0"
										class="list">
										<tr>
											<td>编号</td>
											<td>填报日期</td>
											<td>填报人</td>
											<td>总金额</td>
											<td>状态</td>
											<td>待处理人</td>
											<td>操作</td>
										</tr>
										<c:forEach items="${data.list}" var="d">
											<c:forEach items="${d.voucher}" var="v">
												<tr>
													<td><span> ${v.vc_id} </span></td>
													<td><span> <fmt:formatDate
																value="${v.create_time}" /></span></td>
													<c:forEach items="${list}" var="l">
														<c:if test="${l.eid==v.create_eid}">
															<td><span>${l.ename}</span></td>
														</c:if>
													</c:forEach>
													<td>￥<span>${v.total_account}</span></td>
													<c:forEach items="${v.checkresult}" var="c">
														<td><span>${c.status}</span></td>
														<c:forEach items="${list}" var="l">
															<c:if test="${l.eid==c.next_eid}">
																<td><span> ${l.ename} </span></td>
															</c:if>
														</c:forEach>
													</c:forEach>
													<td><a
														href="bxdetails?create_eid=${v.create_eid}&vc_id=${v.vc_id}"><img
															src="/jabosystems/images/search.gif" width="16"
															height="15" /></a> <a
														href="bxexamination?create_eid=${v.create_eid}&vc_id=${v.vc_id}"><img
															src="/jabosystems/images/save.gif" width="16" height="16" /></a>
														<a href=""><img src="/jabosystems/images/edit.gif"
															width="16" height="16" /></a> <a href=""><img
															src="/jabosystems/images/delete.gif" /></a>	</td>
												</tr>
											</c:forEach>
										</c:forEach>
										<tr>
											<td colspan="6" align="left"><a href="#">首页</a> <a
												href="#">上一页</a> <a href="#">下一页</a> <a href="#">末页</a></td>
										</tr>
									</table> <!--增加报销单 区域 结束-->
						</div>
					</div>
			</form>
		</div>
	</div>
	<div class="copyright">Copyright &nbsp; &copy; &nbsp; 北大青鸟</div>
</body>
</html>