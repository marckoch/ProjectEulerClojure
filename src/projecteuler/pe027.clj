(ns projecteuler.pe027
  (:require [com.hypirion.primes :as p]))

(defn calc 
  "Calculate n^2 + a*n + b"
  [a b n]
  (->>
   (+ n a)
   (* n)
   (+ b)))

(defn max-length [a b]
  (loop [n 0]
    (let [res (calc a b n)]
      (if (not (p/prime? res))
        n
        (recur (inc n))))))

(max-length -79 1601)

(->>
 (apply max-key #(max-length (first %) (second %))
        (for [a (range -1000 1001)
              b (range -1000 1001)]
          (list a b)))
 (reduce *))