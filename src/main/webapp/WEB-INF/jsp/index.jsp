<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="../css/layui.css"  media="all">
    <meta charset="utf-8">
    <title>南昌航空大学校友会</title>
    <style>
        *{
            margin: 0 auto;
            padding: 0 auto;
        }
        .myLink1{
            font-size: 18px;
        }

        .myLink2{
            font-size: 15px;
        }

        #top1{
            width: 100%;
            height: 30px;
            border: 1px solid #000000;
            background-color: #CDF5FD;
            float: left;
        }
        .top1{
            float: left;
            margin-left: 30px;
            margin-top: 4px;
        }
        a{
            text-decoration: none;
        }



        #top2{
            width: 100%;
            height: 120px;
            border: 1px solid #29D5A9;
            display: block;
            white-space: nowrap;
            float: left;
        }
        #top2_image{
            display: inline-block;
            border: 1px solid #29D5A9;
            margin-left: 110px;
            float: left;
        }
        #top2_search{
            display: inline-block;
            border: 1px solid #29D5A9;
            float: left;
            margin-top: 60px;
            margin-left: 300px;
        }
        #search_text{
            width: 300px;
            height: 40px;
            border-radius: 18px;
            outline: none;
            border: 1px solid #ccc;
            padding-left: 20px;
            position: absolute;
        }
        #search_button{
            height: 30px;
            width: 40px;
            margin-top: 1px;
            margin-left: 245px;
            background-image:url("../images/search.png");
            border: none;
            outline: none;
            cursor: pointer;
            position: absolute;
        }



        #top3{
            width: 100%;
            height: 40px;
            border: 1px solid #A4E5FB;
            background-color: #2B71C4;
            text-align: center;
            float: left;
        }



        #left{
            height:600px;
            width: 150px;
            border: 1px solid #D56464;
            background-color: #EEEEEE;
            float: left;
        }



        #middle{
            height:600px;
            width: 1213.21px;
            border: 1px solid #D56464;
            float: left;
        }
        #middle_left{
            height:600px;
            width:300px;
            border: 1px solid #D56464;
            text-align: center;
            float: left;
        }
        #triangle{
            float: left;
            margin-top: -4px;
            margin-left: 80px;
            display: inline-block;;
        }
        #first{
            float: left;
        }
        #allA{
            float: left;
            margin-top: 70px;
            width: 100%;
            text-align: center;
        }


        #middle_right{
            height:600px;
            width:909px;
            border: 1px solid #007DDB;
            text-align: center;
            float: left;
        }
        .page{
            margin-top: 50px;
            float: left;
            margin-left: 260px;
        }



        #right{
            height:600px;
            width: 150px;
            border: 1px solid aquamarine;
            background-color: #EEEEEE;
            float: left;
        }
        #bottom1{
            width: 100%;
            height: 300px;
            border: 1px solid #D56464;
            float: left;
        }
        #bottom2{
            width: 100%;
            height: 60px;
            border: 1px solid #D56464;
            float: left;
        }

    </style>


    <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        var start = 0;//起始页
        var flashMethod;//最新方法

        $(function() {//进行初始化方法
            clickNews();
            clickAll("news",0)
        });

        function pageUp() {//上一页
            start -= 5;
            if(start<0){
                alert("当前已是首页！")
                start = 0;//重新置为零
                return;
            }
            else {
                clickAll(flashMethod,start);
            }

        }

        function pageDown() {//下一页
            //通过ajax去获取当前methods下表的长度
            start += 5;
            var whichMethods;
            if (flashMethod=="news" || flashMethod=="newsFlash" || flashMethod=="schoolNews" || flashMethod=="announce"){
                whichMethods = "news";
            }
            else if (flashMethod=="alumni" || flashMethod=="brief" || flashMethod=="rule" || flashMethod=="party"){//校友会界面
                whichMethods = "alumni";
            }
            else if (flashMethod=="donate" || flashMethod=="terrace" || flashMethod=="infomation") {//捐赠界面
                whichMethods = "donate";
            }
            else if (flashMethod=="figure" || flashMethod=="presence" || flashMethod=="elite") {//人物界面
                whichMethods = "figure";
            }
            else if (flashMethod=="help" || flashMethod=="school" || flashMethod=="phone") {//帮助界面
                whichMethods = "help";
            }
            else if (flashMethod=="medium" || flashMethod=="photo" || flashMethod=="video") {//视频和照片界面
                whichMethods = "medium";
            }
            else{//昌航人
                whichMethods = "student";
            }
            $.ajax({
                type: "post",
                async:true,//设置异步，不然可能接收不到后端返回的json
                url: "http://localhost:8080/"+whichMethods+"/getCount",
                data: {'methods':flashMethod},
                success:function (data) {
                    if (start>=data){
                        start -= 5;
                        alert("当前已是末页！")
                        return;
                    }
                    else{
                        clickAll(flashMethod,start);
                    }
                },//end success
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("失败了")
                    console.log(XMLHttpRequest.status);
                    console.log(XMLHttpRequest.readyState);
                    console.log(textStatus);
                }
            })//end ajax
        }//end pageDown

        //检查链接方法
        function clickAll(methods,start2) {
            if (start2!=start)//如果不是通过下一页按钮进入的，则将start置为0。
                start = 0;
            flashMethod = methods;
            var obj = document.getElementById("middle_right")
            var flag = obj.getElementsByTagName("a");//获取middle_left里面的a标签
            if (flag.length>0) {//每当用户再次请求内容时，先清除里面的内容
                $('#middle_right a').remove();
                $('#middle_right br').remove();
            }
            if (methods=="news" || methods=="newsFlash" || methods=="schoolNews" || methods=="announce") {//新闻界面
                $.ajax({
                    type: "post",
                    async:true,//设置异步，不然可能接收不到后端返回的json
                    url: "http://localhost:8080/news/whichNews",
                    data: {'methods':methods,'start':start2},
                    success:function (data) {
                        var str = "";
                        $.each(data,function (index,res) {//循环读出数据
                            $("#middle_right").append("<br /><br />");
                            str = "<a id='allA' href='../html/"+res.ncLink+"\' target='_blank'>" + "<h2>"+res.ncName+"<h2 />"+"<a />"+"<br />";
                            $("#middle_right").append("<a >"+"<a />"+str);
                        })
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                    }
                })
            }//end if
            else if (methods=="alumni" || methods=="brief" || methods=="rule" || methods=="party"){//校友会界面
                $.ajax({
                    type: "post",
                    async:true,//设置异步，不然可能接收不到后端返回的json
                    url: "http://localhost:8080/alumni/whichAlumni",
                    data: {'methods':methods,'start':start2},
                    success:function (data) {
                        var str = "";
                        $.each(data,function (index,res) {//循环读出数据
                            $("#middle_right").append("<br /><br />");
                            str = "<a id='allA' href='../html/"+res.acLink+"\' target='_blank'>" + "<h2>"+res.acName+"<h2 />"+"<a />"+"<br />";
                            $("#middle_right").append("<a >"+"<a />"+str);
                        })
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                    }
                })
            }//end else if

            else if (methods=="donate" || methods=="terrace" || methods=="infomation"){//捐赠界面
                $.ajax({
                    type: "post",
                    async:true,//设置异步，不然可能接收不到后端返回的json
                    url: "http://localhost:8080/donate/whichDonate",
                    data: {'methods':methods,'start':start2},
                    success:function (data) {
                        var str = "";
                        $.each(data,function (index,res) {//循环读出数据
                            $("#middle_right").append("<br /><br />");
                            str = "<a id='allA' href='../html/"+res.dcLink+"\' target='_blank'>" + "<h2>"+res.dcName+"<h2 />"+"<a />"+"<br />";
                            $("#middle_right").append("<a >"+"<a />"+str);
                        })
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                    }
                })
            }//end else if

            else if (methods=="figure" || methods=="presence" || methods=="elite"){//人物界面
                $.ajax({
                    type: "post",
                    async:true,//设置异步，不然可能接收不到后端返回的json
                    url: "http://localhost:8080/figure/whichFigure",
                    data: {'methods':methods,'start':start2},
                    success:function (data) {
                        var str = "";
                        $.each(data,function (index,res) {//循环读出数据
                            $("#middle_right").append("<br /><br />");
                            str = "<a id='allA' href='../html/"+res.fcLink+"\' target='_blank'>" + "<h2>"+res.fcName+"<h2 />"+"<a />"+"<br />";
                            $("#middle_right").append("<a >"+"<a />"+str);
                        })
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                    }
                })
            }//end else if

            else if (methods=="help" || methods=="school" || methods=="phone"){//帮助界面
                $.ajax({
                    type: "post",
                    async:true,//设置异步，不然可能接收不到后端返回的json
                    url: "http://localhost:8080/help/whichHelp",
                    data: {'methods':methods,'start':start2},
                    success:function (data) {
                        var str = "";
                        $.each(data,function (index,res) {//循环读出数据
                            $("#middle_right").append("<br /><br />");
                            str = "<a id='allA' href='../html/"+res.hcLink+"\' target='_blank'>" + "<h2>"+res.hcName+"<h2 />"+"<a />"+"<br />";
                            $("#middle_right").append("<a >"+"<a />"+str);
                        })
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                    }
                })
            }//end else if

            else if (methods=="medium" || methods=="photo" || methods=="video"){//视频和照片界面
                $.ajax({
                    type: "post",
                    async:true,//设置异步，不然可能接收不到后端返回的json
                    url: "http://localhost:8080/medium/whichMedium",
                    data: {'methods':methods,'start':start2},
                    success:function (data) {
                        var str = "";
                        $.each(data,function (index,res) {//循环读出数据
                            $("#middle_right").append("<br /><br />");
                            str = "<a id='allA' href='../html/"+res.mcLink+"\' target='_blank'>" + "<h2>"+res.mcName+"<h2 />"+"<a />"+"<br />";
                            $("#middle_right").append("<a >"+"<a />"+str);
                        })
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                    }
                })
            }//end else if

            else{//昌航人界面
                $.ajax({
                    type: "post",
                    async:true,//设置异步，不然可能接收不到后端返回的json
                    url: "http://localhost:8080/student/whichStudent",
                    data: {'methods':methods,'start':start2},
                    success:function (data) {
                        var str = "";
                        $.each(data,function (index,res) {//循环读出数据
                            $("#middle_right").append("<br /><br />");
                            if (methods=="yearbook"){//同学录专属跳转
                                str = "<a id='allA' href='../jsp/"+res.scLink+"\' target='_blank'>" + "<h2>"+res.scName+"<h2 />"+"<a />"+"<br />";
                            }
                            else {
                                str = "<a id='allA' href='../html/" + res.scLink + "\' target='_blank'>" + "<h2>" + res.scName + "<h2 />" + "<a />" + "<br />";
                            }
                            $("#middle_right").append("<a >"+"<a />"+str);
                        })
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        console.log(XMLHttpRequest.status);
                        console.log(XMLHttpRequest.readyState);
                        console.log(textStatus);
                    }
                })
            }
        }//end clickAll


        function clickNews() {
            var obj = document.getElementById("middle_left")
            var flag = obj.getElementsByTagName("a");//获取middle_left里面的a标签
            if (flag.length>0) {//每当用户再次请求内容时，先清除里面的内容
                $('#middle_left a').remove();
                $('#middle_left br').remove();
            }
            $.ajax({
                type: "post",
                async:true,//设置异步，不然可能接收不到后端返回的json
                url: "http://localhost:8080/news/clickNews",
                success:function (data) {
                    var str = "";
                    $.each(data,function (index,res) {//循环读出数据

                        if (index==0){//先加三个换行符，调样式的
                            $("#middle_left").append("<br /><br /><br />");//将链接上传到clickAll进行判断
                            str = "<a id='first' onclick='clickAll(\"" + res.nLink + "\",0)'>"+"<h2>"+res.nName+"<h2 />"+"<a />"+"<br />";
                            $("#middle_left").append("<a onclick='clickAll(\"" + res.nLink + "\",0)'>"+"<img id='triangle' src='../images/triangle.png'/>"+"<a />"+str);
                        }
                        else {
                            if(index==1) {
                                $("#middle_left").append("<br /><br />");
                            }
                            str = "<a id='\"" + res.nLink + "\"' onclick='clickAll(\"" + res.nLink + "\",0)'>" + "<h2>" + res.nName + "<h2 />" + "<a />" + "<br /><br />";
                            $("#middle_left").append(str);
                        }
                    })
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    console.log(XMLHttpRequest.status);
                    console.log(XMLHttpRequest.readyState);
                    console.log(textStatus);
                }
            });
        }//end function


        function clickAlumni() {
            var obj = document.getElementById("middle_left")
            var flag = obj.getElementsByTagName("a");//获取middle_left里面的a标签
            if (flag.length>0) {//每当用户再次请求内容时，先清除里面的内容
                $('#middle_left a').remove();
                $('#middle_left br').remove();
            }
            $.ajax({
                type: "post",
                async:true,//设置异步，不然可能接收不到后端返回的json
                url: "http://localhost:8080/alumni/clickAlumni",
                success:function (data) {
                    var str = "";
                    $.each(data,function (index,res) {//循环读出数据

                        if (index==0){//先加三个换行符，调样式的
                            $("#middle_left").append("<br /><br /><br />");
                            str = "<a id='first' onclick='clickAll(\"" + res.aLink + "\",0)'>"+"<h2>"+res.aName+"<h2 />"+"<a />"+"<br />";
                            $("#middle_left").append("<a onclick='clickAll(\"" + res.aLink + "\",0)'>"+"<img id='triangle' src='../images/triangle.png'/>"+"<a />"+str);
                        }
                        else {
                            if(index==1) {
                                $("#middle_left").append("<br /><br />");
                            }
                            str = "<a onclick='clickAll(\"" + res.aLink + "\",0)'>" + "<h2>" + res.aName + "<h2 />" + "<a />" + "<br /><br />";
                            $("#middle_left").append(str);
                        }
                    })
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    console.log(XMLHttpRequest.status);
                    console.log(XMLHttpRequest.readyState);
                    console.log(textStatus);
                }
            });
        }//end function

        function clickFigure() {
            var obj = document.getElementById("middle_left")
            var flag = obj.getElementsByTagName("a");//获取middle_left里面的a标签
            if (flag.length>0) {//每当用户再次请求内容时，先清除里面的内容
                $('#middle_left a').remove();
                $('#middle_left br').remove();
            }
            $.ajax({
                type: "post",
                async:true,//设置异步，不然可能接收不到后端返回的json
                url: "http://localhost:8080/figure/clickFigure",
                success:function (data) {
                    var str = "";
                    $.each(data,function (index,res) {//循环读出数据

                        if (index==0){//先加三个换行符，调样式的
                            $("#middle_left").append("<br /><br /><br />");
                            str = "<a id='first' onclick='clickAll(\"" + res.fLink + "\",0)'>"+"<h2>"+res.fName+"<h2 />"+"<a />"+"<br />";
                            $("#middle_left").append("<a onclick='clickAll(\"" + res.fLink + "\",0)'>"+"<img id='triangle' src='../images/triangle.png'/>"+"<a />"+str);
                        }
                        else {
                            if(index==1) {
                                $("#middle_left").append("<br /><br />");
                            }
                            str = "<a onclick='clickAll(\"" + res.fLink + "\",0)'>" + "<h2>" + res.fName + "<h2 />" + "<a />" + "<br /><br />";
                            $("#middle_left").append(str);
                        }
                    })
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    console.log(XMLHttpRequest.status);
                    console.log(XMLHttpRequest.readyState);
                    console.log(textStatus);
                }
            });
        }//end function

        function clickDonate() {
            var obj = document.getElementById("middle_left")
            var flag = obj.getElementsByTagName("a");//获取middle_left里面的a标签
            if (flag.length>0) {//每当用户再次请求内容时，先清除里面的内容
                $('#middle_left a').remove();
                $('#middle_left br').remove();
            }
            $.ajax({
                type: "post",
                async:true,//设置异步，不然可能接收不到后端返回的json
                url: "http://localhost:8080/donate/clickDonate",
                success:function (data) {
                    var str = "";
                    $.each(data,function (index,res) {//循环读出数据

                        if (index==0){//先加三个换行符，调样式的
                            $("#middle_left").append("<br /><br /><br />");
                            str = "<a id='first' onclick='clickAll(\"" + res.dLink + "\",0)'>"+"<h2>"+res.dName+"<h2 />"+"<a />"+"<br />";
                            $("#middle_left").append("<a onclick='clickAll(\"" + res.dLink + "\",0)'>"+"<img id='triangle' src='../images/triangle.png'/>"+"<a />"+str);
                        }
                        else {
                            if(index==1) {
                                $("#middle_left").append("<br /><br />");
                            }
                            str = "<a onclick='clickAll(\"" + res.dLink + "\",0)'>" + "<h2>" + res.dName + "<h2 />" + "<a />" + "<br /><br />";
                            $("#middle_left").append(str);
                        }
                    })
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    console.log(XMLHttpRequest.status);
                    console.log(XMLHttpRequest.readyState);
                    console.log(textStatus);
                }
            });
        }//end function

        function clickHelp() {
            var obj = document.getElementById("middle_left")
            var flag = obj.getElementsByTagName("a");//获取middle_left里面的a标签
            if (flag.length>0) {//每当用户再次请求内容时，先清除里面的内容
                $('#middle_left a').remove();
                $('#middle_left br').remove();
            }
            $.ajax({
                type: "post",
                async:true,//设置异步，不然可能接收不到后端返回的json
                url: "http://localhost:8080/help/clickHelp",
                success:function (data) {
                    var str = "";
                    $.each(data,function (index,res) {//循环读出数据

                        if (index==0){//先加三个换行符，调样式的
                            $("#middle_left").append("<br /><br /><br />");
                            str = "<a id='first' onclick='clickAll(\"" + res.hLink + "\",0)'>"+"<h2>"+res.hName+"<h2 />"+"<a />"+"<br />";
                            $("#middle_left").append("<a onclick='clickAll(\"" + res.hLink + "\",0)'>"+"<img id='triangle' src='../images/triangle.png'/>"+"<a />"+str);
                        }
                        else {
                            if(index==1) {
                                $("#middle_left").append("<br /><br />");
                            }
                            str = "<a onclick='clickAll(\"" + res.hLink + "\",0)'>" + "<h2>" + res.hName + "<h2 />" + "<a />" + "<br /><br />";
                            $("#middle_left").append(str);
                        }
                    })
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    console.log(XMLHttpRequest.status);
                    console.log(XMLHttpRequest.readyState);
                    console.log(textStatus);
                }
            });
        }//end function

        function clickMedium() {
            var obj = document.getElementById("middle_left")
            var flag = obj.getElementsByTagName("a");//获取middle_left里面的a标签
            if (flag.length>0) {//每当用户再次请求内容时，先清除里面的内容
                $('#middle_left a').remove();
                $('#middle_left br').remove();
            }
            $.ajax({
                type: "post",
                async:true,//设置异步，不然可能接收不到后端返回的json
                url: "http://localhost:8080/medium/clickMedium",
                success:function (data) {
                    var str = "";
                    $.each(data,function (index,res) {//循环读出数据

                        if (index==0){//先加三个换行符，调样式的
                            $("#middle_left").append("<br /><br /><br />");
                            str = "<a id='first' onclick='clickAll(\"" + res.mLink + "\",0)'>"+"<h2>"+res.mName+"<h2 />"+"<a />"+"<br />";
                            $("#middle_left").append("<a onclick='clickAll(\"" + res.mLink + "\",0)'>"+"<img id='triangle' src='../images/triangle.png'/>"+"<a />"+str);
                        }
                        else {
                            if(index==1) {
                                $("#middle_left").append("<br /><br />");
                            }
                            str = "<a onclick='clickAll(\"" + res.mLink + "\",0)'>" + "<h2>" + res.mName + "<h2 />" + "<a />" + "<br /><br />";
                            $("#middle_left").append(str);
                        }
                    })
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    console.log(XMLHttpRequest.status);
                    console.log(XMLHttpRequest.readyState);
                    console.log(textStatus);
                }
            });
        }//end function

        function clickStudent() {
            var obj = document.getElementById("middle_left")
            var flag = obj.getElementsByTagName("a");//获取middle_left里面的a标签
            if (flag.length>0) {//每当用户再次请求内容时，先清除里面的内容
                $('#middle_left a').remove();
                $('#middle_left br').remove();
            }
            $.ajax({
                type: "post",
                async:true,//设置异步，不然可能接收不到后端返回的json
                url: "http://localhost:8080/student/clickStudent",
                success:function (data) {
                    var str = "";
                    $.each(data,function (index,res) {//循环读出数据

                        if (index==0){//先加三个换行符，调样式的
                            $("#middle_left").append("<br /><br /><br />");
                            str = "<a id='first' onclick='clickAll(\"" + res.sLink + "\",0)'>"+"<h2>"+res.sName+"<h2 />"+"<a />"+"<br />";
                            $("#middle_left").append("<a onclick='clickAll(\"" + res.sLink + "\",0)'>"+"<img id='triangle' src='../images/triangle.png'/>"+"<a />"+str);
                        }
                        else {
                            if(index==1) {
                                $("#middle_left").append("<br /><br />");
                            }
                            str = "<a onclick='clickAll(\"" + res.sLink + "\",0)'>" + "<h2>" + res.sName + "<h2 />" + "<a />" + "<br /><br />";
                            $("#middle_left").append(str);
                        }
                    })
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    console.log(XMLHttpRequest.status);
                    console.log(XMLHttpRequest.readyState);
                    console.log(textStatus);
                }
            });
        }//end function


    </script>
