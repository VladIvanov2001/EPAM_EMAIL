<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Email sender form</title>
  </head>
  <body>
  <form action="controller" method="post">
      <caption><h2>Send New E-mail</h2></caption>
        <input type="email" name="recipient" size="50" placeholder="address of the recipient" required/><br/>
        <input type="text" name="subject" size="50" placeholder="topic" required/><br/>
        <textarea rows="8" cols="30" name="content" placeholder="Text" required></textarea><br/>
        <input type="submit" value="Send"/>
  </form>
  </body>
</html>
