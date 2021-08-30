(ns projecteuler.pe005)

;; idea: get primes below 20 and produce max multiples of each prime that is below 20
;; e.g. 2 --> 16 (== 2^4), next multiple 2^5 == 32 would exceed 20
;; we can see that this only applies to 2 and 3, as 5^2 is already > 20

(def primes-below-20 (list 2 3 5 7 11 13 17 19))

(defn max-multiple-below-20 
  "Find the maximum of n below 20, e.g. n=2 -> 2^4 = 16"
  [n]
  (let [sq (* n n)]
    (if (> sq 20)
      n
      (recur sq)))
  )

(->> primes-below-20
     (map max-multiple-below-20)
     (reduce *)
     )