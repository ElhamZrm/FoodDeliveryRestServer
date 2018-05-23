<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<!DOCTYPE HTML>

<html>
<head>
<title>Add Product Form</title>
<style type="text/css">@import url(resources/css/main.css);</style>
</head>
<body>

<div id="global">
<form:form modelAttribute="product" action="product" method="post">
    <fieldset>
        <legend>Add a product</legend>
        <p>
            <label for="name">Product Name: </label>
            <form:input type="text" id="name" path="name" />
  
        </p>
        <p>
            <label for="description">Description: </label>
            <form:input type="text" id="description" path="description"  />
        </p>
        <p>
            <label for="price">Price: </label>
            <form:input type="text" id="price" path="price" value = "0.0" />
        </p>
         
        <p id="buttons">
             <input id="submit" type="submit" tabindex="5" 
                value="Add Product">
        </p>
    </fieldset>
</form:form>
</div>
</body>
</html>
