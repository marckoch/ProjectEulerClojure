(ns projecteuler.pe035
  (:require [com.hypirion.primes :as p]))

(defn rotations
  "Returns a lazy seq of all rotations of a seq"
  [x]
  (if (seq x)
    (map
     (fn [n _]
       (lazy-cat (drop n x) (take n x)))
     (iterate inc 0) x)
    (list nil)))

(defn all-rotations-prime?
  "Return true if all rotations of the given number result in a prime."
  [n]
  (->>
   (rotations (str n))
   (map #(apply str %))
   (map #(Integer/parseInt %))
   (map p/prime?)
   (every? true?)))

(time (->>
 (range 1 1e6)
 (filter all-rotations-prime?)
 count))
