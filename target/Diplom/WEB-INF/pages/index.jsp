<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>index page</title>
</head>
<link href="../../resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../../resources/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
<link href="../../resources/bower_components/bootstrap-social/bootstrap-social.css" rel="stylesheet">
<link href="../../resources/bower_components/dist/css/sb-admin-2.css" rel="stylesheet">
<link href="../../resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<script src="../../resources/bower_components/jquery/dist/jquery.min.js"></script>
<style>
    .flexcroll {
        scrollbar-face-color: #367CD2;
        scrollbar-shadow-color: #FFFFFF;
        scrollbar-highlight-color: #FFFFFF;
        scrollbar-3dlight-color: #FFFFFF;
        scrollbar-darkshadow-color: #FFFFFF;
        scrollbar-track-color: #FFFFFF;
        scrollbar-arrow-color: #FFFFFF;
    }

</style>
<script>
    $(document).ready(function () {
        $("#inputSearch").keyup(function () {
            alert("salam millet...")
            var param = $("#inputSearch").val();
            $.ajax({
                url: "test?key=" + param + "",
                dataType: "json",
                type: "GET",
                success: function (data) {
                    $("#container_panels").empty();
                    alert(data);
                    var returnData = data;
                    if (returnData != "") {
                        var out = ' <div class="col-lg-3">' +
                            ' <div class="panel panel-success">' +
                            '<div class="panel-heading">';

                        var i;
                        for (i = 0; i < returnData.length; i++) {
                            out += '  Panelin basligi' +
                                ' </div>' +
                                ' <div class="panel-body">' +
                                '   <p>Panelin metni</p>';
                        }
                        out += '</div >' +
                            ' <div class="panel-footer">' +
                            ' Panel Footer' +
                            ' </div>' +
                            ' </div>' +
                            ' </div>';
                        document.getElementById("container_panels").innerHTML = out;
                    }
                }
            });
        });
    });
</script>
<body>

<div id="wrapper" class="flexcroll">

    <div class="panel-body">

        <div class="row">
            <div class="col-lg-4">
                <h4 style="">Ətraflı axtarış</h4>
                <h4 class="page-header" style="color: #163758">İnfeksion əstəliklər</h4>
            </div>
            <div class="col-lg-6">
                <div class="form-group has-success">
                    <input type="text" class="form-control" id="inputSearch" placeholder="Latın hərfləri ilə daxil edin"
                           style="height: 45px;margin:37px 0 0 0px">
                </div>
            </div>
        </div>
        <br>
        <div class="row" id="container_panels">
            <c:if test="${!empty diseases}">
                <c:forEach items="${diseases}" var="disease">
                    <div class="col-lg-3">
                        <div class="panel panel-success">
                            <div class="panel-heading">
                                <p style="">${disease.name}</p>
                            </div>
                            <div class="panel-body" style="max-height:180px;overflow-y: scroll;">
                                <p>${disease.diseaseDescription}</p>
                            </div>
                            <div class="panel-footer">
                                Panel Footer
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
    <div class="panel-footer">
        <h4>Social Buttons</h4>
        <hr>
        <div class="text-center">
            <a class="btn btn-social-icon btn-bitbucket" href="/bitbucket.com"><i class="fa fa-bitbucket"></i></a>
            <a class="btn btn-social-icon btn-dropbox"><i class="fa fa-dropbox"></i></a>
            <a class="btn btn-social-icon btn-facebook"><i class="fa fa-facebook"></i></a>
            <a class="btn btn-social-icon btn-flickr"><i class="fa fa-flickr"></i></a>
            <a class="btn btn-social-icon btn-github"><i class="fa fa-github"></i></a>
            <a class="btn btn-social-icon btn-google-plus"><i class="fa fa-google-plus"></i></a>
            <a class="btn btn-social-icon btn-instagram"><i class="fa fa-instagram"></i></a>
            <a class="btn btn-social-icon btn-linkedin"><i class="fa fa-linkedin"></i></a>
            <a class="btn btn-social-icon btn-pinterest"><i class="fa fa-pinterest"></i></a>
            <a class="btn btn-social-icon btn-tumblr"><i class="fa fa-tumblr"></i></a>
            <a class="btn btn-social-icon btn-twitter"><i class="fa fa-twitter"></i></a>
            <a class="btn btn-social-icon btn-vk"><i class="fa fa-vk"></i></a>
        </div>
    </div>
</div>

</body>

<!-- Bootstrap Core JavaScript -->
<script src="../../resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../../resources/bower_components/metisMenu/dist/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../../resources/dist/js/sb-admin-2.js"></script>
</html>
