<%@page contentType="text/html" pageEncoding="windows-1250"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Semestrální projekt</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <spring:url value="/css/main.css" var="coreCss" />
        <spring:url value="/img/logo-fm.png" var="logo" />
        <link href="${coreCss}" rel="stylesheet" media="all" />
    </head>
    <body>
        <header>
            <div id="Logo">
                <h1><a href="#">Semestrální projekt</a></h1>
            </div>

        </header>
        <section id="Preview">

            <div class="img_Border">  <a href="www.fm.tul.cz"><img class="def" src=${logo} alt="" /></a> </div>
        </section>
        <section>
            <article class="cont">

                <header >
                    <h2>Vítejte na stránkách semestrální práce z pøedmìtu Pokroèilé programování na platformì Java</h2>
                </header>
                <div class="galery">
                    <img class="def" src=${logo} alt="" />
                    <div class="left-but">
                    <form:form method="GET"  action="/previous/id=${previous}">
                        <input type="submit"  value="PØEDCHOZÍ"/>
                    </form:form>
                    </div>
                    <div class="right-but">
                        <form:form method="GET"  action="/next/id=${next}">
                            <input type="submit"  value="DALŠÍ"/>
                        </form:form>
                    </div>
                </div>



            </article>


        </section>
        <footer>
            <p>&copy; Semestrální projekt 2016. All rights reserved. Design by Marek Jindrák.</p>
        </footer>

    </body>
</html>
