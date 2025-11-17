# language: es

Característica: Validar saldos de un grupo

Regla: El total de un grupo no puede ser negativo

Escenario: Agregar un gasto positivo a un grupo sin saldo resulta en saldo positivo
  Dado un grupo con saldo 0
  Cuando el usuario agrega un gasto de 10 al grupo
  Entonces el gasto total será un numero positivo

  Escenario: Agregar un gasto positivo a un grupo con saldo resulta en saldo positivo
    Dado un grupo con saldo 1
    Cuando el usuario agrega un gasto de 10 al grupo
    Entonces el gasto total será un numero positivo

  Escenario: Agregar un gasto negativo menor al total del grupo resulta en saldo positivo
    Dado un grupo con saldo 10
    Cuando el usuario agrega un gasto de -1 al grupo
    Entonces el gasto total será un numero positivo

  Escenario: Agregar un gasto negativo igual al total del grupo resulta en saldo cero
    Dado un grupo con saldo 10
    Cuando el usuario agrega un gasto de -10 al grupo
    Entonces el gasto total será cero


  Escenario: Agregar un gasto negativo a un grupo sin saldo resulta en un error
    Dado un grupo con saldo 0
    Cuando el usuario agrega un gasto de -1 al grupo
    Entonces resultará en un error con el mensaje "El total no puede ser negativo"