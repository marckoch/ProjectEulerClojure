(ns projecteuler.pe003)

;; first try, very unefficient. Just brute force division.
(defn get-prime-factors
  "Get prime factors of n."
  ([n] (get-prime-factors n 2 []))
  ([n div factors]
   ;; (println n div factors)
     (if (= n 1)
       factors
       (if (zero? (rem n div))
         (recur (/ n div) div (conj factors div))
         (recur n (inc div) factors))))) ;; OPTIMIZE: we could/should use primes here and not `inc`

(get-prime-factors 11730)

(get-prime-factors 600851475143)

(reduce max (get-prime-factors 600851475143))