<html>
    <head>
        <title>Register Confirm</title>
        <style>
            body{
                margin: 100px 20px 20px 250px;
            }
            p{
                font-size: 25px;
                /* font-family: Arial, Helvetica, sans-serif; */
            }
        </style>
    </head>
    <body>
        <p>Name: <?php echo $_POST["firstname"] . $_POST["lastname"]; ?></p>
        <br>
        <p>Email: <?php echo $_POST["email"]; ?></p>
        <br>
        <p>Address: <?php echo $_POST["address"]; ?></p>
        <br>
        <p>Photo:
            <?php 
                $target_dir = "upload-tmp-dir/";
                $target_file = $target_dir . basename($_FILES["image"]["name"]);
                echo $target_file;

                $uploadOk = 1;
                $imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));
                if(isset($_POST["submit"])) {
                    $check = getimagesize($_FILES["image"]["tmp_name"]);
                    if($check !== false) {
                        echo "File is an image - " . $check["mime"] . ".";
                        $uploadOk = 1;
                    } else {
                        echo "File is not an image.";
                        $uploadOk = 0;
                    }
                }

                
                if (file_exists($target_file)) {
                    echo "Sorry, file already exists.";
                    $uploadOk = 0;
                }

                if ($_FILES["image"]["size"] > 500000) {
                    echo "Sorry, your file is too large.";
                    $uploadOk = 0;
                }

                print_r($_FILES["image"]);

            ?>
        </p>
    </body>
</html>