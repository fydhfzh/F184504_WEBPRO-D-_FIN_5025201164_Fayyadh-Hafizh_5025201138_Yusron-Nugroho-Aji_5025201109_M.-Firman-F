<jsp:include page="../layout/upper_layout.jsp"/>
<%@page import="com.pweb.FinalProject.model.Note" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.pweb.FinalProject.database.NoteModel" %>
<%
	ArrayList<Note> notes = NoteModel.all(request, response);
%>
<div class="container p-3">
    <div class="row pt-4">
        <div class="col-6">
            <h2>Note List</h2>
        </div>
        <div class="col-6 text-end">
            <a href="create.jsp" class="btn btn-primary">
                Create New Note
            </a>
        </div>
    </div>
    <br />
    <div class="container d-flex flex-wrap mx-5">
    <%
    	for(Note note: notes){    		
	    	out.println("<div class=\"card w-25 mx-3 my-3 border-5\">");
	    		out.println("<div class=\"d-flex justify-content-end bg-secondary p-2\">");
					out.println("<form method=\"post\" action=\"/FinalProject/note/edit\">");
                		out.println("<div class=\"btn-group\" role=\"group\">");
                    		out.println("<a class=\"btn btn-warning\" href=\"edit.jsp\"><i class=\"fas fa-edit\"></i></a>");
                    		out.println("<button type=\"submit\" class=\"btn btn-danger\"><i class=\"fas fa-trash-alt\"></i></button>");
                		out.println("</div>");
            		out.println("</form>");
				out.println("</div>");
				out.println("<div style=\"height:300px; font-size:20px;\" class=\"p-2 text-dark\">Hallo semuanya </div>");
			out.println("</div>");
    	}
    %>
    </div>
</div>
<jsp:include page="../layout/lower_layout.jsp"/>