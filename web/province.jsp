<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="/ssm/js/jquery-3.2.1.min.js"></script>
</head>
<body>
    省:
     <select id="province">
       <%--  <c:forEach items="${cities}" var="city">
             <option>${city.pid}</option>
         </c:forEach>--%>
     </select>
     <script>
         $.ajax({
             url : '/ssm/objectTest02',
             type : 'get',
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
