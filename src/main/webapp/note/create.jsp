<jsp:include page="../layout/upper_layout.jsp"/>
<form method="post" style="width:50%; margin: auto;">
    <div class="border p-3 mt-4">
        <div class="row pb-3">
            <h2 class="text-primary">Create Note</h2>
            <hr />
        </div>
        <div class="mb-3">
            <label for="text">Note</label>
            <input name="text" id="text" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-primary" style="width:150px;">Create</button>
        <a class="btn btn-secondary" style="width:150px;" href="/FinalProject/note/index.jsp">Back to List</a>
    </div>
</form>
<jsp:include page="../layout/lower_layout.jsp"/>