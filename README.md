# ProyectoPatrones


Repositorio dedicado a proyecto universitario. Programación con patrones. Tercer Cuatrimestre 2017. 

## Condiciones generales

Se realiza y se entrega en grupos de máximo 4 personas.

Cada persona del grupo debe tener actividad en el repositorio. Una persona sin commits significa que no contribuyó al código y por lo tanto tendrá un cero como nota. 


## Contexto

La empresa DesarrollosElectrónicos S.A. necesita desarrollar un back-end core que maneje mensajería para el procesador de procesos de negocio. 

Básicamente quieren hacer un software capaz de realizar un TRÁMITE, de principio a fin. Cada trámite tiene pasos. Y cada paso está asignado a una área funcional de la empresa responsable. Dentro de cada área funcional hay empleados. Hay trámites que pueden ser tomados por cualquier empleado [Opcional:y otros que solo pueden ser tomados por empleados con un rol específico. ].

Un trámite puede ser un procesos como tal, o bien un “documento” que require llenado de campos, revisiones y autorizaciones. 

Cuando se inicia un trámite, se necesita que lleve una FIRMA digital, un destino y debe especificar el origen. 

La firma debe ser verificada con un certificado del emisor. Y lo ideal es que el mensaje sea encriptado de forma que solo el receptor pueda designado pueda leeerlo. 

En todo momento debe ser posible listar todos los trámites en curso o bien solo los trámites de cierto tipo. 

También debe ser posible ver la evolución de pasos del trámite: qué pasó, cuando pasó y quién estuvo a cargo. 


## Requerimientos

No se necesita front-end. Puede hacerse todo con consola.. Aúnque suene increible. 

Tienen que ser capaces de simular para probar los pasos de un trámite. 

Tiene que haber firma y autenticación del destino y origen del documento. 

Deben incluir PRUEBAS de las funciones. 

Deben verificar la cobertura de las pruebas. 


## Deadlines

Entrega inicial: 11 de noviembre, especificar repositorio y diseño inicial del proyecto. 

Revisión intermedia 2 de diciembre: avance, cambios de diseño y razones. 

Entrega final el 16 de diciembre. Cada grupo debe estar presente ese día en la clase. Se le calificará el proyecto y se dará la nota individual a cada integrante. 

## Evaluación
Pruebas: 20%
Diseño inicial: 10%
Diseño final y justificación de la evolución 20%
Completitud funcional implementada 50%
