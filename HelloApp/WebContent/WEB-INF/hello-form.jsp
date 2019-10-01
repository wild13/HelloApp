<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Hello-form</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post" action="hello-form">
            <fieldset>
                <legend>Formulaire</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

				<label for="lastname">lastname</label>
                <input type="text" id="lastname" name="lastname" value="" size="20" maxlength="20" />
                
                <br />
                
				<label for="firstname">firstname</label>
                <input type="text" id="firstname" name="firstname" value="" size="20" maxlength="20" />
           	
           		<br />
           	
                <label for="time">Heure de la journée</label>
                <input type="time" id="time" name="time" value="" size="20" maxlength="60" />
                
                <br />

                <input type="submit" value="form" />
                
            </fieldset>
        </form>
    </body>
</html>