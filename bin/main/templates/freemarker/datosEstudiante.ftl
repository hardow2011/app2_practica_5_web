<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Información Estudiante ${estudiante.nombre}</title>
    <link href="/css/miEstilo.css" rel="stylesheet" >
</head>
<body>
<h1>Matrícula ${estudiante.matricula?string["0"]} -  ${estudiante.nombre}</h1>
<h2>Estudia en la carrea de ${estudiante.carrera}</h2>
</body>
<table>
    <thead>
        <tr>
            <th>Nombre</th>
            <th>Matrícula</th>
            <th>Carrera</th>
        </tr>
    </thead>
    <tbody>
        <#foreach estudiante in listaEstudiante>                  
        <tr>
            <td>${estudiante.nombre}</td>
            <td>${estudiante.matricula?c}</td>
            <td>${estudiante.carrera}</td>
        </tr>
        </#foreach>   
    </tbody>
</table>
</html>