(ns projecteuler.pe025
  (:require [math.fibonacci :as fib]))

(def fib-with-index (map-indexed (fn [a b] [a b]) fib/fibonacci-seq))

(defn number-of-digits [n]
  (count (str n)))

(defn first-with 
  "Return the first element of coll that matches the pred."
  [coll pred]
  (first (drop-while (complement pred) coll)))

(first (first-with fib-with-index #(= (number-of-digits (second %)) 1000)))

