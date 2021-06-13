<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>
<h2>Library</h2>

<div class="authors-form" style="display: flex">
    <div>
        <h2>Add Author</h2>
        <form method="post" action="${pageContext.request.contextPath}/author">
            <div class="form-group">
                <label for="name" class="control-label">Name: </label>
                <input id="name" class="form-control" type="text"
                       name="name"/>
            </div>
            <div class="form-group">
                <label for="pseudonym" class="control-label">Pseudonym: </label>
                <input id="pseudonym" class="form-control" type="text"
                       name="pseudonym"/>
            </div>
            <div class="form-group">
                <button id="button" type="submit" class="btn btn-success">Submit</button>
            </div>
        </form>
    </div>
    <div style="margin-left: 20px">
        <h2>Update Author</h2>
        <form method="post" action="${pageContext.request.contextPath}/update">
            <div class="form-group">
                <label for="code" class="control-label">Code: </label>
                <input id="code" class="form-control" type="number"
                       name="code"/>
            </div>
            <div class="form-group">
                <label for="updateName" class="control-label">Name: </label>
                <input id="updateName" class="form-control" type="text"
                       name="name"/>
            </div>
            <div class="form-group">
                <label for="updatepseudonym" class="control-label">Pseudonym: </label>
                <input id="updatepseudonym" class="form-control" type="text"
                       name="pseudonym"/>
            </div>
            <div class="form-group">
                <button id="updateButton" type="submit" class="btn btn-success">Submit</button>
            </div>
        </form>
    </div>

</div>
<div class="books-form" style="display: flex">
    <div>
        <h2>Add Book</h2>
        <form method="post" action="${pageContext.request.contextPath}/book">
            <div class="form-group">
                <label for="nameBook" class="control-label">Name: </label>
                <input id="nameBook" class="form-control" type="text"
                       name="name"/>
            </div>
            <div class="form-group">
                <label for="genre" class="control-label">Genre: </label>
                <input id="genre" class="form-control" type="text"
                       name="genre"/>
            </div>
            <div class="form-group">
                <label for="year" class="control-label">Year: </label>
                <input id="year" class="form-control" type="number"
                       name="year"/>
            </div>
            <div class="form-group">
                <label for="authorId" class="control-label">Author id: </label>
                <input id="authorId" class="form-control" type="number"
                       name="authorId"/>
            </div>
            <div class="form-group">
                <button id="buttonBook" type="submit" class="btn btn-success">Submit</button>
            </div>
        </form>
    </div>
    <div style="margin-left: 20px">
        <h2>Update Book</h2>
        <form method="post" action="${pageContext.request.contextPath}/book">
            <div class="form-group">
                <label for="nameBook" class="control-label">Name: </label>
                <input id="nameBook" class="form-control" type="text"
                       name="name"/>
            </div>
            <div class="form-group">
                <label for="genre" class="control-label">Genre: </label>
                <input id="genre" class="form-control" type="text"
                       name="genre"/>
            </div>
            <div class="form-group">
                <label for="year" class="control-label">Year: </label>
                <input id="year" class="form-control" type="number"
                       name="year"/>
            </div>
            <div class="form-group">
                <label for="authorId" class="control-label">Author id: </label>
                <input id="authorId" class="form-control" type="number"
                       name="authorId"/>
            </div>
            <div class="form-group">
                <button id="buttonBook" type="submit" class="btn btn-success">Submit</button>
            </div>
        </form>
    </div>

</div>
<div>
    <a href="${pageContext.request.contextPath}/book">Get all books</a>
    <a href="${pageContext.request.contextPath}/author">Get all authors</a>
</div>
<div class="authors">

    <h2><c:out value="${authorTitle}"/></h2>
    <c:forEach items="${authors}" var="author" varStatus="loop">
        <div>
            <h4><c:out value="${loop.index + 1}"/></h4>
            <p>Id: <c:out value="${author.getCode()}"/></p>
            <p>Name: <c:out value="${author.getName()}"/></p>
            <p>Pseudonym: <c:out value="${author.getPseudonym()}"/></p>
            <a href="${pageContext.request.contextPath}/delete?authorId=${author.getCode()}">Delete</a>

        </div>
    </c:forEach>
</div>
<div class="books">
    <h2><c:out value="${bookTitle}"/></h2>
    <c:forEach items="${books}" var="book" varStatus="loop">
        <div>
            <h4><c:out value="${loop.index +1 }"/></h4>
            <p>Name: <c:out value="${book.getName()}"/></p>
            <p>Genre: <c:out value="${book.getGenre()}"/></p>
            <p>Year: <c:out value="${book.getYear()}"/></p>
            <p>AuthorId: <c:out value="${book.getAuthorId()}"/></p>
            <a href="${pageContext.request.contextPath}/delete?id=${book.getId()}">Delete</a>
        </div>
    </c:forEach>
</div>
</body>
</html>
