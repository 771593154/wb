<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<h1>操作用户</h1>
输入需要查询的id号<input id="id" type="text" name="id" /><button onclick="sel()" value="点击删除"></button><br />
<input id="del" type="text" name="del" /><br />
<form action="user/edit" method="post">
    输入需要修改的id号<input id="id2" type="text" name="id2" /><br />
    用户 <input type="text" id="username" name="username" /><br /> 密码 <input type="text" id="password"
                                                             name="password" /><br /> <input type="submit" value="点击修改">
</form>
</body>
</html>
</html>

<script >
    function sel(){

        $.ajax({
            url: "${pageContext.request.contextPath}/user/sav",
            type: "POST", //方式
            data: {id:$("#id").val(),del:$("#del").val()}, //传值
            cache: false, //禁用缓存
            async: true,  //异步调用
            dataType: "json",
            success: function(data){
                $("#username").val(data.userName);
                $("#password").val(data.pwd);
                if(data.del!=""){
                    alert("删除成功");
                }
            }
        })
    }

</script>