</head>
<body>
<div id="top1">
    <div id="top1_1">
        <div class="top1">
            <a href="http://www.nchu.edu.cn/" target="_blank">南昌航空大学</a>
        </div>
        <div class="top1">
            <a href="http://www.jxedu.gov.cn/" target="_blank">江西高等教育网</a>
        </div>
        <div class="top1">
            <a href="http://www.nchu.edu.cn/" target="_blank">校友捐赠</a>
        </div>
    </div>
</div>

<div id="top2">
    <div id="top2_image">
        <a href="index.jsp">
            <img src="../images/school.png"/>
        </a>
    </div>
    <div id="top2_search">
        <form>
            <input id="search_text" type="text" placeholder="搜索"/>
            <input id="search_button" type="submit" value=""/>
        </form>
    </div>
</div>

<div id="top3">
    <ul class="layui-nav layui-bg-blue">
    <c:forEach var="News" items="${requestScope.get('listNews')}" begin="0" end="0">
        <li class="layui-nav-item"><a onclick="clickNews()"><font class="myLink1" onclick="clickAll('${News.getnLink()}',0)">${News.getnName()}</font></a>
    </c:forEach>
            <dl class="layui-nav-child">
                <c:forEach var="News" items="${requestScope.get('listNews')}" begin="1">
                    <dd><a onclick="clickNews()"><font class="myLink2" onclick="clickAll('${News.getnLink()}',0)">${News.getnName()}</font></a></dd>
                </c:forEach>
            </dl>
        </li>
        <span><img src="../images/span.png"/></span>

    <c:forEach var="alumni" items="${requestScope.get('listAlumni')}" begin="0" end="0">
        <li class="layui-nav-item"><a onclick="clickAlumni()"><font class="myLink1" onclick="clickAll('${alumni.getaLink()}',0)">${alumni.getaName()}</font></a>
    </c:forEach>
            <dl class="layui-nav-child">
                <c:forEach var="alumni" items="${requestScope.get('listAlumni')}" begin="1">
                    <dd><a onclick="clickAlumni()"><font class="myLink2" onclick="clickAll('${alumni.getaLink()}',0)">${alumni.getaName()}</font></a></dd>
                </c:forEach>
                <!--<dd class="layui-this"><a href="">选中项</a></dd>  选中项操作方法-->
            </dl>
        </li>
        <span><img src="../images/span.png"/></span>

    <c:forEach var="figure" items="${requestScope.get('listFigure')}" begin="0" end="0">
        <li class="layui-nav-item "><a onclick="clickFigure()"><font class="myLink1" onclick="clickAll('${figure.getfLink()}',0)">${figure.getfName()}</font></a>
    </c:forEach>
            <dl class="layui-nav-child">
                <c:forEach var="figure" items="${requestScope.get('listFigure')}" begin="1">
                    <dd><a onclick="clickFigure()"><font class="myLink2" onclick="clickAll('${figure.getfLink()}',0)">${figure.getfName()}</font></a></dd>
                </c:forEach>
            </dl>
        </li>
        <span><img src="../images/span.png"/></span>

    <c:forEach var="donate" items="${requestScope.get('listDonate')}" begin="0" end="0">
        <li class="layui-nav-item "><a onclick="clickDonate()"><font class="myLink1" onclick="clickAll('${donate.getdLink()}',0)">${donate.getdName()}</font></a>
    </c:forEach>
            <dl class="layui-nav-child">
                <c:forEach var="donate" items="${requestScope.get('listDonate')}" begin="1">
                    <dd><a onclick="clickDonate()"><font class="myLink2" onclick="clickAll('${donate.getdLink()}',0)">${donate.getdName()}</font></a></dd>
                </c:forEach>
            </dl>
        </li>
        <span><img src="../images/span.png"/></span>

    <c:forEach var="student" items="${requestScope.get('listStudent')}" begin="0" end="0">
        <li class="layui-nav-item "><a onclick="clickStudent()"><font class="myLink1" onclick="clickAll('${student.getsLink()}',0)">${student.getsName()}</font></a>
    </c:forEach>
            <dl class="layui-nav-child">
                <c:forEach var="student" items="${requestScope.get('listStudent')}" begin="1">
                    <dd><a onclick="clickStudent()"><font class="myLink2" onclick="clickAll('${student.getsLink()}',0)">${student.getsName()}</font></a></dd>
                </c:forEach>
            </dl>
        </li>
        <span><img src="../images/span.png"/></span>

    <c:forEach var="medium" items="${requestScope.get('listMedium')}" begin="0" end="0">
        <li class="layui-nav-item "><a onclick="clickMedium()"><font class="myLink1" onclick="clickAll('${medium.getmLink()}',0)">${medium.getmName()}</font></a>
    </c:forEach>
            <dl class="layui-nav-child">
                <c:forEach var="medium" items="${requestScope.get('listMedium')}" begin="1">
                    <dd><a onclick="clickMedium()"><font class="myLink2" onclick="clickAll('${medium.getmLink()}',0)">${medium.getmName()}</font></a></dd>
                </c:forEach>
            </dl>
        </li>
        <span><img src="../images/span.png"/></span>

    <c:forEach var="help" items="${requestScope.get('listHelp')}" begin="0" end="0">
        <li class="layui-nav-item "><a onclick="clickHelp()"><font class="myLink1" onclick="clickAll('${help.gethLink()}',0)">${help.gethName()}</font></a>
    </c:forEach>
            <dl class="layui-nav-child">
                <c:forEach var="help" items="${requestScope.get('listHelp')}" begin="1">
                    <dd><a onclick="clickHelp()"><font class="myLink2" onclick="clickAll('${help.gethLink()}',0)">${help.gethName()}</font></a></dd>
                </c:forEach>
            </dl>
        </li>

    </ul>

</div>

<div id="left"></div>

<div id="middle">
    <div id="middle_left">

    </div>
    <div id="middle_right">
        <div>
            <p class="page" onclick="pageUp()">上一页</p>
            <p class="page" onclick="pageDown()">下一页</p>
        </div>
    </div>
</div>

<div id="right"></div>

<div id="bottom1">

</div>

<div id="bottom2">

</div>

<script src="../js/layui.all.js" charset="utf-8"></script>
<script>
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        //监听导航点击
        element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
</script>
</body>
</html>