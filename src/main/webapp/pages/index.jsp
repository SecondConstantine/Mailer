<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="resources/css/index.css">
    <link rel="stylesheet" href="resources/lib/bootstrap.min.css">
    <script src="resources/lib/angular.js"></script>
</head>

<body ng-app="myApp">
<form action="start" method="POST" enctype="multipart/form-data">
    <p>Тема:
        <input type="text" name="subject">
    </p>
    <p>Шаблон:
        <input type="file" name="template">
    </p>

    <p>Список почтовых ящиков:
        <input type="file" name="emails">
    </p>

    <p>
        <input type="submit" value="Разослать">
    </p>
</form>
</body>

</html>