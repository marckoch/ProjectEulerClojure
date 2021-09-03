(ns projecteuler.pe014)

(defn next-collatz [n]
  (cond
    (even? n) (/ n 2)
    (odd? n) (+ (* n 3) 1)))

(next-collatz 13)

(defn collatz
  ([n] (collatz n []))
  ([n vec] (if (= n 1)
             (conj vec 1)
             (recur (next-collatz n) (conj vec n)))))

(collatz 837799)

; we can start with 500.000 because every even number n 
; has its double 2n in the 'upper' half and gets hit when we check 2n
(time
 (->> (range 500001 1000000)
      (apply max-key #(count (collatz %)))))

(comment
  ;; some experiments with memoize

  (def memo-next-collatz (memoize next-collatz))

  (collatz 837799)

  (count (collatz 837799))

  (def memo-collatz
    (memoize (fn
               ([n] (collatz n []))
               ([n vec] (if (= n 1)
                          (conj vec 1)
                          (lazy-seq (cons n (memo-collatz (memo-next-collatz n) vec))))))))

  (time
   (->> (range 1 100000)
        (apply max-key #(count (memo-collatz %)))))

  (time
   (->> (range 1000000 1 -1)
        (apply max-key #(count (memo-collatz %)))))

  ; collatz as lazy sequence
  ; not really needed here, because we always need all elements (because we count them)
  (defn collatz-lazy
    ([n] (collatz-lazy n []))
    ([n vec] (if (= n 1)
               (conj vec 1)
               (lazy-seq (cons n (collatz-lazy (next-collatz n) vec))))))

  (collatz-lazy 13))