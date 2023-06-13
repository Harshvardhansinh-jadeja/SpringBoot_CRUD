<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>Thymeleaf demo</title>
    <link rel="stylesheet" th:href="@{css/demo.css}" />
  </head>
  <body>
    <h1>Jsp page</h1>
    <p class="funny" th:text="'Time on the server is ' + ${date} " />

  </body>
</html>
