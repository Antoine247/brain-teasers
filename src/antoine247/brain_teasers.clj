(ns antoine247.brain-teasers
  (:gen-class))

;; equality

(= 1 1.0 1N 1.0M)
;;=>false
(== 1 1.0 1N 1.0M)
;;=>true

;; mas comun usar el =, el == es utilo para casos de operaciones con distintos tipos de numeros

;; sumas

(def bignum 9223372036854775807)
(def biggernum 9223372036854775808)

(= biggernum (+ bignum 1))
;;=>exception overflow
(= biggernum (+' bignum 1))
;;=>true
(= biggernum (unchecked-add bignum 1))
;;=>false

;; suma normal (+) chequea overflows, si te llegas a pasar de bytes para un tipo de numero, va a lanzar arithmeticExcepcion
;; suma "promotora" (+') en el caso de que un numero exceda los bytes de un tipo, lo promueve a un tipo de numero con mayor
;; capacidad, por ejemplo de long a BigInt.
;; suma sin proteccion (unchecked-add) no chequea overflows, si te pasas de bytes en un long por ejemplo, da la vuelta
;; y se hace un numero negativo.

;; ##NaNs

(= ##NaN ##NaN)
;;=> false
(== ##NaN ##NaN)
;;=> false

;; un NaN "Not a Number" es una expresion numerica de java para representar un numero que no es un numero, que no se puede calcular
(/ 0.0 0.0)
;;=>##NaN
