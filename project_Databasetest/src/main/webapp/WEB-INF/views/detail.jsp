<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plan detail</title>
</head>
<body>
	<h3>Plan detail description</h3>
		<table border="1">
			
			<td align="center">
				<table >
					<tr height="50">
						<td width="80">plan_number</td>
						<td width="160">${plan.plan_number }</td>
					</tr>
					<tr height="50">
						<td width="80">plan_title</td>
						<td width="160">${plan.plan_title }</td>
					</tr>
					<tr height="50">
						<td width="80">plan_location</td>
						<td width="160">${plan.plan_location }</td>
					</tr>
					<tr height="50">
						<td width="80">plan_description</td>
						<td width="160">${plan.plan_description }</td>
					</tr>
					<tr height="50">
						<td width="80">plan_deadline</td>
						<td width="160">${plan.plan_deadline }</td>
					</tr>
					<tr height="50">
						<td width="80">plan_deadline</td>
						<td width="160">${plan.plan_deadline }</td>
					</tr>
					<tr height="50">
						<td width="80">plan_category</td>
						<td width="160">${plan.plan_category }</td>
					</tr>
					<tr height="50">
						<td width="80">plan_share</td>
						<td width="160">${plan.plan_share }</td>
					</tr>
					<tr height="50">
						<td align="center" width="240" colspan="3">
						<a href="/">목록으로</a>
						<a href="/modifiy/${plan.plan_number }">수정하기</a>
						<a href="/delete/${plan.plan_number }">삭제</a>
						</td>
					</tr>
				</table>
			</td>
		</table>
</body>
</html>