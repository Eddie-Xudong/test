<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <title>学生查询ajax</title>
    <base href="<%=basePath%>"/>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function (){
            //在当前页面dom对象加载后，执行loadStudentsData()
            loadStudentsData();

            $("#btn").click(function (){
                loadStudentsData();
            })
        })

        function loadStudentsData(){
            $.ajax({
                url:"student/queryStudents.do",
                type:"get",
                dataType:"json",
                success:function (data){
                    //清除旧的数据
                    $("#info").html("");
                    //添加新数据
                    $.each(data,function (i,n){
                        $("#info").append("<tr>")
                            .append("<td>"+n.id+"</td>")
                            .append("<td>"+n.name+"</td>")
                            .append("<td>"+n.age+"</td>")
                            .append("</tr>")
                    })
                }
            })
        }
    </script>
</head>
<body>
    <div align="center">
        <table border="2px">
            <thead>
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>年龄</td>
            </tr>
            </thead>
            <tbody id="info">

            </tbody>
        </table>
        <input type="button" id="btn" value="加载数据">
    </div>
</body>
</html>
