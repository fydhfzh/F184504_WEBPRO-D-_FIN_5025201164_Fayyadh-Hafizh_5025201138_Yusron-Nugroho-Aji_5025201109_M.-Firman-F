<jsp:include page="layout/upper_layout.jsp"/>
<section class="vh-100" style="color:azure;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-80">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card  shadow-2-strong" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <h3 class="mb-5" style="color: #0d6eff">Register</h3>

                        <form method="post" action="/FinalProject/insertUser">
                            <div class="form-outline mb-4" >
                                <label class="form-label" style="color: #000000" for="name">Name</label>
                                <input type="text" name="name" id="typePasswordX-2" class="form-control form-control-lg" />
                            </div>

                            <div class="form-outline mb-4">
                                <label class="form-label" style="color: #000000" for="email">Email</label>
                                <input type="email" name="email" class="form-control form-control-lg" />
                            </div>
                            <div class="form-outline mb-4">
                                <label class="form-label" style="color: #000000" for="password">Password</label>
                                <input type="password" name="password" class="form-control form-control-lg" />
                            </div>

                            <button class="btn btn-primary btn-lg btn-block" type="submit" style="width:200px">Register</button>
                            <br />
                            <hr class="my-4">
                            <div class="text-decoration-none text-lg-center" style="color:cadetblue">Already has an account? <strong><a href="login.jsp" class="text-decoration-none">Login Here</a></strong></div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="layout/lower_layout.jsp"/>