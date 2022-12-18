<jsp:include page="layout/upper_layout.jsp"/>
<div style="z-index: 0" class="text-center vh-100 mt-auto">
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <%
    	Cookie[] cookies = request.getCookies();
    	Cookie cookie = cookies[0];
    %>
    <h1 class="display-4">Hello, <%=cookie.getValue() %> Welcome to My Diary!</h1>
    <p>Here you can write all of your days activities and keep it as a long-living memories</p>
    <div class="row pb-3 justify-content-center">
        <a class="btn btn-primary w-50" href="/FinalProject/note/dashboard.jsp"><h2>Try Here!</h2></a>
    </div>
</div>
<jsp:include page="layout/lower_layout.jsp"/>