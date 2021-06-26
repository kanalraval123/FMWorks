<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IMAGE UPLOAD</title>
</head>
<body>
	<h1>Upload Image</h1>
	<form method="post" action="UploadImageController"
		enctype="multipart/form-data">
		<p>
			<span>Note:</span><span>Image size must be 2MB or less.Image
				width-height must 1100px-1210px.Image must in .jpg Format.</span>
		</p>
		<br> Enter File Name: <input type="text" name="file_name"><br>
		<input type="file" name="file2" accept="image/jpeg" size="2" required /><br>
		<input type="submit" value="Upload" />
	</form>
	<%
	String file_name = (String) request.getParameter("filename");
	if (file_name != null) {
		out.println(file_name + " File uploaded successfuly");
	}
	%>
</body>
</html>