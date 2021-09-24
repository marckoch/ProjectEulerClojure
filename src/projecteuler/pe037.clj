(ns projecteuler.pe037
  (:require [com.hypirion.primes :as p]))

(defn right-truncable? [n]
  (if (zero? n)
    true
    (and (p/prime? n) (recur (quot n 10)))))

(defn drop-first-digit [n]
  (let [s (str n)
        c (count s)]
    (if (> c 1)
      (Integer/parseInt (apply str (drop 1 s)))
      n)))

(defn left-truncable? [n]
  (if (> 10 n)
    (p/prime? n)
    (and (p/prime? n) (recur (drop-first-digit n)))))

(->>
 (range 11 1e6 2)
 (filter #(and (left-truncable? %) (right-truncable? %)))
 (reduce +))
