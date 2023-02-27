<html>
    <head>
        <title>Register</title>
        <link rel="stylesheet" type="text/css" href="registerstyle.css">
    </head>
    <body>
        <form METHOD="POST" action="RegisterConfirm.php" enctype="multipart/form-data" >
            <div class="container">
                <div class="register">
                       <div class="firstname">
                            <label for="firstname"><b>First Name</b></label>
                            <input type="text" placeholder="Enter Your First Name" name="firstname" required>
                       </div>
                        <div class="lastname">
                            <label for="lastname"><b>Last Name</b></label>
                            <input type="text" placeholder="Enter Your Last Name" name="lastname" required>
                        </div>
                    <br><br><br>
                    <label for="email"><b>Email</b></label>
                    <input type="text" placeholder="Enter Email" name="email" required>
                    <br><br><br>
                    <div>
                        <lebel for="address" id="addressplace"><b>Address</b></lebel>
                        <textarea name="address" id="address" cols="30" rows="10" placeholder="Enter Your Address" required></textarea>
                    </div>
                    <br><br>
                    <div class="photo">
                        <label for="Photo" ><b>Photo</b></label>
                        <input type="file" name="image" accept="image/*" required>
                    </div>
                    <br><br><br>
                    <div class="clearfix">
                        <button type="button" class="cancelbtn">Cancel</button>
                        <button type="submit" class="signupbtn">Sign Up</button>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>