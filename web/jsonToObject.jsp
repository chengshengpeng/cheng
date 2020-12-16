<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="/ssm/js/jquery-3.2.1.min.js"></script>
</head>
<body>

     <script>
         var city = {'cid':10,'cname':'XXX市','pid':'XXX省','user':{
             'username':'张三','password':'123'
             }};
         var cityJson = JSON.stringify(city);
        /* alert(typeof cityJson)
         alert(cityJson);*/
        $.ajax({
             url : '/ssm/jsonToObject04',
             data : cityJson,
             type : 'post',
             contentType : "application/json",//以json串的形式传到后台
             dataType : 'json',
             success : function (data) {
                 for(var i = 0 ; i < data.length; i++){
                     $('#province').append("<option>"+data[i].pid+"</option>");
                 }
             }
         });
     </script>
</body>
</html>
