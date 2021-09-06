(ns projecteuler.pe023
  (:require [math.divisors :as d]))

(defn abundant? [n]
  (let [sum-proper-divisors (reduce + (d/proper-divisors n))]
    (< n sum-proper-divisors)))

(def memo-abundant? (memoize abundant?))

(defn sum-of-two-abundant-numbers? [n]
  (->>
   (range 1 (inc (/ n 2)))
   (some #(and (memo-abundant? %) (memo-abundant? (- n %))))))

(time (->>
       (range 1 28124)
       (remove sum-of-two-abundant-numbers?)
       (reduce +)))