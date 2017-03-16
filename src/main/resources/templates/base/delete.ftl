<!-- PAGE COMMENTE -->
<!-- ?c, ?string, ... cast la valeur en caractère ou en string -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/custom.css"/>
</head>
<html>
<body>
	<!-- $(nom) fait référence au 'nom' qu'on a renseigné dans le model.add("nom", ce que l'on veut récupérer) -->
    <h1>${page}</h1>
    <!-- Création d'un formulaire de type POST -->
    <form action="" method="POST">
    	<!-- '#list' permet de boucler sur liste en précisant le nom du paramètre sur lequel on boucle 'fields'-->
        <#list fields as field>
        	<!-- currentItem est une MAP. En écrivant toto?keys on récupérer la clé de la MAP (keys est un mot clé réservé)-->
            <#list currentItem?keys as key>
                <#if key == field>
                    <#if key != "id">
                    	<!-- Valeur de l'item correspondant à une clé donné : currentItem[id] = 6 -->
                        <#if currentItem[key]?is_boolean>
                            <br>${key} : ${currentItem[key]?c}</br>
                            	<!-- Bien distinguer la valeur du nom de la valeur : id (nom de la valeur) = 6 (valeur) -->
                                <input type="hidden" name="${key}" value="${currentItem[key]?c}">
                        <#elseif currentItem[key]?is_date>
                            <br>${key} : ${currentItem[key]?string("yyyy/MM/dd HH:mm:ss")}</br>
                                <input type="hidden" name="${key}" value="${currentItem[key]?string("yyyy/MM/dd HH:mm:ss")}">
                        <#elseif currentItem[key]?is_sequence>
                            <br>Sequence</br>
                        <#else>
                            <br>${key} : ${currentItem[key]}</br>
                                <input type="hidden" name="${key}" value="${currentItem[key]}">
                        </#if>
                    <#else>
                        <input type="hidden" name="id" value="${currentItem[key]}">
                    </#if>
                </#if>
            </#list>
        </#list>
        <br>
            <input type="submit" value="delete"/>
        </br>
    </form>
    <a href="../list">Back</a>
</body>
</html>