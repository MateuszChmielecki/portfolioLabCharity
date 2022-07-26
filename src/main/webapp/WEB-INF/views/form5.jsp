<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../fragments/formHeader.jsp" %>
<div>
    <%--@elvariable id="donation" type="pl.coderslab.charity.entity.Donation"--%>
    <form action="form5" method="post" modelAttribute="donation">
    <div data-step="5" class="active form-group--inline">
        <h3>Podsumowanie Twojej darowizny</h3>

        <div class="summary">
            <div class="form-section">
                <h4>Oddajesz:</h4>
                <ul>
                    <li>
                        <span class="icon icon-bag"></span>
                        <span class="summary--text"
                        ><c:out value="${donation.quantity}"></c:out> worki
                            <c:forEach var="item" items="${donation.categories}">
                            <c:out value="${item.name}"></c:out> </c:forEach></span
                        >
                    </li>

                    <li>
                        <span class="icon icon-hand"></span>
                        <span class="summary--text"
                        >Dla fundacji "<c:out value="${donation.institution.name}"></c:out>"</span
                        >
                    </li>
                </ul>
            </div>

            <div class="form-section form-section--columns">
                <div class="form-section--column">
                    <h4>Adres odbioru:</h4>
                    <ul>
                        <li><c:out value="${donation.street}"></c:out></li>
                        <li><c:out value="${donation.city}"></c:out></li>
                        <li><c:out value="${donation.zipCode}"></c:out></li>
                    </ul>
                </div>

                <div class="form-section--column">
                    <h4>Termin odbioru:</h4>
                    <ul>
                        <li><c:out value="${donation.pickUpDate}"></c:out></li>
                        <li><c:out value="${donation.pickUpTime}"></c:out></li>
                        <li><c:out value="${donation.pickUpComment}"></c:out></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="form-group form-group--buttons">
            <button type="button" class="btn prev-step">Wstecz</button>
            <button type="submit" class="btn">Potwierdzam</button>
        </div>
    </div>
    </form>

<%@include file="../fragments/formFooter.jsp" %>