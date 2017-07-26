<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Spring MVC文件上传</title>
</head>
<body>
    <h2>图片文件上传</h2>
    <form  action="upload.do" enctype="multipart/form-data" method="post">
        <table>
            <tr>
                <td>用户ID：</td>
                <td><input type="text" name="nurseId"></td>
            </tr>
            <tr>
                <td>选择头像：</td>
                <td><input type="file" name="file" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form>
     
    <c:if test="${n !=null }">
        <h2>上传结果</h2>
        <table>
            <c:if test="${n.nurseId != null }">
                <tr>
                    <td>用户名：</td>
                    <td>${n.nurseId}</td>
                </tr>
            </c:if>
            <c:if test="${n.nursePicture != null }">
                <tr>
                    <td>头像：</td>
                    <td><img src="${n.nursePicture}" width="100px" height="100px"></td><br/>
                    <td>文件名：${n.nursePicture}</td>
                </tr>
            </c:if>
             
        </table>
 
    </c:if>
 
</body>
</html>