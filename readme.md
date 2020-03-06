# mastertech

# POST /usuario
Cria Usuario no sistema.
Response 200
> {
> 	"cpf":"12312312312",
> 	"dataDoCadastro":"1990-11-20",
> 	"email":"fas@asdf.com",
> 	"nomeCompleto":"Bruno"
> }

# POST /ponto
Cria o ponto no sistema.
> {
> 	"dataPonto":"2020-02-20",
> 	"entrada":"",
> 	"saida": "Saida",
> 	"usuario": {
> 		"id" : 1
> 	}
> }


# GET /usuario/busca?id=1
Busca o ponto do usuario.
Response 200
> {
>    "id": 1,
>     "nomeCompleto": "teste",
>     "cpf": "12312312312",
>     "email": "fas@asdf.com",
>     "dataDoCadastro": "1990-07-14",
>     "ponto": [
>         {
>             "dataPonto": "2020-02-19",
>             "id": 2,
>            "entrada": "entrada",
>             "saida": ""
>         }
>     ]
> }

# GET /usuario/buscatudo
GET /usuario/buscatudo
Busca todos os usuarios e seus pontos
Response 200
> [
>     {
>         "id": 1,
>         "nomeCompleto": "teste",
>         "cpf": "12312312312",
>         "email": "fas@asdf.com",
>         "dataDoCadastro": "1990-07-14",
>         "ponto": [
>             {
>                 "dataPonto": "2020-02-19",
>                 "id": 2,
>                 "entrada": "entrada",
>                 "saida": ""
>             }
>         ]
>     },
>     {
>         "id": 3,
>         "nomeCompleto": "Bruno",
>         "cpf": "12312312312",
>         "email": "fas@asdf.com",
>         "dataDoCadastro": "1990-11-19",
>         "ponto": [
>             {
>                 "dataPonto": "2020-02-19",
>                 "id": 4,
>                 "entrada": "",
>                 "saida": "Saida"
>             }
>         ]
>     }
> ]

# PUT /usuario/editar/1
> {
> 	"id":"1",
> 	"cpf":"12312312312",
> 	"email":"fas@asdf.com",
> 	"nomeCompleto":"Felipe"
> }
