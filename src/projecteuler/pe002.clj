(ns projecteuler.pe002
  (:require [math.fibonacci :as fib]))

;; some tests
(comment
  (take 10 fib/fibonacci-seq)

  (take-while
   #(> 4e6 %)
   fib/fibonacci-seq))

(->>
 fib/fibonacci-seq
 (take-while #(< % 4e6))
 (filter #(even? %))
 (reduce +))
