
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>宿舍查询</title>
    <script type="text/javascript">
      function search() {
        //创建异步对象
            var xmlHttp= new XMLHttpRequest();
        //绑定事件
            xmlHttp.onreadystatechange=function () {
                 if(xmlHttp.readyState==4&&xmlHttp.status==200){
                      var data = xmlHttp.responseText;
                      var dataa =eval("("+data+")")
                      document.getElementById("shezhang").value =dataa.shezhang;
                      document.getElementById("chengyuan").value =dataa.chengyuan;
                      document.getElementById("chengyuan1").value =dataa.chengyuan1;
                      document.getElementById("chengyuan2").value =dataa.chengyuan2;
                      document.getElementById("chengyuan3").value =dataa.chengyuan3;
                      document.getElementById("chengyuan4").value =dataa.chengyuan4;
                 }
            }
        //初始异步对象
        var susheid = document.getElementById("susheid").value;
            xmlHttp.open("get","one?susheid="+susheid,true)
        //发送请求
            xmlHttp.send()
      }
    </script>
  </head>
  <body>
  <center><font  style="color: chartreuse;font-size: 45px" >宿舍成员快速查询</font></center>
  <center><table border="2">
    <tr>
      <td>宿舍编号</td>
      <td><input type="text" id="susheid"><input type="button" value="搜索" onclick="search()"></td>
    </tr>
    <tr>
      <td>宿舍舍长</td>
      <td><input type="text" id="shezhang"></td>
    </tr>
    <tr>
      <td>宿舍成员1</td>
      <td><input type="text" id="chengyuan"></td>
    </tr>
    <tr>
      <td>宿舍成员2</td>
      <td><input type="text" id="chengyuan1"></td>
    </tr>
    <tr>
      <td>宿舍成员3</td>
      <td><input type="text" id="chengyuan2"></td>
    </tr>
    <tr>
      <td>宿舍成员4</td>
      <td><input type="text" id="chengyuan3"></td>
    </tr>
    <tr>
      <td>宿舍成员5</td>
      <td><input type="text" id="chengyuan4"></td>
    </tr>
  </table></center>

  </body>
</html>
