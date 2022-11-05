<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- User ServletFileUpload 	
	<form role="form" action="add" method="post"
		enctype="multipart/form-data">
		<div class="form-group">
			<label>Tên danh mục:</label> <input class="form-control"
				placeholder="please enter category Name" name="name" />
		</div>
		<div class="form-group">
			<label>Ảnh đại diện</label> <input type="file" name="image" />
		</div>
		<button type="submit" class="btn btn-default">Thêm</button>
		<button type="reset" class="btn btn-primary">Hủy</button>
	</form> -->
	<form method="post"
		action="${pageContext.request.contextPath}/uploadmulti"
		enctype="multipart/form-data">
		Chọn ảnh đại diện: <br /> <input type="file" name="image" /> <br />
		Tên danh mục: <br /> <input type="text" name="name" size="100" /> <br /> <br />
		<input type="submit" value="Upload" />
		<button type="reset" class="btn btn-primary">Hủy</button>
	</form>

</body>
</html>