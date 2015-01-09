<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>OOOOOO - NEXT POST</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/stylish-portfolio.css" rel="stylesheet">

    <!-- Custom Fonts -->

    <link href="font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/earlyaccess/nanumgothic.css" rel="stylesheet" type="text/css" />
    <link href="mycss.css" rel="stylesheet">
</head>

<body>
    <header id="top" class="header">
        <center>
            <div class="well wellarticle">
                <h1>${ARTICLE.title}</h1>
				
                <span>by ${ARTICLE.writer} <a href="#"></a>
                </span>

                <p><span class="glyphicon glyphicon-time"></span> Posted on ${ARTICLE.creation}</p>

                <!-- Post Content -->
                <p>
                ${ARTICLE.content}
                </p>

                <!-- Comments Form -->
                <div class="well wellcomment">
                    <h4>Leave a Comment</h4>
                    <form id="comment">
                        <div class="form-group">
                            <input class="form-control" placeholder="닉네임">
                            <textarea class="form-control" placeholder="코멘트"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </center>
    </header>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>

</html>
