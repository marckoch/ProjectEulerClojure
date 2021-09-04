(ns math.fibonacci)

;; https://blog.klipse.tech/clojurescript/2016/04/19/fibonacci.html
(def fibonacci-seq
  ((fn fib [a b]
     (lazy-seq (cons a (fib b (+' a b)))))
   0 1))

(comment
  (take 10 fibonacci-seq))