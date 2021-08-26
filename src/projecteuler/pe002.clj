(ns projecteuler.pe002)

;; https://blog.klipse.tech/clojurescript/2016/04/19/fibonacci.html
(def fibonacci-seq
  ((fn fib [a b]
     (lazy-seq (cons a (fib b (+ a b)))))
   0 1))

;; some tests
(comment
  (take 10 fibonacci-seq)

  (take-while
   #(> 4e6 %)
   fibonacci-seq))

(->>
 fibonacci-seq
 (take-while #(< % 4e6))
 (filter #(even? %))
 (reduce +))
