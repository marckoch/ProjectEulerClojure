(ns projecteuler.pe030
  (:require [math.digitsum :as digitsum]))

(def p 3)

;; upper bound can be found here:
;; https://www.mathblog.dk/project-euler-30-sum-numbers-that-can-be-written-as-the-sum-fifth-powers-digits/
;; https://www.xarg.org/puzzle/project-euler/problem-30/
(def limit (* 7 (int (Math/pow 9 p))))

(->>
 (range 2 limit)
 (filter #(= % (digitsum/sum-nth-power-of-digits % p)))
 (reduce +))