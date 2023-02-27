<html>
    <head>
        <title>Register Confirm</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    
        <style>
            body{
                margin: 100px 20px 20px 150px;
            }
            p{
                font-size: 25px;
                /* font-family: Arial, Helvetica, sans-serif; */
            }
            .img-circle{
                width: 200px;
                height: 200px;
                border-radius: 50%;
            }
            .info{
                float: left;
                width: 40%;
                height: 50%;
                /* border: 1px solid black; */

            }
            .image{
                display: flex;
                justify-content: center;
                align-items: center;
                
                float: right;
                width: 30%;
                height: 50%;
                margin-right: 100px;
                /* border: 1px solid black; */
            }

        </style>
    </head>
    <body>
        <div class='info'>
            <p>Name: <?php echo $_POST["firstname"] ." ". $_POST["lastname"]; ?></p>
            <br>
            <p>Email: <?php echo $_POST["email"]; ?></p>
            <br>
            <p>Address: <?php echo $_POST["address"]; ?></p>
        </div>
        
        <div class='image'>
            <?php 
                $imagename = $_FILES["image"]["name"];
                $imagetmp = $_FILES["image"]["tmp_name"];

                if(move_uploaded_file($imagetmp, $imagename)){
                    // echo "File uploaded successfully";
                    echo "<img class='img-circle' src='$imagename'> ";
                }
                else{
                    echo "File not uploaded";
                }

            ?>    
        </div>
        
    </body>
</html>