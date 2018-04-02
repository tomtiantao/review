<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户信息</title>
</head>
<body>

userId：<input type="text" name="userId" id="userId"/><br/>
userName：<input type="text" name="userName" id="userName"/><br/>
userPassword：<input type="text" name="userPassword" id="userPassword"/><br/>
userEmail：<input type="text" name="userEmail" id="userEmail"/><br/>
<input type="button" value="提交信息" onclick="postUser();"/>


<script src="jquery-1.11.1.js" type="text/javascript"></script>
<script type="text/javascript">
    function postUser() {
        var userId = $('#userId').val();
        var userName = $('#userName').val();
        var userPassword = $('#userPassword').val();
        var userEmail = $('#userEmail').val();
        console.info('userId:' + userId);
        //debugger;
        var user = {
            userId: userId,
            userName: userName,
            userPassword: userPassword,
            userEmail: userEmail
        };
        $.ajax({
            url: "http://localhost:8080/spring_mybatis_test2/tt/test99.do?",
            data: JSON.stringify(user), //要用双引号!!
            dataType: "json",
            contentType: "application/json;charset=utf-8", // 因为上面是JSON数据
            type: "POST",
            headers: {
                Accept: "application/json",
            },
            success: function (data, textStatus) {
                console.log(JSON.stringify(data));
                //alert(data);
                $.each(data, function (index, item) {
                    alert("第" + (index + 1) + "个：" + item.userName);
                });
            },
            error: function (data, textStatus, errorThrown) {
                console.log(data);
            },
        });
    }
</script>
</body>
</html>